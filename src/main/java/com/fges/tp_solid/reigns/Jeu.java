package com.fges.tp_solid.reigns;

import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {    
    public static void main(String args[]) {
        
        // Début du jeu 
        System.out.println("Bienvenue sur Reigns");
        System.out.println("Voulez-vous jouer avec le mode GOT ? (1 pour oui, 2 pour non)");
        Scanner scanner = new Scanner(System.in);
        System.out.flush();
        JeuGOT modeGOT;
        if (scanner.nextInt() == 1){
            modeGOT = new JeuGOT(true);
        }
        else {
            modeGOT = new JeuGOT(false);
        }
        
        // Création du personnage
        System.out.println("Création du personnage...");
        Personnage personnage = new Personnage();
        System.out.println(personnage.getGenre().longRegne() + " " + personnage.getNom());
        Jauge.AfficheJauges();

        // Initialisation des questions
        ArrayList<Question> questions = new ArrayList<Question>();
        Question.initBanqueQuestions(questions, personnage);
        
        int nbTours = 0;
        Question question;
        while(!finDuJeu(personnage)) {
            nbTours++;
            modeGOT.upDate(nbTours); 
            question = Question.getQuestionAleatoire(questions, personnage);
            question.reponseQuestion(personnage, nbTours, modeGOT.activated);
            Jauge.AfficheJauges();
        }
        
        // Fin du jeu
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
        || perso.jauges.get(3).getValeur()>=50) {
            return true;
        }
        else {
            return false;
        }
    } 
}
