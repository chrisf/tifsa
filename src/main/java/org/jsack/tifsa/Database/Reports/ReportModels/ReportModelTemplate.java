package org.jsack.tifsa.Database.Reports.ReportModels;

import javafx.scene.control.Control;
import org.jsack.tifsa.Database.ModelBase;
import org.jsack.tifsa.Database.Reports.ReportBase;
import org.jsack.tifsa.Database.Reports.ReportCategory;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron on 4/9/17.
 */

/*
    TODO: Change "ReportModelTemplate" To you report name
    This name must match the name of the file!
 */
public class ReportModelTemplate extends ModelBase implements ReportBase {

    //TODO: Insert your report SQL Code inside the quotes for sql
    private final String sql = "";

    //TODO: Insert the name of your report between the quotes for name
    private final String name = "";


    private ReportCategory category;
    private List<String> row;
    private List<String> columns;

    //TODO: Change "ReportModelTemplate" To the name you used for your Class above
    public ReportModelTemplate() {
        row = new ArrayList<>();
        columns = new ArrayList<>();


        /*
            TODO: Change to the Category of your specific report.
            Available categories are
                Customer,
                Order,
                Vendor,
                Sales,
                Delivery,
                Employee,
                Product
         */
        category = ReportCategory.Customer;


        //TODO: Add your columns here. These must be the exact column headers that appear on your report when you run it in SSMS.
        columns.add("");
    }

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ReportCategory getCategory() {
        return category;
    }

    /*
     TODO: After you create your Mapper, change this to your mapper
     ex: Change from "return null" to "return new MyWrapper()"
     */
    @Override
    public RowMapper getMapper() {
        return null;
    }

    @Override
    public List<String> getRow() {
        return row;
    }

    @Override
    public List<String> getColumns() {
        return columns;
    }

    @Override
    public List<Control> getControls() {
        return null;
    }

    @Override
    public List<ReportBase> get() {
        return null;
    }
}
