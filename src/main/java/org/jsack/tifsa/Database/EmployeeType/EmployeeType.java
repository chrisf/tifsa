package org.jsack.tifsa.Database.EmployeeType;

public class EmployeeType {
  private Long employeeTypeId;
  private String employeeTypeDescription;



  private boolean deleted;

  public Long getEmployeeTypeId() {
    return employeeTypeId;
  }

  public void setEmployeeTypeId(Long employeeTypeId) {
    this.employeeTypeId = employeeTypeId;
  }

  public String getEmployeeTypeDescription() {
    return employeeTypeDescription;
  }

  public void setEmployeeTypeDescription(String employeeTypeDescription) {
    this.employeeTypeDescription = employeeTypeDescription;
  }

public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }
}
