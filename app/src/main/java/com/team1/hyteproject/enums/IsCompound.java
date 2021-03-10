package com.team1.hyteproject.enums;

/**
 * @Author Aarni Pesonen
 * Used in program generation to help stream reader decide what exercises to pick from ExerciseList
 * When adding exercises to exerciseList, user must set this value
 */
public enum IsCompound {
    TRUE("Compound"),
    FALSE("Isolation");


    private String valueAsString;

    /**
     * store enum string value in a field
     * @param valueAsString enum value as string
     */
    private IsCompound(String valueAsString){
        this.valueAsString = valueAsString;
    }

    /**
     * override toString() and return enum value as string
     * @return enum as string
     */
    @Override public String toString(){
        return valueAsString;
    }
}