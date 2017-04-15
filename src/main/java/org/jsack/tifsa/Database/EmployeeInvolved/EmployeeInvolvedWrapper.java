package org.jsack.tifsa.Database.EmployeeInvolved;

import org.jsack.tifsa.Database.Employee.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/14/2017.
 */
public class EmployeeInvolvedWrapper implements RowMapper<EmployeeInvolved> {
    @Override
    public EmployeeInvolved mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeInvolved employeeInvolved = new EmployeeInvolved();

        employeeInvolved.setEmployeeId(rs.getLong("EmployeeID"));
        employeeInvolved.setEmployeeIncidentId(rs.getLong("EmployeeIncidentID"));
        employeeInvolved.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return employeeInvolved;
    }
}
