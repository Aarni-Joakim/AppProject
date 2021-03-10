package com.team1.hyteproject.enums;

/**
 * @author Aarni Pesonen
 * When fully implemented, will affect weekly volume of exercises per muscle group
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
     * @param realName enum value as string
     */
    ProgramVolume(String realName){
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
