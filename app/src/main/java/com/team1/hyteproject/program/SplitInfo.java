package com.team1.hyteproject.program;

import android.util.Log;

import com.team1.hyteproject.enums.Split;
import com.team1.hyteproject.enums.TargetMuscleGroup;

import java.util.ArrayList;

// Holds information ABOUT each different workout split
// Check the function of this class
// This class needs to be instantiated before MEGALOOPS? edit. SHOULD NOT MAKE DIFFERENCE?

public class SplitInfo {

    private final String TAG = "SplitInfo";
    ArrayList<WorkoutMuscleGroup> workoutMuscleGroups;                  //HOLDS INFO OF MUSCLE GROUPS TO BE TRAINED IN A SINGLE WORKOUT SESSION. CREATE AS MANY OBJECTS OF SplitMuscleGroup AS THERE ARE UNIQUE WORKOUT DAYS IN A PROGRAM.
    WorkoutMuscleGroup workoutMuscleGroup;
    Split split;
    int workoutsPerWeek;

    public SplitInfo(Split split, int workoutsPerWeek) {
        Log.d(TAG, "Creating SplitInfo instance.");
        this.split = split;
        this.workoutsPerWeek = workoutsPerWeek;
        setWorkoutMuscleGroups(split);
    }

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
                workoutMuscleGroups.add(workoutMuscleGroup);        // this is to counter index out of bounds
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
            workoutMuscleGroups.add(workoutMuscleGroup);            // TESTING FUNCTIONALITY

            if (workoutsPerWeek == 4) {
                workoutMuscleGroups.add(workoutMuscleGroup);        // this is to counter index out of bounds
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
                workoutMuscleGroups.add(workoutMuscleGroup);        // this is to counter index out of bounds
            }
        }
    }

    public void setWorkoutMuscleGroupsList(ArrayList<WorkoutMuscleGroup> workoutMuscleGroups) {
        this.workoutMuscleGroups = workoutMuscleGroups;
        Log.d(TAG, "Setting SplitMuscleGroupsList" + workoutMuscleGroups);
    }

    public ArrayList<WorkoutMuscleGroup> getWorkoutMuscleGroupsList() {
        return workoutMuscleGroups;
    }
}