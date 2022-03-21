package com.fges.tp_solid.reigns;

import java.util.ArrayList;

public class Jeu {    
    public static void main(String args[]) {
        
        // début du jeu 
        System.out.println("Bienvenue sur Reigns");

        ArrayList<Question> questions = new ArrayList<Question>();
        Question.initBanqueQuestions(questions);
        
        System.out.println("Création du personnage...");
        
        Personnage personnage = new Personnage();
        
        System.out.println(personnage.getGenre().longRegne() + " " + personnage.getNom());

        ArrayList<Jauge> jauges = new ArrayList<Jauge>();
        Jauge.AfficheJauges();
        
        // tirage des questions
        int nbTours = 0;
        
        Question question;
        while(!finDuJeu(personnage)) {
            nbTours++;
            question = Question.getQuestionAleatoire(questions);
            question.reponseQuestion(personnage);
            Jauge.AfficheJauges();
        }
        
        // fin du jeu
        System.out.println(personnage.getNom() + " a perdu ! Son règne a duré " + nbTours + " tours");
    }
    
    // Le jeu s'arrête si une des jauges atteint 0 ou 50
    public static boolean finDuJeu(Personnage perso) {
        if(perso.jauges.get(0).getValeur()<=0
        || perso.jauges.get(0).getValeur()>=50
        || perso.jauges.get(1).getValeur()<=0
        || perso.jauges.get(1).getValeur()>=50
        || perso.jauges.get(2).getValeur()<=0
        || perso.jauges.get(2).getValeur()>=50
        || perso.jauges.get(3).getValeur()<=0
        || perso.jauges.get(3).getValeur()>=50){
            return true;
        }
        else {
            return false;
        }
    } 
}
