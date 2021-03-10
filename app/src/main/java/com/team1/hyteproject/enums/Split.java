package com.team1.hyteproject.enums;

/**
 * @Author Aarni Pesonen
 * Static program split values determined based on exercises per week.
 * First iteration does not allow dynamic morphing between splits after program generation
 */
//stores program split information
public enum Split{
    FULL_BODY("Full-body"),
    UPPER_LOWER("Upper lower"),
    PPL("PPL");

    private String realName;

    /**
     * store enum string value in a field
     * @param realName enum value as string
     */
    private Split(String realName){
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
