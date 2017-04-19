package org.jsack.tifsa.Reports.Delivery.DailyDeliveryReport;

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
        columns.put("Order Number", new ColumnInfo("Order Number", IntegerColumn.class));
        columns.put("Last Name", new ColumnInfo("Last Name", StringColumn.class));
        columns.put("First Name", new ColumnInfo("First Name", StringColumn.class));
        columns.put("Street1", new ColumnInfo("Street1", StringColumn.class));
        columns.put("Street2", new ColumnInfo("Street2", StringColumn.class));
        columns.put("City", new ColumnInfo("City", StringColumn.class));
        columns.put("State", new ColumnInfo("State", IntegerColumn.class));
        columns.put("Zip", new ColumnInfo("Zip", IntegerColumn.class));
        columns.put("Product", new ColumnInfo("Product", StringColumn.class));
        columns.put("Delivery Date", new ColumnInfo("Delivery Date", DateTimeColumn.class));
        columns.put("Delivery Type", new ColumnInfo("Delivery Type", StringColumn.class));

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
