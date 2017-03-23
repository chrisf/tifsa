package org.jsack.tifsa.Database.Order;

import java.sql.Timestamp;

/**
 * Created by Katie on 3/22/2017.
 */
public class Order {
    private long orderId;
    private long customerId;
    private double orderTotal;
    private java.sql.Timestamp orderDate;
    private String orderBillingFirst;
    private String orderBillingLast;
    private String orderBillingStreet;
    private String orderBillingStreet2;
    private String orderBillingState;
    private String orderBillingCity;
    private String orderBillingZip;
    private double orderPaid;
    private double orderBalance;
    private boolean orderCashOnDelivery;
    private long orderStatusId;
    private java.sql.Timestamp orderStatusDate;
    private double orderTax;
    private double orderFee;
    private long soldByEmployeeId;
    private String orderCompletedOn;
    private String orderShippingStreet;
    private String orderShippingStreet2;
    private String orderShippingState;
    private String orderShippingCity;
    private String orderShippingZip;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderBillingFirst() {
        return orderBillingFirst;
    }

    public void setOrderBillingFirst(String orderBillingFirst) {
        this.orderBillingFirst = orderBillingFirst;
    }

    public String getOrderBillingLast() {
        return orderBillingLast;
    }

    public void setOrderBillingLast(String orderBillingLast) {
        this.orderBillingLast = orderBillingLast;
    }

    public String getOrderBillingStreet() {
        return orderBillingStreet;
    }

    public void setOrderBillingStreet(String orderBillingStreet) {
        this.orderBillingStreet = orderBillingStreet;
    }

    public String getOrderBillingStreet2() {
        return orderBillingStreet2;
    }

    public void setOrderBillingStreet2(String orderBillingStreet2) {
        this.orderBillingStreet2 = orderBillingStreet2;
    }

    public String getOrderBillingState() {
        return orderBillingState;
    }

    public void setOrderBillingState(String orderBillingState) {
        this.orderBillingState = orderBillingState;
    }

    public String getOrderBillingCity() {
        return orderBillingCity;
    }

    public void setOrderBillingCity(String orderBillingCity) {
        this.orderBillingCity = orderBillingCity;
    }

    public String getOrderBillingZip() {
        return orderBillingZip;
    }

    public void setOrderBillingZip(String orderBillingZip) {
        this.orderBillingZip = orderBillingZip;
    }

    public double getOrderPaid() {
        return orderPaid;
    }

    public void setOrderPaid(double orderPaid) {
        this.orderPaid = orderPaid;
    }

    public double getOrderBalance() {
        return orderBalance;
    }

    public void setOrderBalance(double orderBalance) {
        this.orderBalance = orderBalance;
    }

    public boolean isOrderCashOnDelivery() {
        return orderCashOnDelivery;
    }

    public void setOrderCashOnDelivery(boolean orderCashOnDelivery) {
        this.orderCashOnDelivery = orderCashOnDelivery;
    }

    public long getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(long orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public Timestamp getOrderStatusDate() {
        return orderStatusDate;
    }

    public void setOrderStatusDate(Timestamp orderStatusDate) {
        this.orderStatusDate = orderStatusDate;
    }

    public double getOrderTax() {
        return orderTax;
    }

    public void setOrderTax(double orderTax) {
        this.orderTax = orderTax;
    }

    public double getOrderFee() {
        return orderFee;
    }

    public void setOrderFee(double orderFee) {
        this.orderFee = orderFee;
    }

    public long getSoldByEmployeeId() {
        return soldByEmployeeId;
    }

    public void setSoldByEmployeeId(long soldByEmployeeId) {
        this.soldByEmployeeId = soldByEmployeeId;
    }

    public String getOrderCompletedOn() {
        return orderCompletedOn;
    }

    public void setOrderCompletedOn(String orderCompletedOn) {
        this.orderCompletedOn = orderCompletedOn;
    }

    public String getOrderShippingStreet() {
        return orderShippingStreet;
    }

    public void setOrderShippingStreet(String orderShippingStreet) {
        this.orderShippingStreet = orderShippingStreet;
    }

    public String getOrderShippingStreet2() {
        return orderShippingStreet2;
    }

    public void setOrderShippingStreet2(String orderShippingStreet2) {
        this.orderShippingStreet2 = orderShippingStreet2;
    }

    public String getOrderShippingState() {
        return orderShippingState;
    }

    public void setOrderShippingState(String orderShippingState) {
        this.orderShippingState = orderShippingState;
    }

    public String getOrderShippingCity() {
        return orderShippingCity;
    }

    public void setOrderShippingCity(String orderShippingCity) {
        this.orderShippingCity = orderShippingCity;
    }

    public String getOrderShippingZip() {
        return orderShippingZip;
    }

    public void setOrderShippingZip(String orderShippingZip) {
        this.orderShippingZip = orderShippingZip;
    }
}
