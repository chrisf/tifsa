package org.jsack.tifsa.Reports.Customer.CustomerOrderByYear;

import org.jsack.tifsa.Reports.ColumnFormats.CurrencyColumn;
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
        columns.put("Year", new ColumnInfo("Year", StringColumn.class));
        columns.put("CustomerFirst", new ColumnInfo("Customer First", StringColumn.class));
        columns.put("CustomerLast", new ColumnInfo("Customer Last", StringColumn.class));
        columns.put("ContactInfo", new ColumnInfo("Contact Info", StringColumn.class));
        columns.put("OrderTotal", new ColumnInfo("Order Total", CurrencyColumn.class));
        columns.put("OrderDiscount", new ColumnInfo("Order Discount", CurrencyColumn.class));
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
