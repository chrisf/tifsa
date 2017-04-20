package org.jsack.tifsa.Reports.Product.ShowProductByVendor;

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


        //columns added By Steven
        columns.put("ProductDescription", new ColumnInfo("Product Description", StringColumn.class));
        columns.put("BrandName", new ColumnInfo("Brand", StringColumn.class));
        columns.put("VendorName", new ColumnInfo("Vendor", StringColumn.class));
        columns.put("VendorContactInfo", new ColumnInfo("Vendor Contact Info", StringColumn.class));

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
