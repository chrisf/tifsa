package org.jsack.tifsa.Database.Reports.ReportModels;

/**
 * Created by aaron on 4/9/17.
 */

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the class that models each individual row of our reports.
 * All this class does is hold data.
 */
public class CustomerUnpaidBalances {

    /**
     * Create all your variables based on the column's in your report.
     * There should be a variable for EACH column header.
     * Make sure the datatypes match the column datatypes in the database.
     * Once you create the variables, highlight them, press alt+insert (or right-click -> generate) and click Getter & Setter
     * Then select all the variables and click ok. All your Getter and Setter's should be created.
     */
    public String customerFirst;
    public String customerLast;
    public String customerContactInfo;
    public String customerContactTypeDescription;
    public Double orderBalance;


    public String getCustomerFirst() {
        return customerFirst;
    }

    public void setCustomerFirst(String customerFirst) {
        this.customerFirst = customerFirst;
    }

    public String getCustomerLast() {
        return customerLast;
    }

    public void setCustomerLast(String customerLast) {
        this.customerLast = customerLast;
    }

    public String getCustomerContactInfo() {
        return customerContactInfo;
    }

    public void setCustomerContactInfo(String customerContactInfo) {
        this.customerContactInfo = customerContactInfo;
    }

    public String getCustomerContactTypeDescription() {
        return customerContactTypeDescription;
    }

    public void setCustomerContactTypeDescription(String customerContactTypeDescription) {
        this.customerContactTypeDescription = customerContactTypeDescription;
    }

    public Double getOrderBalance() {
        return orderBalance;
    }

    public void setOrderBalance(Double orderBalance) {
        this.orderBalance = orderBalance;
    }

    /*
        This is how we will return the columns for our table.
     */
    public List<TableColumn<CustomerUnpaidBalances, String>> getColumns() {

            //Create an array list using your model as the first type, and a string as the second.
            List<TableColumn<CustomerUnpaidBalances, String>> columns = new ArrayList<>();

            //Create a TableColumn object for each column in your report, using the TableHeader as the text argument (ex: FirstName is what will show up as the table Header)
            TableColumn<CustomerUnpaidBalances, String> firstName = new TableColumn<>("FirstName");
            TableColumn<CustomerUnpaidBalances, String> lastName = new TableColumn<>("LastName");
            TableColumn<CustomerUnpaidBalances, String> customerContactInfo = new TableColumn<>("CustomerContactInfo");
            TableColumn<CustomerUnpaidBalances, String> customerContactTypeDescription = new TableColumn<>("CustomerContactTypeDescription");
            TableColumn<CustomerUnpaidBalances, String> orderBalance = new TableColumn<>("OrderBalance");

            //Create the "CellValueFactories" these are what will return the values associated with our model.
            //These should ALL be Strings. So if the value in the Model is not a string you must convert it. Look at the 5th column here, OrderTotal, as an Example.
            //If the value is already a string, there is no need for conversion. You just create a SimpleStringProperty using that value.
            firstName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCustomerFirst()));
            lastName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCustomerLast()));
            customerContactInfo.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCustomerContactInfo()));
            customerContactTypeDescription.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCustomerContactTypeDescription()));
            orderBalance.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getOrderBalance())));

            //Add all the columns to our array
            columns.add(firstName);
            columns.add(lastName);
            columns.add(customerContactInfo);
            columns.add(customerContactTypeDescription);
            columns.add(orderBalance);

            //Return the array of columns.
            return columns;
    }

}
