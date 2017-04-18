package org.jsack.tifsa.Reports.ColumnFormats;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.text.NumberFormat;
import java.util.Locale;

public class DecimalColumn extends ColumnFormat
{
    private String value;

    public DecimalColumn(String value)
    {
        this.value = value;
    }

    @Override
    public String getValue() {
        java.text.DecimalFormat df = new java.text.DecimalFormat(   "#,###,###,##0.00");
        return df.format(Double.parseDouble(value));
    }
}
