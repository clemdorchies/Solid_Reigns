package com.fges.tp_solid.reigns;

public class JeuGOT {
    Boolean activated;

    public JeuGOT(Boolean activated) {
        this.activated = activated;
    }

    public void upDate(int nbTours) {
        if (activated == true) {
            if (nbTours % 10 == 0) {
                System.out.println("L'hiver arrive");
            }
            if (nbTours % 11 == 0 || nbTours % 12 == 0 || nbTours % 13 == 0 || nbTours % 14 == 0 || nbTours % 15 == 0) {
                System.out.println("L'hiver est là");
            }
            if (nbTours % 16 == 0) {
                System.out.println("L'hiver est parti");
            }
        }
    }
}
