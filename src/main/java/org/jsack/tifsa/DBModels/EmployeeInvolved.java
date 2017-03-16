package org.jsack.tifsa.DBModels;

/**
 * Created by aaron on 3/16/17.
 */
public class EmployeeInvolved {
    private int employeeId;
    private int employeeIncidentId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeIncidentId() {
        return employeeIncidentId;
    }

    public void setEmployeeIncidentId(int employeeIncidentId) {
        this.employeeIncidentId = employeeIncidentId;
    }
}
