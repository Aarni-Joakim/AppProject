package com.team1.hyteproject.enums;

/**
 * Author Aarni Pesonen
 */
public enum IsCompound {
    TRUE("Compound"),
    FALSE("Isolation");


    private String valueAsString;

    /**
     * store enum string value in a field
     * @param valueAsString
     */
    private IsCompound(String valueAsString){
        this.valueAsString = valueAsString;
    }

    /**
     * override toString() and return enum value as string
     * @return
     */
    @Override public String toString(){
        return valueAsString;
    }
}