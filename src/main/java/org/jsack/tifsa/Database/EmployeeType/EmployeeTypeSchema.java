package org.jsack.tifsa.Database.EmployeeType;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by Admin on 4/16/2017.
 */
public class EmployeeTypeSchema implements ISchema {
    @Override
    public String getName() {
        return "EmployeeType";
    }

    @Override
    public String getIdColumn() {
        return "EmployeeTypeID";
    }

    @Override
    public RowMapper getWrapper() {
        return new EmployeeTypeWrapper();
    }
}
