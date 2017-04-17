package org.jsack.tifsa.Database.EmployeeRole;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by Admin on 4/16/2017.
 */
public class EmployeeRoleSchema implements ISchema {
    @Override
    public String getName() {
        return "EmployeeRole";
    }

    @Override
    public String getIdColumn() {
        return "EmployeeRoleID";
    }

    @Override
    public RowMapper getWrapper() {
        return new EmployeeRoleWrapper();
    }
}
