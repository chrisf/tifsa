package org.jsack.tifsa.Database.EmployeeIncident;

import java.sql.Date;

/**
 * Created by aaron on 3/16/17.
 */
public class EmployeeIncident {
    private long employeeIncidentId;
    private long incidentTypeId;
    private String employeeIncidentDescription;
    private java.sql.Date employeeIncidentDate;
    private boolean deleted;

    public long getEmployeeIncidentId() {
        return employeeIncidentId;
    }

    public void setEmployeeIncidentId(long employeeIncidentId) {
        this.employeeIncidentId = employeeIncidentId;
    }

    public long getIncidentTypeId() {
        return incidentTypeId;
    }

    public void setIncidentTypeId(long incidentTypeId) {
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
