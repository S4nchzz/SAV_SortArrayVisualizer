package com.sav.savScene;

import java.io.IOException;

import com.sav.savScene.sortAlgorithms.BubbleSort;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;


public class Sav {
    @FXML
    private HBox fxid_hbox;
    private final int [] arr;

    public Sav(Stage stage, int [] arr) {
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
            
        this.arr = arr;

        this.fxid_hbox.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        generatePanes(arr);
        Platform.runLater(() -> {
            BubbleSort bsort = new BubbleSort(arr, this);
            bsort.sort();
        });
        
    }

    private void generatePanes(int [] arr) {
        int amountOfPilars = arr.length;

        for (int i = 0; i < amountOfPilars; i++) {
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: white");
            pane.setPrefHeight(arr[i]);
            pane.setMaxHeight(Region.USE_PREF_SIZE);

            double pilarWidth = amountOfPilars > this.fxid_hbox.getPrefWidth() ? amountOfPilars / this.fxid_hbox.getPrefWidth() : this.fxid_hbox.getPrefWidth() / amountOfPilars;
            pane.setPrefWidth(pilarWidth);
            pane.setLayoutY(pilarWidth);
            fxid_hbox.getChildren().add(pane);
        }
    }

    public void movePane(int paneA, int paneB) {
        Pane nodeB = (Pane)this.fxid_hbox.getChildren().get(paneB);
        double heigthB = nodeB.getPrefHeight();

        Pane nodeA = (Pane)this.fxid_hbox.getChildren().get(paneA);
        double heigthA = nodeA.getPrefHeight();

        nodeB.setPrefHeight(heigthA);
        this.fxid_hbox.getChildren().set(paneB, nodeB);

        nodeA.setPrefHeight(heigthB);
        this.fxid_hbox.getChildren().set(paneA, nodeA);
    }
}
