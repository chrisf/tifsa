package org.jsack.tifsa.Database.EmployeeStatus;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/16/2017.
 */
public class EmployeeStatusWrapper implements RowMapper<EmployeeStatus> {
    @Override
    public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeStatus employeeStatus = new EmployeeStatus();

        employeeStatus.setEmployeeStatusId(rs.getLong("EmployeeStatusID"));
        employeeStatus.setEmployeeStatusDescription(rs.getString("EmployeeStatusDescription"));
        employeeStatus.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));
        return employeeStatus;
    }
}
