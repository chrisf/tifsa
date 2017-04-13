package org.jsack.tifsa.Database.CustomerStatus;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/13/17.
 */
public class CustomerStatusSchema implements ISchema {
    @Override
    public String getName() {
        return "CustomerStatus";
    }

    @Override
    public String getIdColumn() {
        return "CustomerStatusID";
    }

    @Override
    public RowMapper getWrapper() {
        return null;
    }
}
