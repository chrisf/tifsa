package org.jsack.tifsa.Controllers;

import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.annotation.PostConstruct;


/**
 * Created by aaron on 4/18/17.
 */
@ViewController(value= "/Scenes/Intro.fxml", title="Home")
public class IntroController {
    @FXML
    ImageView logo;

    @FXML
    ImageView tifsaLogo;

    @PostConstruct
    public void init() {
        logo.setImage(new Image(getClass().getResource("/IMGS/logo.png").toExternalForm()));
        tifsaLogo.setImage(new Image(getClass().getResource("/IMGS/TIFSALOGO.png").toExternalForm()));
    }


}
