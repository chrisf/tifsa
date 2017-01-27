package org.jsack.tifsa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jsack.tifsa.Sql.TestConnect;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        TestConnect test = new TestConnect();

        Parent root = FXMLLoader.load(getClass().getResource("/main_window.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
