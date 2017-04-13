package org.jsack.tifsa.Database.CustomerStatus;

/**
 * Created by aaron on 3/16/17.
 */
public class CustomerStatus {
    private int customerStatusId;
    private String customerStatusDescription;
    private boolean deleted;

    public int getCustomerStatusId() {
        return customerStatusId;
    }

    public void setCustomerStatusId(int customerStatusId) {
        this.customerStatusId = customerStatusId;
    }

    public String getCustomerStatusDescription() {
        return customerStatusDescription;
    }

    public void setCustomerStatusDescription(String customerStatusDescription) {
        this.customerStatusDescription = customerStatusDescription;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
