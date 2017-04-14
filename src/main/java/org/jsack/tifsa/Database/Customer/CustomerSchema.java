package org.jsack.tifsa.Database.Customer;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/13/17.
 */
public class CustomerSchema implements ISchema{
    @Override
    public String getName() {
        return "Customer";
    }

    @Override
    public String getIdColumn() {
        return "CustomerID";
    }

    @Override
    public RowMapper getWrapper() {
        return new CustomerWrapper();
    }
}
