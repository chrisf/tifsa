package org.jsack.tifsa.DBModels;

import java.sql.Date;

/**
 * Created by aaron on 3/16/17.
 */
public class Delivered {
    private int deliveryId;
    private java.sql.Date deliveryDate;
    private int orderLineDeliveryType;
    private int orderLineId;
    private int employeeId;

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getOrderLineDeliveryType() {
        return orderLineDeliveryType;
    }

    public void setOrderLineDeliveryType(int orderLineDeliveryType) {
        this.orderLineDeliveryType = orderLineDeliveryType;
    }

    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
