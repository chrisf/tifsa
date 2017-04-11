package org.jsack.tifsa.Database.Reports;

import javafx.scene.layout.VBox;
import org.jsack.tifsa.Controllers.Reports.ReportControllerBase;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * Created by aaron on 4/9/17.
 */
public interface ReportBase {
    String getSql();
    String getName();

    ReportCategory getCategory();

    RowMapper getMapper();


    List<String> getRow();
    List<String> getColumns();
    VBox getControlLayout();
    ReportControllerBase getControlBase();
    List<ReportBase> get();
}
