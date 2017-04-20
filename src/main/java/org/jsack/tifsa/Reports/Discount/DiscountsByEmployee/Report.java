package org.jsack.tifsa.Reports.Discount.DiscountsByEmployee;

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
    private final String sql = "SELECT\n" +
            "dbo.Employee.EmployeeID, \n" +
            "dbo.Employee.EmployeeFirst AS 'First Name', \n" +
            "dbo.Employee.EmployeeLast AS 'Last Name',\n" +
            "dbo.[Order].CustomerID, \n" +
            "dbo.[Order].OrderID, \n" +
            "dbo.[Order].OrderDate,\n" +
            "dbo.OrderStatus.OrderStatusDescription AS 'Order Status',\n" +
            "dbo.OrderDiscount.OrderDiscountAmount AS 'Discount Amount'\n" +
            "\n" +
            "FROM [Order]\n" +
            "INNER JOIN Employee ON [Order].SoldByEmployeeID = Employee.EmployeeID\n" +
            "INNER JOIN OrderStatus ON [Order].OrderStatusID = OrderStatus.OrderStatusID\n" +
            "INNER JOIN OrderDiscount ON [Order].OrderID = OrderDiscount.OrderID\n" +
            "\n" +
            "WHERE OrderDiscount.OrderDiscountAmount != 0 AND [Order].Deleted='0'\n" +
            "\n" +
            "ORDER BY \n" +
            "Employee.EmployeeID ASC\n";

    /*
        TODO: Name your report.
        Set the name of your report here. Make it unique.
     */
    private final String name = "Discounts By Employee";

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
        return new FXMLLoader(getClass().getResource("/ReportControls/DiscountsByEmployee.fxml"));
    }
}
