package org.jsack.tifsa.Reports.Delivery.ShowPastDeliveries;

import org.jsack.tifsa.Reports.ColumnFormats.DateTimeColumn;
import org.jsack.tifsa.Reports.ColumnFormats.IntegerColumn;
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

        /*
            TODO: Add report columns
            Add all your report columns here. These must be in order and match what appears in your report on SSMS!

            The first part is the name of the column / attribute,
            The second part is the label of the column that appears in the report header
            The third part is the type/format of the attribute

            If the type of attribute is a string/varchar, use StringColumn.class

            If the type of attribute should be formatted as currency/money, use CurrencyColumn.class
            If the type of attribute is just a regular number, use either DecimalColumn.class or IntegerColumn.class depending on if you want decimals

            Examples for "ColumnFormat":
                string      => StringColumn.class
                int         => IntegerColumn.class
                long        => IntegerColumn.class
                double      => DecimalColumn.class / CurrencyColumn.class
                boolean     => BooleanColumn.class
                date        => DateColumn.class
                time        => TimeColumn.class
                date/time   => DateTimeColumn.class
         */
        columns.put("Order Number", new ColumnInfo("Order Number", IntegerColumn.class));
        columns.put("Last Name", new ColumnInfo("Last Name", StringColumn.class));
        columns.put("First Name", new ColumnInfo("First Name", StringColumn.class));
        columns.put("Product", new ColumnInfo("Product", StringColumn.class));
        columns.put("Date Delivered", new ColumnInfo("Date Delivered", DateTimeColumn.class));
        columns.put("Delivery Type", new ColumnInfo("Delivery Type", StringColumn.class));

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
