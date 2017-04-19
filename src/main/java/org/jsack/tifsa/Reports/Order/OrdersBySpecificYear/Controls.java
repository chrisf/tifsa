package org.jsack.tifsa.Reports.Order.OrdersBySpecificYear;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import javafx.fxml.Initializable;
import org.joda.time.LocalDateTime;
import org.jsack.tifsa.Reports.Interfaces.IControl;
import org.jsack.tifsa.Utility;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controls implements Initializable, IControl {
    public JFXComboBox<String> yearSelection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        yearSelection.setItems(Utility.getYears());
    }

    @Override
    public Map<String, Object> getAttributes() {
        Map<String, Object> attributes = new HashMap<>();
        LocalDateTime d = Utility.parseDateString("January", "1", yearSelection.getValue());

        attributes.put("dayStart", d.dayOfYear().withMinimumValue().toString());
        attributes.put("dayEnd", d.dayOfYear().withMaximumValue().toString());
        return attributes;
    }
}