package com.team1.hyteproject.program;

import java.util.ArrayList;

public class Program {
    private ArrayList<Workout> workouts;
    private ArrayList<Workout> workoutHistory;
    private String programName;

    private ArrayList<BaseExercise> programExercises;

    private String programType;              // toning, power building, muscle mass, strength
    private long creationDate;               // date the program was generated
    private long endDate;                    // predicted date of finishing
    private int programDuration;             // weeks
    private int numberOfWorkouts;            // how many daily workouts in the program
    private int programIntensity;            // generated from individual workout intensities
    private int programGrade;                // generated from individual workout grades
    private String mockNextWorkoutDate = "07.03.2021";

    public Program(String programName) {
        this.programName = programName;
        workouts = new ArrayList<>();
    }

    public ArrayList<Workout> getWorkoutList() { return workouts; }

    public Workout getWorkout(int index) { return workouts.get(index); }

    public BaseExercise getProgramExercise (int index) { return programExercises.get(index); }

    public void addWorkout(Workout workout) { workouts.add(workout); } // input parameters!

    public void removeWorkout(int index) { workouts.remove(index); }

    public void setProgramName(String name) { this.programName = name; }

    public void setProgramType(String programType) { this.programType = programType; }

    public void setCreationDate(long creationDate) { this.creationDate = creationDate; }

    public void setProgramDuration(int programDuration) { this.programDuration = programDuration; }

    public void setProgramIntensity() {}

    public void setProgramGrade() {}

    public String getProgramName() {
        return programName;
    }

    public String getNextWorkoutDate() {
        return mockNextWorkoutDate;
    }

    // TODO: Getters

    // TODO: Integrate with Workout class
}
