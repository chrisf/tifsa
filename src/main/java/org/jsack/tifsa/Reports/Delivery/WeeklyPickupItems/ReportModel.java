package org.jsack.tifsa.Reports.Delivery.WeeklyPickupItems;

import org.jsack.tifsa.Reports.ColumnFormats.CurrencyColumn;
import org.jsack.tifsa.Reports.ColumnFormats.DateTimeColumn;
import org.jsack.tifsa.Reports.ColumnFormats.StringColumn;
import org.jsack.tifsa.Reports.ColumnInfo;
import org.jsack.tifsa.Reports.ReportModelBase;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by aaron on 4/11/17.
 */
public class ReportModel extends ReportModelBase {

    private List<String> row;
    private LinkedHashMap<String, ColumnInfo> columns;

    public ReportModel() {
        row = new ArrayList<>();
        columns = new LinkedHashMap<>();


        columns.put("Date", new ColumnInfo("Date", DateTimeColumn.class));
        columns.put("CustomerFirst", new ColumnInfo("First Name", StringColumn.class));
        columns.put("CustomerLast", new ColumnInfo("Last Name", StringColumn.class));
        columns.put("Contact Information", new ColumnInfo("Contact Info", StringColumn.class));
        columns.put("Poduct Description", new ColumnInfo("Product Description", StringColumn.class));
        columns.put("Price", new ColumnInfo("Price", CurrencyColumn.class));

    }

    @Override
    public List<String> getRow() {
        return row;
    }

    @Override
    public LinkedHashMap<String, ColumnInfo> getColumns() {
        return columns;
    }
}
