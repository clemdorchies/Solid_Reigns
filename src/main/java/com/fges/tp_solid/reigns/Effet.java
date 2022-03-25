package com.fges.tp_solid.reigns;

import java.util.Map;
import java.util.Map.Entry;

public class Effet {
    public String afficheEffets(Map<TypeJauge,Integer> effets, int nbTours, Boolean activated){
        String result = "";
        for(Entry<TypeJauge,Integer> effet : effets.entrySet()){
            result += "; jauge " + effet.getKey().toString() + " : ";
            if (effet.getValue() > 0) {
                result += "+";
            }

            if ((nbTours % 11 == 0 || nbTours % 12 == 0 || nbTours % 13 == 0 || nbTours % 14 == 0 || nbTours % 15 == 0) && activated == true) {
                result += effet.getValue() * 2;
            }
            else {
                result += effet.getValue();
            }
        }
        return result.substring(1);
    }
    
    public void appliqueEffetsGauche(Personnage perso, Map<TypeJauge,Integer> effetJaugeGauche, int nbTours, Boolean activated){
        appliqueEffets(effetJaugeGauche, perso, nbTours, activated);
    }
    
    public void appliqueEffetsDroite(Personnage perso, Map<TypeJauge,Integer> effetJaugeDroite, int nbTours, Boolean activated){
        appliqueEffets(effetJaugeDroite, perso, nbTours, activated);
    }
    
    private void appliqueEffets(Map<TypeJauge,Integer> effets, Personnage perso, int nbTours, Boolean activated){
        for(Entry<TypeJauge,Integer> effet : effets.entrySet()){
            switch(effet.getKey()){
                    case ARMEE:
                        if ((nbTours % 11 == 0 || nbTours % 12 == 0 || nbTours % 13 == 0 || nbTours % 14 == 0 || nbTours % 15 == 0) && activated == true) {
                            Jauge.getJaugeArmee(perso).setValeur(Jauge.getJaugeArmee(perso).getValeur() + (effet.getValue() * 2));
                        }
                        else {
                            Jauge.getJaugeArmee(perso).setValeur(Jauge.getJaugeArmee(perso).getValeur() + effet.getValue());
                        }
                        break;
                    case CLERGE:
                        if ((nbTours % 11 == 0 || nbTours % 12 == 0 || nbTours % 13 == 0 || nbTours % 14 == 0 || nbTours % 15 == 0) && activated == true) {
                            Jauge.getJaugeClerge(perso).setValeur(Jauge.getJaugeClerge(perso).getValeur() + (effet.getValue() * 2));
                        }
                        else {
                            Jauge.getJaugeClerge(perso).setValeur(Jauge.getJaugeClerge(perso).getValeur() + effet.getValue());
                        }
                        break;
                    case FINANCE:
                        if ((nbTours % 11 == 0 || nbTours % 12 == 0 || nbTours % 13 == 0 || nbTours % 14 == 0 || nbTours % 15 == 0) && activated == true) {
                            Jauge.getJaugeFinance(perso).setValeur(Jauge.getJaugeFinance(perso).getValeur() + (effet.getValue() *2));
                        }
                        else {
                            Jauge.getJaugeFinance(perso).setValeur(Jauge.getJaugeFinance(perso).getValeur() + effet.getValue());
                        }
                        break;
                    case PEUPLE:
                        if ((nbTours % 11 == 0 || nbTours % 12 == 0 || nbTours % 13 == 0 || nbTours % 14 == 0 || nbTours % 15 == 0) && activated == true) {
                            Jauge.getJaugePeuple(perso).setValeur(Jauge.getJaugePeuple(perso).getValeur() + (effet.getValue() * 2));
                        }
                        else {
                            Jauge.getJaugePeuple(perso).setValeur(Jauge.getJaugePeuple(perso).getValeur() + effet.getValue());
                        }
                        break;
            }
        }
    }
}