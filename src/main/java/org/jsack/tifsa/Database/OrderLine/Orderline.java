package org.jsack.tifsa.Database.OrderLine;
/**
 * Created by steven on 4/11/17.
 */

public class Orderline {
  private Long orderlineid;
  private Long orderid;
  private Long productid;
  private Long orderlinequantity;
  private Double orderlinediscount;
  private java.sql.Timestamp orderlinerecieved;
  private java.sql.Timestamp orderlinedelivered;
  private java.sql.Timestamp orderlinedeliveron;
  private Long orderlinedeliverytypeid;
  private Long orderlinestatusid;

  public Long getOrderlineid() {
    return orderlineid;
  }

  public void setOrderlineid(Long orderlineid) {
    this.orderlineid = orderlineid;
  }

  public Long getOrderid() {
    return orderid;
  }

  public void setOrderid(Long orderid) {
    this.orderid = orderid;
  }

  public Long getProductid() {
    return productid;
  }

  public void setProductid(Long productid) {
    this.productid = productid;
  }

  public Long getOrderlinequantity() {
    return orderlinequantity;
  }

  public void setOrderlinequantity(Long orderlinequantity) {
    this.orderlinequantity = orderlinequantity;
  }

  public Double getOrderlinediscount() {
    return orderlinediscount;
  }

  public void setOrderlinediscount(Double orderlinediscount) {
    this.orderlinediscount = orderlinediscount;
  }

  public java.sql.Timestamp getOrderlinerecieved() {
    return orderlinerecieved;
  }

  public void setOrderlinerecieved(java.sql.Timestamp orderlinerecieved) {
    this.orderlinerecieved = orderlinerecieved;
  }

  public java.sql.Timestamp getOrderlinedelivered() {
    return orderlinedelivered;
  }

  public void setOrderlinedelivered(java.sql.Timestamp orderlinedelivered) {
    this.orderlinedelivered = orderlinedelivered;
  }

  public java.sql.Timestamp getOrderlinedeliveron() {
    return orderlinedeliveron;
  }

  public void setOrderlinedeliveron(java.sql.Timestamp orderlinedeliveron) {
    this.orderlinedeliveron = orderlinedeliveron;
  }

  public Long getOrderlinedeliverytypeid() {
    return orderlinedeliverytypeid;
  }

  public void setOrderlinedeliverytypeid(Long orderlinedeliverytypeid) {
    this.orderlinedeliverytypeid = orderlinedeliverytypeid;
  }

  public Long getOrderlinestatusid() {
    return orderlinestatusid;
  }

  public void setOrderlinestatusid(Long orderlinestatusid) {
    this.orderlinestatusid = orderlinestatusid;
  }
}
