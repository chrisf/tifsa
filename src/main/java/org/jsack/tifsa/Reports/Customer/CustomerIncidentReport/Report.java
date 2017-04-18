package org.jsack.tifsa.Reports.Customer.CustomerIncidentReport;

import javafx.fxml.FXMLLoader;
import org.jsack.tifsa.Reports.Interfaces.IReport;
import org.jsack.tifsa.Reports.Interfaces.IReportModel;
import org.jsack.tifsa.Reports.ReportCategory;
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
    private final String sql = "SELECT dbo.CustomerType.CustomerTypeName,dbo.Customer.CustomerFirst, dbo.Customer.CustomerLast, dbo.CustomerIncident.CustomerIncidentDescription, dbo.IncidentType.IncidentTypeDescription " +
            "FROM Customer " +
            "INNER JOIN CustomerType ON Customer.CustomerTypeID = CustomerType.CustomerTypeID " +
            "INNER JOIN CustomerIncident ON Customer.CustomerID = CustomerIncident.CustomerID " +
            "INNER JOIN IncidentType ON CustomerIncident.IncidentTypeID = IncidentType.IncidentTypeID";

    /*
        TODO: Name your report.
        Set the name of your report here. Make it unique.
     */
    private final String name = "Customer Incident Report";

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
        TODO: Change the "OrdersBySpecificDay" portion of the file path to your Report Path.
        If my report was in a new Directory called "EmployeeRevenueByYear" I would change OrdersBySpecificDay to EmployeeRevenueByYear
        ex: ../java/org/jsack/tifsa/Reports/OrdersBySpecificDay/EmployeeRevenueByYear.fxml would translate to
            ../java/org/jsack/tifsa/Reports/EmployeeRevenueByYear/EmployeeRevenueByYear.fxml
     */
    @Override
    public FXMLLoader getControls() throws IOException {
        return new FXMLLoader(getClass().getResource("/ReportControls/CustomerIncidentReport.fxml"));
    }
}
