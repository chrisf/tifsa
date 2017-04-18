package org.jsack.tifsa.Reports.Interfaces;

import org.jsack.tifsa.Reports.ColumnInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by aaron on 4/11/17.
 */
public interface IReportModel {
    List<String> getRow();
    Map<String, ColumnInfo> getColumns();
}

