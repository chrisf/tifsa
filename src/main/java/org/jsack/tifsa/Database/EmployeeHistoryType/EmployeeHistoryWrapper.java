package org.jsack.tifsa.Database.EmployeeHistoryType;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/14/2017.
 */
public class EmployeeHistoryWrapper implements RowMapper<EmployeeHistoryType> {
    @Override
    public EmployeeHistoryType mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeHistoryType employeeHistoryType = new EmployeeHistoryType();

        employeeHistoryType.setEmployeeHistoryTypeId(rs.getLong("EmployeeHistoryTypeID"));
        employeeHistoryType.setEmployeeHistoryTypeDescription(rs.getString("EmployeeHistoryTypeDescription"));
        employeeHistoryType.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return employeeHistoryType;
    }
}
