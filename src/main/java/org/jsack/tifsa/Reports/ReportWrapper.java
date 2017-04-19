package org.jsack.tifsa.Reports;

import org.jsack.tifsa.Reports.Interfaces.IReport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/11/17.
 */
public class ReportWrapper implements RowMapper<ReportModelBase> {

    private IReport report;
    public ReportWrapper(IReport report) {
       this.report = report;
    }
    @Override
    public ReportModelBase mapRow(ResultSet resultSet, int i) throws SQLException {
        ReportModelBase reportModel = report.getModel();
        reportModel.getColumns().entrySet().forEach((entry) ->
        {
            try {
                reportModel.getRow().add(resultSet.getObject(entry.getKey()).toString());
           } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return reportModel;
    }
}