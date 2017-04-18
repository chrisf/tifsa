package org.jsack.tifsa.Reports.ColumnFormats;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public class IntegerColumn extends ColumnFormat
{
    private String value;

    public IntegerColumn(String value)
    {
        this.value = value;
    }

    @Override
    public String getValue() {
        java.text.DecimalFormat df = new java.text.DecimalFormat(   "#,###,###,##0");
        return df.format(Long.parseLong(value));
    }
}
