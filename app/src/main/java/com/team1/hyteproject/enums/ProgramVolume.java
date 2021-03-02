package com.team1.hyteproject.enums;

public enum ProgramVolume{
    LOWEST("Lowest"),
    LOW("Low"),
    MED_LOW("Medium"),
    MED_HIGH("Medium-High"),
    HIGH("High"),
    EXTREME("Extreme");

    private String realName;

    ProgramVolume(String realName){
        this.realName = realName;
    }

    @Override public String toString(){
        return realName;
    }
}
