package org.jsack.tifsa.Reports.Order.ShowCanceledOrders;

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
    private final String sql = "SELECT DATENAME (year, dbo.[Order].OrderDate) AS Year,\n" +
            "DATENAME (month, dbo.[Order].OrderDate) AS Month,\n" +
            "DATEPART(day, dbo.[Order].OrderDate) AS Day,\n" +
            "COUNT(case when dbo.[Order].OrderStatusID = '3' then 1 else null end) AS OrdersCanceled,\n" +
            "dbo.[Order].OrderID, dbo.Customer.CustomerFirst, dbo.Customer.CustomerLast,\n" +
            "dbo.Employee.EmployeeFirst, dbo.Employee.EmployeeLast FROM [Order]\n" +
            "\n" +
            "INNER JOIN Employee ON [Order].SoldByEmployeeID = Employee.EmployeeID\n" +
            "INNER JOIN Customer on [Order].CustomerID = Customer.CustomerID\n" +
            "INNER JOIN OrderStatus on OrderStatus.OrderStatusID = [Order].OrderStatusID\n" +
            "\n" +
            "WHERE OrderStatus.OrderStatusID ='3' AND [Order].Deleted = 0\n" +
            "\n" +
            "GROUP BY [Order].OrderDate, [Order].OrderID,\n" +
            "Customer.CustomerFirst, Customer.CustomerLast,\n" +
            "Employee.EmployeeFirst, Employee.EmployeeLast\n" +
            "\n" +
            "ORDER BY dbo.[Order].OrderDate DESC\n";

    /*
        TODO: Name your report.
        Set the name of your report here. Make it unique.
     */
    private final String name = "Show Canceled Orders";

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
        return new FXMLLoader(getClass().getResource("/ReportControls/ShowCanceledOrders.fxml"));
    }
}
