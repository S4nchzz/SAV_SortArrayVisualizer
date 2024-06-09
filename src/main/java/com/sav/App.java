package com.sav;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

import com.sav.savScene.Sav;

/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new Sav(stage, generateRandomArray());
    }

    public static void main(String[] args) {
        launch();
    }

    private int [] generateRandomArray() {
        Random rm = new Random();
        int [] arr = new int [rm.nextInt(100)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rm.nextInt(647);
        }

        return arr;
    }
}