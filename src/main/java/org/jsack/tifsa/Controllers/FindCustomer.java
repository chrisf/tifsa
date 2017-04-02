package org.jsack.tifsa.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.jsack.tifsa.Database.Customer.Customer;
import org.jsack.tifsa.Database.Customer.CustomerDAO;
import org.jsack.tifsa.Database.CustomerContact.CustomerContactDAO;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by aaron on 4/1/17.
 */
public class FindCustomer implements Initializable {
    private CustomerContactDAO customerContactDAO;
    private CustomerDAO customerDAO;
    private List<Customer> results;

    @FXML private TextField contactInfoField;
    @FXML private TextField customerFirstField;
    @FXML private TextField customerLastField;
    @FXML private Button searchButton;
    @FXML TableView<Customer> resultTable;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void search() {

    }

    private void searchByContact() {

    }
    private void searchByName() {

    }

}
