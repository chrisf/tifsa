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
    public long create(String businessName, String first, String middle, String last,
                       String billingFirst, String billingMiddle, String billingLast,
                       String address1, String address2, String addressCity, long state,
                       String zip, long typeId, long statusId) {
        Map<String, Object> attributes = new HashMap<>();

        attributes.put("CustomerBusinessName", businessName);
        attributes.put("CustomerFirst", first);
        attributes.put("CustomerMiddleInitial", middle);
        attributes.put("CustomerLast", last);
        attributes.put("CustomerBillingFirst", billingFirst);
        attributes.put("CustomerBillingMiddleInitial", billingMiddle);
        attributes.put("CustomerBillingLast", billingLast);
        attributes.put("CustomerAddressStreet", address1);
        attributes.put("CustomerAddressStreet2", address2);
        attributes.put("StateID", state);
        attributes.put("CustomerAddressCity", addressCity);
        attributes.put("CustomerAddressZip", zip);
        attributes.put("CustomerTypeID", typeId);
        attributes.put("CustomerStatusID", statusId);

        return this.getSimpleInsert().executeAndReturnKey(attributes).longValue();
    }
    /*
     Will need to return to these create methods after we get more DAOs created.
     TODO: Lookups for stateIds
     TODO: Set default status/types for the two different creates. Depends on what data is in the database.
     */

    @Override
    public long create(String first, String last, String street1, String street2, String city, String zip, String state) {
        long stateId = 0; //when StateDAO is created, we can set this to State.getIdByName or something.
        return create(null, first, null, last, first, null, last, street1, street2, city, stateId, zip, 2, 0);
    }

    @Override
    public long create(String businessName, String first, String last, String street1, String street2, String city, String zip, String state) {
        long stateId = 0; //same thing here
        //
        return create(businessName, first, null, last, first, null, last, street1, street2, city, stateId, zip, 1, 0);
    }

    @Override
    public long create(String first, String last) {
        return create(null, first, null, last, first, null, last, null, null, null, 0, null, 1, 0);
    }

    @Override
    public int delete(long id) {
        return this.delete("Customer", "CustomerID", id);
    }

    @Override
    public int update(long id, Customer c){

        return 0;
    }
}