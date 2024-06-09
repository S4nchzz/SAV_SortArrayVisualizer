package com.sav.savScene;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Sav {
    public Sav(Stage stage) {
        FXMLLoader savLoader = new FXMLLoader();
        savLoader.setLocation(getClass().getResource("/com/sav/sav.fxml"));
        savLoader.setController(this);

        try {
            Parent savParent = savLoader.load();
            Scene savScene = new Scene(savParent);

            stage.setTitle("Sort Algorithm visualizer");
            stage.setScene(savScene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();

        } catch (IOException e) {}        
    }
}
