package org.jsack.tifsa.Controllers.SalesControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import org.jsack.tifsa.Database.Customer.Customer;
import org.jsack.tifsa.Database.Customer.CustomerSchema;
import org.jsack.tifsa.Database.DBSelect;
import org.jsack.tifsa.Database.Employee.Employee;
import org.jsack.tifsa.Database.Order.Order;
import org.jsack.tifsa.Database.State.State;
import org.jsack.tifsa.Julius;
import org.jsack.tifsa.Utility;

import javax.annotation.PostConstruct;

/**
 * Created by aaron on 4/19/17.
 */
@ViewController("/Scenes/Sales/OrderForm2.fxml")
public class OrdersController2 {
    @FXML
    Label dateLabel;

    @FXML
    JFXRadioButton pickupSelected, deliverySelected;

    @FXML
    JFXTextField billingFirst, billingMid, billingLast, billingAddress1, billingAddress2, billingCity,
            billingZip, shippingFirst, shippingMid, shippingLast, shippingAddress1, shippingAddress2, shippingCity, shippingZip;

    @FXML
    JFXComboBox<Employee> employeeSelect;

    @FXML
    JFXComboBox<State> billingState, shippingState;

    @FXML
    JFXButton billingSame, nextButton;

    @FXMLViewFlowContext
    ViewFlowContext context;
    final ToggleGroup toggleGroup = new ToggleGroup();
    private Order order = null;

    Property<State> selectedBillingState = new SimpleObjectProperty<>();

    @PostConstruct
    public void init() {
        order = (Order) context.getRegisteredObject("NewOrderCustomer");
        FlowHandler flowHandler = (FlowHandler) context.getRegisteredObject("ContentFlowHandler");
        System.out.println(order.getOrderBillingState());
        pickupSelected.setToggleGroup(toggleGroup);
        deliverySelected.setToggleGroup(toggleGroup);
        billingState.setItems(Julius.getAllStates());
        shippingState.setItems(Julius.getAllStates());
        employeeSelect.setItems(Julius.getAllEmployees());
        billingState.valueProperty().bindBidirectional(selectedBillingState);
        billingSame.setOnMouseClicked(e -> {
            shippingFirst.setText(billingFirst.getText());
            shippingMid.setText(billingMid.getText());
            shippingLast.setText(billingLast.getText());
            shippingAddress1.setText(billingAddress1.getText());
            shippingAddress2.setText(billingAddress2.getText());
            shippingCity.setText(billingCity.getText());
            shippingState.setValue(billingState.getValue());
            shippingZip.setText(billingZip.getText());
            shippingState.getSelectionModel().select(billingState.getSelectionModel().getSelectedIndex());
        });
        nextButton.setOnMouseClicked(e -> {
            order.setOrderBillingFirst(billingFirst.getText());
            order.setOrderBillingLast(billingLast.getText());
            order.setOrderBillingStreet(billingAddress1.getText());
            order.setOrderBillingStreet2(billingAddress2.getText());
            order.setOrderBillingState(Utility.getStateIdByName(billingState.getSelectionModel().getSelectedItem().toString()));
            order.setOrderBillingCity(billingCity.getText());
            order.setOrderBillingZip(billingZip.getText());
            order.setOrderShippingStreet(shippingAddress1.getText());
            order.setOrderShippingStreet2(shippingAddress2.getText());
            order.setOrderShippingState(Utility.getStateIdByName(shippingState.getSelectionModel().getSelectedItem().toString()));
            order.setOrderShippingCity(shippingCity.getText());
            order.setOrderShippingZip(shippingZip.getText());
            order.setSoldByEmployeeId(Utility.getEmployeeIdByName(employeeSelect.getSelectionModel().getSelectedItem().toString()));
            order.setOrderCashOnDelivery("1");

            context.register("NewOrderIsDelivery", deliverySelected.isSelected());

            // TODO: create order in database
           try {
               flowHandler.navigateTo(OrdersController3.class);
           } catch (Exception ex) { }

        });
        setValues();
    }

    private void setValues() {
        Customer cust = (Customer) new DBSelect().select(new CustomerSchema(), order.getCustomerId());

        if (order != null && cust != null) {
            billingFirst.setText(Utility.blankIfNull(cust.getCustomerBillingFirst()));
            billingMid.setText(Utility.blankIfNull(cust.getCustomerBillingMiddleInitial()));
            billingLast.setText(Utility.blankIfNull(cust.getCustomerBillingLast()));
            billingAddress1.setText(Utility.blankIfNull(cust.getCustomerAddressStreet()));
            billingAddress2.setText(Utility.blankIfNull(cust.getCustomerAddressStreet2()));
            billingCity.setText(Utility.blankIfNull(cust.getCustomerAddressCity()));
            billingZip.setText(Utility.blankIfNull(cust.getCustomerAddressZip()));

            selectedBillingState.setValue(Utility.getStateById(cust.getStateId()));
            billingState.setPromptText("");
        }
    }
}
