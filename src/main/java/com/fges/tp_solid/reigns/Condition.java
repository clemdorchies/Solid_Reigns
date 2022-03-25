package com.fges.tp_solid.reigns;

public class Condition {
    public TypeJauge type;
    public String operateur;
    public int nombre;

    public Condition(TypeJauge typeJauge, String operateur, int nombre) {
        this.type = typeJauge;
        this.operateur = operateur;
        this.nombre = nombre;
    }
}
