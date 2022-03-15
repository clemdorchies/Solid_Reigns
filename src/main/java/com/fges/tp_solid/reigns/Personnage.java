/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fges.tp_solid.reigns;

import static com.fges.tp_solid.reigns.Genre.REINE;
import static com.fges.tp_solid.reigns.Genre.ROI;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author julie.jacques
 */
public class Personnage {
    
    protected String nom;
    protected Genre genre;
    protected static ArrayList<Jauge> jauges;
    
    public Personnage(String nom, Genre genre, ArrayList<Jauge> jauges){
        this.nom = nom;
        this.genre = genre;
        Personnage.jauges = jauges;
    }
    
    public static Personnage initPersonnage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        String nom = scanner.nextLine();
        System.out.println(
            "Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)");
        int genre = scanner.nextInt();
        Genre roiReine; 
        if(genre==1){
            roiReine = ROI;
        }else{
            roiReine = REINE;
        }
        jauges = Jauge.initJauge();
        return new Personnage(nom, roiReine, jauges);
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
