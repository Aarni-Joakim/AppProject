package com.team1.hyteproject.program;

import java.util.ArrayList;

/**
 *Authot Aarni Pesonen
 */
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

    /**
     * constructor
     * @param programName
     */
    public Program(String programName) {
        this.programName = programName;
        workouts = new ArrayList<>();
    }

    /**
     * returns list of all workouts included in program
     * @return
     */
    public ArrayList<Workout> getWorkoutList() { return workouts; }

    /**
     * gets specific workouts from workouts list based on index value
     * @param index
     * @return
     */
    public Workout getWorkout(int index) { return workouts.get(index); }

    /**
     * returns a specific element of programExercises list based on given index (list includes all exercises in a program)
     * @param index
     * @return
     */
    public BaseExercise getProgramExercise (int index) { return programExercises.get(index); }

    /**
     * adds a workout object to complete list of program workouts
     * @param workout
     */
    public void addWorkout(Workout workout) { workouts.add(workout); } // input parameters!

    /**
     * removes an element from workouts list based on index
     * (to be inserted in workout history list, not yet implemented)
     * @param index
     */
    public void removeWorkout(int index) { workouts.remove(index); }

    /**
     * set program name, user input
     * @param name
     */
    public void setProgramName(String name) { this.programName = name; }

    /**
     * sets program types based on user input goal
     * @param programType
     */
    public void setProgramType(String programType) { this.programType = programType; }

    /**
     * set program creation date
     * @param creationDate
     */
    public void setCreationDate(long creationDate) { this.creationDate = creationDate; }

    /**
     * set program duration in weeks
     * @param programDuration
     */
    public void setProgramDuration(int programDuration) { this.programDuration = programDuration; }

    /**
     * sets program intensity (not fully implemented)
     */
    public void setProgramIntensity() {}

    /**
     * sets program grade, based on user input (not yet implemented)
     */
    public void setProgramGrade() {}

    /**
     * return program name
     * @return
     */
    public String getProgramName() {
        return programName;
    }

    /**
     * gets next workout date (to be displayed in program_workout_list)
     * @return
     */
    public String getNextWorkoutDate() {
        return mockNextWorkoutDate;
    }

    // TODO: Integrate fully with Workout class
}
