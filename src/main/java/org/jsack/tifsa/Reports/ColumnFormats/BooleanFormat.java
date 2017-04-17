package org.jsack.tifsa.Reports.ColumnFormats;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public class BooleanFormat extends SimpleStringProperty implements ObservableValue<String>
{
    private String value;

    public BooleanFormat(String value)
    {
        this.value = value;
    }

    @Override
    public String getValue()
    {
        return value == "True" ? "Yes" : "No";
    }
}
