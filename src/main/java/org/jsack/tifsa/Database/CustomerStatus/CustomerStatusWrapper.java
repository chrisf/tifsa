package org.jsack.tifsa.Database.CustomerStatus;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/13/17.
 */
public class CustomerStatusWrapper implements RowMapper<CustomerStatus> {
    @Override
    public CustomerStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomerStatus customerStatus = new CustomerStatus();

        customerStatus.setCustomerStatusId(rs.getLong("CustomerStatusID"));
        customerStatus.setCustomerStatusDescription(rs.getString("CustomerStatusDescription"));
        customerStatus.setDeleted(Boolean.parseBoolean(rs.getString("Deleted")));

        return customerStatus;
    }
}
