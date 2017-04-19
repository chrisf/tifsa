package org.jsack.tifsa.Reports.Revenue.RevenueByDay;

import org.jsack.tifsa.Reports.ColumnFormats.CurrencyColumn;
import org.jsack.tifsa.Reports.ColumnFormats.DateColumn;
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
            The second part is the type of the attribute

            If the type of attribute is a string/varchar, use StringColumn.class

            If the type of attribute should be formatted as currency/money, use CurrencyColumn.class
            If the type of attribute is just a regular number, use either DecimalColumn.class or IntegerColumn.class depending on if you want decimals

            Examples for "PropertyType":
                string  => StringColumn.class
                int     => IntegerColumn.class
                long    => IntegerColumn.class
                double  => DecimalColumn.class / CurrencyColumn.class
                boolean => BooleanColumn.class
         */

        columns.put("Total Orders", new ColumnInfo("Total Orders", IntegerColumn.class));
        columns.put("Total Customers", new ColumnInfo("Total Customers", IntegerColumn.class));
        columns.put("Total Revenue", new ColumnInfo("Total Revenue", CurrencyColumn.class));
        columns.put("Products Sold", new ColumnInfo("Products Sold", IntegerColumn.class));
        columns.put("Total Employees", new ColumnInfo("Total Employees", IntegerColumn.class));
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
