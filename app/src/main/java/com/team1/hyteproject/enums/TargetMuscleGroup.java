package com.team1.hyteproject.enums;

public enum TargetMuscleGroup{
    ABS("Abs"),
    BACK("Back"),
    BICEPS("Biceps"),
    CALVES("Calves"),
    CHEST("Chest"),
    CORE("Core"),
    DELTS("Delts"),
    GLUTES("Glutes"),
    HAMS("Hamstrings"),
    LEGS("Legs"),
    LOWER_BACK("Lower back"),
    UPPER_BACK("Upper back"),
    TRICEPS("Triceps"),
    QUADS("Quads");

    private String realName;

    private TargetMuscleGroup(String realName){
        this.realName = realName;
    }

    @Override public String toString(){
        return realName;
    }
}


