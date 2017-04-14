package org.jsack.tifsa.Database.CustomerIncident;

import java.sql.Date;

/**
 * Created by aaron on 3/16/17.
 */
public class CustomerIncident {
    private long customerIncidentId;
    private long orderId;
    private java.sql.Date customerIncidentDate;
    private String customerIncidentDescription;
    private long incidentTypeId;
    private long customerId;
    private boolean deleted;

    public long getCustomerIncidentId() {
        return customerIncidentId;
    }

    public void setCustomerIncidentId(long customerIncidentId) {
        this.customerIncidentId = customerIncidentId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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

    public long getIncidentTypeId() {
        return incidentTypeId;
    }

    public void setIncidentTypeId(long incidentTypeId) {
        this.incidentTypeId = incidentTypeId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
