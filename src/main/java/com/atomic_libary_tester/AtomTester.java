package com.atomic_libary_tester;

import java.io.ObjectInput;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class AtomTester extends Application {
    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();

        // Draw atoms
        Circle oxygen = new Circle(150, 100, 20, Color.RED);
        Circle hydrogen1 = new Circle(100, 150, 10, Color.BLUE);
        Circle hydrogen2 = new Circle(200, 150, 10, Color.BLUE);

        // Draw bonds
        Line bond1 = new Line(150, 100, 100, 150);
        Line bond2 = new Line(150, 100, 200, 150);

        pane.getChildren().addAll(oxygen, hydrogen1, hydrogen2, bond1, bond2);

        Scene scene = new Scene(pane, 300, 300);
        stage.setTitle("Molecule Visualizer");
        stage.setScene(scene);
        stage.show();
    }

    

    public static void main(String[] args) {
        launch(args);
    }
}
