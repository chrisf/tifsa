package org.jsack.tifsa.DBModels;

/**
 * Created by aaron on 3/16/17.
 */
public class CustomerType {
    private int customerTypeId;
    private String customerTypeName;

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
