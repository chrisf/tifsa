package org.jsack.tifsa.Database.OrderLineIncident;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderLineIncidentWrapper implements RowMapper<OrderLineIncident> {
    @Override
    public OrderLineIncident mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderLineIncident orderLineIncident = new OrderLineIncident();

        orderLineIncident.setOrderLineIncidentId(rs.getLong("OrderLineIncidentID"));
        orderLineIncident.setIncidentTypeId(rs.getLong("IncidentTypeID"));
        orderLineIncident.setOrderLineIncidentDescription(rs.getString("OrderLineIncidentDescription"));
        orderLineIncident.setOrderLineIncidentDate(rs.getTimestamp("OrderLineIncidentDate"));
        orderLineIncident.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return orderLineIncident;
    }
}
