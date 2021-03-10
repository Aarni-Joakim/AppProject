package com.team1.hyteproject.program;

import com.team1.hyteproject.enums.ExerciseGroup;
import com.team1.hyteproject.enums.TargetMuscleGroup;

import java.util.ArrayList;

/**
 * @Author Aarni Pesonen
 * First iteration of BaseExercise class stores all exercise related information
 * Inheritance structure was originally planned for exercises, but not yet implemented
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

    /**
     * parameterized constructor
     * @param name of exercise
     * @param targetMuscleGroup of exercise
     * @param sets to be performed in a single workout
     * @param reps to be performed in a single set
     */
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
     * @param sets to be performed during a workout
     */
    public void setSets (String sets) { this.sets = sets; }

    /**
     * set the amount of reps
     * @param reps to be performed during each set
     */
    public void setReps (String reps) { this.reps = reps; }

    /**
     * set exercise preference value
     * @param preference user preference value for exercise, not yet implemented
     */
    public void setPreference (int preference) { this.preference = preference; }

    /**
     * set exercise priority value
     * @param priority priority determines which exercises will be selected first by the ProgramGenereator stream reader
     */
    public void setPriority (int priority) { this.priority = priority; }

    /**
     * set weight to be used (not yet implemented)
     * @param weight not yet implemented
     */
    public void setWeight (double weight) { this.weight = weight; }

    /**
     * set exercise recovery days
     * @param recoveryDays how many days does it take to recover from given exercise
     */
    public void setRecoveryDays (int recoveryDays) { this.recoveryDays = recoveryDays; }

    /**
     * how many days since the recovery started
     * @param recoveryProgress how far is the recovery progress, not yet implemented
     */
    public void setRecoveryProgress (int recoveryProgress) { this.recoveryProgress = recoveryProgress; }

    /**
     * is the exercise selected to programExercises? there is a method to reset the value
     * @param isSelected true if stream reader has selected the exercise to a list
     *                   if false exercise cannot be selected again until value is set to zero
     */
    public void setIsSelected(boolean isSelected) { this.isSelected = isSelected; }

    /**
     * bool value for recovery
     * @param recovered has recovery been completed yet, not yet implemented
     */
    public void setRecovered(boolean recovered) {
        this.isRecovered = recovered;
    }

    /**
     * not yet implemented
     * @param recoveryProgress set recovery progress value, not yet implemented
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
     * @param tag enables user to set various tags to exercises for ProgramGenerator to use
     */
    public void addTag(String tag) {
        if (tags == null)
        tags = new String[5];

        int arrayLength = tags.length;
        tags[arrayLength - 1] = tag;
    }

    /**
     * gets exercise name
     * @return name of exercise
     */
    public String getName (){
        return name;
    }

    /**
     * gets exercise priority
     * @return priority value of exercise
     */
    public int getPriority (){
        return priority;
    }

    /**
     * gets exercise main target muscle group
     * @return main target muscle group of exercise
     */
    public TargetMuscleGroup getTargetMuscleGroup() { return targetMuscleGroup; }

    /***
     * gets exercise intensity value
     * @return not yet implemented
     */
    public int getExerciseIntensity() { return exerciseIntensity; }

    /**
     * gets exercise type, compound: true, isolation: false
     * @return true for compound, false for isolation
     */
    public boolean getIsCompound() { return isCompound; }

    /**
     * get is the exercise selected, checked when stream reader goes through ExerciseList singleton
     * (ExerciesList contains all exercises included in the app)
     * @return true if exercise has been selected to a list by stream reader, false if unselected or reset
     */
    public boolean getIsSelected(){ return isSelected; }

    /**
     * get bool recovery value
     * @return true if recovered, false if not
     */
    public boolean getRecovered() { return isRecovered; }

    /**
     * gets days since start of recovery (not yet implemented)
     * @return not yet implemented
     */
    public int getRecoveryProgress() { return this.recoveryProgress; }

    /**
     * gets how many days of recovery is needed
     * @return recovery days needed
     */
    public int getRecoveryDays() {return this.recoveryDays; }

    /**
     * list of past recovery statistics (not yet implemented)
     * @return not yet implemented
     */
    public ArrayList getRecoveryStatistics () { return recoveryStatistics; }

    /**
     * return exercise sets value
     * @return value of sets
     */
    public String getSets() {
        return sets;
    }

    /**
     * return exercise reps value
     * @return value of reps
     */
    public String getReps() {
        return reps;
    }

    /**
     * overrides toString method to return exercise name (redundant?)
     * @return exercise name as string
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * gets the group exercise belongs to
     * @return group the exercise belongs to
     */
    public ExerciseGroup getExerciseGroup() {
        return exerciseGroup;
    }
}

