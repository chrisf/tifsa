package org.jsack.tifsa.Database.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO extends CustomerBase {
    public CustomerDAO(){
        this.setSimpleInsert("Customer", "CustomerID");
    }

    @Override
    public List<Customer> selectAll() {
        String sql = "SELECT * FROM Customer";
        List<Customer> customers = getTemplate().query(sql, new CustomerWrapper());
        return customers;
    }

    @Override
    public Customer selectById(long id) {
        String sql = "SELECT * FROM Customer Where (CustomerID = ?)";
        Customer customer = getTemplate().queryForObject(sql, new Object[] { id }, new CustomerWrapper());
        return customer;
    }

    @Override
    public List<Customer> selectByName(String firstName, String lastName, boolean exclusive) {
        String sql = exclusive ? "SELECT * FROM Customer WHERE (CustomerFirst = :firstname AND CustomerLast = :lastname)" :
                "SELECT * FROM Customer WHERE (CustomerFirst = :firstname) OR (CustomerLast = :lastname)";
        Map<String, Object> attributes = new HashMap<String,Object>();

        attributes.put("firstname", firstName);
        attributes.put("lastname", lastName);

        List<Customer> customers = getNamedTemplate().query(sql, attributes, new CustomerWrapper());
        return customers;
    }

    @Override
    public long create(Customer customer) {
        Map<String, Object> attributes = new HashMap<>();

        attributes.put("CustomerBusinessName", customer.getCustomerBusinessName());
        attributes.put("CustomerFirst", customer.getCustomerFirst());
        attributes.put("CustomerMiddleInitial", customer.getCustomerMiddleInitial());
        attributes.put("CustomerLast", customer.getCustomerLast());
        attributes.put("CustomerBillingFirst", customer.getCustomerBillingFirst());
        attributes.put("CustomerBillingMiddleInitial", customer.getCustomerBillingMiddleInitial());
        attributes.put("CustomerBillingLast", customer.getCustomerBillingLast());
        attributes.put("CustomerAddressStreet", customer.getCustomerAddressStreet());
        attributes.put("CustomerAddressStreet2", customer.getCustomerAddressStreet2());
        attributes.put("CustomerAddedOn", customer.getCustomerAddedOn());
        attributes.put("StateID", customer.getStateId());
        attributes.put("CustomerAddressCity", customer.getCustomerAddressCity());
        attributes.put("CustomerAddressZip", customer.getCustomerAddressZip());
        attributes.put("CustomerTypeID", customer.getCustomerTypeId());
        attributes.put("CustomerStatusID", customer.getCustomerStatusId());

        return this.getSimpleInsert().executeAndReturnKey(attributes).longValue();
    }

    @Override
    public int delete(long id) {
        String sql = "DELETE FROM Customer WHERE CustomerID = ?";
        return this.getTemplate().update(sql, new Object[] { id });
    }

    @Override
    public int update(long id, Map<String, Object> attributes){
       return this.update("Customer", "CustomerID", id, attributes);
    }
}