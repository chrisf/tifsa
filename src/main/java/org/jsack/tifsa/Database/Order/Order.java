package org.jsack.tifsa.Database.Order;

import java.sql.Timestamp;

public class Order {
  private Long orderid;
  private Long customerid;
  private Double ordertotal;
  private java.sql.Timestamp orderdate;
  private String orderbillingfirst;
  private String orderbillinglast;
  private String orderbillingstreet;
  private String orderbillingstreet2;
  private Long orderbillingstate;
  private String orderbillingcity;
  private String orderbillingzip;
  private Double orderpaid;
  private Double orderbalance;
  private String ordercashondelivery;
  private Long orderstatusid;
  private java.sql.Timestamp orderstatusdate;
  private Double ordertax;
  private Double orderfee;
  private Long soldbyemployeeid;
  private Timestamp ordercompletedon;
  private String ordershippingstreet;
  private String ordershippingstreet2;
  private Long ordershippingstate;
  private String ordershippingcity;
  private String ordershippingzip;

  public Long getOrderid() {
    return orderid;
  }

  public void setOrderid(Long orderid) {
    this.orderid = orderid;
  }

  public Long getCustomerid() {
    return customerid;
  }

  public void setCustomerid(Long customerid) {
    this.customerid = customerid;
  }

  public Double getOrdertotal() {
    return ordertotal;
  }

  public void setOrdertotal(Double ordertotal) {
    this.ordertotal = ordertotal;
  }

  public java.sql.Timestamp getOrderdate() {
    return orderdate;
  }

  public void setOrderdate(java.sql.Timestamp orderdate) {
    this.orderdate = orderdate;
  }

  public String getOrderbillingfirst() {
    return orderbillingfirst;
  }

  public void setOrderbillingfirst(String orderbillingfirst) {
    this.orderbillingfirst = orderbillingfirst;
  }

  public String getOrderbillinglast() {
    return orderbillinglast;
  }

  public void setOrderbillinglast(String orderbillinglast) {
    this.orderbillinglast = orderbillinglast;
  }

  public String getOrderbillingstreet() {
    return orderbillingstreet;
  }

  public void setOrderbillingstreet(String orderbillingstreet) {
    this.orderbillingstreet = orderbillingstreet;
  }

  public String getOrderbillingstreet2() {
    return orderbillingstreet2;
  }

  public void setOrderbillingstreet2(String orderbillingstreet2) {
    this.orderbillingstreet2 = orderbillingstreet2;
  }

  public Long getOrderbillingstate() {
    return orderbillingstate;
  }

  public void setOrderbillingstate(Long orderbillingstate) {
    this.orderbillingstate = orderbillingstate;
  }

  public String getOrderbillingcity() {
    return orderbillingcity;
  }

  public void setOrderbillingcity(String orderbillingcity) {
    this.orderbillingcity = orderbillingcity;
  }

  public String getOrderbillingzip() {
    return orderbillingzip;
  }

  public void setOrderbillingzip(String orderbillingzip) {
    this.orderbillingzip = orderbillingzip;
  }

  public Double getOrderpaid() {
    return orderpaid;
  }

  public void setOrderpaid(Double orderpaid) {
    this.orderpaid = orderpaid;
  }

  public Double getOrderbalance() {
    return orderbalance;
  }

  public void setOrderbalance(Double orderbalance) {
    this.orderbalance = orderbalance;
  }

  public String getOrdercashondelivery() {
    return ordercashondelivery;
  }

  public void setOrdercashondelivery(String ordercashondelivery) {
    this.ordercashondelivery = ordercashondelivery;
  }

  public Long getOrderstatusid() {
    return orderstatusid;
  }

  public void setOrderstatusid(Long orderstatusid) {
    this.orderstatusid = orderstatusid;
  }

  public java.sql.Timestamp getOrderstatusdate() {
    return orderstatusdate;
  }

  public void setOrderstatusdate(java.sql.Timestamp orderstatusdate) {
    this.orderstatusdate = orderstatusdate;
  }

  public Double getOrdertax() {
    return ordertax;
  }

  public void setOrdertax(Double ordertax) {
    this.ordertax = ordertax;
  }

  public Double getOrderfee() {
    return orderfee;
  }

  public void setOrderfee(Double orderfee) {
    this.orderfee = orderfee;
  }

  public Long getSoldbyemployeeid() {
    return soldbyemployeeid;
  }

  public void setSoldbyemployeeid(Long soldbyemployeeid) {
    this.soldbyemployeeid = soldbyemployeeid;
  }

  public Timestamp getOrdercompletedon() {
    return ordercompletedon;
  }

  public void setOrdercompletedon(Timestamp ordercompletedon) {
    this.ordercompletedon = ordercompletedon;
  }

  public String getOrdershippingstreet() {
    return ordershippingstreet;
  }

  public void setOrdershippingstreet(String ordershippingstreet) {
    this.ordershippingstreet = ordershippingstreet;
  }

  public String getOrdershippingstreet2() {
    return ordershippingstreet2;
  }

  public void setOrdershippingstreet2(String ordershippingstreet2) {
    this.ordershippingstreet2 = ordershippingstreet2;
  }

  public Long getOrdershippingstate() {
    return ordershippingstate;
  }

  public void setOrdershippingstate(Long ordershippingstate) {
    this.ordershippingstate = ordershippingstate;
  }

  public String getOrdershippingcity() {
    return ordershippingcity;
  }

  public void setOrdershippingcity(String ordershippingcity) {
    this.ordershippingcity = ordershippingcity;
  }

  public String getOrdershippingzip() {
    return ordershippingzip;
  }

  public void setOrdershippingzip(String ordershippingzip) {
    this.ordershippingzip = ordershippingzip;
  }
}
