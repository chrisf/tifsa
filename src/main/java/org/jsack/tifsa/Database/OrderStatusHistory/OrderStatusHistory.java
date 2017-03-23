package org.jsack.tifsa.Database.OrderStatusHistory;

import java.sql.Timestamp;

/**
 * Created by chris on 3/20/17.
 */
public class OrderStatusHistory {
    private long orderStatusId;
    private long orderId;
    private Timestamp orderStatusHistoryDate;
    private Timestamp orderStatusHistoryEndDate;
    private int orderStatusHistoryId;

    public long getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(long orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Timestamp getOrderStatusHistoryDate() {
        return orderStatusHistoryDate;
    }

    public void setOrderStatusHistoryDate(Timestamp orderStatusHistoryDate) {
        this.orderStatusHistoryDate = orderStatusHistoryDate;
    }

    public Timestamp getOrderStatusHistoryEndDate() {
        return orderStatusHistoryEndDate;
    }

    public void setOrderStatusHistoryEndDate(Timestamp orderStatusHistoryEndDate) {
        this.orderStatusHistoryEndDate = orderStatusHistoryEndDate;
    }

    public int getOrderStatusHistoryId() {
        return orderStatusHistoryId;
    }

    public void setOrderStatusHistoryId(int orderStatusHistoryId) {
        this.orderStatusHistoryId = orderStatusHistoryId;
    }
}
