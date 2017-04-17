package org.jsack.tifsa.Database.EmployeeStatus;

public class EmployeeStatus {
  private Long employeeStatusId;
  private String employeeStatusDescription;
  private boolean deleted;

  public Long getEmployeeStatusId() {
    return employeeStatusId;
  }

  public void setEmployeeStatusId(Long employeeStatusId) {
    this.employeeStatusId = employeeStatusId;
  }

  public String getEmployeeStatusDescription() {
    return employeeStatusDescription;
  }

  public void setEmployeeStatusDescription(String employeeStatusDescription) {
    this.employeeStatusDescription = employeeStatusDescription;
  }

public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }
}
