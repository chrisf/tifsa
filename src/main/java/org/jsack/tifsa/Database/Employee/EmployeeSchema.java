package org.jsack.tifsa.Database.Employee;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/13/17.
 */
public class EmployeeSchema implements ISchema {
    @Override
    public String getName() {
        return "Employee";
    }

    @Override
    public String getIdColumn() {
        return "EmployeeID";
    }

    @Override
    public RowMapper getWrapper() {
        return new EmployeeWrapper();
    }
}
