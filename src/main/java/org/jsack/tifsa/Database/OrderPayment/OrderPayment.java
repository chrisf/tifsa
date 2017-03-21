package org.jsack.tifsa.Database.OrderPayment;

import java.math.BigDecimal;

/**
 * Created by chris on 3/20/17.
 */
public class OrderPayment {
    private int paymentId;
    private int orderId;
    private BigDecimal orderPaymentAmount;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getOrderPaymentAmount() {
        return orderPaymentAmount;
    }

    public void setOrderPaymentAmount(BigDecimal orderPaymentAmount) {
        this.orderPaymentAmount = orderPaymentAmount;
    }
}
