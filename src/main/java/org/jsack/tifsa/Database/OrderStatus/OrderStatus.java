package org.jsack.tifsa.Database.OrderStatus;

/**
 * Created by chris on 3/20/17.
 */
public class OrderStatus {
    private long orderStatusId;
    private String orderStatusDescription;

    public long getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(long orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getOrderStatusDescription() {
        return orderStatusDescription;
    }

    public void setOrderStatusDescription(String orderStatusDescription) {
        this.orderStatusDescription = orderStatusDescription;
    }
}
