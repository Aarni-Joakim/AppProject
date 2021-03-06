package com.team1.hyteproject.program;

import java.util.ArrayList;
import java.util.Date;

public class Workout {

    private ArrayList<BaseExercise> workoutExercises;

    private Date workoutDate;
    private String workoutDateString = "07.03.2020";
    private String workoutType = "test type";
    private long workoutDateLong;           // or String?
    private double workoutDuration;         // in minutes
    private int workoutNumber;              // assigned workout order number
    private int workoutIntensity;           //
    private int workoutGrade;

    private boolean workoutCompleted = false;

    public Workout () {

    }
    public Workout(String workoutDateString, String workoutType) {
        this.workoutDateString = workoutDateString;
        this.workoutType = workoutType;
        workoutExercises = new ArrayList<>();
    }

    public ArrayList<BaseExercise> getExerciseList() { return workoutExercises; }

    public BaseExercise getExercise(int index) { return workoutExercises.get(index); }

    public void addExercise(BaseExercise baseExercise) { workoutExercises.add(baseExercise); } // input parameters

    public void removeExercise(int index) { workoutExercises.remove(index); }

    public void setWorkoutType(String workoutType) {this.workoutType = workoutType;}

    public void setWorkoutDate(long workoutDate) {this.workoutDateLong = workoutDate;}

    public void setWorkoutDuration(int workoutDuration) {this.workoutDuration = workoutDuration;}

    public void setWorkoutIntensity(int workoutIntensity) {this.workoutIntensity = workoutIntensity;}

    public void setWorkoutGrade(int workoutGrade) {this.workoutGrade = workoutGrade;}

    public void setWorkoutNumber(int workoutNumber) {this.workoutNumber = workoutNumber;}

    public void convertDates() {

    }

    public void dateToString(){
        this.workoutDateString = workoutDate.toString();
    }

    public String getWorkoutDate () {
        return workoutDateString;
    }
    public String getWorkoutType () {
        return workoutType;
    }


    // TODO: Getters

    // TODO: Integrate with Exercise class
}
