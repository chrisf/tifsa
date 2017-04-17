package org.jsack.tifsa.Database.Order;

import java.sql.Timestamp;

public class Order {
  private Long orderId;
  private Long customerId;
  private Double orderTotal;
  private java.sql.Timestamp orderDate;
  private String orderBillingFirst;
  private String orderBillingLast;
  private String orderBillingStreet;
  private String orderBillingStreet2;
  private Long orderBillingState;
  private String orderBillingCity;
  private String orderBillingZip;
  private Double orderPaid;
  private Double orderbalance;
  private String orderCashOnDelivery;
  private Long orderStatusId;
  private java.sql.Timestamp orderStatusDate;
  private Double orderTax;
  private Double orderFee;
  private Long soldByEmployeeId;
  private Timestamp orderCompletedOn;
  private String orderShippingStreet;
  private String orderShippingStreet2;
  private Long orderShippingState;
  private String orderShippingCity;
  private String orderShippingZip;
  private boolean deleted;

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Double getOrderTotal() {
    return orderTotal;
  }

  public void setOrderTotal(Double orderTotal) {
    this.orderTotal = orderTotal;
  }

  public java.sql.Timestamp getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(java.sql.Timestamp orderDate) {
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

  public Long getOrderBillingState() {
    return orderBillingState;
  }

  public void setOrderBillingState(Long orderBillingState) {
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

  public Double getOrderPaid() {
    return orderPaid;
  }

  public void setOrderPaid(Double orderPaid) {
    this.orderPaid = orderPaid;
  }

  public Double getOrderbalance() {
    return orderbalance;
  }

  public void setOrderbalance(Double orderbalance) {
    this.orderbalance = orderbalance;
  }

  public String getOrderCashOnDelivery() {
    return orderCashOnDelivery;
  }

  public void setOrderCashOnDelivery(String orderCashOnDelivery) {
    this.orderCashOnDelivery = orderCashOnDelivery;
  }

  public Long getOrderStatusId() {
    return orderStatusId;
  }

  public void setOrderStatusId(Long orderStatusId) {
    this.orderStatusId = orderStatusId;
  }

  public java.sql.Timestamp getOrderStatusDate() {
    return orderStatusDate;
  }

  public void setOrderStatusDate(java.sql.Timestamp orderStatusDate) {
    this.orderStatusDate = orderStatusDate;
  }

  public Double getOrderTax() {
    return orderTax;
  }

  public void setOrderTax(Double orderTax) {
    this.orderTax = orderTax;
  }

  public Double getOrderFee() {
    return orderFee;
  }

  public void setOrderFee(Double orderFee) {
    this.orderFee = orderFee;
  }

  public Long getSoldByEmployeeId() {
    return soldByEmployeeId;
  }

  public void setSoldByEmployeeId(Long soldByEmployeeId) {
    this.soldByEmployeeId = soldByEmployeeId;
  }

  public Timestamp getOrderCompletedOn() {
    return orderCompletedOn;
  }

  public void setOrderCompletedOn(Timestamp orderCompletedOn) {
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

  public Long getOrderShippingState() {
    return orderShippingState;
  }

  public void setOrderShippingState(Long orderShippingState) {
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
public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }
}
