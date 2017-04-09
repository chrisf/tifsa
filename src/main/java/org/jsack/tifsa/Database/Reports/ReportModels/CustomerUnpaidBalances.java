package org.jsack.tifsa.Database.Reports.ReportModels;

/**
 * Created by aaron on 4/9/17.
 */

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

}
