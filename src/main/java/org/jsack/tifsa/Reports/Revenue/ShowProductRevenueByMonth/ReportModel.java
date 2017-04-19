package org.jsack.tifsa.Reports.Revenue.ShowProductRevenueByMonth;

import org.jsack.tifsa.Reports.ColumnFormats.CurrencyColumn;
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


        //columns added by steven
        columns.put("Year", new ColumnInfo("Year", IntegerColumn.class));
        columns.put("Month", new ColumnInfo("Month", StringColumn.class));
        columns.put("ProductDescription", new ColumnInfo("Product Description", StringColumn.class));
        columns.put("ProductSKU", new ColumnInfo("Product SKU", IntegerColumn.class));
        columns.put("Revenue", new ColumnInfo("Revenue", CurrencyColumn.class));
        columns.put("VendorName", new ColumnInfo("Vendor Name", StringColumn.class));
        columns.put("BrandName", new ColumnInfo("Brand Name", StringColumn.class));
        columns.put("ManufacturerName", new ColumnInfo("Manufacturer Name", StringColumn.class));
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
