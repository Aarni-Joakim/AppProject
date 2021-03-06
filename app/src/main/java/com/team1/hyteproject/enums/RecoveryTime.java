package com.team1.hyteproject.enums;

public enum RecoveryTime{
    ONE("1 day"),
    TWO("2 days"),
    THREE("3 days"),
    FOUR("4 days"),
    FIVE("5 days"),
    SIX("6 days"),
    SEVEN("7 days");


    private String valueAsString;

    private RecoveryTime(String valueAsString){
        this.valueAsString = valueAsString;
    }

    @Override public String toString(){
        return valueAsString;
    }
}