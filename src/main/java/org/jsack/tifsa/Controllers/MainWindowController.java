package org.jsack.tifsa.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSnackbar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    JFXButton salesButton;
    @FXML
    GridPane mainPane;
    @FXML
    JFXSnackbar snacky;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public MainWindowController() {
    }

    @FXML
    public void salesButtonClick() {
        Parent salesMenu = null;

        try {
             salesMenu = FXMLLoader.load(getClass().getResource("/scenes/sales_menu.fxml"));
             Stage stage = new Stage();
             stage.setScene(new Scene(salesMenu));
             stage.show();
             salesButton.getScene().getWindow().hide();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    @FXML
    public void reportsButtonClick() {
        Parent salesMenu = null;
        try {
            salesMenu = FXMLLoader.load(getClass().getResource("/scenes/reports.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(salesMenu));
            stage.show();
        }
        catch (Exception ex) {}
    }
}
