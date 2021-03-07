package com.team1.hyteproject.enums;
/**
 * Author Aarni Pesonen
 */
public enum IntensityPriority{
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5");


    private String valueAsString;

    /**
     * store enum string value in a field
     * @param valueAsString
     */
    private IntensityPriority(String valueAsString){
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
