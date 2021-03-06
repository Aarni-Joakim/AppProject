package com.team1.hyteproject.program;

import com.team1.hyteproject.enums.ExerciseGroup;
import com.team1.hyteproject.enums.TargetMuscleGroup;

import java.util.ArrayList;

public class BaseExercise {

    private TargetMuscleGroup targetMuscleGroup;
    private int testMuscleGroup;
    private String name;
    private ExerciseGroup exerciseGroup;
    private String tag;
    private double weight;
    private int recoveryDays;
    private int recoveryProgress;
    private int exerciseIntensity;
    private int reps;
    private int sets;
    private int priority;
    private int preference = 0;
    private boolean isCompound;
    private boolean isSelected = false;
    private boolean isRecovered = true;

    private ArrayList<Integer> recoveryStatistics;
    private String[] tags;              // tags could be used to assists program generator in exercise selection

    public BaseExercise() {}

    public BaseExercise(String name, int recoveryDays, int exerciseIntensity, int Priority,  boolean isCompound, TargetMuscleGroup targetMuscleGroup, ExerciseGroup exerciseGroup) {
        this.name = name;
        this.exerciseGroup = exerciseGroup;
        this.recoveryDays = recoveryDays;
        this.exerciseIntensity = exerciseIntensity;
        this.priority = Priority;
        this.isCompound = isCompound;
        this.targetMuscleGroup = targetMuscleGroup;
    }

    public void setSets (int sets) { this.sets = sets; }

    public void setReps (int reps) { this.reps = reps; }

    public void setPreference (int preference) { this.preference = preference; }

    public void setPriority (int priority) { this.priority = priority; }

    public void setWeight (double weight) { this.weight = weight; }

    public void setRecoveryDays (int recoveryDays) { this.recoveryDays = recoveryDays; }

    public void setRecoveryProgress (int recoveryProgress) { this.recoveryProgress = recoveryProgress; }

    public void setIsSelected(boolean isSelected) { this.isSelected = isSelected; }

    public void setRecovered(boolean recovered) {
        this.isRecovered = recovered;
    }

    public void setRecoveryStatistics(int recoveryProgress) {
        if(recoveryStatistics == null) {
            this.recoveryStatistics = new ArrayList<>();
        }
        recoveryStatistics.add(recoveryProgress);
    }

    public void addTag(String tag) {
        if (tags == null)
        tags = new String[5];

        int arrayLength = tags.length;
        tags[arrayLength - 1] = tag;
    }

    public String getName (){
        return name;
    }

    public int getPriority (){
        return priority;
    }

    public TargetMuscleGroup getTargetMuscleGroup() { return targetMuscleGroup; }

    public int getExerciseIntensity() { return exerciseIntensity; }

    public boolean getIsCompound() { return isCompound; }

    public boolean getIsSelected(){ return isSelected; }

    public boolean getRecovered() { return isRecovered; }

    public int getRecoveryProgress() { return this.recoveryProgress; }

    public int getRecoveryDays() {return this.recoveryDays; }

    public ArrayList getRecoveryStatistics () { return recoveryStatistics; }

    @Override
    public String toString() {
        return this.name;
    }

    public ExerciseGroup getExerciseGroup() {
        return exerciseGroup;
    }
}

