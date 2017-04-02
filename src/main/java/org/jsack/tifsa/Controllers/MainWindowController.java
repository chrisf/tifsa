package org.jsack.tifsa.Controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML //  fx:id="salesButton"
    private Button salesButton; // Value injected by FXMLLoader
    @FXML
    private Button reportsButton; // Value injected by FXMLLoader
    @FXML
    private Button adminButton; // Value injected by FXMLLoader


    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        // make sure all the buttons were found on the form
        assert salesButton != null : "fx:id=\"salesButton\" was not injected: check your FXML file 'main_window.fxml'.";
        assert reportsButton != null : "fx:id=\"reportsButton\" was not injected: check your FXML file 'main_window.fxml'.";
        assert adminButton != null : "fx:id=\"adminButton\" was not injected: check your FXML file 'main_window.fxml'.";

        // set handler for when sales button is clicked
        salesButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.NONE, "Open Sales Menu", ButtonType.OK);
                alert.showAndWait();
            }
        });

        // set handler for when reports button is clicked
        reportsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.NONE, "Open Reports Menu", ButtonType.OK);
                alert.showAndWait();
            }
        });

        // set handler for when admin button is clicked
        adminButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.NONE, "Open Administration Menu", ButtonType.OK);
                alert.showAndWait();
            }
        });
    }
}
