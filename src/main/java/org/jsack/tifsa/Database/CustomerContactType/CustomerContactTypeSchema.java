package org.jsack.tifsa.Database.CustomerContactType;

import org.jsack.tifsa.Database.CustomerContact.CustomerContactWrapper;
import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/13/17.
 */
public class CustomerContactTypeSchema implements ISchema {
    @Override
    public String getName() {
        return "CustomerContactType";
    }

    @Override
    public String getIdColumn() {
        return "CustomerContactTypeID";
    }

    @Override
    public RowMapper getWrapper() {
        return new CustomerContactWrapper();
    }
}
