package org.jsack.tifsa.Reports.ColumnFormats;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.text.NumberFormat;
import java.util.Locale;

public class StringColumn extends ColumnFormat
{
    String value;

    public StringColumn(String value)
    {
        this.value = value;
    }

    @Override
    public String getValue()
    {
        return value;
    }
}
