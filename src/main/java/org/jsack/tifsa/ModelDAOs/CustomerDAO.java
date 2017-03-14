package org.jsack.tifsa.ModelDAOs;

import org.jsack.tifsa.DBModelWrappers.CustomerWrapper;
import org.jsack.tifsa.DBModels.Customer;
import org.jsack.tifsa.ModelBase.CustomerBase;

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
        List<Customer> customers = getTemplate().query(sql, new Object[] { id }, new CustomerWrapper());
        if(!customers.isEmpty()) {
            return customers.get(0);
        }
        return null;
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
    public void addNew(String businessName, String first, String middle, String last, String billingFirst, String billingMiddle, String billingLast, String address1, String address2, String addressCity, int state, String zip, int typeId, int statusId) {

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
}