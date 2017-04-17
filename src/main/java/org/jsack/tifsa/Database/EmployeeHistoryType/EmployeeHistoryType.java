package org.jsack.tifsa.Database.EmployeeHistoryType;

/**
 * Created by aaron on 3/16/17.
 */
public class EmployeeHistoryType {
    private long employeeHistoryTypeId;
    private String employeeHistoryTypeDescription;
    private boolean deleted;

    public long getEmployeeHistoryTypeId() {
        return employeeHistoryTypeId;
    }

    public void setEmployeeHistoryTypeId(long employeeHistoryTypeId) {
        this.employeeHistoryTypeId = employeeHistoryTypeId;
    }

    public String getEmployeeHistoryTypeDescription() {
        return employeeHistoryTypeDescription;
    }

    public void setEmployeeHistoryTypeDescription(String employeeHistoryTypeDescription) {
        this.employeeHistoryTypeDescription = employeeHistoryTypeDescription;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


}
