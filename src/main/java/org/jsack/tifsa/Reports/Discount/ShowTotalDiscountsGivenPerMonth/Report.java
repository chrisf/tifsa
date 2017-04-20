package org.jsack.tifsa.Reports.Discount.ShowTotalDiscountsGivenPerMonth;

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
    private final String sql = "SELECT MONTH(dbo.[Order].OrderDate) AS Month,\n" +
            "DATEPART(Year, dbo.[Order].OrderDate) AS Year,\n" +
            "SUM(dbo.OrderDiscount.OrderDiscountAmount) AS TotalDiscountsGiven,\n" +
            "dbo.Employee.EmployeeFirst, dbo.Employee.EmployeeLast,\n" +
            "o1.RoleCount\n" +
            "\n" +
            "FROM OrderDiscount\n" +
            "\n" +
            "INNER JOIN [Order] ON OrderDiscount.OrderID = [Order].OrderID\n" +
            "INNER JOIN Employee ON [Order].SoldByEmployeeID = Employee.EmployeeID\n" +
            "INNER JOIN (\n" +
            "SELECT COUNT(EmployeeRole.EmployeeID) AS RoleCount, EmployeeRole.EmployeeID\n" +
            "FROM EmployeeRole\n" +
            "GROUP BY EmployeeRole.EmployeeID\n" +
            ") as o1 ON o1.EmployeeID = Employee.EmployeeID \n" +
            "\n" +
            "\n" +
            "WHERE DATEPART(year, dbo.[Order].OrderDate) = '2008' AND [OrderDiscount].Deleted = 0\n" +
            "\n" +
            "GROUP BY DATEPART(Year,[Order].OrderDate),\n" +
            "DATEPART(month,[Order].OrderDate),\n" +
            "Employee.EmployeeFirst, Employee.EmployeeLast, o1.RoleCount\n";

    /*
        TODO: Name your report.
        Set the name of your report here. Make it unique.
     */
    private final String name = "Show Total Discounts Given By Month";

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
    private ReportCategory reportCategory = ReportCategory.Discount;

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
        return new FXMLLoader(getClass().getResource("/ReportControls/ShowTotalDiscountsGivenPerMonth.fxml"));
    }
}