package org.jsack.tifsa.Database.OrderLineStatus;

/**
 * Created by chris on 3/20/17.
 */
public class OrderLineStatus {
    private long orderLineStatusId;
    private String orderLineStatusDescription;
    private boolean deleted;

    public long getOrderLineStatusId() {
        return orderLineStatusId;
    }

    public void setOrderLineStatusId(long orderLineStatusId) {
        this.orderLineStatusId = orderLineStatusId;
    }

    public String getOrderLineStatusDescription() {
        return orderLineStatusDescription;
    }

    public void setOrderLineStatusDescription(String orderLineStatusDescription) {
        this.orderLineStatusDescription = orderLineStatusDescription;
    }
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
