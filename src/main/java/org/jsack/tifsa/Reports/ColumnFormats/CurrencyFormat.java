package org.jsack.tifsa.Reports.ColumnFormats;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormat extends SimpleStringProperty implements ObservableValue<String>
{
    private String value;

    public CurrencyFormat(String value)
    {
        this.value = value;
    }

    @Override
    public String getValue() {
        Locale currentLocale = Locale.getDefault();
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
        return currencyFormatter.format(Double.parseDouble(value));
    }
}
