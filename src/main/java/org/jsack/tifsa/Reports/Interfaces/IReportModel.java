package org.jsack.tifsa.Reports.Interfaces;

import javafx.beans.property.Property;

import java.util.List;
import java.util.Map;

/**
 * Created by aaron on 4/11/17.
 */
public interface IReportModel {
    List<String> getRow();
    Map<String, Class> getColumns();
}

