package org.jsack.tifsa.OrderDiscount;

/**
 * Created by Katie on 3/22/2017.
 */
public class OrderDiscount {

    private long orderDiscountId;
    private long orderId;
    private double orderDiscountAmount;

    public long getOrderDiscountId() {
        return orderDiscountId;
    }

    public void setOrderDiscountId(long orderDiscountId) {
        this.orderDiscountId = orderDiscountId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public double getOrderDiscountAmount() {
        return orderDiscountAmount;
    }

    public void setOrderDiscountAmount(double orderDiscountAmount) {
        this.orderDiscountAmount = orderDiscountAmount;
    }
}



