package com.team1.hyteproject.enums;

public enum IsCompound {
    TRUE("Compound"),
    FALSE("Isolation");


    private String valueAsString;

    private IsCompound(String valueAsString){
        this.valueAsString = valueAsString;
    }

    @Override public String toString(){
        return valueAsString;
    }
}