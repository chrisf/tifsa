package org.jsack.tifsa.Reports.Revenue.RevenueByDay;

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
            "COUNT([Order].OrderID) AS 'Total Orders', COUNT([Order].CustomerID) AS 'Total Customers',\n" +
            "SUM([Order].OrderTotal) AS 'Total Revenue',\n" +
            "COUNT(a1.ProductsPerOrder) AS 'Products Sold',\n" +
            "COUNT(Distinct[Order].SoldByEmployeeID) AS 'Total Employees'\n" +
            "\n" +
            "FROM [Order]\n" +
            "INNER JOIN Customer ON [Order].CustomerID = Customer.CustomerID\n" +
            "INNER JOIN (\n" +
            "   SELECT SUM([OrderLine].OrderLineQuantity) AS ProductsPerOrder, [OrderLine].OrderID\n" +
            "   FROM OrderLine\n" +
            "   GROUP BY OrderLine.OrderID\n" +
            "   ) as a1 ON a1.OrderID = [Order].OrderID\n" +
            "\n" +
            "WHERE [Order].OrderDate >= :dayStart AND [Order].OrderDate <= :dayEnd\n" +
            "AND [Order].Deleted = 0\n";

    /*
        TODO: Name your report.
        Set the name of your report here. Make it unique.
     */
    private final String name = "Revenue By Day";

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
    private ReportCategory reportCategory = ReportCategory.Revenue;

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
        return new FXMLLoader(getClass().getResource("/ReportControls/RevenueByDay.fxml"));
    }
}
