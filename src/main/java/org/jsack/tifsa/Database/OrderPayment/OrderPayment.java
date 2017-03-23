package org.jsack.tifsa.Database.OrderPayment;

/**
 * Created by chris on 3/20/17.
 */
public class OrderPayment {
    private long paymentId;
    private long orderId;
    private double orderPaymentAmount;

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public double getOrderPaymentAmount() {
        return orderPaymentAmount;
    }

    public void setOrderPaymentAmount(double orderPaymentAmount) {
        this.orderPaymentAmount = orderPaymentAmount;
    }
}
