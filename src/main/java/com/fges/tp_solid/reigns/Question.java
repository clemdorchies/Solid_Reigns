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
    protected ArrayList<Condition> conditions;
    
    public Question(String nomPersonnage, String question, String effetGauche, String effetDroite) {
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.effetGauche = effetGauche;
        this.effetDroite = effetDroite;
        this.effet = new Effet();
        this.effetJaugeGauche = new TreeMap<>();
        this.effetJaugeDroite = new TreeMap<>();
        this.conditions = new ArrayList<Condition>();
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
    
    public static Question getQuestionAleatoire(ArrayList<Question> questions, Personnage perso){
        int numQuestion = (int) (Math.random()*questions.size());
        Boolean bonneCondition = true;
        int i = 0;
        if (numQuestion == 5 || numQuestion == 6) {
        while (i < questions.get(numQuestion).conditions.size() && bonneCondition == true) {
            if (questions.get(numQuestion).conditions.get(i).operateur == ">" &&
            perso.jauges.get(questions.get(numQuestion).conditions.get(i).type.getValue()).getValeur() > questions.get(numQuestion).conditions.get(i).nombre) {
                bonneCondition = true;
            }
            else if (questions.get(numQuestion).conditions.get(i).operateur == "<" &&
            perso.jauges.get(questions.get(numQuestion).conditions.get(i).type.getValue()).getValeur() < questions.get(numQuestion).conditions.get(i).nombre) {
                bonneCondition = true;
            }
            else {
                bonneCondition = false;
            }
            i++;
        }}
        if (bonneCondition == true) {
            return questions.get(numQuestion);
        }
        System.out.println("Relance");
        return getQuestionAleatoire(questions, perso);
    }

    public static void initBanqueQuestions(ArrayList<Question> questions, Personnage perso){
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
        //TODO : version 1.2
        Question question6 = new Question(
                    "Main du Roi",
                    "Les caisses sont vides...",
                    "Augmenter les taxes",
                    "Emprunter");
        question6.ajouteEffetGauche(TypeJauge.FINANCE, +10);
        question6.ajouteEffetGauche(TypeJauge.PEUPLE, -5);
        question6.ajouteEffetDroite(TypeJauge.FINANCE, +1);
        question6.ajouteEffetDroite(TypeJauge.PEUPLE, -3);
        question6.conditions.add(new Condition(TypeJauge.FINANCE, "<", 10));
        questions.add(question6);
        Question question7 = new Question(
                    "Prêtre",
                    "J'aimerai qu'on nous considère en tant que tel",
                    "Construire un monastère",
                    "Ecouter sans rien faire");
        question7.ajouteEffetGauche(TypeJauge.FINANCE, +10);
        question7.ajouteEffetGauche(TypeJauge.PEUPLE, -5);
        question7.ajouteEffetDroite(TypeJauge.FINANCE, +1);
        question7.ajouteEffetDroite(TypeJauge.PEUPLE, -3);
        question7.conditions.add(new Condition(TypeJauge.CLERGE, "<", 10));
        question7.conditions.add(new Condition(TypeJauge.FINANCE, ">", 30));
        questions.add(question7);
    }
    
    public void ajouteEffetGauche(TypeJauge jauge, int valeur){
        effetJaugeGauche.put(jauge,valeur);
    }
    
    public void ajouteEffetDroite(TypeJauge jauge, int valeur){
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
