package com.team1.hyteproject.program;

import android.util.Log;

import com.team1.hyteproject.enums.TargetMuscleGroup;

import java.util.ArrayList;

/**
 * Author Aarni Pesonen
 * Holds lists of different muscle group divisions a program split has. Ex. there could be several different lists for a full body split with different exercise focus
 * SplitInfo holds a list containing all different muscle group compositions of a program, WorkoutMuscleGroup defines what muscle groups are included in aforementioned compositions
 */
// Holds lists of different muscle group divisions a program split has. Ex. there could be several different lists for a full body split with different exercise focus
public class WorkoutMuscleGroup {

    private final String TAG = "WorkoutMuscleGroup";
    ArrayList<TargetMuscleGroup> targetMuscleGroupsList;                // HOW MANY DIFFERENT MUSCLE GROUPS ARE TRAINED IN A SINGLE SESSION/WORKOUT
    TargetMuscleGroup targetMuscleGroup;

    /**
     * default constructor
     */
    public WorkoutMuscleGroup() {
        Log.d(TAG, "Creating SplitMuscleGroup instance.");
    }

    /**
     * not yet implemented
     */
    public void setSplitMuscleGroups () {}

    /**
     * called from SplitInfo class, takes in TargetMuscleGroup enum as parameter and adds it to a list
     * this list holds info which muscle groups are trained in a single workout sessio
     * @param targetMuscleGroup
     */
    public void setTargetMuscleGroupsList(TargetMuscleGroup targetMuscleGroup) {
        targetMuscleGroupsList = new ArrayList();
        Log.d(TAG, "Adding to targetMuscleGroupsList: " + targetMuscleGroup);
        targetMuscleGroupsList.add(targetMuscleGroup);
    }

    /**
     * returns a list of muscle groups to be trained in a single session
     * @return
     */
    public ArrayList getTargetMuscleGroupList () {
        return targetMuscleGroupsList;
    }

    /**
     * returns an element from workout specific muscle groups list at given index
     * program generator uses this data inside one of it's loops to pick exercises for this specific group
     * @param index
     * @return
     */
    public TargetMuscleGroup getTargetMuscleGroup(int index) {
        Log.d(TAG, "Returning targetMuscleGroupLists. Is empty:" + targetMuscleGroupsList.isEmpty());
        return targetMuscleGroupsList.get(index);
    }
}
