package org.jsack.tifsa.Database.Customer;

import org.jsack.tifsa.Database.ModelBase;

import java.util.List;
import java.util.Map;

/**
 * Created by aaron on 3/13/17.
 */
public abstract class CustomerBase extends ModelBase {

    public abstract List<Customer> selectAll();
    public abstract  Customer selectById(long id);
    public abstract List<Customer> selectByName(String firstName, String lastName, boolean exclusive);

    public abstract long create(Customer customer);

    public abstract int delete(long id);

    public abstract int update(long id, Map<String, Object> attributes);
}
