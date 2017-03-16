package org.jsack.tifsa.Database.CustomerStatus;

/**
 * Created by aaron on 3/16/17.
 */
public class CustomerStatus {
    private int customerStatusId;
    private String customerStatusDescription;

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
}
