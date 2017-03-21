package org.jsack.tifsa.Database.OrderStatus;

/**
 * Created by chris on 3/20/17.
 */
public class OrderStatus {
    private int orderStatusId;
    private String orderStatusDescription;

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getOrderStatusDescription() {
        return orderStatusDescription;
    }

    public void setOrderStatusDescription(String orderStatusDescription) {
        this.orderStatusDescription = orderStatusDescription;
    }
}
