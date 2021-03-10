package com.team1.hyteproject.program;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Aarni Pesonen
 */
public class Workout {

    private ArrayList<BaseExercise> workoutExercises = new ArrayList<>();

    private Date workoutDate;                               //date from java calendar
    private String workoutDateString;
    private String workoutType;
    private long workoutDateLong;                           // redundant?
    private double workoutDuration;                         // in minutes, not implemented
    private int workoutNumber;                              // assigned workout order number
    private int workoutIntensity;                           // based on workout exercise intensity average
    private int workoutGrade;                               // user input self evaluation stat, not yet implemented

    private boolean workoutCompleted = false;

    /**
     * default constructor
     */
    public Workout () {

    }

    /**
     * parameterized constructor, taking in workout date as a string and workout type
     * @param workoutDateString date generated from java calendar converted to string
     * @param workoutType not yet implemented, would be defined based on major muscle groups trained in a session
     *                    ex. workout with mostly leg exercises would be typed: legs.
     *                    other types would include full-body, upper body, core etc.
     */
    public Workout(String workoutDateString, String workoutType) {
        this.workoutDateString = workoutDateString;
        this.workoutType = workoutType;
    }

    /**
     * returns a list of exercises included in workout
     * @return list of exercises included in a single workout
     */
    public ArrayList<BaseExercise> getExerciseList() { return workoutExercises; }

    /**
     * returns a specific exercise inside workout exercises list based on a given index
     * @param index of specific exercise to get, used when implementing exercise specific fragment/view
     * @return exercise at given index
     */
    public BaseExercise getExercise(int index) { return workoutExercises.get(index); }

    /**
     * adds an exercise to workoutExercises list
     * @param baseExercise to be added to a single workout
     */
    public void addExercise(BaseExercise baseExercise) { workoutExercises.add(baseExercise); } // input parameters

    /**
     * removes an exercise from workoutExercises list at a given index
     * @param index of exercise to be removed from workout, used when implementing program customization
     */
    public void removeExercise(int index) { workoutExercises.remove(index); }

    /**
     * sets workout type, based on exercise muscle group volume, not yet implemented
     * @param workoutType not implemented, check class description
     */
    public void setWorkoutType(String workoutType) {this.workoutType = workoutType;}

    /**
     * sets workoutDate long value (redundant?)
     * @param workoutDate value as long
     */
    public void setWorkoutDate(String workoutDate) {this.workoutDateString = workoutDateString;}

    /**
     * sets workout duration in minutes, calculation not yet implemented
     * @param workoutDuration not yet implemented, would be calculated from sets, reps and rest periods of workouts exercise composition
     */
    public void setWorkoutDuration(int workoutDuration) {this.workoutDuration = workoutDuration;}

    /**
     * sets workout intensity, calculated from exercise intensity average, not yet implememnted
     * @param workoutIntensity value from age, experience, desiredIntensity, would affect volume, frequency and possibly exercise selection
     */
    public void setWorkoutIntensity(int workoutIntensity) {this.workoutIntensity = workoutIntensity;}

    /**
     * sets workout grade form user input, not yet implemented
     * @param workoutGrade from user input
     */
    public void setWorkoutGrade(int workoutGrade) {this.workoutGrade = workoutGrade;}

    /**
     * sets workout number, is equal to list index +1
     * @param workoutNumber to be displayed in workoutListView
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
     * @return date value as string
     */
    public String getWorkoutDate () {
        return workoutDateString;
    }

    /**
     * not yet implmemented, gets workout type string value
     * @return type of workout
     */
    public String getWorkoutType () {
        return workoutType;
    }


    // TODO: Getters

    // TODO: Integrate fully with BaseExercise class
}
