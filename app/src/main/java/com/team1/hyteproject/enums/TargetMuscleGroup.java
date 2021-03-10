package com.team1.hyteproject.enums;

import com.team1.hyteproject.program.BaseExercise;

/**
 * @author Aarni Pesonen
 * Enum class handles target muscle group info, value conversions between enum and string
 * also finds exercise group of exercise based on target muscle group
 */
//used to store exercise targetMuscleGroup value
public enum TargetMuscleGroup{
    ABS("Abs"),
    BACK("Back"),
    BICEPS("Biceps"),
    CALVES("Calves"),
    CHEST("Chest"),
    CORE("Core"),
    DELTS("Delts"),
    GLUTES("Glutes"),
    HAMSTRINGS("Hamstrings"),
    LEGS("Legs"),
    LOWER_BACK("Lower back"),
    UPPER_BACK("Upper back"),
    TRICEPS("Triceps"),
    QUADS("Quads");

    private String realName;

    /**
     * store enum string value in a field
     * @param realName enum value as string
     */
    private TargetMuscleGroup(String realName){
        this.realName = realName;
    }

    /**
     * override toString() and return enum value as string
     * @return enum value as string
     */
    @Override public String toString(){
        return realName;
    }

    /**
     * return exerciseGroup string value based on target muscle group of exercise
     * @param targetMuscleGroup of an exercise
     * @return exercise group based on exercises target muscle group
     */
    public String getExerciseGroup (TargetMuscleGroup targetMuscleGroup) {
        String exerciseGroup;

        if (targetMuscleGroup.equals(BACK) || targetMuscleGroup.equals(BICEPS) || targetMuscleGroup.equals(CHEST)
                ||targetMuscleGroup.equals(DELTS) ||targetMuscleGroup.equals(LOWER_BACK) ||targetMuscleGroup.equals(UPPER_BACK) ||targetMuscleGroup.equals(TRICEPS)) {
            exerciseGroup = "Upper Body";
            return exerciseGroup;
        } else if (targetMuscleGroup.equals(LEGS) || targetMuscleGroup.equals(GLUTES) || targetMuscleGroup.equals(HAMSTRINGS) || targetMuscleGroup.equals(CALVES) || targetMuscleGroup.equals(QUADS)) {
            exerciseGroup = "Lower Body";
            return exerciseGroup;
        } else if (targetMuscleGroup.equals(CORE) || targetMuscleGroup.equals(CORE)) {
            exerciseGroup = "Core";
            return exerciseGroup;
        } else {
            exerciseGroup = "Exercise group not found!";
            return exerciseGroup;
        }
    }

    /**
     * converts a string value representation to enum value
     * @param targetMuscleGroupToConvert input parameter to convert
     * @return enum value of a string
     */
    //TODO: Check if this needs toUpperCase()
    public TargetMuscleGroup stringToValue(String targetMuscleGroupToConvert) {
        TargetMuscleGroup targetMuscleGroup = TargetMuscleGroup.valueOf(targetMuscleGroupToConvert);
       return targetMuscleGroup;
    }

    /**
     * returns exercise group of BaseExercise object entered as a parameter
     * @param baseExercise
     * @return exercise group of BaseExercise object entered as a parameter
     */
    public TargetMuscleGroup getExerciseGroupFromObject (BaseExercise baseExercise) {
        TargetMuscleGroup targetMuscleGroup = baseExercise.getTargetMuscleGroup();
        return targetMuscleGroup;
    }
}


