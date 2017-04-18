package org.jsack.tifsa.Reports;


import org.jsack.tifsa.Reports.ColumnFormats.ColumnFormat;

/**
 * Created by cfitz on 4/18/17.
 */
public class ColumnInfo {
    public final String columnLabel;
    public final Class<? extends ColumnFormat> columnFormat;

    public ColumnInfo(String columnLabel, Class<? extends ColumnFormat> columnFormat) {
        this.columnLabel = columnLabel;
        this.columnFormat = columnFormat;
    }
}
