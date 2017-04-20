package org.jsack.tifsa.Reports.Customer.CustomerOrderByDay;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import org.joda.time.LocalDateTime;
import org.jsack.tifsa.Julius;
import org.jsack.tifsa.Reports.Interfaces.IControl;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controls implements Initializable, IControl {
    public DatePicker dayPicker;

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