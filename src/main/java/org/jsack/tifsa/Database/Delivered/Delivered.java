package org.jsack.tifsa.Database.Delivered;

import java.sql.Date;

/**
 * Created by aaron on 3/16/17.
 */
public class Delivered {
    private long deliveryId;
    private java.sql.Date deliveryDate;
    private long orderLineDeliveryType;
    private long orderLineId;
    private long employeeId;
    private boolean deleted;

    public long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public long getOrderLineDeliveryType() {
        return orderLineDeliveryType;
    }

    public void setOrderLineDeliveryType(long orderLineDeliveryType) {
        this.orderLineDeliveryType = orderLineDeliveryType;
    }

    public long getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(long orderLineId) {
        this.orderLineId = orderLineId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
