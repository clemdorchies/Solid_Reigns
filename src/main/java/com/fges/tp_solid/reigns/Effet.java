package com.fges.tp_solid.reigns;

import java.util.Map;
import java.util.Map.Entry;

public class Effet {
    public String afficheEffets(Map<TypeJauge,Integer> effets){
        String result = "";
        for(Entry<TypeJauge,Integer> effet : effets.entrySet()){
            result += "; jauge "+effet.getKey().toString()+" : ";
            if(effet.getValue()>0)
                result += "+";
            result += effet.getValue();
        }
        return result.substring(1);
    }
    
    public void appliqueEffetsGauche(Personnage perso, Map<TypeJauge,Integer> effetJaugeGauche){
        appliqueEffets(effetJaugeGauche, perso);
    }
    
    public void appliqueEffetsDroite(Personnage perso, Map<TypeJauge,Integer> effetJaugeDroite){
        appliqueEffets(effetJaugeDroite, perso);
    }
    
    private void appliqueEffets(Map<TypeJauge,Integer> effets, Personnage perso){
        for(Entry<TypeJauge,Integer> effet : effets.entrySet()){
            switch(effet.getKey()){
                    case ARMEE:
                        Jauge.getJaugeArmee(perso).setValeur(
                                Jauge.getJaugeArmee(perso).getValeur()
                                        +effet.getValue());
                        break;
                    case CLERGE:
                        Jauge.getJaugeClerge(perso).setValeur(
                                Jauge.getJaugeClerge(perso).getValeur()
                                        +effet.getValue());
                        break;
                    case FINANCE:
                        Jauge.getJaugeFinance(perso).setValeur(
                                Jauge.getJaugeFinance(perso).getValeur()
                                        +effet.getValue());
                        break;
                    case PEUPLE:
                        Jauge.getJaugePeuple(perso).setValeur(
                                Jauge.getJaugePeuple(perso).getValeur()
                                        +effet.getValue());
                        break;
            }
        }
    }
}