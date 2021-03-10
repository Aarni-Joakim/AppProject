package com.team1.hyteproject.enums;

/**
 * Author Aarni Pesonen
 * Users prior experience with target workout type.
 * Can be used to determine exercise selection, volume, frequency, intensity multiplier
 */
//static values for user experience, used in program generation
public enum Experience{
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");

    private String realName;

    /**
     * store enum string value in a field
     * @param realName enum value as string
     */
    private Experience(String realName){
        this.realName = realName;
    }

    /**
     * override toString() and return enum value as string
     * @return return enum value as string
     */
    @Override public String toString(){
        return realName;
    }
}
