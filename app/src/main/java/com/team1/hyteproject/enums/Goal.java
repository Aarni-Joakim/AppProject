package com.team1.hyteproject.enums;

public enum Goal{
    MUSCLE("Muscle mass"),
    STRENGTH("Strength"),
    POWER_BUILDING("Power building"),
    TONING("Toning");

    private String realName;

    private Goal(String realName){
        this.realName = realName;
    }

    @Override public String toString(){
        return realName;
    }
}
