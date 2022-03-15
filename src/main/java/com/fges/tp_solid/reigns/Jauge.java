/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fges.tp_solid.reigns;

import java.util.ArrayList;

/**
 *
 * @author julie.jacques
 */
public class Jauge {
    
    protected TypeJauge type;
    protected String nom;
    protected int valeur;
    
    protected static Jauge jaugeClerge;
    protected static Jauge jaugePeuple;
    protected static Jauge jaugeArmee;
    protected static Jauge jaugeFinance;

    public Jauge(String nom, int valeur){
        this.nom = nom;
        this.valeur = valeur;
    }

    public static ArrayList<Jauge> initJauge(){
        ArrayList<Jauge> jauges = new ArrayList<Jauge>();

        // initialisation des jauges entre 15 et 35 points
        jaugeClerge = new Jauge("Clergé",(int) (15 + Math.random() * ( 35 - 15 )));
        jauges.add(jaugeClerge);
        jaugePeuple = new Jauge("Peuple",(int) (15 + Math.random() * ( 35 - 15 )));
        jauges.add(jaugePeuple);
        jaugeArmee = new Jauge("Armée",(int) (15 + Math.random() * ( 35 - 15 )));
        jauges.add(jaugeArmee);
        jaugeFinance = new Jauge("Finance",(int) (15 + Math.random() * ( 35 - 15 )));
        jauges.add(jaugeFinance);

        return jauges;
    }

    /**
     * Affiche les jauges dans la console
     */
    public static void AfficheJauges(Personnage perso){
        afficheJauge(jaugeClerge);
        afficheJauge(jaugePeuple);
        afficheJauge(jaugeArmee);
        afficheJauge(jaugeFinance);
        System.out.flush();
    }

    /**
     * Affiche une jauge dans la console (
     */
    private static void afficheJauge(Jauge jauge){
        String resultat = "[";
        // valeur : ####
        for(int i=0;i<jauge.getValeur();i++){
            resultat += "#";
        }
        // on complète avec ____
        for(int i=0;i<50-(jauge.getValeur()>0?jauge.getValeur():0);i++){
            resultat += "_";
        }
        resultat += "] ";
        // affichage du nom
        resultat += jauge.getNom();
        System.out.println(resultat);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public TypeJauge getType() {
        return type;
    }

    public void setType(TypeJauge type) {
        this.type = type;
    }

    public static Jauge getJaugeClerge(Personnage perso) {
        return Personnage.jauges.get(0);
    }

    public void setJaugeClerge(Jauge jaugeClerge) {
        Jauge.jaugeClerge = jaugeClerge;
    }

    public static Jauge getJaugePeuple(Personnage perso) {
        return Personnage.jauges.get(1);
    }

    public void setJaugePeuple(Jauge jaugePeuple) {
        Jauge.jaugePeuple = jaugePeuple;
    }

    public static Jauge getJaugeArmee(Personnage perso) {
        return Personnage.jauges.get(2);
    }

    public void setJaugeArmee(Jauge jaugeArmee) {
        Jauge.jaugeArmee = jaugeArmee;
    }

    public static Jauge getJaugeFinance(Personnage perso) {
        return Personnage.jauges.get(3);
    }

    public void setJaugeFinance(Jauge jaugeFinance) {
        Jauge.jaugeFinance = jaugeFinance;
    }   
}
