package org.jsack.tifsa.Database.EmployeeRole;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/16/2017.
 */
public class EmployeeRoleWrapper implements RowMapper<EmployeeRole> {

    @Override
    public EmployeeRole mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeRole employeeRole = new EmployeeRole();

        employeeRole.setEmployeeId(rs.getLong("EmployeeRoleID"));
        employeeRole.setEmployeeTypeId(rs.getLong("EmployeeTypeID"));
        employeeRole.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return employeeRole;
    }
}
