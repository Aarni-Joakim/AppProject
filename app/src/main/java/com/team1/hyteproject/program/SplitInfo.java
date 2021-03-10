package com.team1.hyteproject.program;

import android.util.Log;

import com.team1.hyteproject.enums.Split;
import com.team1.hyteproject.enums.TargetMuscleGroup;

import java.util.ArrayList;

// Holds information ABOUT each different workout split
// Check the function of this class
// This class needs to be instantiated before MEGALOOPS? edit. SHOULD NOT MAKE DIFFERENCE?

/**
 * @Author Aarni Pesonen
 * Program split info and muscle groups contained in each split are defined here
 * By isolating split specific info to it's own class it is possible to create variance between exercise compositions
 * ex. in a full-body split, each included major muscle group is trained in every session, but specific exercise content variance could be defined here
 * works in conjunction with WorkoutMuscleGroup class, storing instances of said class in a list to define what muscle groups are trained in a given workout
 */
public class SplitInfo {

    private final String TAG = "SplitInfo";
    ArrayList<WorkoutMuscleGroup> workoutMuscleGroups;                  //HOLDS INFO OF MUSCLE GROUPS TO BE TRAINED IN A SINGLE WORKOUT SESSION. CREATE AS MANY OBJECTS OF SplitMuscleGroup AS THERE ARE UNIQUE WORKOUT DAYS IN A PROGRAM.
    WorkoutMuscleGroup workoutMuscleGroup;
    Split split;
    int workoutsPerWeek;

    /**
     * contructor takes in Split enum value and workouts per week to determine muscle groups of individual workouts included in program based on split
     * @param split of the program
     * @param workoutsPerWeek how many workouts per week are performed in the program
     */
    public SplitInfo(Split split, int workoutsPerWeek) {
        Log.d(TAG, "Creating SplitInfo instance.");
        this.split = split;
        this.workoutsPerWeek = workoutsPerWeek;
        setWorkoutMuscleGroups(split);
    }

    /**
     * finds all muscle groups to be worked in a single session based on program split
     * feature has not been fully developed
     * different workout session splits are stored inside workoutMuscleGroups list as WorkoutMuscleGroup objects
     * in this first iteration workout muscle groups are not dynamically defined, but instead set static based on split value
     * @param split parameter used to determine what muscle groups are trained in a workout
     */
    public void setWorkoutMuscleGroups(Split split) {
        if (split.equals(Split.FULL_BODY)) {
            workoutMuscleGroups = new ArrayList<>();
            workoutMuscleGroup = new WorkoutMuscleGroup();
            Log.d(TAG, "Start adding to muscleGroupList");
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.BACK);
            Log.d(TAG, "Added back to muscleGroupList");
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.BICEPS);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.CHEST);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.DELTS);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.LEGS);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.TRICEPS);

            workoutMuscleGroups.add(workoutMuscleGroup);
            Log.d(TAG, "Finished adding to muscleGroupList");
            Log.d(TAG, "Adding muscle groups to splitMuscleGroups<TargetMuscleGroup>");
            if (workoutsPerWeek == 2) {
                workoutMuscleGroups.add(workoutMuscleGroup);        // implement additional muscle group divisions
            }
        }
        else if (split.equals(Split.UPPER_LOWER)) {
            workoutMuscleGroups = new ArrayList<>();
            workoutMuscleGroup = new WorkoutMuscleGroup();

            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.LEGS);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.QUADS);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.CALVES);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.HAMSTRINGS);
            workoutMuscleGroups.add(workoutMuscleGroup);

            workoutMuscleGroup = new WorkoutMuscleGroup();

            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.BACK);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.BICEPS);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.CHEST);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.TRICEPS);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.DELTS);

            workoutMuscleGroups.add(workoutMuscleGroup);
            workoutMuscleGroups.add(workoutMuscleGroup);            // implement additional muscle group divisions

            if (workoutsPerWeek == 4) {
                workoutMuscleGroups.add(workoutMuscleGroup);        // implement additional muscle group divisions
            }
        }
        else if (split.equals(Split.PPL)) {
            workoutMuscleGroups = new ArrayList<>();
            workoutMuscleGroup = new WorkoutMuscleGroup();

            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.LEGS);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.QUADS);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.CALVES);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.HAMSTRINGS);
            workoutMuscleGroups.add(workoutMuscleGroup);

            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.CHEST);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.BICEPS);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.TRICEPS);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.DELTS);
            workoutMuscleGroups.add(workoutMuscleGroup);

            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.BACK);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.UPPER_BACK);
            workoutMuscleGroup.setTargetMuscleGroupsList(TargetMuscleGroup.LOWER_BACK);
            workoutMuscleGroups.add(workoutMuscleGroup);
            workoutMuscleGroups.add(workoutMuscleGroup);
            workoutMuscleGroups.add(workoutMuscleGroup);

            if (workoutsPerWeek == 6) {
                workoutMuscleGroups.add(workoutMuscleGroup);        // implement additional muscle group divisions
            }
        }
    }

    /**
     * not yet implemented, could be used to set different muscle group compositions included in a program split
     * @param workoutMuscleGroups class could a list of muscle groups to be trained in a single session, instead of them being
     *                            just added in manually as above
     */
    public void setWorkoutMuscleGroupsList(ArrayList<WorkoutMuscleGroup> workoutMuscleGroups) {
        this.workoutMuscleGroups = workoutMuscleGroups;
        Log.d(TAG, "Setting SplitMuscleGroupsList" + workoutMuscleGroups);
    }

    /**
     * returns the list of all different muscle group compositions included in a program split
     * used in program generation
     * @return list of workouts to be trained in a single workout session
     */
    public ArrayList<WorkoutMuscleGroup> getWorkoutMuscleGroupsList() {
        return workoutMuscleGroups;
    }
}
