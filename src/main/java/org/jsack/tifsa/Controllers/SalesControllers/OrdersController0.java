package org.jsack.tifsa.Controllers.SalesControllers;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import io.datafx.controller.ViewController;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeTableColumn;
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
@ViewController("/Scenes/Sales/OrderForm0.fxml")
public class OrdersController0 {

    @FXML
    JFXTextField filterText;

    @FXML
    JFXTreeTableColumn<CustomerRecord, String> businessNameColumn, firstNameColumn, lastNameColumn, addressColumn, cityColumn, stateColumn, contactColumn;

    @FXML
    JFXButton createCustomer;

    @FXML
    JFXTreeTableView<CustomerRecord> customerTable;

    private ObservableList<CustomerRecord> customerRecords;
    private ObservableList<CustomerContact> customerContacts;

    @PostConstruct
    public void init() {
        setupCellValueFactory(businessNameColumn, c -> c.businessName);
        setupCellValueFactory(firstNameColumn, c -> c.firstName);
        setupCellValueFactory(lastNameColumn, c -> c.lastName);
        setupCellValueFactory(addressColumn, c -> c.address);
        setupCellValueFactory(cityColumn, c -> c.city);
        setupCellValueFactory(stateColumn, c -> c.state);
        setupCellValueFactory(contactColumn, c->c.contactInfo);

        filterText.textProperty().addListener((o, oldVal, newVal) -> {
            new Thread(() -> {
                customerTable.setPredicate(productProp -> {
                    final CustomerRecord product = productProp.getValue();
                    final List<CustomerContact> contact = customerContacts.filtered(c -> c.getCustomerId() == product.customerId.get());
                    return Utility.containsIgnoreCase(product.businessName.get(), newVal) ||
                            Utility.containsIgnoreCase(product.firstName.get(), newVal) || Utility.containsIgnoreCase(product.lastName.get(), newVal) ||
                            contact.stream().anyMatch(e -> Utility.containsIgnoreCase(e.getCustomerContactInfo(), newVal));
                });
            }).start();
        });
        new Thread(() -> {
            loadCustomers();
        }).start();
    }

    private void loadCustomers() {
        customerRecords = FXCollections.observableArrayList(Julius.getJdbcTemplate().query("" +
                "SELECT Customer.CustomerID, CustomerBusinessName, CustomerFirst, CustomerLast, CustomerAddressStreet, CustomerAddressCity, " +
                "StateName, CustomerAddressZip, CustomerContactInfo " +
                "FROM Customer " +
                "INNER JOIN [State] ON Customer.StateID = State.StateID " +
                "FULL JOIN ( " +
                "SELECT * FROM CustomerContact WHERE CustomerContactPrimary = 1 " +
                ") as o1 ON o1.CustomerID = Customer.CustomerID", new CustomerRecordWrapper()
        ));
        customerContacts = FXCollections.observableArrayList(
                new DBSelect().selectAll(new CustomerContactSchema()));

        Utility.runOnGuiAndWait(() -> {
            customerTable.setRoot(new RecursiveTreeItem<>(customerRecords, RecursiveTreeObject::getChildren));
            customerTable.setShowRoot(false);
        });
    }

    private class CustomerRecordWrapper implements RowMapper<CustomerRecord> {
        @Override
        public CustomerRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new CustomerRecord(rs.getLong("CustomerID"), rs.getString("CustomerBusinessName"), rs.getString("CustomerFirst"),
                    rs.getString("CustomerLast"), rs.getString("CustomerAddressStreet"), rs.getString("CustomerAddressCity"), rs.getString("StateName"), rs.getString("CustomerContactInfo"));

        }
    }

    private <T> void setupCellValueFactory(JFXTreeTableColumn<CustomerRecord, T> column, Function<CustomerRecord, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<CustomerRecord, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }

    private static final class CustomerRecord extends RecursiveTreeObject<CustomerRecord> {
        final StringProperty businessName, firstName, lastName, address, city, state, contactInfo;
        final LongProperty customerId;

        CustomerRecord(long customerId, String businessName, String firstName, String lastName, String address, String city, String state, String contactInfo) {
            this.customerId = new SimpleLongProperty(customerId);
            this.businessName = new SimpleStringProperty(Utility.blankIfNull(businessName));
            this.firstName = new SimpleStringProperty(Utility.blankIfNull(firstName));
            this.lastName = new SimpleStringProperty(Utility.blankIfNull(lastName));
            this.address = new SimpleStringProperty(Utility.blankIfNull(address));
            this.city = new SimpleStringProperty(Utility.blankIfNull(city));
            this.state = new SimpleStringProperty(Utility.blankIfNull(state));
            this.contactInfo = new SimpleStringProperty(Utility.blankIfNull(contactInfo));
        }
    }

}
