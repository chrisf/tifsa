package org.jsack.tifsa.Reports.Order.WeeklyTotalOrdersByEmployee;

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
    private final String sql = "SELECT e1.EmployeeFirst AS 'First Name', e1.EmployeeLast AS 'Last Name', o1.Total as 'Total Orders',\n" +
            "o1.TotalPrice AS 'Total Price of Orders' ,\n" +
            "a1.OrderStatusDescription AS 'Status'\n" +
            "\n" +
            "FROM Employee e1\n" +
            "INNER JOIN (\n" +
            "    SELECT Count([Order].SoldByEmployeeID) AS Total, SUM([Order].OrderTotal) AS TotalPrice, [Order].SoldByEmployeeID, [Order].OrderStatusID\n" +
            "    FROM dbo.[Order]\n" +
            "\tWHERE (dbo.[Order].OrderDate >= '2009-09-14' AND OrderDate <= '2009-09-21 23:59:59')\n" +
            "    GROUP BY [Order].SoldByEmployeeID, [Order].OrderStatusID\n" +
            "    ) AS o1 ON e1.EmployeeID = o1.SoldByEmployeeID\n" +
            "INNER JOIN OrderStatus as a1 ON o1.OrderStatusID = a1.OrderStatusID\n" +
            "\n" +
            "WHERE [e1].Deleted = 0\n" +
            "ORDER BY e1.EmployeeFirst ASC;\n";

    /*
        TODO: Name your report.
        Set the name of your report here. Make it unique.
     */
    private final String name = "Weekly Total Orders By Employee";

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
        return new FXMLLoader(getClass().getResource("/ReportControls/WeeklyTotalOrdersByEmployee.fxml"));
    }
}
