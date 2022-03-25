package com.fges.tp_solid.reigns;

public enum TypeJauge {
    CLERGE(0),
    PEUPLE(1),
    ARMEE(2),
    FINANCE(3);

    private final int value;

    TypeJauge(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
