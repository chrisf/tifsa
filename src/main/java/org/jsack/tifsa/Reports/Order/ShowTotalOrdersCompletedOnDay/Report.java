package org.jsack.tifsa.Reports.Order.ShowTotalOrdersCompletedOnDay;

import javafx.fxml.FXMLLoader;
import org.jsack.tifsa.Reports.Interfaces.IReport;
import org.jsack.tifsa.Reports.ReportCategory;
import org.jsack.tifsa.Reports.ReportModelBase;
import org.jsack.tifsa.Reports.ReportWrapper;
import org.springframework.jdbc.core.RowMapper;

import java.io.IOException;

/**
 * Created by aaron on 4/11/17.
 */
public class Report implements IReport{

    /*
        TODO: Set this to your SQL report code.
        If you already created your reports using the previous method, just copy and paste it into here.
        If you haven't, copy and paste it from Drive and replace all the "\n" with a space.
     */
    private final String sql = "SELECT DATEPART(day, dbo.[Order].OrderDate) AS Date,\n" +
            "DATENAME (month, dbo.[Order].OrderDate) AS Month,\n" +
            "COUNT(case when dbo.[Order].OrderStatusID = '4' then 1 else null end) AS TotalOrdersCompleted,\n" +
            "dbo.Employee.EmployeeFirst, dbo.Employee.EmployeeLast,\n" +
            "dbo.EmployeeType.EmployeeTypeDescription FROM [Order]\n" +
            "\n" +
            "INNER JOIN Employee ON [Order].SoldByEmployeeID = Employee.EmployeeID\n" +
            "INNER JOIN EmployeeRole ON Employee.EmployeeID = EmployeeRole.EmployeeID\n" +
            "INNER JOIN EmployeeType ON EmployeeRole.EmployeeTypeID = EmployeeType.EmployeeTypeID\n" +
            "\n" +
            "WHERE (EmployeeType.EmployeeTypeID='4' OR EmployeeType.EmployeeTypeID='5' OR EmployeeType.EmployeeTypeID='6') AND [Order].OrderDate BETWEEN '2008-07-07' AND '2008-07-08' AND [Order].Deleted = 0\n" +
            "\n" +
            "GROUP BY  DATENAME(month,[Order].OrderDate),\n" +
            "DATEPART(day, [Order].OrderDate),\n" +
            "Employee.EmployeeFirst, Employee.EmployeeLast,\n" +
            "EmployeeType.EmployeeTypeDescription\n";

    /*
        TODO: Name your report.
        Set the name of your report here. Make it unique.
     */
    private final String name = "Show Total Orders Completed On Day";

    /*
        TODO: Set report Category.
        Set the report category of this specific report. A list of available Categories are:
            Customer,
            Order,
            Vendor,
            Sales,
            Delivery,
            Employee,
            Product
     */
    private ReportCategory reportCategory = ReportCategory.Order;

    @Override
    public ReportModelBase getModel() {
        return new ReportModel();
    }

    @Override
    public RowMapper getMapper() {
        return new ReportWrapper(this);
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

    /*
        TODO: Change to the path of your .fxml file for your controls
        This should be the FXML file you create in the /resources/ReportControls/ directory following the template there.
        This is what enables each report to have custom controls.
        Change the "template.fxml" to the correct name of your template. Look at reports I have created for examples.
     */
    @Override
    public FXMLLoader getControls() throws IOException {
        return new FXMLLoader(getClass().getResource("/ReportControls/ShowTotalOrdersCompletedOnDay.fxml"));
    }
}
