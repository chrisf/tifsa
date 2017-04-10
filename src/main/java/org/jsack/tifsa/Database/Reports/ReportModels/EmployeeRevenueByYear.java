package org.jsack.tifsa.Database.Reports.ReportModels;

import org.jsack.tifsa.Database.Reports.ReportBase;
import org.jsack.tifsa.Database.Reports.ReportCategory;
import org.jsack.tifsa.Database.Reports.ReportWrappers.EmployeeRevenueByYearWrapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron on 4/9/17.
 */
public class EmployeeRevenueByYear implements ReportBase {

    private final String sql = "SELECT dbo.EmployeeType.EmployeeTypeDescription, e1.EmployeeFirst, e1.EmployeeLast, o1.Total " +
            "FROM Employee e1 " +
            "INNER JOIN EmployeeRole ON EmployeeRole.EmployeeID = e1.EmployeeID " +
            "INNER JOIN EmployeeType ON EmployeeRole.EmployeeTypeID = EmployeeType.EmployeeTypeID " +
            "INNER JOIN (" +
            "    SELECT SUM([Order].OrderBalance) AS Total, [Order].SoldByEmployeeID " +
            "    FROM dbo.[Order] " +
            "    WHERE [Order].OrderDate > '2017' " +
            "    GROUP BY [Order].SoldByEmployeeID " +
            "    ) AS o1 ON e1.EmployeeID = o1.SoldByEmployeeID " +
            "WHERE EmployeeType.EmployeeTypeID = 2";


    private final String name = "Employee Revenue By Year";
    private ReportCategory category;
    private List<String> row;
    private List<String> columns;

    public EmployeeRevenueByYear() {
        category = ReportCategory.Employee;

        row = new ArrayList<>();
        columns = new ArrayList<>();

        columns.add("EmployeeTypeDescription");
        columns.add("EmployeeFirst");
        columns.add("EmployeeLast");
        columns.add("Total");
    }

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ReportCategory getCategory() {
        return category;
    }

    /*
     This needs to be set to return your Wrapper!
        ex: return MyReportRapper();
     */
    @Override
    public RowMapper getMapper() {
        return new EmployeeRevenueByYearWrapper();
    }

    @Override
    public List<String> getRow() {
        return row;
    }

    @Override
    public List<String> getColumns() {
        return columns;
    }
}
