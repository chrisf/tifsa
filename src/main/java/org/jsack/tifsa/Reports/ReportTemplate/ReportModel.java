package org.jsack.tifsa.Reports.ReportTemplate;

import javafx.beans.property.SimpleStringProperty;
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

            The first part is the name of the column / attribute,
            The second part is the type of the attribute

            If the type of attribute is a string/varchar, use StringFormat.class

            If the type of attribute should be formatted as currency/money, use CurrencyFormat.class
            If the type of attribute is just a regular number, use either DecimalFormat.class or NumberFormat.class depending on if you want decimals

            Examples for "PropertyType":
                string  => StringFormat.class
                int     => NumberFormat.class
                long    => NumberFormat.class
                double  => DecimalFormat.class / CurrencyFormat.class
                boolean => BooleanFormat.class
         */
        columns.put("NameOfColumn", SimpleStringProperty.class);
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
