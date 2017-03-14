package org.jsack.tifsa.ModelBase;

import org.jsack.tifsa.DBModels.Customer;

import java.util.List;

/**
 * Created by aaron on 3/13/17.
 */
public abstract class CustomerBase extends ModelBase {

    public abstract List<Customer> selectAll();
    public abstract  Customer findById(int id);
    public abstract List<Customer> findByName(String firstName, String lastName, boolean exclusive);

    public abstract void addNew(String businessName, String first, String middle, String last, String billingFirst, String billingMiddle, String billingLast, String address1, String address2, String addressCity, int state, String zip, int typeId, int statusId);
    public abstract void addNew(String first, String last, String street1, String street2, String city, String zip, String state);
    public abstract void addNew(String businessName, String first, String last, String street1, String street2, String city, String zip, String state);
    public abstract void addNew(String first, String last);


}