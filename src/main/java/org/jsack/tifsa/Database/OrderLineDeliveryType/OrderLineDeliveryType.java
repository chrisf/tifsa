package org.jsack.tifsa.Database.OrderLineDeliveryType;

public class OrderLineDeliveryType {
  private Long orderLineDeliveryTypeID;
  private String orderLineDeliveryTypeDescription;
  private boolean deleted;

  public Long getOrderLineDeliveryTypeID() {
    return orderLineDeliveryTypeID;
  }

  public void setOrderLineDeliveryTypeID(Long orderLineDeliveryTypeID) {
    this.orderLineDeliveryTypeID = orderLineDeliveryTypeID;
  }

  public String getOrderLineDeliveryTypeDescription() {
    return orderLineDeliveryTypeDescription;
  }

  public void setOrderLineDeliveryTypeDescription(String orderLineDeliveryTypeDescription) {
    this.orderLineDeliveryTypeDescription = orderLineDeliveryTypeDescription;
  }
public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }
}
