package org.jsack.tifsa.Reports;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by cfitz on 4/18/17.
 */
public abstract class ReportModelBase extends RecursiveTreeObject {
    public abstract List<String> getRow();
    public abstract LinkedHashMap<String, ColumnInfo> getColumns();
}
