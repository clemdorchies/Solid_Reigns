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
public class Jeu {
    private static Personnage personnage;
    private static ArrayList<Question> questions;
    
    public static void main(String args[]){
        
        // début du jeu 
        System.out.println("Bienvenue sur Reigns");

        questions = Question.initBanqueQuestions();
        
        System.out.println("Création du personnage...");
        
        personnage = Personnage.initPersonnage();
        
        System.out.println(personnage.getGenre().longRegne() + " " + personnage.getNom());

        Jauge.AfficheJauges(personnage);
        
        // tirage des questions
        int nbTours = 0;
        while(!finDuJeu()){
            nbTours++;
            Question question = Question.getQuestionAleatoire(questions);
            Question.reponseQuestion(question, personnage);
            Jauge.AfficheJauges(personnage);
        }
        
        // fin du jeu
        System.out.println(personnage.getNom() + " a perdu ! Son règne a duré " + nbTours + " tours");
    }
    
    /**
     * Le jeu s'arrête si une des jauges atteint 0 ou 50
     * @return 
     */
    public static boolean finDuJeu(){
        if(Personnage.jauges.get(0).getValeur()<=0
        || Personnage.jauges.get(0).getValeur()>=50
        || Personnage.jauges.get(1).getValeur()<=0
        || Personnage.jauges.get(1).getValeur()>=50
        || Personnage.jauges.get(2).getValeur()<=0
        || Personnage.jauges.get(2).getValeur()>=50
        || Personnage.jauges.get(3).getValeur()<=0
        || Personnage.jauges.get(3).getValeur()>=50){
            return true;
        }
        else{
            return false;
        }
    } 
}
