package org.jsack.tifsa.Database.Reports;

import javafx.scene.control.Control;
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
    List<Control> getControls();
}
