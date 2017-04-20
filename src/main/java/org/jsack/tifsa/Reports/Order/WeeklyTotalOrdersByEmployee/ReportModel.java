package org.jsack.tifsa.Reports.Order.WeeklyTotalOrdersByEmployee;

import org.jsack.tifsa.Reports.ColumnFormats.CurrencyColumn;
import org.jsack.tifsa.Reports.ColumnFormats.IntegerColumn;
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


        columns.put("First Name", new ColumnInfo("First Name", StringColumn.class));
        columns.put("Last Name", new ColumnInfo("Last Name", StringColumn.class));
        columns.put("Total Orders", new ColumnInfo("Number of Orders", IntegerColumn.class));
        columns.put("Total Price of Orders", new ColumnInfo("Order Totals", CurrencyColumn.class));
        columns.put("Status", new ColumnInfo("Status", StringColumn.class));
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
