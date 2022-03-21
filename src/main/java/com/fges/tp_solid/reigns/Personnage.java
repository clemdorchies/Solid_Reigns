package com.fges.tp_solid.reigns;

import static com.fges.tp_solid.reigns.Genre.REINE;
import static com.fges.tp_solid.reigns.Genre.ROI;

import java.util.ArrayList;
import java.util.Scanner;

public class Personnage {
    
    protected String nom;
    protected Genre genre;
    protected ArrayList<Jauge> jauges;
    
    public Personnage() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nom du personnage : ");
        System.out.flush();
        nom = scanner.nextLine();

        System.out.println("Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)");
        if (scanner.nextInt() == 1) {
            genre = ROI;
        }
        else {
            genre = REINE;
        }

        jauges = Jauge.initJauge();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
