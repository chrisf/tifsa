package org.jsack.tifsa.Database.CustomerType;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/13/2017.
 */
public class CustomerTypeWrapper implements RowMapper<CustomerType> {
    @Override
    public CustomerType mapRow(ResultSet rs, int rowNum) throws SQLException {
       CustomerType customerType = new CustomerType();

       customerType.setCustomerTypeId(rs.getLong("CustomerTypeID"));
       customerType.setCustomerTypeName(rs.getString("CustomerTypeName"));
       customerType.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

       return customerType;
    }
}
