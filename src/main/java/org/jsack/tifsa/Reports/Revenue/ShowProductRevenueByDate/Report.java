package org.jsack.tifsa.Reports.Revenue.ShowProductRevenueByDate;

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
    private final String sql = "SELECT YEAR([Order].OrderDate) as 'Year',\n" +
            "DATENAME(month, dbo.[Order].OrderDate) as 'Month',\n" +
            "DATEPART(day, dbo.[Order].OrderDate) AS 'Date',\n" +
            "Product.ProductDescription, Product.ProductSKU,\n" +
            "SUM(Product.ProductPrice) as 'Revenue',\n" +
            "Vendor.VendorName, Brand.BrandName, Manufacturer.ManufacturerName FROM OrderLine\n" +
            "\n" +
            "INNER JOIN [Order] ON [Order].OrderID = OrderLine.OrderID\n" +
            "INNER JOIN Product ON OrderLine.ProductID = Product.ProductID\n" +
            "INNER JOIN Vendor ON Product.VendorID = Vendor.VendorID\n" +
            "INNER JOIN Brand ON Product.BrandID = Brand.BrandID\n" +
            "INNER JOIN Manufacturer ON Brand.ManufacturerID = Manufacturer.ManufacturerID\n" +
            "\n" +
            "WHERE [Order].OrderDate BETWEEN '2016-03-01' AND '2016-03-02' AND OrderLine.Deleted = '0'\n" +
            "\n" +
            "GROUP BY YEAR([Order].OrderDate), DATENAME(month,[Order].OrderDate), DATEPART(week,dbo.[Order].OrderDate), DATEPART(day, dbo.[Order].OrderDate), Product.ProductSKU, Product.ProductDescription, Product.ProductPrice, Vendor.VendorName, Brand.BrandName, Manufacturer.ManufacturerName";

    /*
        TODO: Name your report.
        Set the name of your report here. Make it unique.
     */
    private final String name = "Show Product Revenue By Date";

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
        return new FXMLLoader(getClass().getResource("/ReportControls/ShowProductRevenueByDate.fxml"));
    }
}
