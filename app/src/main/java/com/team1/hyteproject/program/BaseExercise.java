package com.team1.hyteproject.program;

import com.team1.hyteproject.enums.TargetMuscleGroup;

public class BaseExercise {

    private TargetMuscleGroup targetMuscleGroup;
    private String name;
    private String tag;
    private double weight;
    private int recoveryDays;
    private int exerciseIntensity;
    private int reps;
    private int sets;
    private int priority;
    private boolean preference;
    private boolean isCompound;

    private String[] tags;              // tags could be used to assists program generator in exercise selection

    public BaseExercise() {}

    public BaseExercise(String name, int recoveryDays, int exerciseIntensity, boolean isCompound, TargetMuscleGroup targetMuscleGroup) {
        this.name = name;
        this.recoveryDays = recoveryDays;
        this.exerciseIntensity = exerciseIntensity;
        this.isCompound = isCompound;
    }

    public void setSets (int sets) { this.sets = sets; }

    public void setReps (int reps) { this.reps = reps; }

    public void setPreference (boolean preference) { this.preference = preference; }

    public void setPriority (int priority) { this.priority = priority; }

    public void setWeight (double weight) { this.weight = weight; }

    public void setRecoveryDays (int recoveryDays) { this.recoveryDays = recoveryDays; }

    public void addTag(String tag) {
        if (tags == null)
        tags = new String[5];

        int arrayLength = tags.length;
        tags[arrayLength - 1] = tag;
    }

    public String getName (){
        return name;
    }
}

