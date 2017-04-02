package org.jsack.tifsa.Controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import org.jsack.tifsa.Database.Customer.Customer;
import org.jsack.tifsa.Database.Customer.CustomerDAO;
import org.jsack.tifsa.Database.CustomerContact.CustomerContactDAO;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by aaron on 4/1/17.
 */
public class FindCustomer implements Initializable {
    @FXML
    TableView<Customer> resultTable;
    @FXML
    TableColumn<Customer, String> businessNameColumn, firstNameColumn, lastNameColumn, address1Column;
    private CustomerContactDAO customerContactDAO;
    private CustomerDAO customerDAO;
    private ObservableList<Customer> results;
    @FXML
    private TextField contactInfoField;
    @FXML
    private TextField customerFirstField;
    @FXML
    private TextField customerLastField;
    @FXML
    private Button searchButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerDAO = new CustomerDAO();
        customerContactDAO = new CustomerContactDAO();
        businessNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomerBusinessName()));
        firstNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomerFirst()));
        lastNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomerLast()));
        address1Column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomerAddressStreet()));

        resultTable.setRowFactory(tv -> {
            TableRow<Customer> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                    Customer clicked = row.getItem();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, String.format("You clicked: %s %s\nID: %d", clicked.getCustomerFirst(), clicked.getCustomerLast(), clicked.getCustomerId()));
                    alert.showAndWait();
                }
            });
            return row;
        });
    }

    @FXML
    private void search() {
        String contactInfo = contactInfoField.getText();
        String firstName = customerFirstField.getText();
        String lastName = customerLastField.getText();

        if(!contactInfo.isEmpty()) {
            resultTable.setItems(FXCollections.observableArrayList(customerDAO.selectCustomersByInfo(contactInfo)));
        }
        else if (!firstName.isEmpty() && !lastName.isEmpty()) {
            resultTable.setItems(FXCollections.observableArrayList(customerDAO.selectByName(firstName, lastName, true)));
        }
        else if(!firstName.isEmpty() || !lastName.isEmpty()) {
            resultTable.setItems(FXCollections.observableArrayList(customerDAO.selectByName(firstName, lastName, false)));
        }
        else {
            new Alert(Alert.AlertType.WARNING, "Must specify search terms!").showAndWait();
        }
    }

    private void searchByContact() {

    }

    private void searchByName() {

    }

}
