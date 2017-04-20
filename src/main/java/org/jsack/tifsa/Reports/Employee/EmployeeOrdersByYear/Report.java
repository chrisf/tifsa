package org.jsack.tifsa.Reports.Employee.EmployeeOrdersByYear;

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
    private final String sql = "SELECT \n" +
            "YEAR (dbo.[Order].OrderDate) AS Year, \n" +
            "dbo.Employee.EmployeeID, dbo.Employee.EmployeeFirst AS 'First Name', dbo.Employee.EmployeeLast AS 'Last Name',\n" +
            "dbo.[Order].OrderID, dbo.[Order].CustomerID, dbo.[Order].OrderTotal,\n" +
            "dbo.OrderLine.OrderLineRecieved AS 'Order Received',\n" +
            "dbo.OrderLine.OrderLineDelivered AS 'Order Delivered',\n" +
            "dbo.OrderStatus.OrderStatusDescription AS 'Order Status'\n" +
            "\n" +
            "FROM [Order]\n" +
            "INNER JOIN Employee ON [Order].SoldByEmployeeID = Employee.EmployeeID\n" +
            "INNER JOIN OrderLine ON [Order].OrderID = OrderLine.OrderID\n" +
            "INNER JOIN OrderStatus ON [Order].OrderStatusID = OrderStatus.OrderStatusID\n" +
            "\n" +
            "WHERE DATEPART(year,dbo.[Order].OrderDate) = '2008' AND [Order].Deleted = '0'\n" +
            "\n" +
            "GROUP BY dbo.[Order].OrderDate,[Order].OrderTotal, \n" +
            "Employee.EmployeeId,Employee.EmployeeFirst,Employee.EmployeeLast, \n" +
            "[Order].OrderID,[Order].CustomerID,OrderLine.OrderLineRecieved,OrderLine.OrderLineDelivered,OrderStatus.OrderStatusDescription\n" +
            "\n" +
            "Order By \n" +
            "[Order].OrderDate DESC\n";

    /*
        TODO: Name your report.
        Set the name of your report here. Make it unique.
     */
    private final String name = "Employee Orders By Year";

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
    private ReportCategory reportCategory = ReportCategory.Employee;

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
        return new FXMLLoader(getClass().getResource("/ReportControls/EmployeeOrdersByYear.fxml"));
    }
}
