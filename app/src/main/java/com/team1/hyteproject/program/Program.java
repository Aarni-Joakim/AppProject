package com.team1.hyteproject.program;

import android.widget.ProgressBar;

import java.util.ArrayList;

/**
 *@author Aarni Pesonen
 */

public class Program {
    private ArrayList<Workout> programWorkouts = new ArrayList<>();
    private ArrayList<Workout> workoutHistory = new ArrayList<>();
    private ArrayList<BaseExercise> programExercises = new ArrayList<>();

    private ProgressBar progressbar;
    private String programName;                 // user input
    private String programType;                 // toning, power building, muscle mass, strength
    private long creationDate;                  // date the program was generated
    private long endDate;                       // predicted date of finishing
    private int programDuration;                // weeks
    private int workoutsInProgram;              // how many daily workouts in the program
    private int workoutsCompleted;
    private int programIntensity;               // generated from individual workout intensities
    private int programGrade;                   // generated from individual workout grades
    //TODO: get this value from next workouts workoutDate field
    private String mockNextWorkoutDate = "07.03.2021";

    /**
     * default constructor
     */
    public Program() {
    }
    /**
     * constructor with name input parameter
     * @param programName input parameter
     */
    public Program(String programName) {
        this.programName = programName;
        programWorkouts = new ArrayList<>();
    }

    /**
     * returns list of all workouts included in program
     * @return all workouts included in the program
     */
    public ArrayList<Workout> getWorkoutList() { return programWorkouts; }

    /**
     * gets specific workouts from workouts list based on index value
     * @param index get specific workout based on index
     * @return workout of given index
     */
    public Workout getWorkout(int index) { return programWorkouts.get(index); }

    /**
     * returns a specific element of programExercises list based on given index (list includes all exercises in a program)
     * @param index get specific exercise from exercises included in program
     * @return exercise at given index of programExercises list
     */
    public BaseExercise getProgramExercise (int index) { return programExercises.get(index); }

    /**
     * adds a workout object to complete list of program workouts
     * @param workout object to add
     */
    public void addWorkout(Workout workout) { programWorkouts.add(workout); } // input parameters!

    /**
     * removes an element from workouts list based on index
     * (to be inserted in workout history list, not yet implemented)
     * @param index index to remove workout at
     */
    public void removeWorkout(int index) { programWorkouts.remove(index); }

    /**
     * sets the list of all exercises included in the program
     * @param arraylist set list of program exercises, handled automatically by program generator
     */
    public void setProgramExercises (ArrayList arraylist){
        this.programExercises = arraylist;
    }

    /**
     * set generated of workouts
     * @param arrayList set the list of all workouts included in program, handled automatically by program generator
     */
    public void setProgramWorkouts (ArrayList arrayList) {
        this.programWorkouts = arrayList;
    }
    /**
     * set program name, user input
     * @param name name of program, from user input
     */
    public void setProgramName(String name) { this.programName = name; }

    /**
     * sets program types based on user input goal
     * @param programType program type determined by user goal
     */
    public void setProgramType(String programType) { this.programType = programType; }

    /**
     * set program creation date
     * @param creationDate added with java calendar
     */
    public void setCreationDate(long creationDate) { this.creationDate = creationDate; }

    /**
     * set program duration in weeks
     * @param programDuration in weeks, from user input
     */
    public void setProgramDuration(int programDuration) { this.programDuration = programDuration; }

    /**
     * sets program intensity (not yet implemented)
     */
    public void setProgramIntensity() {}

    /**
     * sets program grade, based on user input (not yet implemented)
     */
    public void setProgramGrade() {}

    /**
     * return program name
     * @return name of the program, to be shown on programListView
     */
    public String getProgramName() {
        return programName;
    }

    /**
     * gets next workout date (to be displayed in program_workout_list)
     * @return mockNextWorkoutDate (feature not yet implemented)
     */
    public String getNextWorkoutDate() {
        return mockNextWorkoutDate;

    }
    // TODO: Integrate fully with Workout class
}
