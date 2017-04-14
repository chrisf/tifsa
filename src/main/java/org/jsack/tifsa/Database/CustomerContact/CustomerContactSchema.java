package org.jsack.tifsa.Database.CustomerContact;

import org.jsack.tifsa.Database.Customer.CustomerWrapper;
import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/13/17.
 */
public class CustomerContactSchema implements ISchema {
    @Override
    public String getName() {
        return "CustomerContact";
    }

    @Override
    public String getIdColumn() {
        return "CustomerContactID";
    }

    @Override
    public RowMapper getWrapper() {
        return new CustomerContactWrapper();
    }
}
