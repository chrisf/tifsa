package org.jsack.tifsa.Database.CustomerType;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/13/17.
 */
public class CustomerTypeSchema implements ISchema {
    @Override
    public String getName() {
        return "CustomerType";
    }

    @Override
    public String getIdColumn() {
        return "CustomerTypeID";
    }

    @Override
    public RowMapper getWrapper() {
        return null;
    }
}
