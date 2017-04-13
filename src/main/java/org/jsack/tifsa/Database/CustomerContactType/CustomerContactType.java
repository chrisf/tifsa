package org.jsack.tifsa.Database.CustomerContactType;

/**
 * Created by aaron on 3/16/17.
 */
public class CustomerContactType {
    private long customerContactTypeID;
    private String customerContactTypeDescription;
    private boolean deleted;

    public long getCustomerContactTypeID() {
        return customerContactTypeID;
    }

    public void setCustomerContactTypeID(long customerContactType) {
        this.customerContactTypeID = customerContactType;
    }

    public String getCustomerContactTypeDescription() {
        return customerContactTypeDescription;
    }

    public void setCustomerContactTypeDescription(String customerContactTypeDescription) {
        this.customerContactTypeDescription = customerContactTypeDescription;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
