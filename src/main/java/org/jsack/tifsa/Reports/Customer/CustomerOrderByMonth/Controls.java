package org.jsack.tifsa.Reports.Customer.CustomerOrderByMonth;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import org.joda.time.LocalDateTime;
import org.jsack.tifsa.Julius;
import org.jsack.tifsa.Reports.Interfaces.IControl;
import org.jsack.tifsa.Utility;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controls implements Initializable, IControl {
    public JFXComboBox<String> monthSelection;
    public JFXComboBox<String> yearSelection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        yearSelection.setItems(Julius.getYears());
        monthSelection.setItems(Julius.getMonths());
    }

    @Override
    public Map<String, Object> getAttributes() {
        Map<String, Object> attributes = new HashMap<>();
        LocalDateTime d = Utility.parseDateString(monthSelection.getValue(), "1", yearSelection.getValue());

        attributes.put("dayStart", d.dayOfMonth().withMinimumValue().toString());
        attributes.put("dayEnd", d.dayOfMonth().withMaximumValue().toString());
        return attributes;
    }
}