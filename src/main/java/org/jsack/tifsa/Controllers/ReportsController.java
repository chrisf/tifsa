package org.jsack.tifsa.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.property.SimpleStringProperty;
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

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by aaron on 4/9/17.
 */
public class ReportsController implements Initializable{
    @FXML
    JFXComboBox reportSelection1, reportSelection2;
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
        reportSelection1.setItems(categorySelectionList);
        reportSelection1.setValue(categorySelectionList.get(0));

       onReportTypeChange();
    }

    public void onReportTypeChange() {
        reportSelectionList = FXCollections.observableArrayList(
                reports.getReportsByCategory((String)reportSelection1.getSelectionModel().getSelectedItem())
        );
        reportSelection2.setItems(reportSelectionList);
    }
    public void onReportChange() {
        currentReport = reports.getReportByName((String)reportSelection2.getSelectionModel().getSelectedItem());
        reportTable.getColumns().clear();

        int idx = 0;
        for(String columnName : currentReport.getModel().getColumns()) {
            final int i = idx;
            TableColumn<IReportModel,String> column = new TableColumn<>(columnName);
            column.setMaxWidth(Double.MAX_VALUE);
            column.setCellValueFactory(model -> new SimpleStringProperty(model.getValue().getRow().get(i)));
            idx++;
            reportTable.getColumns().add(column);
        }

        try {
            currentLoader = currentReport.getControls();
            customControls = currentLoader.load();
            gridPane.add(customControls, 0, 1);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        refreshClick();
    }

    public void refreshClick() {
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
