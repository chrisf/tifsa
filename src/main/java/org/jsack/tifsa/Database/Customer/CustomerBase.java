package org.jsack.tifsa.Database.Customer;

import org.jsack.tifsa.Database.ModelBase;

import java.util.List;

/**
 * Created by aaron on 3/13/17.
 */
public abstract class CustomerBase extends ModelBase {

    public abstract List<Customer> selectAll();
    public abstract  Customer selectById(long id);
    public abstract List<Customer> selectByName(String firstName, String lastName, boolean exclusive);

    public abstract long create(String businessName, String first, String middle, String last, String billingFirst, String billingMiddle, String billingLast, String address1, String address2, String addressCity, long state, String zip, long typeId, long statusId);
    public abstract long create(String first, String last, String street1, String street2, String city, String zip, String state);
    public abstract long create(String businessName, String first, String last, String street1, String street2, String city, String zip, String state);
    public abstract long create(String first, String last);

    public abstract int delete();

    public abstract int update(long id, Customer c);
}
