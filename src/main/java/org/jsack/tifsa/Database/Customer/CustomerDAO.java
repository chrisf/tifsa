package org.jsack.tifsa.Database.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO extends CustomerBase {
    public CustomerDAO(){
    }

    @Override
    public List<Customer> selectAll() {
        String sql = "SELECT * FROM Customer";
        List<Customer> customers = getTemplate().query(sql, new CustomerWrapper());
        return customers;
    }

    @Override
    public Customer findById(int id) {
        String sql = "SELECT * FROM Customer Where (CustomerID = ?)";
        Customer customer = getTemplate().queryForObject(sql, new Object[] { id }, new CustomerWrapper());
        return customer;
    }

    @Override
    public List<Customer> findByName(String firstName, String lastName, boolean exclusive) {
        Map<String, Object> values = new HashMap<String,Object>();
        values.put("firstname", firstName);
        values.put("lastname", lastName);

        String sql = exclusive ? "SELECT * FROM Customer WHERE (CustomerFirst = :firstname AND CustomerLast = :lastname)" :
                "SELECT * FROM Customer WHERE (CustomerFirst = :firstname) OR (CustomerLast = :lastname)";

        List<Customer> customers = getNamedTemplate().query(sql, values, new CustomerWrapper());
        return customers;
    }

    @Override
    public void addNew(String businessName, String first, String middle, String last,
                       String billingFirst, String billingMiddle, String billingLast,
                       String address1, String address2, String addressCity, int state,
                       String zip, int typeId, int statusId) {
        Customer customer = new Customer();
        customer.setCustomerBusinessName(businessName);
        customer.setCustomerFirst(first);
        customer.setCustomerLast(last);
        customer.setCustomerMiddleInitial(middle);
        customer.setCustomerBillingFirst(billingFirst);
        customer.setCustomerBillingMiddleInitial(billingMiddle);
        customer.setCustomerBillingLast(billingLast);
        customer.setCustomerAddressStreet(address1);
        customer.setCustomerAddressStreet2(address2);
        customer.setCustomerAddressCity(addressCity);
        customer.setStateId(state);
        customer.setCustomerAddressZip(zip);
        customer.setCustomerTypeId(typeId);
        customer.setStateId(statusId);

    }

    @Override
    public void addNew(String first, String last, String street1, String street2, String city, String zip, String state) {

    }

    @Override
    public void addNew(String businessName, String first, String last, String street1, String street2, String city, String zip, String state) {

    }

    @Override
    public void addNew(String first, String last) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Customer c){
        String sqlInsert = "INSERT INTO Customer VALUES (DEFAULT,:business, :first, :middle, :last, :billingFirst" +
                ",:billingMiddle, :billingLast,DEFAULT,:street, :street2, :city, :state, :zip, :type, :status)";

        Map<String, Object> values = new HashMap<>();
        values.put("business", c.getCustomerBusinessName());
        values.put("first", c.getCustomerFirst());
        values.put("middle", c.getCustomerMiddleInitial());
        values.put("last", c.getCustomerLast());
        values.put("billingFirst", c.getCustomerBillingFirst());
        values.put("billingMiddle", c.getCustomerBillingMiddleInitial());
        values.put("billingLast", c.getCustomerBillingLast());
        values.put("street", c.getCustomerAddressStreet());
        values.put("street2", c.getCustomerAddressStreet2());
        values.put("city", c.getCustomerAddressCity());
        values.put("state", c.getStateId());
        values.put("zip", c.getCustomerAddressZip());
        values.put("type", c.getCustomerTypeId());
        values.put("status", c.getCustomerStatusId());

       //Not finished yet.

    }
}