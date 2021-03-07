package com.team1.hyteproject.program;

import com.team1.hyteproject.enums.ExerciseGroup;
import com.team1.hyteproject.enums.TargetMuscleGroup;

import java.util.ArrayList;

/**
 * Author Aarni Pesonen
 */
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
    private String reps;
    private String sets;
    private int priority;
    private int preference = 0;
    private boolean isCompound;
    private boolean isSelected = false;
    private boolean isRecovered = true;

    private ArrayList<Integer> recoveryStatistics;
    private String[] tags;              // tags could be used to assists program generator in exercise selection

    /**
     * default constructor
     */
    public BaseExercise() {}

    public BaseExercise(String name, TargetMuscleGroup targetMuscleGroup, String sets, String reps) {
        this.name = name;
        this.targetMuscleGroup = targetMuscleGroup;
        this.sets = sets;
        this.reps = reps;
    }
    /**
     * parameterized constructor
     * @param name of the exercise
     * @param recoveryDays how many days to recoved from exercise
     * @param exerciseIntensity how intense is the exercise
     * @param Priority used when selecting exercises for a program, can be altered based on program goal (feature not yet implemented)
     * @param isCompound compound exercise: true, isolation exercise: false
     * @param targetMuscleGroup main muscle group the exercise targets
     * @param exerciseGroup exercise group the exercise belongs to (only gym related groups implemented)
     */
    public BaseExercise(String name, int recoveryDays, int exerciseIntensity, int Priority,  boolean isCompound, TargetMuscleGroup targetMuscleGroup, ExerciseGroup exerciseGroup) {
        this.name = name;
        this.exerciseGroup = exerciseGroup;
        this.recoveryDays = recoveryDays;
        this.exerciseIntensity = exerciseIntensity;
        this.priority = Priority;
        this.isCompound = isCompound;
        this.targetMuscleGroup = targetMuscleGroup;
    }

    /**
     * set the amount of sets
     * @param sets
     */
    public void setSets (String sets) { this.sets = sets; }

    /**
     * set the amount of reps
     * @param reps
     */
    public void setReps (String reps) { this.reps = reps; }

    /**
     * set exercise preference value
     * @param preference
     */
    public void setPreference (int preference) { this.preference = preference; }

    /**
     * set exercise priority value
     * @param priority
     */
    public void setPriority (int priority) { this.priority = priority; }

    /**
     * set weight to be used (not yet implemented)
     * @param weight
     */
    public void setWeight (double weight) { this.weight = weight; }

    /**
     * set exercise recovery days
     * @param recoveryDays
     */
    public void setRecoveryDays (int recoveryDays) { this.recoveryDays = recoveryDays; }

    /**
     * how many days since the recovery started
     * @param recoveryProgress
     */
    public void setRecoveryProgress (int recoveryProgress) { this.recoveryProgress = recoveryProgress; }

    /**
     * is the exercise selected to programExercises? there is a method to reset the value
     * @param isSelected
     */
    public void setIsSelected(boolean isSelected) { this.isSelected = isSelected; }

    /**
     * bool value for recovery
     * @param recovered
     */
    public void setRecovered(boolean recovered) {
        this.isRecovered = recovered;
    }

    /**
     * not yet implemented
     * @param recoveryProgress
     */
    public void setRecoveryStatistics(int recoveryProgress) {
        if(recoveryStatistics == null) {
            this.recoveryStatistics = new ArrayList<>();
        }
        recoveryStatistics.add(recoveryProgress);
    }

    /**
     * plan is for user to be able to tag exercises and have program generator take these into account
     * not yet implemented
     * @param tag
     */
    public void addTag(String tag) {
        if (tags == null)
        tags = new String[5];

        int arrayLength = tags.length;
        tags[arrayLength - 1] = tag;
    }

    /**
     * gets exercise name
     * @return
     */
    public String getName (){
        return name;
    }

    /**
     * gets exercise priority
     * @return
     */
    public int getPriority (){
        return priority;
    }

    /**
     * gets exercise main target muscle group
     * @return
     */
    public TargetMuscleGroup getTargetMuscleGroup() { return targetMuscleGroup; }

    /***
     * gets exercise intensity value
     * @return
     */
    public int getExerciseIntensity() { return exerciseIntensity; }

    /**
     * gets exercise type, compound: true, isolation: false
     * @return
     */
    public boolean getIsCompound() { return isCompound; }

    /**
     * get is the exercise selected, checked when stream reader goes through ExerciseList singleton
     * (ExerciesList contains all exercises included in the app)
     * @return
     */
    public boolean getIsSelected(){ return isSelected; }

    /**
     * get bool recovery value
     * @return
     */
    public boolean getRecovered() { return isRecovered; }

    /**
     * gets days since start of recovery (not yet implemented)
     * @return
     */
    public int getRecoveryProgress() { return this.recoveryProgress; }

    /**
     * gets how many days of recovery is needed
     * @return
     */
    public int getRecoveryDays() {return this.recoveryDays; }

    /**
     * list of past recovery statistics (not yet implemented)
     * @return
     */
    public ArrayList getRecoveryStatistics () { return recoveryStatistics; }

    public String getSets() {
        return sets;
    }
    public String getReps() {
        return reps;
    }

    /**
     * overrides toString method to return exercise name (redundant?)
     * @return
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * gets the group exercise belongs to
     * @return
     */
    public ExerciseGroup getExerciseGroup() {
        return exerciseGroup;
    }
}

