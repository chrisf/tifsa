package org.jsack.tifsa.Database.OrderLineIncident;

/**
 * Created by steven on 3/24/17.
 */

public class OrderLineDeliveryType {
    private long orderLineIncidentId;
    private String incidentTypeId;
    private String orderLineIncidentDescription;
    private java.sql.Date orderLineIncidentDate;


    public long getOrderLineIncidentId() {
        return orderLineIncidentId;
    }

    public void setOrderLineIncidentId(long orderLineIncidentId) {
        this.orderLineIncidentId = orderLineIncidentId;
    }

    public String getIncidentTypeId() {
        return incidentTypeId;
    }

    public void setIncidentTypeId(String incidentTypeId) {
        this.incidentTypeId = incidentTypeId;
    }

    public String getOrderLineIncidentDescription() {
        return orderLineIncidentDescription;
    }

    public void setOrderLineIncidentDescription(String orderLineIncidentDescription) {
        this.orderLineIncidentDescription = orderLineIncidentDescription;
    }

    public Date getOrderLineIncidentDate() {
        return orderLineIncidentDate;
    }

    public void setOrderLineIncidentDate(Date orderLineIncidentDate) {
        this.OrderLineIncidentDate = orderLineIncidentDate;
    }

}