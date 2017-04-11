package org.jsack.tifsa.Reports.EmployeeRevenueByYear;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/11/17.
 */
public class ReportWrapper implements RowMapper<ReportModel> {
    @Override
    public ReportModel mapRow(ResultSet resultSet, int i) throws SQLException {
        ReportModel reportModel = new ReportModel();

        reportModel.getRow().add(resultSet.getString("EmployeeTypeDescription"));
        reportModel.getRow().add(resultSet.getString("EmployeeFirst"));
        reportModel.getRow().add(resultSet.getString("EmployeeLast"));
        reportModel.getRow().add(String.valueOf(resultSet.getDouble("Total")));

        return reportModel;
    }
}