package com.team1.hyteproject.enums;

/**
 * Author Aarni Pesonen
 */
//static values for user experience, used in program generation
public enum Experience{
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");

    private String realName;

    /**
     * store enum string value in a field
     * @param realName
     */
    private Experience(String realName){
        this.realName = realName;
    }

    /**
     * override toString() and return enum value as string
     * @return
     */
    @Override public String toString(){
        return realName;
    }
}
