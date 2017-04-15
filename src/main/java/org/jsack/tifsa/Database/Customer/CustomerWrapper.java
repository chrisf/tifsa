package org.jsack.tifsa.Database.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 3/13/17.
 */
public class CustomerWrapper implements org.springframework.jdbc.core.RowMapper<Customer>{
    public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(resultSet.getLong("CustomerID"));
        customer.setCustomerBusinessName(resultSet.getString("CustomerBusinessName"));
        customer.setCustomerFirst(resultSet.getString("CustomerFirst"));
        customer.setCustomerLast(resultSet.getString("CustomerLast"));
        customer.setCustomerMiddleInitial(resultSet.getString("CustomerMiddleInitial"));
        customer.setCustomerBillingFirst(resultSet.getString("CustomerBillingFirst"));
        customer.setCustomerBillingMiddleInitial(resultSet.getString("CustomerBillingMiddleInitial"));
        customer.setCustomerBillingLast(resultSet.getString("CustomerBillingLast"));
        customer.setCustomerAddedOn(resultSet.getTimestamp("CustomerAddedOn"));
        customer.setCustomerAddressStreet(resultSet.getString("CustomerAddressStreet"));
        customer.setCustomerAddressStreet2(resultSet.getString("CustomerAddressStreet2"));
        customer.setCustomerAddressCity(resultSet.getString("CustomerAddressCity"));
        customer.setStateId(resultSet.getLong("StateID"));
        customer.setCustomerAddressZip(resultSet.getString("CustomerAddressZip"));
        customer.setCustomerTypeId(resultSet.getLong("CustomerTypeID"));
        customer.setCustomerStatusId(resultSet.getLong("CustomerStatusID"));
        customer.setDeleted(resultSet.getString("Deleted").equalsIgnoreCase("1"));

        return customer;
    }
}
