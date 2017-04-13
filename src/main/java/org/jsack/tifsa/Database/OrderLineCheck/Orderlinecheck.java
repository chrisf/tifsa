package com.my.db;

public class Orderlinecheck {
  private Long orderlinecheckid;
  private Long orderlineid;
  private Long employeeid;
  private String orderlinecheck;
  private java.sql.Timestamp orderlinecheckdate;

  public Long getOrderlinecheckid() {
    return orderlinecheckid;
  }

  public void setOrderlinecheckid(Long orderlinecheckid) {
    this.orderlinecheckid = orderlinecheckid;
  }

  public Long getOrderlineid() {
    return orderlineid;
  }

  public void setOrderlineid(Long orderlineid) {
    this.orderlineid = orderlineid;
  }

  public Long getEmployeeid() {
    return employeeid;
  }

  public void setEmployeeid(Long employeeid) {
    this.employeeid = employeeid;
  }

  public String getOrderlinecheck() {
    return orderlinecheck;
  }

  public void setOrderlinecheck(String orderlinecheck) {
    this.orderlinecheck = orderlinecheck;
  }

  public java.sql.Timestamp getOrderlinecheckdate() {
    return orderlinecheckdate;
  }

  public void setOrderlinecheckdate(java.sql.Timestamp orderlinecheckdate) {
    this.orderlinecheckdate = orderlinecheckdate;
  }
}
