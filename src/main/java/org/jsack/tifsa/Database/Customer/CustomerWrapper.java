package org.jsack.tifsa.Database.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 3/13/17.
 */
public class CustomerWrapper implements org.springframework.jdbc.core.RowMapper<Customer>{
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(rs.getLong("CustomerID"));
        customer.setCustomerBusinessName(rs.getString("CustomerBusinessName"));
        customer.setCustomerFirst(rs.getString("CustomerFirst"));
        customer.setCustomerLast(rs.getString("CustomerLast"));
        customer.setCustomerMiddleInitial(rs.getString("CustomerMiddleInitial"));
        customer.setCustomerBillingFirst(rs.getString("CustomerBillingFirst"));
        customer.setCustomerBillingMiddleInitial(rs.getString("CustomerBillingMiddleInitial"));
        customer.setCustomerBillingLast(rs.getString("CustomerBillingLast"));
        customer.setCustomerAddedOn(rs.getTimestamp("CustomerAddedOn"));
        customer.setCustomerAddressStreet(rs.getString("CustomerAddressStreet"));
        customer.setCustomerAddressStreet2(rs.getString("CustomerAddressStreet2"));
        customer.setCustomerAddressCity(rs.getString("CustomerAddressCity"));
        customer.setStateId(rs.getLong("StateID"));
        customer.setCustomerAddressZip(rs.getString("CustomerAddressZip"));
        customer.setCustomerTypeId(rs.getLong("CustomerTypeID"));
        customer.setCustomerStatusId(rs.getLong("CustomerStatusID"));
        return customer;
    }
}
