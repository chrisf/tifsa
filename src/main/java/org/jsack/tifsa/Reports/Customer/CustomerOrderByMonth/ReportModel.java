package org.jsack.tifsa.Reports.Customer.CustomerOrderByMonth;

import org.jsack.tifsa.Reports.ColumnFormats.CurrencyColumn;
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

        //Columns by Steven
        columns.put("Year", new ColumnInfo("Year", StringColumn.class));
        columns.put("Month", new ColumnInfo("Month", StringColumn.class));
        columns.put("CustomerFirst", new ColumnInfo("Customer First", StringColumn.class));
        columns.put("CustomerLast", new ColumnInfo("CustomerLast", StringColumn.class));
        columns.put("ContactInfo", new ColumnInfo("Contact Info", StringColumn.class));
        columns.put("OrderTotal", new ColumnInfo("Order Total", CurrencyColumn.class));
        columns.put("OrderDiscount", new ColumnInfo("Order Discount", CurrencyColumn.class));
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
