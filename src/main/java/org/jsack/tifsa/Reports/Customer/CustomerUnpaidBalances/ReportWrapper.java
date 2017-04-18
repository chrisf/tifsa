package org.jsack.tifsa.Reports.Customer.CustomerUnpaidBalances;

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

       /*
           TODO: Add column headers from your report into the array.
           The data being inserted must be a String type, so you may have to do some conversions!

           For example, if the data is a double in a column called OrderTotal you would do the following:
           reportModel.getRow().add(String.valueOf(resultSet.getDouble("OrderTotal")));

           If it is a date, do the following:
           reportModel.getRow().add(resultSet.getDate("OrderDate").toString());

           Make sure these headers are spelled exactly the same as what appears on your report results when running from SSMS
           and in the exact same order!
        */
        reportModel.getRow().add(resultSet.getString("CustomerFirst"));
        reportModel.getRow().add(resultSet.getString("CustomerLast"));
        reportModel.getRow().add(resultSet.getString("CustomerContactInfo"));
        reportModel.getRow().add(resultSet.getString("CustomerContactTypeDescription"));
        reportModel.getRow().add(String.valueOf(resultSet.getDouble("OrderBalance")));

       return reportModel;
    }
}