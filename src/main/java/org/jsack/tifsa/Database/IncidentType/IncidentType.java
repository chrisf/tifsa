package org.jsack.tifsa.Database.IncidentType;

public class IncidentType {
  private Long incidentTypeId;
  private String incidentTypeDescription;
  private boolean deleted;

  public Long getIncidentTypeId() {
    return incidentTypeId;
  }

  public void setIncidentTypeId(Long incidentTypeId) {
    this.incidentTypeId = incidentTypeId;
  }

  public String getIncidentTypeDescription() {
    return incidentTypeDescription;
  }

  public void setIncidentTypeDescription(String incidentTypeDescription) {
    this.incidentTypeDescription = incidentTypeDescription;
  }

public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }
}
