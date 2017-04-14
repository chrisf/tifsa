package org.jsack.tifsa.Database.CustomerContact;

/**
 * Created by aaron on 3/16/17.
 */
public class CustomerContact {


    private long customerContactId;
    private long customerId;
    private long customerContactTypeId;
    private String customerContactInfo;
    private boolean customerContactPrimary;
    private boolean deleted;

    public void setCustomerContactId(long customerContactId) {
        this.customerContactId = customerContactId;
    }

    public void setCustomerContactTypeId(long customerContactTypeId) {
        this.customerContactTypeId = customerContactTypeId;
    }
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    public long getCustomerContactId() {
        return customerContactId;
    }

    public long getCustomerContactTypeId() {
        return customerContactTypeId;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
