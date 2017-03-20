package org.jsack.tifsa.Database.PaymentType;

/**
 * Created by chris on 3/20/17.
 */
public class PaymentType {
    private int paymentTypeId;
    private String paymentTypeDescription;

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentTypeDescription() {
        return paymentTypeDescription;
    }

    public void setPaymentTypeDescription(String paymentTypeDescription) {
        this.paymentTypeDescription = paymentTypeDescription;
    }
}
