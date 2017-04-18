package org.jsack.tifsa.Reports.ColumnFormats;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeColumn extends ColumnFormat
{
    private String value;

    public DateTimeColumn(String value)
    {
        this.value = value;
    }

    @Override
    public String getValue() {
        LocalDateTime dt = LocalDateTime.parse(value);
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(dt);
    }
}
