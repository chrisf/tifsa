package org.jsack.tifsa.Reports.Product.ShowProductByVendor;

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
    private final String sql = "SELECT dbo.Product.ProductDescription,\n" +
            "dbo.Brand.BrandName,\n" +
            "dbo.Vendor.VendorName,\n" +
            "dbo.VendorContact.VendorContactInfo FROM Vendor\n" +
            "\n" +
            "LEFT OUTER JOIN VendorContact ON Vendor.VendorID = VendorContact.VendorID\n" +
            "INNER JOIN Product ON Vendor.VendorID = Product.VendorID\n" +
            "INNER JOIN Brand ON Product.BrandID = Brand.BrandID\n" +
            "\n" +
            "WHERE dbo.Vendor.VendorName='Coaster Furniture' AND dbo.VendorContact.VendorContactPrimary ='1' AND Vendor.Deleted = '0'\n";

    /*
        TODO: Name your report.
        Set the name of your report here. Make it unique.
     */
    private final String name = "Show Product By Vendor";

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
    private ReportCategory reportCategory = ReportCategory.Product;

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
        return new FXMLLoader(getClass().getResource("/ReportControls/ShowProductByVendor.fxml"));
    }
}
