package org.jsack.tifsa.Reports.CustomerIncidentReport;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import org.jsack.tifsa.Reports.ColumnFormats.StringFormat;
import org.jsack.tifsa.Reports.Interfaces.IReportModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aaron on 4/11/17.
 */
public class ReportModel implements IReportModel {

    private List<String> row;
    private Map<String, Class> columns;

    public ReportModel() {
        row = new ArrayList<>();
        columns = new HashMap<>();

        /*
            TODO: Add report columns
            Add all your report columns here. These must be in order and match what appears in your report on SSMS!
            If you've already done your reports, you should be able to just copy and paste the column.adds here.
         */
        columns.put("CustomerTypeName", StringFormat.class);
        columns.put("CustomerFirst", StringFormat.class);
        columns.put("CustomerLast", StringFormat.class);
        columns.put("CustomerIncidentDescription", StringFormat.class);
        columns.put("IncidentTypeDescription", StringFormat.class);
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
