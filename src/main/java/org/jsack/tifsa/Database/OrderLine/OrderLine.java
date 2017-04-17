package org.jsack.tifsa.Database.OrderLine;

public class OrderLine {
  private Long orderLineId;
  private Long orderId;
  private Long productId;
  private Long orderLineQuantity;
  private Double orderLineDiscount;
  private java.sql.Timestamp orderLineRecieved;
  private java.sql.Timestamp orderLineDelivered;
  private java.sql.Timestamp orderLineDeliverOn;
  private Long orderLineDeliveryTypeId;
  private Long orderLineStatusId;
  private boolean deleted;


  public Long getOrderLineId() {
    return orderLineId;
  }

  public void setOrderLineId(Long orderLineId) {
    this.orderLineId = orderLineId;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Long getOrderLineQuantity() {
    return orderLineQuantity;
  }

  public void setOrderLineQuantity(Long orderLineQuantity) {
    this.orderLineQuantity = orderLineQuantity;
  }

  public Double getOrderLineDiscount() {
    return orderLineDiscount;
  }

  public void setOrderLineDiscount(Double orderLineDiscount) {
    this.orderLineDiscount = orderLineDiscount;
  }

  public java.sql.Timestamp getOrderLineRecieved() {
    return orderLineRecieved;
  }

  public void setOrderLineRecieved(java.sql.Timestamp orderLineRecieved) {
    this.orderLineRecieved = orderLineRecieved;
  }

  public java.sql.Timestamp getOrderLineDelivered() {
    return orderLineDelivered;
  }

  public void setOrderLineDelivered(java.sql.Timestamp orderLineDelivered) {
    this.orderLineDelivered = orderLineDelivered;
  }

  public java.sql.Timestamp getOrderLineDeliverOn() {
    return orderLineDeliverOn;
  }

  public void setOrderLineDeliverOn(java.sql.Timestamp orderLineDeliverOn) {
    this.orderLineDeliverOn = orderLineDeliverOn;
  }

  public Long getOrderLineDeliveryTypeId() {
    return orderLineDeliveryTypeId;
  }

  public void setOrderLineDeliveryTypeId(Long orderLineDeliveryTypeId) {
    this.orderLineDeliveryTypeId = orderLineDeliveryTypeId;
  }

  public Long getOrderLineStatusId() {
    return orderLineStatusId;
  }

  public void setOrderLineStatusId(Long orderLineStatusId) {
    this.orderLineStatusId = orderLineStatusId;
  }
public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }
}
