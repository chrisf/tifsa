package org.jsack.tifsa.Reports.CustomerUnpaidBalances;

import javafx.fxml.FXMLLoader;
import org.jsack.tifsa.Reports.Interfaces.IReport;
import org.jsack.tifsa.Reports.Interfaces.IReportModel;
import org.jsack.tifsa.Reports.ReportCategory;
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
    public final String sql = "SELECT " +
            "dbo.Customer.CustomerFirst, dbo.Customer.CustomerLast," +
            "dbo.CustomerContact.CustomerContactInfo," +
            "dbo.CustomerContactType.CustomerContactTypeDescription," +
            "dbo.[Order].OrderBalance " +
            "FROM Customer " +
            "INNER JOIN CustomerContact ON Customer.CustomerID = CustomerContact.CustomerID " +
            "INNER JOIN CustomerContactType ON CustomerContactType.CustomerContactTypeID = CustomerContact.CustomerContactTypeID " +
            "INNER JOIN [Order] ON [Order].CustomerID = CustomerContact.CustomerContactID " +
            "WHERE CustomerContact.[CustomerContactPrimary] = 1 AND OrderBalance > 0";

    /*
        TODO: Name your report.
        Set the name of your report here. Make it unique.
     */
    public final String name = "Customers with Unpaid Balances";

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
    private ReportCategory reportCategory = ReportCategory.Customer;

    @Override
    public IReportModel getModel() {
        return new ReportModel();
    }

    @Override
    public RowMapper getMapper() {
        return new ReportWrapper();
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
        TODO: Change to the correct path of your .fxml file for controls

     */
    @Override
    public FXMLLoader getControls() throws IOException {
        return new FXMLLoader(getClass().getResource("/ReportControls/CustomerUnpaidBalances.fxml"));
    }
}
