package org.jsack.tifsa.Reports.EmployeeRevenueByYear;

import javafx.beans.property.SimpleStringProperty;
import org.jsack.tifsa.Reports.ColumnFormats.CurrencyFormat;
import org.jsack.tifsa.Reports.ColumnFormats.StringFormat;
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

        columns.put("EmployeeTypeDescription", StringFormat.class);
        columns.put("EmployeeFirst", StringFormat.class);
        columns.put("EmployeeLast", StringFormat.class);
        columns.put("Total", CurrencyFormat.class);
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

