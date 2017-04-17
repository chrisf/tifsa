package org.jsack.tifsa.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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

    StringProperty selectedCategory = new SimpleStringProperty();
    StringProperty selectedReportName = new SimpleStringProperty();

    private ReportManager reports;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reports = new ReportManager();

        categorySelectionList = FXCollections.observableArrayList(
                reports.getReportCategories()
        );

        reportSelectionList = FXCollections.observableArrayList();

        reportType.setItems(categorySelectionList);
        reportSelection.setItems(reportSelectionList);

        reportType.valueProperty().bindBidirectional(selectedCategory);
        reportSelection.valueProperty().bindBidirectional(selectedReportName);

        reportType.valueProperty().addListener(this::onReportTypeChange);
        reportSelection.valueProperty().addListener(this::onReportSelectionChange);
    }

    public void onReportTypeChange(ObservableValue obs, Object oldVal, Object newVal) {
        reportSelectionList.clear();

        // load all reports for the selected category
        reportSelectionList.addAll(
                reports.getReportsByCategory(newVal.toString())
        );

        if(reportSelectionList.size() > 0)
        {
            selectedReportName.set(reportSelectionList.get(0));
        }
    }
    
    public void onReportSelectionChange(ObservableValue obs, Object oldVal, Object newVal) {
        if(reportSelectionList.size() == 0)
        {
            return;
        }

        // set the current report to the selected one
        currentReport = reports.getReportByName(newVal.toString());

        // clear columns and rows
        reportTable.getColumns().clear();
        reportTable.getItems().clear();

        int idx = 0;

        // load all the columns for the table based on the selected report
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

        // load controls for the report
        try {
            currentLoader = currentReport.getControls();
            customControls.getChildren().clear();
            customControls.getChildren().add(currentLoader.load());
        }
        catch (Exception ex) {
            ex.printStackTrace();
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
