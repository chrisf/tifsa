package org.jsack.tifsa.Database.EmployeeIncident;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/13/17.
 */
public class EmployeeIncidentSchema implements ISchema {
    @Override
    public String getName() {
        return "EmployeeIncident";
    }

    @Override
    public String getIdColumn() {
        return "EmployeeIncidentID";
    }

    @Override
    public RowMapper getWrapper() {
        return null;
    }
}
