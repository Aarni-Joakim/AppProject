package com.team1.hyteproject.program;

import java.util.ArrayList;

public class Workout {

    private ArrayList<Exercise> exercises;

    private String workoutType;
    private long workoutDate;               // or String?
    private double workoutDuration;         // in minutes
    private int workoutNumber;
    private int workoutIntensity;
    private int workoutGrade;

    public Workout() {

        exercises = new ArrayList<Exercise>();
    }

    public ArrayList<Exercise> getExerciseList() { return exercises; }

    public Exercise getExercise(int index) { return exercises.get(index); }

    public void addExercise() { exercises.add(new Exercise()); } // input parameters

    public void removeExercise(int index) { exercises.remove(index); }

    public void setWorkoutType(String workoutType) {this.workoutType = workoutType;}

    public void setWorkoutDate(long workoutDate) {this.workoutDate = workoutDate;}

    public void setWorkoutDuration(int workoutDuration) {this.workoutDuration = workoutDuration;}

    public void setWorkoutIntensity(int workoutIntensity) {this.workoutIntensity = workoutIntensity;}

    public void setWorkoutGrade(int workoutGrade) {this.workoutGrade = workoutGrade;}

    public void setWorkoutNumber(int workoutNumber) {this.workoutNumber = workoutNumber;}

    // TODO: Getters

    // TODO: Integrate with Exercise class
}
