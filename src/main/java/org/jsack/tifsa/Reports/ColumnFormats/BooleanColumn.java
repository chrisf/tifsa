package org.jsack.tifsa.Reports.ColumnFormats;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public class BooleanColumn extends SimpleStringProperty implements ObservableValue<String>
{
    private String value;

    public BooleanColumn(String value)
    {
        this.value = value;
    }

    @Override
    public String getValue()
    {
        return value == "True" ? "Yes" : "No";
    }
}
