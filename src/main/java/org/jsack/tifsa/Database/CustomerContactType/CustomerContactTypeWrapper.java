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

        customerContactType.setCustomerContactTypeDescription(resultSet.getString("CustomerContactTypeDescription"));
        customerContactType.setDeleted(Boolean.parseBoolean(resultSet.getString("Deleted")));

        return customerContactType;
    }
}
