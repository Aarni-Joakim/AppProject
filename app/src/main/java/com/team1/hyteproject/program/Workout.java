package com.team1.hyteproject.program;

import java.util.ArrayList;
import java.util.Date;

/**
 * Author Aarni Pesonen
 */
public class Workout {

    private ArrayList<BaseExercise> workoutExercises = new ArrayList<>();

    private Date workoutDate;                               //date from java calendar
    private String workoutDateString;
    private String workoutType = "Full Body";
    private long workoutDateLong;                           // redundant?
    private double workoutDuration;                         // in minutes, not implemented
    private int workoutNumber;                              // assigned workout order number
    private int workoutIntensity;                           // based on workout exercise intensity average
    private int workoutGrade;                               // user input self evaluation stat, not yet implemented

    private boolean workoutCompleted = false;

    public Workout () {

    }
    public Workout(String workoutDateString, String workoutType) {
        this.workoutDateString = workoutDateString;
        this.workoutType = workoutType;
    }

    /**
     * returns a list of exercises included in workout
     * @return
     */
    public ArrayList<BaseExercise> getExerciseList() { return workoutExercises; }

    /**
     * returns a specific exercise inside workout exercises list based on a given index
     * @param index
     * @return
     */
    public BaseExercise getExercise(int index) { return workoutExercises.get(index); }

    /**
     * adds an exercise to workoutExercises list
     * @param baseExercise
     */
    public void addExercise(BaseExercise baseExercise) { workoutExercises.add(baseExercise); } // input parameters

    /**
     * removes an exercise from workoutExercises list at a given index
     * @param index
     */
    public void removeExercise(int index) { workoutExercises.remove(index); }

    /**
     * sets workout type, based on exercise muscle group volume, not yet implemented
     * @param workoutType
     */
    public void setWorkoutType(String workoutType) {this.workoutType = workoutType;}

    /**
     * sets workoutDate long value (redundant?)
     * @param workoutDate
     */
    public void setWorkoutDate(String workoutDate) {this.workoutDateString = workoutDateString;}

    /**
     * sets workout duration in minutes, calculation not yet implemented
     * @param workoutDuration
     */
    public void setWorkoutDuration(int workoutDuration) {this.workoutDuration = workoutDuration;}

    /**
     * sets workout intensity, calculated from exercise intensity average, not yet implememnted
     * @param workoutIntensity
     */
    public void setWorkoutIntensity(int workoutIntensity) {this.workoutIntensity = workoutIntensity;}

    /**
     * sets workout grade form user input, not yet implemented
     * @param workoutGrade
     */
    public void setWorkoutGrade(int workoutGrade) {this.workoutGrade = workoutGrade;}

    /**
     * sets workout number, is equal to list index +1
     * @param workoutNumber
     */
    public void setWorkoutNumber(int workoutNumber) {this.workoutNumber = workoutNumber;}

    /**
     * not yet implemented
     */
    public void convertDates() {

    }

    /**
     * converts a Date value to string
     */
    public void dateToString(){
        this.workoutDateString = workoutDate.toString();
    }

    /**
     * gets workout date string value
     * @return
     */
    public String getWorkoutDate () {
        return workoutDateString;
    }

    /**
     * gets workout type string value
     * @return
     */
    public String getWorkoutType () {
        return workoutType;
    }


    // TODO: Getters

    // TODO: Integrate with Exercise class
}
