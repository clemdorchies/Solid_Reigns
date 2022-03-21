package com.fges.tp_solid.reigns;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Question {
    // nom du perso qui pose la question
    protected String nomPersonnage;
    protected String question;
    protected String effetGauche;
    protected String effetDroite;
    protected Effet effet;
    protected Map<TypeJauge,Integer> effetJaugeGauche;
    protected Map<TypeJauge,Integer> effetJaugeDroite;
    
    public Question(String nomPersonnage, String question, String effetGauche, String effetDroite) {
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.effetGauche = effetGauche;
        this.effetDroite = effetDroite;
        this.effetJaugeGauche = new TreeMap<>();
        this.effetJaugeDroite = new TreeMap<>();
        this.effet = new Effet();
    }
    
    public void afficheQuestion(){
        String result = "[" + nomPersonnage + "] "
                + question + " " 
                + "[G: " + effetGauche
                + ",D: " + effetDroite
                + "]";
        System.out.println(result);
        System.out.println("Effet G:" + effet.afficheEffets(effetJaugeGauche));
        System.out.println("Effet D:" + effet.afficheEffets(effetJaugeDroite));
        System.out.flush();
        
    }
    
    public void reponseQuestion(Personnage perso){
        afficheQuestion();
        // récupère la réponse
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        while(!reponse.equals("G") && !reponse.equals("D")){
            System.out.println("Entrez la réponse (G ou D)");
            System.out.flush();
            reponse = scanner.nextLine();
        }
        // applique les malus
        if(reponse.equals("G")){
            effet.appliqueEffetsGauche(perso, effetJaugeGauche);
        }else{
            effet.appliqueEffetsDroite(perso, effetJaugeDroite);
        }
    } 
    
    public static Question getQuestionAleatoire(ArrayList<Question> questions){
        int numQuestion = (int) (Math.random()*questions.size());
        return questions.get(numQuestion);
    }

    public static void initBanqueQuestions(ArrayList<Question> questions){
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                "Oui",
                "Non");
        question1.ajouteEffetGauche(TypeJauge.ARMEE, -5);
        question1.ajouteEffetGauche(TypeJauge.PEUPLE, +5);
        question1.ajouteEffetDroite(TypeJauge.PEUPLE, -7);
        questions.add(question1);
        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                "Importer de la nourriture",
                "Ne rien faire");
        question2.ajouteEffetGauche(TypeJauge.FINANCE,-5);
        question2.ajouteEffetGauche(TypeJauge.PEUPLE, +5);
        question2.ajouteEffetDroite(TypeJauge.PEUPLE, -5);
        questions.add(question2);
        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                "Faire un sacrifice",
                "Ne rien faire");
        question3.ajouteEffetGauche(TypeJauge.CLERGE, +5);
        question3.ajouteEffetGauche(TypeJauge.PEUPLE, -3);
        question3.ajouteEffetDroite(TypeJauge.CLERGE, -5);
        questions.add(question3);
        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                "Le soutenir",
                "Rester neutre");
        question4.ajouteEffetGauche(TypeJauge.ARMEE, +3);
        question4.ajouteEffetGauche(TypeJauge.FINANCE, -3);
        question4.ajouteEffetGauche(TypeJauge.CLERGE, -3);
        question4.ajouteEffetDroite(TypeJauge.PEUPLE, +3);
        questions.add(question4);
        Question question5 = new Question(
                    "Paysan",
                    "Abondance de récoltes cette année",
                    "Taxer énormément",
                    "Taxer un tout petit peu");
        question5.ajouteEffetGauche(TypeJauge.FINANCE, +10);
        question5.ajouteEffetGauche(TypeJauge.PEUPLE, -5);
        question5.ajouteEffetDroite(TypeJauge.FINANCE, +1);
        question5.ajouteEffetDroite(TypeJauge.PEUPLE, -3);
        questions.add(question5);
    }
    
    public void ajouteEffetGauche(TypeJauge jauge,
                                   int valeur){
        effetJaugeGauche.put(jauge,valeur);
    }
    
    public void ajouteEffetDroite(TypeJauge jauge,
                                   int valeur){
        effetJaugeDroite.put(jauge,valeur);
    }

    public String getNomPersonnage() {
        return nomPersonnage;
    }

    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getEffetGauche() {
        return effetGauche;
    }

    public void setEffetGauche(String effetGauche) {
        this.effetGauche = effetGauche;
    }

    public String getEffetDroite() {
        return effetDroite;
    }

    public void setEffetDroite(String effetDroite) {
        this.effetDroite = effetDroite;
    }
}
