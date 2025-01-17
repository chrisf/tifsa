package org.jsack.tifsa.Database.CustomerContactType;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/13/17.
 */
public class CustomerContactTypeWrapper implements RowMapper<CustomerContactType> {
    @Override
    public CustomerContactType mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        CustomerContactType customerContactType = new CustomerContactType();

        customerContactType.setCustomerContactTypeID(resultSet.getLong("CustomerContactTypeID"));
        customerContactType.setCustomerContactTypeDescription(resultSet.getString("CustomerContactTypeDescription"));
        customerContactType.setDeleted(resultSet.getString("Deleted").equalsIgnoreCase("1"));

        return customerContactType;
    }
}
