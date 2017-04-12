package org.jsack.tifsa.Database.OrderLineIncident;

/**
 * Created by steven on 4/11/17.
 */

public class Orderlineincident {
  private Long orderlineincidentid;
  private Long incidenttypeid;
  private String orderlineincidentdescription;
  private java.sql.Timestamp orderlineincidentdate;

  public Long getOrderlineincidentid() {
    return orderlineincidentid;
  }

  public void setOrderlineincidentid(Long orderlineincidentid) {
    this.orderlineincidentid = orderlineincidentid;
  }

  public Long getIncidenttypeid() {
    return incidenttypeid;
  }

  public void setIncidenttypeid(Long incidenttypeid) {
    this.incidenttypeid = incidenttypeid;
  }

  public String getOrderlineincidentdescription() {
    return orderlineincidentdescription;
  }

  public void setOrderlineincidentdescription(String orderlineincidentdescription) {
    this.orderlineincidentdescription = orderlineincidentdescription;
  }

  public java.sql.Timestamp getOrderlineincidentdate() {
    return orderlineincidentdate;
  }

  public void setOrderlineincidentdate(java.sql.Timestamp orderlineincidentdate) {
    this.orderlineincidentdate = orderlineincidentdate;
  }
}
