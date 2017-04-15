package org.jsack.tifsa.Database.EmployeeInvolved;

/**
 * Created by aaron on 3/16/17.
 */
public class EmployeeInvolved {
    private long employeeId;
    private long employeeIncidentId;
    private boolean deleted;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getEmployeeIncidentId() {
        return employeeIncidentId;
    }

    public void setEmployeeIncidentId(long employeeIncidentId) {
        this.employeeIncidentId = employeeIncidentId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
