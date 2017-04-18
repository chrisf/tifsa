package org.jsack.tifsa;

import com.sun.javafx.application.LauncherImpl;
import io.datafx.controller.flow.Flow;
import javafx.application.Application;
import javafx.stage.Stage;
import org.jsack.tifsa.Controllers.MainController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        new Flow(MainController.class).startInStage(primaryStage);
    }
    public static void main(String[] args) {
        LauncherImpl.launchApplication(Main.class,args);
    }
}
