package org.jsack.tifsa;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jsack.tifsa.Sql.TestConnect;

import java.io.IOException;

public class Main extends Application {
    BooleanProperty ready = new SimpleBooleanProperty(false);

    private void longStart() {
        Task task = new Task<Void>() {

            private void setProgress(double step) {
                // Send progress to preloader
                final int maxSteps = 2;
                notifyPreloader(new Preloader.ProgressNotification(((double) i)/maxSteps));
            }

            private void connectToDatabase() {
                
            }

            @Override
            protected Void call() throws Exception {
                setProgress(0);

                connectToDatabase();
                setProgress(1);

                // After init is ready, the app is ready to be shown
                // Do this before hiding the preloader stage to prevent the
                // app from exiting prematurely
                ready.setValue(Boolean.TRUE);

                notifyPreloader(new Preloader.StateChangeNotification(
                        Preloader.StateChangeNotification.Type.BEFORE_START));

                return null;
            }
        };
        new Thread(task).start();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        longStart();

        ready.addListener(new ChangeListener<Boolean>(){
            public void changed(
                    ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                if (Boolean.TRUE.equals(t1)) {
                    Platform.runLater(new Runnable() {
                        public void run() {
                            Parent root = null;
                            try {
                                root = FXMLLoader.load(getClass().getResource("/main_window.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            primaryStage.setTitle("Hello World");
                            primaryStage.setScene(new Scene(root, 300, 275));
                            primaryStage.show();
                        }
                    });
                }
            }
        });
    }


    public static void main(String[] args) {
        LauncherImpl.launchApplication(Main.class, SplashScreen.class, args);
    }
}
