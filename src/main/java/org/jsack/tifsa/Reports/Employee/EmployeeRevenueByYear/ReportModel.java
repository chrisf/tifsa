package org.jsack.tifsa.Reports.Employee.EmployeeRevenueByYear;

import org.jsack.tifsa.Reports.ColumnFormats.CurrencyColumn;
import org.jsack.tifsa.Reports.ColumnFormats.StringColumn;
import org.jsack.tifsa.Reports.ColumnInfo;
import org.jsack.tifsa.Reports.Interfaces.IReportModel;

import java.util.*;

/**
 * Created by aaron on 4/11/17.
 */
public class ReportModel implements IReportModel {

    private List<String> row;
    private Map<String, ColumnInfo> columns;

    public ReportModel() {
        row = new ArrayList<>();
        columns = new HashMap<>();

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
    public Map<String, ColumnInfo> getColumns() {
        return columns;
    }
}

