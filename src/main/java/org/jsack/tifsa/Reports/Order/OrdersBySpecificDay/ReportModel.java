package org.jsack.tifsa.Reports.Order.OrdersBySpecificDay;

import org.jsack.tifsa.Reports.ColumnFormats.CurrencyColumn;
import org.jsack.tifsa.Reports.ColumnFormats.DateColumn;
import org.jsack.tifsa.Reports.ColumnFormats.StringColumn;
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

        columns.put("OrderID", StringColumn.class);
        columns.put("EmployeeFirst", StringColumn.class);
        columns.put("EmployeeLast", StringColumn.class);
        columns.put("CustomerFirst", StringColumn.class);
        columns.put("CustomerLast", StringColumn.class);
        columns.put("OrderTotal", CurrencyColumn.class);
        columns.put("OrderDate", DateColumn.class);
        columns.put("OrderStatusDescription", StringColumn.class);
        columns.put("CustomerTypeName", StringColumn.class);
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
