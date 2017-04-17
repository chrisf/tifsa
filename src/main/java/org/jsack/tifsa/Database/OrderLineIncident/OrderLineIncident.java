package org.jsack.tifsa.Database.OrderLineIncident;

public class OrderLineIncident {
  private Long orderLineIncidentId;
  private Long incidentTypeId;
  private String orderLineIncidentDescription;
  private java.sql.Timestamp orderLineIncidentDate;
  private boolean deleted;

  public Long getOrderLineIncidentId() {
    return orderLineIncidentId;
  }

  public void setOrderLineIncidentId(Long orderLineIncidentId) {
    this.orderLineIncidentId = orderLineIncidentId;
  }

  public Long getIncidentTypeId() {
    return incidentTypeId;
  }

  public void setIncidentTypeId(Long incidentTypeId) {
    this.incidentTypeId = incidentTypeId;
  }

  public String getOrderLineIncidentDescription() {
    return orderLineIncidentDescription;
  }

  public void setOrderLineIncidentDescription(String orderLineIncidentDescription) {
    this.orderLineIncidentDescription = orderLineIncidentDescription;
  }

  public java.sql.Timestamp getOrderLineIncidentdate() {
    return orderLineIncidentDate;
  }

  public void setOrderLineIncidentDate(java.sql.Timestamp orderLineIncidentDate) {
    this.orderLineIncidentDate = orderLineIncidentDate;
  }
public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }

}
