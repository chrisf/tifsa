package org.jsack.tifsa.Reports.ColumnFormats;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.text.NumberFormat;
import java.util.Locale;

public class StringFormat extends SimpleStringProperty implements ObservableValue<String>
{
    String value;

    public StringFormat(String value)
    {
        this.value = value;
    }

    @Override
    public String getValue()
    {
        return value;
    }
}
