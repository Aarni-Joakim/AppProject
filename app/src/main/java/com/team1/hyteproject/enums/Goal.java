package com.team1.hyteproject.enums;
/**
 * Author Aarni Pesonen
 */
public enum Goal{
    MUSCLE("Muscle mass"),
    STRENGTH("Strength"),
    POWER_BUILDING("Power building"),
    TONING("Toning");

    private String realName;

    /**
     * store enum string value in a field
     * @param realName enum value as string
     */
    private Goal(String realName){
        this.realName = realName;
    }

    /**
     * override toString() and return enum value as string
     * @return enum value as string
     */
    @Override public String toString(){
        return realName;
    }
}
