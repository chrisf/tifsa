package org.jsack.tifsa.Reports.Discount.DiscountsByEmployee;

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


        columns.put("EmployeeID", new ColumnInfo("Employee ID", IntegerColumn.class));
        columns.put("First Name", new ColumnInfo("First Name", StringColumn.class));
        columns.put("Last Name", new ColumnInfo("Last Name", StringColumn.class));
        columns.put("CustomerID", new ColumnInfo("Customer ID", IntegerColumn.class));
        columns.put("OrderID", new ColumnInfo("Order ID", IntegerColumn.class));
        columns.put("OrderDate", new ColumnInfo("Order Date", DateTimeColumn.class));
        columns.put("Order Status", new ColumnInfo("Order Status", StringColumn.class));
        columns.put("Discount Amount", new ColumnInfo("Discount Amount", CurrencyColumn.class));


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
