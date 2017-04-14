package org.jsack.tifsa.Database.CustomerContact;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 3/22/17.
 */
public class CustomerContactWrapper implements RowMapper<CustomerContact> {

    @Override
    public CustomerContact mapRow(ResultSet resultSet, int i) throws SQLException {
        CustomerContact customerContact = new CustomerContact();

        customerContact.setCustomerContactId(resultSet.getLong("CustomerContactID"));
        customerContact.setCustomerId(resultSet.getLong("CustomerID"));
        customerContact.setCustomerContactTypeId(resultSet.getLong("CustomerContactTypeID"));
        customerContact.setCustomerContactInfo(resultSet.getString("CustomerContactInfo"));
        customerContact.setCustomerContactPrimary(resultSet.getBoolean("CustomerContactPrimary"));
        customerContact.setDeleted(Boolean.parseBoolean(resultSet.getString("Deleted")));

        return customerContact;
    }
}
