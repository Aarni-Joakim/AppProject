package com.team1.hyteproject.enums;

/**
 * Author Aarni Pesonen
 */
//exercise group that the exercise object belongs to, used in grouping exercises
public enum ExerciseGroup {
    UPPER_BODY("Upper Body"),
    LOWER_BODY("Lower Body"),
    CORE("Core"),
    CARDIO("Cardio"),
    STRETCHING("Stretching"),
    YOGA("Yoga");

    private String realName;

    /**
     * store enum string value in a field
     * @param realName
     */
    private ExerciseGroup(String realName){
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

