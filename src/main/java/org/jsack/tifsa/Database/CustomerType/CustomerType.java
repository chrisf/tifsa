package org.jsack.tifsa.Database.CustomerType;

/**
 * Created by aaron on 3/16/17.
 */
public class CustomerType {
    private long customerTypeId;
    private String customerTypeName;
    private boolean deleted;

    public long getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(long customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
