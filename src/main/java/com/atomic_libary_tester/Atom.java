package com.atomic_libary_tester;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Atom extends Application {
    private String element;
    private double mass;
    private int charge;
    private int isotope;
    private double x, y, z;
    private int protonNumber;
    private int neutronNumber;
    private int electronNumber;

    private Circle visualization; // Circle for visualization
    private static List<Atom> atoms = new ArrayList<>(); // List to store created atoms


    // No-argument constructor required for JavaFX
    public Atom() {
        // Default values (not used in visualization)
        this.element = "";
        this.mass = 0.0;
        this.charge = 0;
        this.isotope = 0;
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    // Constructor with parameters
    public Atom(String element, int charge, int isotope, double x, double y, double z) {
        this.element = element;
        this.charge = charge;
        this.isotope = isotope;
        this.x = x;
        this.y = y;
        this.z = z;

        initializeAtomProperties();
        createVisualization();

        atoms.add(this);
    }

    private void createVisualization() {
        Color color = getColorForElement(element);
        int radius = getAtomicRadiusForElement(element)/2;

        // Create a Circle representing the atom
        visualization = new Circle(this.x, this.y, radius, color);
    }

    private Color getColorForElement(String element) {
        switch (element) {
            case "H":
                return Color.RED;
            case "O":
                return Color.BLUE;
            default:
                return Color.GRAY;
        }
    }

    private int getAtomicRadiusForElement(String element) {
        switch (element) {
            case "H":
                return 37;
            case "O":
                return 100;
            default:
                return 75;
        }
    }

    private void initializeAtomProperties() {
        switch (element) {
            case "H":
                protonNumber = 1;
                mass = 1.00784;
                break;
            case "O":
                protonNumber = 8;
                mass = 15.999;
                break;
            default:
                protonNumber = 0; // Default values for unsupported elements
                mass = 0;
        }

        if (isotope != 0) {
            neutronNumber = isotope - protonNumber;
        } else {
            neutronNumber = (int) Math.round(mass) - protonNumber;
        }

        electronNumber = protonNumber + charge;
    }

    public int getProtonNumber() {
        return protonNumber;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Circle getVisualization() {
        return visualization;
    }

    public static Atom createAtom(String element, int charge, int isotope, double x, double y, double z) {
        return new Atom(element, charge, isotope, x, y, z);
    }

    @Override
    public void start(Stage stage) {
        

        Pane pane = new Pane();

        // Add all atom visualizations to the pane
        for (Atom atom : atoms) {
            pane.getChildren().add(atom.getVisualization());
        }

        for (int i = 0; i < atoms.size(); i++) {
            for (int j = i + 1; j < atoms.size(); j++) {
                Atom atom1 = atoms.get(i);
                Atom atom2 = atoms.get(j);
                Line bond = new Line(atom1.getX(), atom1.getY(), atom2.getX(), atom2.getY());
                pane.getChildren().add(bond);
            }
        }

        Scene scene = new Scene(pane, 600, 600);
        stage.setTitle("Molecule Visualizer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        new Atom("H", 0, 0, 150.0, 150.0, 0.0);
        new Atom("O", 0, 0,200.0, 200.0, 0.0);
        new Atom("H", 0, 0, 250.0, 150.0, 0.0);

        launch(args);
    }
}
