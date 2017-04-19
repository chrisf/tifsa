package org.jsack.tifsa;

import com.jfoenix.controls.JFXDecorator;
import io.datafx.controller.context.FXMLViewContext;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jsack.tifsa.Controllers.MainController;

public class Main extends Application {
    @FXMLViewContext
    ViewFlowContext flowContext;

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("TiFSA - By: jSack-Tech");
        Flow flow = new Flow(MainController.class);
        DefaultFlowContainer container = new DefaultFlowContainer();
        flowContext = new ViewFlowContext();
        flowContext.register("Stage", primaryStage);
        flow.createHandler(flowContext).start(container);

        JFXDecorator decorator = new JFXDecorator(primaryStage, container.getView());
        decorator.setCustomMaximize(true);
        Scene scene = new Scene(decorator, 1250, 900);
        final ObservableList<String> styles = scene.getStylesheets();
        styles.add(getClass().getResource("/styles.css").toExternalForm());

        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(850);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }


}
