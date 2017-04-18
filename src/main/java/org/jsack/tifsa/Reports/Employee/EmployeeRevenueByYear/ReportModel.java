package org.jsack.tifsa.Reports.Employee.EmployeeRevenueByYear;

import org.jsack.tifsa.Reports.ColumnFormats.CurrencyColumn;
import org.jsack.tifsa.Reports.ColumnFormats.StringColumn;
import org.jsack.tifsa.Reports.Interfaces.IReportModel;

import java.util.*;

/**
 * Created by aaron on 4/11/17.
 */
public class ReportModel implements IReportModel {

    private List<String> row;
    private Map<String, Class> columns;

    public ReportModel() {
        row = new ArrayList<>();
        columns = new HashMap<>();

        columns.put("EmployeeTypeDescription", StringColumn.class);
        columns.put("EmployeeFirst", StringColumn.class);
        columns.put("EmployeeLast", StringColumn.class);
        columns.put("Total", CurrencyColumn.class);
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

