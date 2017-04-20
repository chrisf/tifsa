package org.jsack.tifsa.Controllers.LookupControllers;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeTableColumn;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.jsack.tifsa.Database.CustomerContact.CustomerContact;
import org.jsack.tifsa.Database.CustomerContact.CustomerContactSchema;
import org.jsack.tifsa.Database.DBSelect;
import org.jsack.tifsa.Julius;
import org.jsack.tifsa.Utility;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;

/**
 * Created by aaron on 4/19/17.
 */
@ViewController("/Scenes/Lookup/LookupOrder0.fxml")
public class OrderLookup {

    @FXML
    JFXTextField filterText;

    @FXML
    JFXTreeTableColumn<OrderRecord, String> firstNameColumn, lastNameColumn, addressColumn, orderDateColumn, stateColumn, orderStatusColumn, contactColumn;

    @FXML
    JFXTreeTableColumn<OrderRecord, Number> orderIdColumn;
    @FXML
    JFXButton nextButton;

    @FXML
    JFXTreeTableView<OrderRecord> orderTable;

    @FXMLViewFlowContext
    ViewFlowContext context;

    private ObservableList<OrderRecord> orderRecords;
    private ObservableList<CustomerContact> customerContacts;
    private OrderRecord selectedCustomer = null;

    @PostConstruct
    public void init() {
        setupCellValueFactory(orderIdColumn, e -> e.orderId);
        setupCellValueFactory(firstNameColumn, e -> e.firstName);
        setupCellValueFactory(lastNameColumn, e -> e.lastName);
        setupCellValueFactory(addressColumn, e -> e.address);
        setupCellValueFactory(orderDateColumn, e -> e.date);
        setupCellValueFactory(stateColumn, e -> e.state);
        setupCellValueFactory(orderStatusColumn, e -> e.status);
        setupCellValueFactory(contactColumn, e -> e.contactInfo);

        filterText.textProperty().addListener((observable, oldValue, newValue) ->
        {
            new Thread(() -> {
                orderTable.setPredicate(productProp -> {
                    final OrderRecord product = productProp.getValue();
                    final List<CustomerContact> contact = customerContacts.filtered(c -> c.getCustomerId() == product.customerId.get());
                    return Utility.containsIgnoreCase(product.firstName.get(), newValue) ||
                            Utility.containsIgnoreCase(product.lastName.get(), newValue) || contact.stream().anyMatch(e -> Utility.containsIgnoreCase(e.getCustomerContactInfo(), newValue)) || Utility.containsIgnoreCase(String.valueOf(product.orderId.get()), newValue);
                });
            }).start();
        });
        nextButton.setOnMouseClicked(e -> {
            try {
           context.register("OrderLookupId", orderTable.getSelectionModel().getSelectedItem().getValue().orderId.get());
            FlowHandler flowHandler = (FlowHandler) context.getRegisteredObject("ContentFlowHandler");
            flowHandler.navigateTo(OrderLookup2.class); }
            catch (Exception ex) {ex.printStackTrace(); }
        });
        new Thread(() -> {
            loadOrders();
        }).start();
    }

    private void loadOrders() {
        orderRecords = FXCollections.observableArrayList(Julius.getJdbcTemplate().query("" +
                "SELECT OrderID, OrderBillingFirst, OrderBillingLast, OrderBillingStreet, [Order].CustomerID, State.StateName, OrderDate, " +
                "OrderStatus.OrderStatusDescription, o1.CustomerContactInfo " +
                "FROM [Order] " +
                "FULL JOIN OrderStatus ON OrderStatus.OrderStatusID = [Order].OrderStatusID " +
                "INNER JOIN State ON [Order].OrderBillingState=State.StateID " +
                "LEFT JOIN ( SELECT * FROM CustomerContact WHERE CustomerContact.CustomerContactPrimary = '1') " +
                "AS o1 ON [Order].CustomerID = o1.CustomerID " +
                "ORDER BY [Order].OrderID ASC", new OrderRecordWrapper()
        ));
        customerContacts = FXCollections.observableArrayList(
                new DBSelect().selectAll(new CustomerContactSchema()));

        Utility.runOnGuiAndWait(() -> {
            orderTable.setRoot(new RecursiveTreeItem<>(orderRecords, RecursiveTreeObject::getChildren));
            orderTable.setShowRoot(false);
        });
    }

    private class OrderRecordWrapper implements RowMapper<OrderRecord> {
        @Override
        public OrderRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new OrderRecord(rs.getLong("OrderID"), rs.getString("OrderBillingFirst"), rs.getString("OrderBillingLast"), rs.getString("OrderBillingStreet"),
                    rs.getString("StateName"), rs.getString("CustomerContactInfo"), rs.getString("OrderDate").toString(), rs.getString("OrderStatusDescription"), rs.getLong("CustomerID"));
        }
    }

    private <T> void setupCellValueFactory(JFXTreeTableColumn<OrderRecord, T> column, Function<OrderRecord, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<OrderRecord, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }

    private static final class OrderRecord extends RecursiveTreeObject<OrderRecord> {
        final StringProperty firstName, lastName, address, state, contactInfo, date, status;
        final LongProperty orderId, customerId;

        OrderRecord(long orderId, String firstName, String lastName, String address, String state, String contactInfo, String date, String status, long customerId) {
            this.firstName = new SimpleStringProperty(Utility.blankIfNull(firstName));
            this.lastName = new SimpleStringProperty(Utility.blankIfNull(lastName));
            this.address = new SimpleStringProperty(Utility.blankIfNull(address));
            this.state = new SimpleStringProperty(Utility.blankIfNull(state));
            this.contactInfo = new SimpleStringProperty(Utility.blankIfNull(contactInfo));
            this.orderId = new SimpleLongProperty(orderId);
            this.customerId = new SimpleLongProperty(customerId);
            this.status = new SimpleStringProperty(Utility.blankIfNull(status));
            org.joda.time.format.DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
            DateTime dt = dtf.parseDateTime(date);
            this.date = new SimpleStringProperty(DateTimeFormat.forPattern("MM-dd-yyyy").print(dt));
        }
    }

}
