package org.jsack.tifsa.Reports.ColumnFormats;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeColumn extends SimpleStringProperty implements ObservableValue<String>
{
    private String value;

    public TimeColumn(String value)
    {
        this.value = value;
    }

    @Override
    public String getValue() {
        LocalDateTime dt = LocalDateTime.parse(value);
        return DateTimeFormatter.ISO_LOCAL_TIME.format(dt);
    }
}
