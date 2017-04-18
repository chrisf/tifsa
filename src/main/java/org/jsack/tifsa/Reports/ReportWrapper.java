package org.jsack.tifsa.Reports;

import org.jsack.tifsa.Reports.ColumnFormats.*;
import org.jsack.tifsa.Reports.Interfaces.IReportModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/11/17.
 */
public class ReportWrapper implements RowMapper<IReportModel> {
    private IReportModel reportModel;

    public ReportWrapper(IReportModel reportModel)
    {
        this.reportModel = reportModel;
    }

    @Override
    public IReportModel mapRow(final ResultSet resultSet, int i) throws SQLException {
        reportModel.getColumns().entrySet().forEach((entry) ->
        {
            try {
                if(entry.getValue().columnFormat.isAssignableFrom(BooleanColumn.class)) {
                    reportModel.getRow().add(String.valueOf(resultSet.getString(entry.getKey()).equals("1")));
                }
                else if(entry.getValue().columnFormat.isAssignableFrom(CurrencyColumn.class)) {
                    reportModel.getRow().add(String.valueOf(resultSet.getDouble(entry.getKey())));
                }
                else if(entry.getValue().columnFormat.isAssignableFrom(DateColumn.class)) {
                    reportModel.getRow().add(resultSet.getDate(entry.getKey()).toString());
                }
                else if(entry.getValue().columnFormat.isAssignableFrom(DateTimeColumn.class)) {
                    reportModel.getRow().add(resultSet.getDate(entry.getKey()).toString());
                }
                else if(entry.getValue().columnFormat.isAssignableFrom(DecimalColumn.class)) {
                    reportModel.getRow().add(String.valueOf(resultSet.getDouble(entry.getKey())));
                }
                else if(entry.getValue().columnFormat.isAssignableFrom(IntegerColumn.class)) {
                    reportModel.getRow().add(String.valueOf(resultSet.getInt(entry.getKey())));
                }
                else if(entry.getValue().columnFormat.isAssignableFrom(StringColumn.class)) {
                    reportModel.getRow().add(resultSet.getString(entry.getKey()));
                }
                else if(entry.getValue().columnFormat.isAssignableFrom(DateTimeColumn.class)) {
                    reportModel.getRow().add(resultSet.getDate(entry.getKey()).toString());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        return reportModel;
    }
}