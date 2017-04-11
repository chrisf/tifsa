package org.jsack.tifsa.Database.Reports.ReportModels;

import javafx.scene.layout.VBox;
import org.jsack.tifsa.Controllers.Reports.ReportControllerBase;
import org.jsack.tifsa.Database.ModelBase;
import org.jsack.tifsa.Database.Reports.ReportBase;
import org.jsack.tifsa.Database.Reports.ReportCategory;
import org.jsack.tifsa.Database.Reports.ReportWrappers.CustomerIncidentReportWrapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron on 4/10/17.
 */
public class CustomerIncidentReport extends ModelBase implements ReportBase {

    private final String sql = "SELECT dbo.CustomerType.CustomerTypeName,dbo.Customer.CustomerFirst, dbo.Customer.CustomerLast, dbo.CustomerIncident.CustomerIncidentDescription, dbo.IncidentType.IncidentTypeDescription " +
            "FROM Customer " +
            "INNER JOIN CustomerType ON Customer.CustomerTypeID = CustomerType.CustomerTypeID " +
            "INNER JOIN CustomerIncident ON Customer.CustomerID = CustomerIncident.CustomerID " +
            "INNER JOIN IncidentType ON CustomerIncident.IncidentTypeID = IncidentType.IncidentTypeID";

    private final String name = "Customer Incident Report";
    private ReportCategory category;
    private List<String> row;
    private List<String> columns;



    public CustomerIncidentReport() {
        columns = new ArrayList<>();
        row = new ArrayList<>();

        category = ReportCategory.Customer;

        columns.add("CustomerTypeName");
        columns.add("CustomerFirst");
        columns.add("CustomerLast");
        columns.add("CustomerIncidentDescription");
        columns.add("IncidentTypeDescription");

    }

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ReportCategory getCategory() {
        return category;
    }

    /*
     This needs to be set to return your Wrapper!
        ex: return MyReportRapper();
     */
    @Override
    public RowMapper getMapper() {
        return new CustomerIncidentReportWrapper();
    }

    @Override
    public List<String> getRow() {
        return row;
    }

    @Override
    public List<String> getColumns() {
        return columns;
    }

    @Override
    public List<ReportBase> get() {
        return this.getTemplate().query(this.getSql(), this.getMapper());
    }

    @Override
    public VBox getControlLayout() {
        return null;
    }

    @Override
    public ReportControllerBase getControlBase() {
        return null;
    }
}
