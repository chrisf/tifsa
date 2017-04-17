package org.jsack.tifsa.Database.OrderLineCheck;

public class OrderLineCheck {
  private Long orderLineCheckId;
  private Long orderLineId;
  private Long employeeId;
  private String orderLineCheck;
  private java.sql.Timestamp orderLineCheckDate;
  private boolean deleted;

  public Long getOrderLineCheckId() {
    return orderLineCheckId;
  }

  public void setOrderLineCheckId(Long orderLineCheckId) {
    this.orderLineCheckId = orderLineCheckId;
  }

  public Long getOrderLineId() {
    return orderLineId;
  }

  public void setOrderLineId(Long orderLineId) {
    this.orderLineId = orderLineId;
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public String getOrderLineCheck() {
    return orderLineCheck;
  }

  public void setOrderLineCheck(String orderLineCheck) {
    this.orderLineCheck = orderLineCheck;
  }

  public java.sql.Timestamp getOrderLineCheckDate() {
    return orderLineCheckDate;
  }

  public void setOrderLineCheckDate(java.sql.Timestamp orderLineCheckDate) {
    this.orderLineCheckDate = orderLineCheckDate;
  }
public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }
}
