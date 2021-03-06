package com.team1.hyteproject.enums;

public enum ExerciseGroup {
    UPPER_BODY("Upper Body"),
    LOWER_BODY("Lower Body"),
    CORE("Core"),
    CARDIO("Cardio"),
    STRETCHING("Stretching"),
    YOGA("Yoga");

    private String realName;

    private ExerciseGroup(String realName){
        this.realName = realName;
    }

    @Override public String toString(){
        return realName;
    }
}

