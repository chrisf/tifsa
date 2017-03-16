package org.jsack.tifsa.DBModelWrappers;

import org.jsack.tifsa.DBModels.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 3/13/17.
 */
public class CustomerWrapper implements org.springframework.jdbc.core.RowMapper<Customer>{
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("CustomerID"));
        customer.setCustomerBusinessName(rs.getString("CustomerBusinessName"));
        customer.setCustomerFirst(rs.getString("CustomerFirst"));
        customer.setCustomerLast(rs.getString("CustomerLast"));
        customer.setCustomerMiddleInitial(rs.getString("CustomerMiddleInitial"));
        customer.setCustomerBillingFirst(rs.getString("CustomerBillingFirst"));
        customer.setCustomerBillingMiddleInitial(rs.getString("CustomerBillingMiddleInitial"));
        customer.setCustomerBillingLast(rs.getString("CustomerBillingLast"));
        customer.setCustomerAddedOn(rs.getDate("CustomerAddedOn"));
        customer.setCustomerAddressStreet(rs.getString("CustomerAddressStreet"));
        customer.setCustomerAddressStreet2(rs.getString("CustomerAddressStreet2"));
        customer.setCustomerAddressCity(rs.getString("CustomerAddressCity"));
        customer.setStateId(rs.getInt("StateID"));
        customer.setCustomerAddressZip(rs.getString("CustomerAddressZip"));
        customer.setCustomerTypeId(rs.getInt("CustomerTypeID"));
        customer.setCustomerStatusId(rs.getInt("CustomerStatusID"));
        return customer;
    }
}
