package org.jsack.tifsa.Reports.CustomerUnpaidBalances;

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
         */
        columns.add("CustomerFirst");
        columns.add("CustomerLast");
        columns.add("CustomerContactInfo");
        columns.add("CustomerContactTypeDescription");
        columns.add("OrderBalance");
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
