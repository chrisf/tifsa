package org.jsack.tifsa.Reports.Order.ShowOrdersCompletedByWeek;

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
            "  CAST(YEAR([Order].OrderDate) AS VARCHAR) + '/' + CAST(DATEPART(wk, [Order].OrderDate) AS VARCHAR) AS [Week],\n" +
            "  Employee.EmployeeFirst,\n" +
            "  Employee.EmployeeLast,\n" +
            "  EmployeeStatus.EmployeeStatusDescription,\n" +
            "  COUNT([Order].OrderID) as [Number of orders],\n" +
            "  COUNT(OrderLine.OrderLineID) as [Number of products],\n" +
            "  SUM([Order].OrderTotal) as [Revenue]\n" +
            "FROM [Order]\n" +
            "  INNER JOIN Employee ON [Order].SoldByEmployeeID = Employee.EmployeeID\n" +
            "  INNER JOIN OrderLine ON [Order].OrderID = OrderLine.OrderID\n" +
            "  INNER JOIN EmployeeStatus ON Employee.EmployeeStatus = EmployeeStatus.EmployeeStatusID\n" +
            " WHERE (dbo.[Order].OrderDate BETWEEN '2009-09-14' AND '2009-09-21')\n" +
            " AND [Order].Deleted = 0\n" +
            "\n" +
            "GROUP BY [Order].OrderDate, [Order].OrderID, Employee.EmployeeFirst, Employee.EmployeeLast, EmployeeStatus.EmployeeStatusDescription\n" +
            "ORDER BY [Week] DESC, [Revenue] DESC, EmployeeLast, EmployeeFirst";

    /*
        TODO: Name your report.
        Set the name of your report here. Make it unique.
     */
    private final String name = "Show Orders Completed By Week";

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
        return new FXMLLoader(getClass().getResource("/ReportControls/ShowOrdersCompletedByWeek.fxml"));
    }
}
