package org.jsack.tifsa.Database.EmployeeHistory;

import java.sql.Date;

/**
 * Created by aaron on 3/16/17.
 */
public class EmployeeHistory {
    private long employeeHistoryId;
    private long employeeHistoryTypeId;
    private long employeeId;
    private java.sql.Date employeeHistoryBeginDate;
    private java.sql.Date employeeHistoryEndDate;
    private boolean deleted;

    public long getEmployeeHistoryId() {
        return employeeHistoryId;
    }

    public void setEmployeeHistoryId(long employeeHistoryId) {
        this.employeeHistoryId = employeeHistoryId;
    }

    public long getEmployeeHistoryTypeId() {
        return employeeHistoryTypeId;
    }

    public void setEmployeeHistoryTypeId(long employeeHistoryTypeId) {
        this.employeeHistoryTypeId = employeeHistoryTypeId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getEmployeeHistoryBeginDate() {
        return employeeHistoryBeginDate;
    }

    public void setEmployeeHistoryBeginDate(Date employeeHistoryBeginDate) {
        this.employeeHistoryBeginDate = employeeHistoryBeginDate;
    }

    public Date getEmployeeHistoryEndDate() {
        return employeeHistoryEndDate;
    }

    public void setEmployeeHistoryEndDate(Date employeeHistoryEndDate) {
        this.employeeHistoryEndDate = employeeHistoryEndDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
