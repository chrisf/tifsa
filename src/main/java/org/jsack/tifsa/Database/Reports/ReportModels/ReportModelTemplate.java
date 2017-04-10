package org.jsack.tifsa.Database.Reports.ReportModels;

import javafx.scene.control.Control;
import org.jsack.tifsa.Database.Reports.ReportBase;
import org.jsack.tifsa.Database.Reports.ReportCategory;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * Created by aaron on 4/9/17.
 */
public class ReportModelTemplate implements ReportBase {

    private final String sql = "";
    private final String name = "";
    private ReportCategory category;
    private List<String> row;
    private List<String> columns;

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
     This needs to be set to return your Wrapper!
        ex: return MyReportRapper();
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
}
