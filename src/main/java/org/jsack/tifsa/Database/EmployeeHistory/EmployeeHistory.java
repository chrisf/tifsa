package org.jsack.tifsa.Database.EmployeeHistory;

import java.sql.Date;

/**
 * Created by aaron on 3/16/17.
 */
public class EmployeeHistory {
    private int employeeHistoryId;
    private int employeeHistoryTypeId;
    private int employeeId;
    private java.sql.Date employeeHistoryBeginDate;
    private java.sql.Date employeeHistoryEndDate;

    public int getEmployeeHistoryId() {
        return employeeHistoryId;
    }

    public void setEmployeeHistoryId(int employeeHistoryId) {
        this.employeeHistoryId = employeeHistoryId;
    }

    public int getEmployeeHistoryTypeId() {
        return employeeHistoryTypeId;
    }

    public void setEmployeeHistoryTypeId(int employeeHistoryTypeId) {
        this.employeeHistoryTypeId = employeeHistoryTypeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
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
}
