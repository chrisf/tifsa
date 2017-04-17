package org.jsack.tifsa.Reports.EmployeeRevenueByYear;

import javafx.fxml.FXMLLoader;
import org.jsack.tifsa.Reports.Interfaces.IReport;
import org.jsack.tifsa.Reports.Interfaces.IReportModel;
import org.jsack.tifsa.Reports.ReportCategory;
import org.springframework.jdbc.core.RowMapper;

import java.io.IOException;

/**
 * Created by aaron on 4/11/17.
 */
public class Report implements IReport{

    private final String sql = "SELECT dbo.EmployeeType.EmployeeTypeDescription, e1.EmployeeFirst, e1.EmployeeLast, o1.Total " +
            "FROM Employee e1 " +
            "INNER JOIN EmployeeRole ON EmployeeRole.EmployeeID = e1.EmployeeID " +
            "INNER JOIN EmployeeType ON EmployeeRole.EmployeeTypeID = EmployeeType.EmployeeTypeID " +
            "INNER JOIN (" +
            "    SELECT SUM([Order].OrderTotal) AS Total, [Order].SoldByEmployeeID " +
            "    FROM dbo.[Order] " +
            "    WHERE [Order].OrderDate > :yearSelection " +
            "    GROUP BY [Order].SoldByEmployeeID " +
            "    ) AS o1 ON e1.EmployeeID = o1.SoldByEmployeeID " +
            "WHERE EmployeeType.EmployeeTypeID = :employeeSelection ";

    private final String name = "Employee Revenue By Year";

    private ReportCategory reportCategory = ReportCategory.Employee;

    @Override
    public IReportModel getModel() {
        return new ReportModel();
    }

    @Override
    public RowMapper getMapper() {
        return new ReportWrapper();
    }

    @Override
    public ReportCategory getCategory() {
        return reportCategory;
    }

    @Override
    public String getSql() {
        return this.sql;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public FXMLLoader getControls() throws IOException {
        return new FXMLLoader(getClass().getResource("/ReportControls/EmployeeRevenueByYear.fxml"));
    }
}
