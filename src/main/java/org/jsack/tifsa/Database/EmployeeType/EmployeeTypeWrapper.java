package org.jsack.tifsa.Database.EmployeeType;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/16/2017.
 */
public class EmployeeTypeWrapper implements RowMapper<EmployeeType> {
    @Override
    public EmployeeType mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeType employeeType = new EmployeeType();

        employeeType.setEmployeeTypeId(rs.getLong("EmployeeTypeID"));
        employeeType.setEmployeeTypeDescription(rs.getString("EmployeeTypeDescription"));
        employeeType.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return employeeType;
    }
}
