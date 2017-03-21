package org.jsack.tifsa.Database.OrderStatusHistory;

import java.sql.Date;

/**
 * Created by chris on 3/20/17.
 */
public class OrderStatusHistory {
    private int orderStatusId;
    private int orderId;
    private Date orderStatusHistoryDate;
    private Date orderStatusHistoryEndDate;
    private int orderStatusHistoryId;

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderStatusHistoryDate() {
        return orderStatusHistoryDate;
    }

    public void setOrderStatusHistoryDate(Date orderStatusHistoryDate) {
        this.orderStatusHistoryDate = orderStatusHistoryDate;
    }

    public Date getOrderStatusHistoryEndDate() {
        return orderStatusHistoryEndDate;
    }

    public void setOrderStatusHistoryEndDate(Date orderStatusHistoryEndDate) {
        this.orderStatusHistoryEndDate = orderStatusHistoryEndDate;
    }

    public int getOrderStatusHistoryId() {
        return orderStatusHistoryId;
    }

    public void setOrderStatusHistoryId(int orderStatusHistoryId) {
        this.orderStatusHistoryId = orderStatusHistoryId;
    }
}
