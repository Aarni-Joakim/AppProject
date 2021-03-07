package com.team1.hyteproject.enums;

/**
 * Author Aarni Pesonen
 */
//recovery time of a given exercise
public enum RecoveryTime{
    ONE("1 day"),
    TWO("2 days"),
    THREE("3 days"),
    FOUR("4 days"),
    FIVE("5 days"),
    SIX("6 days"),
    SEVEN("7 days");


    private String valueAsString;

    /**
     * store enum string value in a field
     * @param valueAsString
     */
    private RecoveryTime(String valueAsString){
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