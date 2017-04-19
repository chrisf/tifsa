package org.jsack.tifsa.Reports.Order.ShowOrderTotalAboveSpecificAmount;

import org.jsack.tifsa.Reports.ColumnFormats.CurrencyColumn;
import org.jsack.tifsa.Reports.ColumnFormats.DateTimeColumn;
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

        //Columns added by Steven
        columns.put("OrderID", new ColumnInfo("Order ID", IntegerColumn.class));
        columns.put("CustomerFirst", new ColumnInfo("Customer First", StringColumn.class));
        columns.put("CustomerLast", new ColumnInfo("Customer Last", StringColumn.class));
        columns.put("OrderDate", new ColumnInfo("Order Date", DateTimeColumn.class));
        columns.put("Number of products", new ColumnInfo("", IntegerColumn.class));
        columns.put("OrderTotal", new ColumnInfo("Order Total", CurrencyColumn.class));
        columns.put("Sold By", new ColumnInfo("Sold By", StringColumn.class));


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
