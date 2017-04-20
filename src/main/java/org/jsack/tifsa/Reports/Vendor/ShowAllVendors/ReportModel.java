package org.jsack.tifsa.Reports.Vendor.ShowAllVendors;

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

        //columns added by Steven
        columns.put("Vendor", new ColumnInfo("Vendor", StringColumn.class));
        columns.put("Contact", new ColumnInfo("Contact", StringColumn.class));
        columns.put("Type", new ColumnInfo("Type", StringColumn.class));
        columns.put("Department", new ColumnInfo("Department", StringColumn.class));

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
