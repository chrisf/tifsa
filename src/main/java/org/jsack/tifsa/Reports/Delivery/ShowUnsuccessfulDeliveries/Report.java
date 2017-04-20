package org.jsack.tifsa.Reports.Delivery.ShowUnsuccessfulDeliveries;

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
            "dbo.OrderLine.OrderID AS 'Order Number',\n" +
            "dbo.Customer.CustomerLast AS 'Last Name', dbo.Customer.CustomerFirst AS 'First Name',\n" +
            "dbo.Product.ProductDescription AS 'Product',\n" +
            "dbo.OrderLineDeliveryType.OrderLineDeliveryTypeDescription AS 'Delivery Type',\n" +
            "dbo.OrderLineStatus.OrderLineStatusDescription AS 'Status'\n" +
            "\n" +
            "FROM OrderLine\n" +
            "JOIN Customer ON OrderLine.OrderID = Customer.CustomerID\n" +
            "JOIN Product ON OrderLine.ProductID = Product.ProductID\n" +
            "JOIN OrderLineDeliveryType ON OrderLine.OrderLineDeliveryTypeID = OrderLineDeliveryType.OrderLineDeliveryTypeID\n" +
            "JOIN OrderLineStatus ON OrderLine.OrderLineStatusId = OrderLineStatus.OrderLineStatusID\n" +
            "\n" +
            "WHERE OrderLine.OrderLineStatusID = 5 AND OrderLine.Deleted = 0\n";

    /*
        TODO: Name your report.
        Set the name of your report here. Make it unique.
     */
    private final String name = "Show Unsuccessful Deliveries";

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
    private ReportCategory reportCategory = ReportCategory.Delivery;

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
        return new FXMLLoader(getClass().getResource("/ReportControls/ShowUnsuccessfulDeliveries.fxml"));
    }
}
