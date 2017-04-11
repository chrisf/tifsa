package org.jsack.tifsa.Reports.Interfaces;

import javafx.fxml.FXMLLoader;
import org.jsack.tifsa.Reports.ReportCategory;
import org.springframework.jdbc.core.RowMapper;

import java.io.IOException;

/**
 * Created by aaron on 4/11/17.
 */
public interface IReport {
    IReportModel getModel();
    RowMapper getMapper();
    ReportCategory getCategory();

    String getSql();
    String getName();

    FXMLLoader getControls() throws IOException;
}

