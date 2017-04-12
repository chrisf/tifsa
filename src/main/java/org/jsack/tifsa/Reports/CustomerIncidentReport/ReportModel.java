package org.jsack.tifsa.Reports.CustomerIncidentReport;

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

        /*
            TODO: Add report columns
            Add all your report columns here. These must be in order and match what appears in your report on SSMS!
            If you've already done your reports, you should be able to just copy and paste the column.adds here.
         */
        columns.add("CustomerTypeName");
        columns.add("CustomerFirst");
        columns.add("CustomerLast");
        columns.add("CustomerIncidentDescription");
        columns.add("IncidentTypeDescription");
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
