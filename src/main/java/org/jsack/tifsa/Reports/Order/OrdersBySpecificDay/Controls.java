package org.jsack.tifsa.Reports.Order.OrdersBySpecificDay;

import com.jfoenix.controls.JFXDatePicker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.joda.time.LocalDateTime;
import org.jsack.tifsa.Reports.Interfaces.IControl;
import org.jsack.tifsa.Utility;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controls implements Initializable, IControl {

    public JFXDatePicker dayPicker;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public Map<String, Object> getAttributes() {
        Map<String, Object> attributes = new HashMap<>();

        LocalDateTime dt = LocalDateTime.parse(dayPicker.getValue().toString());

        attributes.put("dayStart", dt.dayOfWeek().withMinimumValue().toString());
        attributes.put("dayEnd", dt.withHourOfDay(23).withMinuteOfHour(59).toString());

        return attributes;
    }
}