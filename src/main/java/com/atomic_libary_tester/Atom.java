package com.atomic_libary_tester;
import java.lang.Math;

public class Atom {
    private String element;   // Element name (e.g., H, O)
    private double mass;      // Atomic mass
    private double charge;    // Atomic charge
    private double isotope;    // Atomic charge
    private double x, y, z;   // Position in 3D space
    public int protonNumber;
    public int nuetronNumber;
    public int electronNumber;

    // Constructor
    public Atom(String element, int charge, int isotope, double x, double y, double z) {
        double aMass = 0;
        int aCharge = 0;
        int aIsotope = 0;

        protonNumber = 0;
        nuetronNumber = 0;
        electronNumber = 0;
        switch (element){
            case "H":
                protonNumber = 1;
                aMass = 1.00784;

                if (isotope != 0){nuetronNumber = isotope; aMass = aMass + isotope;}
                else{nuetronNumber = (int) Math.round(aMass) - protonNumber;}
                electronNumber = protonNumber + aCharge;
                
                break;
            case "He":
                protonNumber = 2;
                aMass = 4.002602;

                if (isotope != 0){nuetronNumber = isotope; aMass = aMass + isotope;}
                else{nuetronNumber = (int) Math.round(aMass) - protonNumber;}
                electronNumber = protonNumber + aCharge;
                break;
            case "Li":
                protonNumber = 3;
                aMass = 6.941;

                if (isotope != 0){nuetronNumber = isotope; aMass = aMass + isotope;}
                else{nuetronNumber = (int) Math.round(aMass) - protonNumber;}
                electronNumber = protonNumber + aCharge;
                break;
            case "Be":
                protonNumber = 4;
                aMass = 9.012;

                if (isotope != 0){nuetronNumber = isotope; aMass = aMass + isotope;}
                else{nuetronNumber = (int) Math.round(aMass) - protonNumber;}
                electronNumber = protonNumber + aCharge;
                break;
            case "B":
            protonNumber = 5;
                aMass = 10.811;

                if (isotope != 0){nuetronNumber = isotope; aMass = aMass + isotope;}
                else{nuetronNumber = (int) Math.round(aMass) - protonNumber;}
                electronNumber = protonNumber + aCharge;
                break;
            case "C":
            protonNumber = 6;
                aMass = 12.011;

                if (isotope != 0){nuetronNumber = isotope; aMass = aMass + isotope;}
                else{nuetronNumber = (int) Math.round(aMass) - protonNumber;}
                electronNumber = protonNumber + aCharge;
                break;
            case "N":
            protonNumber = 7;
                aMass = 14.0067;

                if (isotope != 0){nuetronNumber = isotope; aMass = aMass + isotope;}
                else{nuetronNumber = (int) Math.round(aMass) - protonNumber;}
                electronNumber = protonNumber + aCharge;
                break;
            case "O":
            protonNumber = 8;
                aMass = 15.999;

                if (isotope != 0){nuetronNumber = isotope; aMass = aMass + isotope;}
                else{nuetronNumber = (int) Math.round(aMass) - protonNumber;}
                electronNumber = protonNumber + aCharge;
                break;
            case "F":
            protonNumber = 9;
                aMass = 18.998;

                if (isotope != 0){nuetronNumber = isotope; aMass = aMass + isotope;}
                else{nuetronNumber = (int) Math.round(aMass) - protonNumber;}
                electronNumber = protonNumber + aCharge;
                break;
            case "Ne":
            protonNumber = 10;
                aMass = 20.1797;

                if (isotope != 0){nuetronNumber = isotope; aMass = aMass + isotope;}
                else{nuetronNumber = (int) Math.round(aMass) - protonNumber;}
                electronNumber = protonNumber + aCharge;
                break;
            
        }
        this.element = element;
        this.mass = aMass;
        this.charge = aCharge;
        this.isotope = aIsotope;
        this.x = x;
        this.y = y;
        this.z = z;
        this.electronNumber = electronNumber;
        this.protonNumber = protonNumber;
        this.nuetronNumber = nuetronNumber;
    }

    // Method to display the atom's details
    public void display() {
        System.out.println("Element: " + element + ", Mass: " + mass + 
                           ", Charge: " + charge + ", Position: (" + x + ", " + y + ", " + z + ")");
    }

    // Static method to create an Atom object
    public static Atom createAtom(String element, int charge, int isoptope, double x, double y, double z) {
        return new Atom(element, charge, isoptope, x, y, z);
    }

    public static void main(String[] args) {
        // Use the createAtom method to generate an Atom object
        Atom hydrogen = Atom.createAtom("H", 0, 0, 0.0, 0.0, 0.0);
        Atom oxygen = Atom.createAtom("O", 0, 0, 1.0, 1.0, 1.0);

        hydrogen.display();
        oxygen.display();
    }
}
