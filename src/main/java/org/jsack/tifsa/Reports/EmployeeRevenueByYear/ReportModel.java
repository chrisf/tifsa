package org.jsack.tifsa.Reports.EmployeeRevenueByYear;

import org.jsack.tifsa.Reports.Interfaces.IReportModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron on 4/11/17.
 */
public class ReportModel implements IReportModel {

    private List<String> row;
    private List<String> columns;

    public ReportModel() {
        row = new ArrayList<>();
        columns = new ArrayList<>();

        columns.add("EmployeeTypeDescription");
        columns.add("EmployeeFirst");
        columns.add("EmployeeLast");
        columns.add("Total");
    }

    @Override
    public List<String> getRow() {
        return row;
    }

    @Override
    public List<String> getColumns() {
        return columns;
    }
}
