package com.team1.hyteproject.enums;

public enum IntensityPriority{
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5");


    private String valueAsString;

    private IntensityPriority(String valueAsString){
        this.valueAsString = valueAsString;
    }

    @Override public String toString(){
        return valueAsString;
    }
}
