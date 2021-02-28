package com.team1.hyteproject.enums;

public enum ProgramVolume{
    LOW("Low"),
    MED_LOW("Medium"),
    MED_HIGH("Medium-High"),
    HIGH("High");

    private String realName;

    private ProgramVolume(String realName){
        this.realName = realName;
    }

    @Override public String toString(){
        return realName;
    }
}
