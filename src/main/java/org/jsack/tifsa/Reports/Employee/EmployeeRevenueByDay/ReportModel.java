package org.jsack.tifsa.Reports.Employee.EmployeeRevenueByDay;

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

        columns.put("EmployeeTypeDescription", new ColumnInfo("Employee Type", StringColumn.class));
        columns.put("EmployeeFirst", new ColumnInfo("Employee First", StringColumn.class));
        columns.put("EmployeeLast", new ColumnInfo("Employee Last", StringColumn.class));
        columns.put("Total", new ColumnInfo("Total", CurrencyColumn.class));
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