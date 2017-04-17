package org.jsack.tifsa.Database.EmployeeRole;

public class EmployeeRole {
  private Long employeeId;
  private Long employeeTypeId;



  private boolean deleted;


  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public Long getEmployeeTypeId() {
    return employeeTypeId;
  }

  public void setEmployeeTypeId(Long employeeTypeId) {
    this.employeeTypeId = employeeTypeId;
  }

public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }
}
