package org.jsack.tifsa.Database.CustomerIncident;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/13/17.
 */
public class CustomerIncidentWrapper implements RowMapper<CustomerIncident> {
    @Override
    public CustomerIncident mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomerIncident customerIncident = new CustomerIncident();

        customerIncident.setOrderId(rs.getLong("OrderID"));
        customerIncident.setCustomerIncidentDate(rs.getDate("CustomerIncidentDate"));
        customerIncident.setCustomerIncidentDescription(rs.getString("CustomerIncidentDescription"));
        customerIncident.setIncidentTypeId(rs.getLong("IncidentTypeID"));
        customerIncident.setCustomerId(rs.getLong("CustomerID"));
        customerIncident.setDeleted(Boolean.parseBoolean(rs.getString("Deleted")));

        return customerIncident;
    }
}
