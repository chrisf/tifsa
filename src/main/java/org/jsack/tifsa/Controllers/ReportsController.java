package org.jsack.tifsa.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.jsack.tifsa.Reports.Interfaces.IControl;
import org.jsack.tifsa.Reports.Interfaces.IReport;
import org.jsack.tifsa.Reports.Interfaces.IReportModel;
import org.jsack.tifsa.Reports.ReportManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by aaron on 4/9/17.
 */
public class ReportsController implements Initializable{
    @FXML
    JFXComboBox reportType, reportSelection;
    @FXML
    TableView reportTable;
    @FXML
    GridPane gridPane;
    @FXML
    VBox customControls;
    @FXML
    JFXButton refreshButton;

    //Lists for report types
    ObservableList<String> categorySelectionList, reportSelectionList;
    IReport currentReport;
    FXMLLoader currentLoader;
    IControl currentController;

    private ReportManager reports;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reports = new ReportManager();

        categorySelectionList = FXCollections.observableArrayList(
                reports.getReportCategories()
        );
        reportType.setItems(categorySelectionList);
        reportType.setValue(reportType.getItems().get(0));

        onReportTypeChange();
    }

    public void onReportTypeChange() {
        reportSelectionList = FXCollections.observableArrayList(
                reports.getReportsByCategory((String) reportType.getSelectionModel().getSelectedItem())
        );
        reportSelection.setItems(reportSelectionList);
        reportSelection.setValue(reportSelection.getItems().get(0));

        onReportSelectionChange();
    }
    public void onReportSelectionChange() {
        if(reportSelection.getSelectionModel().getSelectedItem() == null)
        {
            return;
        }

        currentReport = reports.getReportByName((String) reportSelection.getSelectionModel().getSelectedItem());
        reportTable.getColumns().clear();

        int idx = 0;

        for(Map.Entry<String, Class> entry : currentReport.getModel().getColumns().entrySet()) {
            final int i = idx;
            final TableColumn<IReportModel,String> column = new TableColumn<>(entry.getKey());
            column.setCellValueFactory(model ->
            {
                try {
                    Constructor<ObservableValue> ctor = entry.getValue().getConstructor(String.class);
                    return ctor.newInstance(model.getValue().getRow().get(i));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                return null;
            });
            idx++;
            reportTable.getColumns().add(column);
        }

        try {
            currentLoader = currentReport.getControls();
            customControls.getChildren().clear();
            customControls.getChildren().add(currentLoader.load());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        if(currentReport != null && customControls.getChildren().size() == 0)
        {
            refreshClick();
        }
    }

    public void refreshClick() {
        if(currentReport == null)
        {
            return;
        }

        try {
            reportTable.setItems(FXCollections.observableArrayList(
                reports.runReport(currentReport, currentLoader.<IControl>getController().getAttributes())
            ));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            reportTable.setItems(FXCollections.observableArrayList(
                reports.runReport(currentReport)
            ));
        }

    }


}
