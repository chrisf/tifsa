package org.jsack.tifsa.DBModels;

import java.sql.Date;

/**
 * Created by aaron on 3/16/17.
 */
public class CustomerIncident {
    private int customerIncidentId;
    private int ordersId;
    private java.sql.Date customerIncidentDate;
    private String customerIncidentDescription;
    private int incidentTypeId;
    private int customerId;

    public int getCustomerIncidentId() {
        return customerIncidentId;
    }

    public void setCustomerIncidentId(int customerIncidentId) {
        this.customerIncidentId = customerIncidentId;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public Date getCustomerIncidentDate() {
        return customerIncidentDate;
    }

    public void setCustomerIncidentDate(Date customerIncidentDate) {
        this.customerIncidentDate = customerIncidentDate;
    }

    public String getCustomerIncidentDescription() {
        return customerIncidentDescription;
    }

    public void setCustomerIncidentDescription(String customerIncidentDescription) {
        this.customerIncidentDescription = customerIncidentDescription;
    }

    public int getIncidentTypeId() {
        return incidentTypeId;
    }

    public void setIncidentTypeId(int incidentTypeId) {
        this.incidentTypeId = incidentTypeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

}
