package org.jsack.tifsa.Reports.Customer.CustomerUnpaidBalances;

import org.jsack.tifsa.Reports.ColumnFormats.CurrencyColumn;
import org.jsack.tifsa.Reports.ColumnFormats.StringColumn;
import org.jsack.tifsa.Reports.ColumnInfo;
import org.jsack.tifsa.Reports.Interfaces.IReportModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aaron on 4/11/17.
 */
public class ReportModel implements IReportModel {

    private List<String> row;
    private Map<String, ColumnInfo> columns;

    public ReportModel() {
        row = new ArrayList<>();
        columns = new HashMap<>();

        /*
            TODO: Add report columns
            Add all your report columns here. These must be in order and match what appears in your report on SSMS!
         */
        columns.put("CustomerFirst", new ColumnInfo("Customer First", StringColumn.class));
        columns.put("CustomerLast", new ColumnInfo("Customer Last", StringColumn.class));
        columns.put("CustomerContactInfo", new ColumnInfo("Primary Contact", StringColumn.class));
        columns.put("CustomerContactTypeDescription", new ColumnInfo("Contact Medium", StringColumn.class));
        columns.put("OrderBalance", new ColumnInfo("Balance", CurrencyColumn.class));
    }

    @Override
    public List<String> getRow() {
        return row;
    }

    @Override
    public Map<String, ColumnInfo> getColumns() {
        return columns;
    }
}
