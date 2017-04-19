package org.jsack.tifsa.Reports.ColumnFormats;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class DateColumn extends ColumnFormat
{
    private String value;

    public DateColumn(String value)
    {
        this.value = value;
    }

    @Override
    public String getValue() {
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
        DateTime dt = dtf.parseDateTime(value);
        return DateTimeFormat.forPattern("MM-dd-yyyy").print(dt);
    }
}
