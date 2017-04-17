package org.jsack.tifsa.Database.EmployeeHistory;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/14/2017.
 */
public class EmployeeHistoryWrapper implements RowMapper<EmployeeHistory> {
    @Override
    public EmployeeHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeHistory employeeHistory = new EmployeeHistory();

        employeeHistory.setEmployeeHistoryId(rs.getLong("EmployeeHistoryID"));
        employeeHistory.setEmployeeHistoryTypeId(rs.getLong("EmployeeHistoryTypeID"));
        employeeHistory.setEmployeeId(rs.getLong("EmployeeID"));
        employeeHistory.setEmployeeHistoryBeginDate(rs.getDate("EmployeeHistoryBeginDate"));
        employeeHistory.setEmployeeHistoryEndDate(rs.getDate("EmployeeHistoryEndDate"));
        employeeHistory.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return employeeHistory;
    }
}
