package com.team1.hyteproject.enums;
/**
 * @author Aarni Pesonen
 * Exercises with higher priority are selected first by ProgramGenerator
 * Used when adding exercises to exerciseList
 * spinners get their values from enums
 */
public enum IntensityPriority{
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6");


    private String valueAsString;

    /**
     * store enum string value in a field
     * @param valueAsString enum value as string
     */
    private IntensityPriority(String valueAsString){
        this.valueAsString = valueAsString;
    }

    /**
     * override toString() and return enum value as string
     * @return enum value as string
     */
    @Override public String toString(){
        return valueAsString;
    }
}
