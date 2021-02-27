package com.team1.hyteproject.program;

public class BaseExercise {

    private enum targetMuscleGroup { ABS, BICEPS, CALVES, CHEST, DELTS, GLUTES, HAMS, LOWER_BACK, UPPER_BACK, QUADS }

    private String name;
    private double weight;
    private int recoveryDays;
    private int exerciseIntensity;
    private int reps;
    private int sets;
    private int priority;
    private boolean preference;

    public BaseExercise() {}

    public BaseExercise(String name, int recoveryDays, int exerciseIntensity) {
        this.name = name;
        this.recoveryDays = recoveryDays;
        this.exerciseIntensity = exerciseIntensity;
    }

    public void setSets (int sets) { this.sets = sets; }

    public void setReps (int reps) { this.reps = reps; }

    public void setPreference (boolean preference) { this.preference = preference; }

    public void setPriority (int priority) { this.priority = priority; }

    public void setWeight (double weight) { this.weight = weight; }

    public void setRecoveryDays (int recoveryDays) { this.recoveryDays = recoveryDays; }
}

