package org.jsack.tifsa.Reports.Customer.CustomerUnpaidBalances;

import org.jsack.tifsa.Reports.ColumnFormats.CurrencyColumn;
import org.jsack.tifsa.Reports.ColumnFormats.StringColumn;
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
    private Map<String, Class> columns;

    public ReportModel() {
        row = new ArrayList<>();
        columns = new HashMap<>();

        /*
            TODO: Add report columns
            Add all your report columns here. These must be in order and match what appears in your report on SSMS!
         */
        columns.put("CustomerFirst", StringColumn.class);
        columns.put("CustomerLast", StringColumn.class);
        columns.put("CustomerContactInfo", StringColumn.class);
        columns.put("CustomerContactTypeDescription", StringColumn.class);
        columns.put("OrderBalance", CurrencyColumn.class);
    }

    @Override
    public List<String> getRow() {
        return row;
    }

    @Override
    public Map<String, Class> getColumns() {
        return columns;
    }
}
