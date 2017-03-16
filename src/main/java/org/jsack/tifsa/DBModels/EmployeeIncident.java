package org.jsack.tifsa.DBModels;

import java.sql.Date;

/**
 * Created by aaron on 3/16/17.
 */
public class EmployeeIncident {
    private int employeeIncidentId;
    private int incidentTypeId;
    private String employeeIncidentDescription;
    private java.sql.Date employeeIncidentDate;

    public int getEmployeeIncidentId() {
        return employeeIncidentId;
    }

    public void setEmployeeIncidentId(int employeeIncidentId) {
        this.employeeIncidentId = employeeIncidentId;
    }

    public int getIncidentTypeId() {
        return incidentTypeId;
    }

    public void setIncidentTypeId(int incidentTypeId) {
        this.incidentTypeId = incidentTypeId;
    }

    public String getEmployeeIncidentDescription() {
        return employeeIncidentDescription;
    }

    public void setEmployeeIncidentDescription(String employeeIncidentDescription) {
        this.employeeIncidentDescription = employeeIncidentDescription;
    }

    public Date getEmployeeIncidentDate() {
        return employeeIncidentDate;
    }

    public void setEmployeeIncidentDate(Date employeeIncidentDate) {
        this.employeeIncidentDate = employeeIncidentDate;
    }
}
