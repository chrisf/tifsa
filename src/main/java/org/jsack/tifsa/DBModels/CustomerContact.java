package org.jsack.tifsa.DBModels;

/**
 * Created by aaron on 3/16/17.
 */
public class CustomerContact {
    private int customerContactId;
    private int customerContactTypeId;
    private String customerContactInfo;
    private boolean customerContactPrimary;

    public int getCustomerContactId() {
        return customerContactId;
    }

    public void setCustomerContactId(int customerContactId) {
        this.customerContactId = customerContactId;
    }

    public int getCustomerContactTypeId() {
        return customerContactTypeId;
    }

    public void setCustomerContactTypeId(int customerContactTypeId) {
        this.customerContactTypeId = customerContactTypeId;
    }

    public String getCustomerContactInfo() {
        return customerContactInfo;
    }

    public void setCustomerContactInfo(String customerContactInfo) {
        this.customerContactInfo = customerContactInfo;
    }

    public boolean isCustomerContactPrimary() {
        return customerContactPrimary;
    }

    public void setCustomerContactPrimary(boolean customerContactPrimary) {
        this.customerContactPrimary = customerContactPrimary;
    }





}
