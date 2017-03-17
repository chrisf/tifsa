package org.jsack.tifsa.Database.Employee;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 3/16/17.
 */
public class EmployeeWrapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getInt("EmployeeID"));
        employee.setEmployeeFirst(resultSet.getString("EmployeeFirst"));
        employee.setEmployeeMiddleInitial(resultSet.getString("EmployeeMiddleInitial"));
        employee.setEmployeeLast(resultSet.getString("EmployeeLast"));
        return employee;
    }
}
