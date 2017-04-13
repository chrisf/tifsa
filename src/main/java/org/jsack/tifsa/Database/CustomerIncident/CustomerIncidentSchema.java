package org.jsack.tifsa.Database.CustomerIncident;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/13/17.
 */
public class CustomerIncidentSchema implements ISchema {
    @Override
    public String getName() {
        return "CustomerIncident";
    }

    @Override
    public String getIdColumn() {
        return "CustomerIncidentID";
    }

    @Override
    public RowMapper getWrapper() {
        return new CustomerIncidentWrapper();
    }
}
