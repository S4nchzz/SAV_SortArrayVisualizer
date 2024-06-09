package com.sav;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import com.sav.savScene.Sav;

/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new Sav(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}