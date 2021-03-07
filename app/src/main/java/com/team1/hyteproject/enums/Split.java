package com.team1.hyteproject.enums;

/**
 * Author Aarni Pesonen
 */
//stores program split information
public enum Split{
    FULL_BODY("Full-body"),
    UPPER_LOWER("Upper lower"),
    PPL("PPL");

    private String realName;

    /**
     * store enum string value in a field
     * @param realName
     */
    private Split(String realName){
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
