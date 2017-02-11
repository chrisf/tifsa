package org.jsack.tifsa;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by cfitz on 1/28/17.
 */
public class SplashScreen extends Preloader {
    Label label;
    ProgressBar bar;
    Stage stage;
    boolean noLoadingProgress = true;
    Scene splashScreenScene;

    public static final String[] steps = new String[] { "Initializing program", "Connecting to database", "Finished"};

    private Scene createPreloaderScene() throws IOException {
        label = new Label(steps[0]);
        bar = new ProgressBar(0);

        BorderPane p = new BorderPane();
        p.setTop(label);
        p.setCenter(bar);
        return new Scene(p, 300, 150);
    }

    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Loading...");
        stage.setScene(createPreloaderScene());
        stage.show();
    }

    @Override
    public void handleProgressNotification(ProgressNotification pn) {
        //application loading progress is rescaled to be first 50%
        //Even if there is nothing to load 0% and 100% events can be
        // delivered
        int step = (int)pn.getProgress();
        label.setText(steps[step]);
        double progress = pn.getProgress() / steps.length - 1;
        if (progress != 1.0 || !noLoadingProgress) {
            bar.setProgress(progress);
            if (progress > 0) {
                noLoadingProgress = false;
            }
        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification evt) {
        //ignore, hide after application signals it is ready
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification pn) {
        if (pn instanceof ProgressNotification) {
            //expect application to send us progress notifications
            //with progress ranging from 0 to 1.0
            double v = ((ProgressNotification) pn).getProgress() / steps.length - 1;
            if (!noLoadingProgress) {
                //if we were receiving loading progress notifications
                //then progress is already at 50%.
                //Rescale application progress to start from 50%

            }
            bar.setProgress(v);
        } else if (pn instanceof StateChangeNotification) {
            //hide after get any state update from application
            stage.hide();
        }
    }
}