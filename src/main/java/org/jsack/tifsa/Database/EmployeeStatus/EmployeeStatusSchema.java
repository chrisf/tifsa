package org.jsack.tifsa.Database.EmployeeStatus;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by Admin on 4/16/2017.
 */
public class EmployeeStatusSchema implements ISchema {
    @Override
    public String getName() {
        return "EmployeeStatus";
    }

    @Override
    public String getIdColumn() {
        return "EmployeeStatusID";
    }

    @Override
    public RowMapper getWrapper() {
        return new EmployeeStatusWrapper();
    }
}
