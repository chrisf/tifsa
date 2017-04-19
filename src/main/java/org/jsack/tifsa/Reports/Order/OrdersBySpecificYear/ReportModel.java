package org.jsack.tifsa.Reports.Order.OrdersBySpecificYear;

import org.jsack.tifsa.Reports.ColumnFormats.CurrencyColumn;
import org.jsack.tifsa.Reports.ColumnFormats.DateColumn;
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

        columns.put("OrderID", new ColumnInfo("Order ID", StringColumn.class));
        columns.put("EmployeeFirst", new ColumnInfo("Employee First", StringColumn.class));
        columns.put("EmployeeLast", new ColumnInfo("Employee Last", StringColumn.class));
        columns.put("CustomerFirst", new ColumnInfo("Customer First", StringColumn.class));
        columns.put("CustomerLast", new ColumnInfo("Customer Last", StringColumn.class));
        columns.put("OrderTotal", new ColumnInfo("Total", CurrencyColumn.class));
        columns.put("OrderDate", new ColumnInfo("Order Date", DateColumn.class));
        columns.put("OrderStatusDescription", new ColumnInfo("Order Status", StringColumn.class));
        columns.put("CustomerTypeName", new ColumnInfo("Customer Type", StringColumn.class));
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
