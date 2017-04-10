package org.jsack.tifsa.Database.Reports.ReportWrappers;

import org.jsack.tifsa.Database.Reports.ReportModels.EmployeeRevenueByYear;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/9/17.
 */
public class EmployeeRevenueByYearWrapper implements RowMapper<EmployeeRevenueByYear> {
    @Override
    public EmployeeRevenueByYear mapRow(ResultSet resultSet, int i) throws SQLException {
        EmployeeRevenueByYear employeeRevenueByYear = new EmployeeRevenueByYear();

        employeeRevenueByYear.getRow().add(resultSet.getString("EmployeeTypeDescription"));
        employeeRevenueByYear.getRow().add(resultSet.getString("EmployeeFirst"));
        employeeRevenueByYear.getRow().add(resultSet.getString("EmployeeLast"));
        employeeRevenueByYear.getRow().add(String.valueOf(resultSet.getDouble("Total")));

        return employeeRevenueByYear;
    }
}
