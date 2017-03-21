package org.jsack.tifsa.Database.OrderLineStatus;

/**
 * Created by chris on 3/20/17.
 */
public class OrderLineStatus {
    private int orderLineStatusId;
    private String orderLineStatusDescription;

    public int getOrderLineStatusId() {
        return orderLineStatusId;
    }

    public void setOrderLineStatusId(int orderLineStatusId) {
        this.orderLineStatusId = orderLineStatusId;
    }

    public String getOrderLineStatusDescription() {
        return orderLineStatusDescription;
    }

    public void setOrderLineStatusDescription(String orderLineStatusDescription) {
        this.orderLineStatusDescription = orderLineStatusDescription;
    }
}
