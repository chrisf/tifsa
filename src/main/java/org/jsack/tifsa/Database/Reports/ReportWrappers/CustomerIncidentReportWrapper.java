package org.jsack.tifsa.Database.Reports.ReportWrappers;

import org.jsack.tifsa.Database.Reports.ReportModels.CustomerIncidentReport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/10/17.
 */
public class CustomerIncidentReportWrapper implements RowMapper<CustomerIncidentReport>{

    @Override
    public CustomerIncidentReport mapRow(ResultSet rs, int rowNum) throws SQLException {

        CustomerIncidentReport customerIncidentReport = new CustomerIncidentReport();
        customerIncidentReport.getRow().add(rs.getString("CustomerTypeName"));
        customerIncidentReport.getRow().add(rs.getString("CustomerFirst"));
        customerIncidentReport.getRow().add(rs.getString("CustomerLast"));
        customerIncidentReport.getRow().add(rs.getString("CustomerIncidentDescription"));
        customerIncidentReport.getRow().add(rs.getString("IncidentTypeDescription"));

        return customerIncidentReport;
    }
}
