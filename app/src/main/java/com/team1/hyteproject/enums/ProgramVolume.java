package com.team1.hyteproject.enums;

/**
 * Author Aarni Pesonen
 */
//used in determining the amount of program training volume *not yet in full use*
public enum ProgramVolume{
    LOWEST("Lowest"),
    LOW("Low"),
    MED_LOW("Medium"),
    MED_HIGH("Medium-High"),
    HIGH("High"),
    EXTREME("Extreme");

    private String realName;

    /**
     * store enum string value in a field
     * @param realName
     */
    ProgramVolume(String realName){
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
