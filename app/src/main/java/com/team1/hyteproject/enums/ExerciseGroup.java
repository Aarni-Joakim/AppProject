package com.team1.hyteproject.enums;

/**
 * @Author Aarni Pesonen
 * Used to group exercises together, ex. all exercises targeting legs belong to lower body group
 * App does not yet take full advantage of this enum class.
 */
//exercise group that the exercise object belongs to, used in grouping exercises
public enum ExerciseGroup {
    UPPER_BODY("Upper_Body"),
    LOWER_BODY("Lower_Body"),
    CORE("Core"),
    CARDIO("Cardio"),
    STRETCHING("Stretching"),
    YOGA("Yoga");

    private String realName;

    /**
     * store enum string value in a field
     * @param realName Enum value as a string
     */
    private ExerciseGroup(String realName){
        this.realName = realName;
    }

    /**
     * override toString() and return enum value as string
     * @return enum value as a string
     */
    @Override public String toString(){
        return realName;
    }
}

