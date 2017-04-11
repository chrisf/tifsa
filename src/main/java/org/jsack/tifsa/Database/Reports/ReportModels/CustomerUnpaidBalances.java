package org.jsack.tifsa.Database.Reports.ReportModels;

/**
 * Created by aaron on 4/9/17.
 */

import javafx.scene.control.Control;
import org.jsack.tifsa.Database.ModelBase;
import org.jsack.tifsa.Database.Reports.ReportBase;
import org.jsack.tifsa.Database.Reports.ReportCategory;
import org.jsack.tifsa.Database.Reports.ReportWrappers.CustomerUnpaidBalancesWrapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the class that models each individual row of our Reports.
 * All this class does is hold data.
 */
public class CustomerUnpaidBalances extends ModelBase implements ReportBase {

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

    public final String reportName = "Customers with Unpaid Balances";
    private List<String> row;
    private List<String> columns;
    private ReportCategory category;

    public CustomerUnpaidBalances() {
        row = new ArrayList<>();
        columns = new ArrayList<>();

        category = ReportCategory.Customer;

        columns.add("CustomerFirst");
        columns.add("CustomerLast");
        columns.add("CustomerContactInfo");
        columns.add("CustomerContactTypeDescription");
        columns.add("OrderBalance");
    }

    @Override
    public String getName() {
        return reportName;
    }

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    public RowMapper getMapper() {
        return new CustomerUnpaidBalancesWrapper();
    }

    @Override
    public ReportCategory getCategory() {
        return category;
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
    public List<Control> getControls() {
        return null;
    }

    @Override
    public List<ReportBase> get() {
        return this.getTemplate().query(this.getSql(), this.getMapper());
    }
}
