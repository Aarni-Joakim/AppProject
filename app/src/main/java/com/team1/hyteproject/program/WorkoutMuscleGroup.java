package com.team1.hyteproject.program;

import android.util.Log;

import com.team1.hyteproject.enums.TargetMuscleGroup;

import java.util.ArrayList;

// Holds lists of different muscle group divisions a program split has. Ex. there could be several different lists for a full body split with different exercise focus
public class WorkoutMuscleGroup {

    private final String TAG = "WorkoutMuscleGroup";
    ArrayList<TargetMuscleGroup> targetMuscleGroupsList;                // HOW MANY DIFFERENT MUSCLE GROUPS ARE TRAINED IN A SINGLE SESSION/WORKOUT
    TargetMuscleGroup targetMuscleGroup;

    public WorkoutMuscleGroup() {
        Log.d(TAG, "Creating SplitMuscleGroup instance.");
    }

    public void setSplitMuscleGroups () {}

    public void setTargetMuscleGroupsList(TargetMuscleGroup targetMuscleGroup) {
        targetMuscleGroupsList = new ArrayList();
        Log.d(TAG, "Adding to targetMuscleGroupsList: " + targetMuscleGroup);
        targetMuscleGroupsList.add(targetMuscleGroup);
    }

    public ArrayList getTargetMuscleGroupList () {
        return targetMuscleGroupsList;
    }

    public TargetMuscleGroup getTargetMuscleGroup(int index) {
        Log.d(TAG, "Returning targetMuscleGroupLists. Is empty:" + targetMuscleGroupsList.isEmpty());
        return targetMuscleGroupsList.get(index);
    }
}
