package org.jsack.tifsa.Database.EmployeeIncident;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/14/2017.
 */
public class EmployeeIncidentWrapper implements RowMapper<EmployeeIncident> {
    @Override
    public EmployeeIncident mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeIncident employeeIncident = new EmployeeIncident();

        employeeIncident.setEmployeeIncidentId(rs.getLong("EmployeeIncidentID"));
        employeeIncident.setIncidentTypeId(rs.getLong("EmployeeIncidentTypeID"));
        employeeIncident.setEmployeeIncidentDescription(rs.getString("EmployeeIncidentDescription"));
        employeeIncident.setEmployeeIncidentDate(rs.getDate("EmployeeIncidentDate"));
        employeeIncident.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return employeeIncident;
    }
}
