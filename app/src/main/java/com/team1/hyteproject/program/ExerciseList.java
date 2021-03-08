package com.team1.hyteproject.program;

import android.util.Log;

import com.team1.hyteproject.enums.ExerciseGroup;
import com.team1.hyteproject.enums.TargetMuscleGroup;

import java.util.ArrayList;

/**
 * Author Aarni Pesonen
 *
 * Singleton class contains the complete list of exercises
 */

public class ExerciseList {
    private final String TAG = "ExerciseList";
    private static final ExerciseList instance = new ExerciseList();

    private ArrayList<BaseExercise> upperBodyExercises;
    private ArrayList<BaseExercise> lowerBodyExercises;
    private ArrayList<BaseExercise> coreExercises;
    private BaseExercise baseExercise;

    /**
     * return instance of ExerciseList singleton
     * @return
     */
    public static ExerciseList getInstance() { return instance; }

    /**
     * default contructor
     */
    private ExerciseList() {
        Log.d(TAG, "Singleton created.");
        upperBodyExercises = new ArrayList<>();
        lowerBodyExercises = new ArrayList<>();
        coreExercises = new ArrayList<>();
        upperBodyExercises.add(new BaseExercise("Deadlift4", 5, 5, 3, true, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift5", 5, 5, 3,true, TargetMuscleGroup.BICEPS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift6", 5, 5, 3,true, TargetMuscleGroup.TRICEPS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift7", 5, 5, 3,true, TargetMuscleGroup.CALVES, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift8", 5, 5, 3,true, TargetMuscleGroup.DELTS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift9", 5, 5, 3,true, TargetMuscleGroup.HAMSTRINGS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift10", 5, 5, 3,true, TargetMuscleGroup.CHEST, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift11", 5, 5, 3,true, TargetMuscleGroup.GLUTES, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift12", 5, 5, 3,true, TargetMuscleGroup.LOWER_BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift13", 5, 5, 3,false, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift14", 5, 5, 3,false, TargetMuscleGroup.CHEST, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift15", 5, 5, 3,false, TargetMuscleGroup.TRICEPS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift16", 5, 5, 3,false, TargetMuscleGroup.BICEPS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift17", 5, 5, 3,false, TargetMuscleGroup.DELTS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift18", 5, 5, 3,false, TargetMuscleGroup.CALVES, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift19", 5, 5, 3,false, TargetMuscleGroup.CORE, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift20", 5, 5, 3,false, TargetMuscleGroup.LEGS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift21", 5, 5, 3,false, TargetMuscleGroup.HAMSTRINGS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift22", 5, 5, 3,false, TargetMuscleGroup.LOWER_BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift23", 5, 5, 3,false, TargetMuscleGroup.UPPER_BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift24", 5, 5, 3,false, TargetMuscleGroup.QUADS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift25", 5, 5, 3,true, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift26", 5, 5, 3,true, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift27", 5, 5, 3,true, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift28", 5, 5, 3,true, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift29", 5, 5, 3,true, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift30", 5, 5, 3,true, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift31", 5, 5, 3,true, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift32", 5, 5, 3,true, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift33", 5, 5, 3,true, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift34", 5, 5, 3,true, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift2", 5, 5, 3,true, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift3", 5, 5, 3,true, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Bench Press", 3, 3, 3,true, TargetMuscleGroup.CHEST, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Dumbell Chest Fly", 2, 2, 3,false, TargetMuscleGroup.CHEST, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Dumbell Lateral Raise", 1, 1, 3,false, TargetMuscleGroup.DELTS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Barbell Bicep Curl", 1, 2, 3,false, TargetMuscleGroup.BICEPS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Tricep Pushdown", 1, 2, 3,false, TargetMuscleGroup.TRICEPS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Dumbell Bicep Curl", 1, 2, 3,false, TargetMuscleGroup.BICEPS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Bodyweight Dip", 2, 3, 3,true, TargetMuscleGroup.TRICEPS, ExerciseGroup.UPPER_BODY));
        lowerBodyExercises.add(new BaseExercise("Barbell Squat", 4, 4, 3,true, TargetMuscleGroup.LEGS, ExerciseGroup.UPPER_BODY));
        lowerBodyExercises.add(new BaseExercise("Standing Calf Raise", 2, 2, 3,false, TargetMuscleGroup.CALVES, ExerciseGroup.UPPER_BODY));
        coreExercises.add(new BaseExercise("Windshield Wiper", 3, 4, 3,false, TargetMuscleGroup.CORE, ExerciseGroup.UPPER_BODY));


    }

    /**
     * gets list of upper body exercises
     * @return
     */
    public ArrayList<BaseExercise> getAllUpperBodyExercises() { return upperBodyExercises; }

    /**
     * gets list of lower body exercises
     * @return
     */
    public ArrayList<BaseExercise> getAllLowerBodyExercises() { return lowerBodyExercises; }

    /**
     * gets list of core exercises
     * @return
     */
    public ArrayList<BaseExercise> getAllCoreExercises() { return coreExercises; }

    /*public void addUpperBodyExercise(String name, int recoveryDays, int exerciseIntensity, boolean isCompound, TargetMuscleGroup targetMuscleGroup) {
        upperBodyExercises.add(new BaseExercise(name, recoveryDays, exerciseIntensity, isCompound, targetMuscleGroup));
    }
    public void addLowerBodyExercise(String name, int recoveryDays, int exerciseIntensity, boolean isCompound, TargetMuscleGroup targetMuscleGroup) {
        lowerBodyExercises.add(new BaseExercise(name, recoveryDays, exerciseIntensity, isCompound, targetMuscleGroup));
    }
    public void addCoreExercise(String name, int recoveryDays, int exerciseIntensity, boolean isCompound, TargetMuscleGroup targetMuscleGroup) {
        coreExercises.add(new BaseExercise(name, recoveryDays, exerciseIntensity, isCompound, targetMuscleGroup));
    }*/

    /**
     * return upper body exercise at given index
     * @param index
     * @return
     */
    public BaseExercise getUpperBodyExercise(int index) {
        return upperBodyExercises.get(index);
    }

    /**
     * return lower body exercise at given index
     * @param index
     * @return
     */
    public BaseExercise getLowerBodyExercise(int index) {
        return lowerBodyExercises.get(index);
    }

    /**
     * return core exercise at given index
     * @param index
     * @return
     */
    public BaseExercise getCoreExercise(int index) {
        return coreExercises.get(index);
    }

    /*public void addExercise (String name, int recoveryDays, int exerciseIntensity, String isCompound, TargetMuscleGroup targetMuscleGroup) {
        baseExercise = new BaseExercise(name, recoveryDays, exerciseIntensity, getIsCompoundBool(isCompound), targetMuscleGroup);
        Log.d(TAG, "Added " + baseExercise.getName() + " to exercise list.");
        Log.d(TAG, "MuscleGroup: " +baseExercise.getTargetMuscleGroup());
        Log.d(TAG, "Intensity: " +baseExercise.getExerciseIntensity());
        Log.d(TAG, "IsCompound: " +baseExercise.getIsCompound());
        Log.d(TAG, "Priority: " +baseExercise.getPriority());
        Log.d(TAG, "isRecovered:" +baseExercise.getRecovered());

        if (targetMuscleGroup.getExerciseGroup(targetMuscleGroup) == "Upper Body") {
            upperBodyExercises.add(baseExercise);
        } else if (targetMuscleGroup.getExerciseGroup(targetMuscleGroup) == "Lower Body") {
            lowerBodyExercises.add(baseExercise);
        } else if (targetMuscleGroup.getExerciseGroup(targetMuscleGroup) == "Core") {
            coreExercises.add(baseExercise);
        }
    }*/

    /**
     * add an exercise to complete list of exercises
     * sorts exercise in a list based on it's target muscle group
     * @param baseExercise takes in BaseExercise class as parameter
     */
    public void addExercise (BaseExercise baseExercise) {

        this.baseExercise = baseExercise;

        Log.d(TAG, "Added " + baseExercise.getName() + " to exercise list.");
        Log.d(TAG, "MuscleGroup: " +baseExercise.getTargetMuscleGroup());
        Log.d(TAG, "Intensity: " +baseExercise.getExerciseIntensity());
        Log.d(TAG, "IsCompound: " +baseExercise.getIsCompound());
        Log.d(TAG, "Priority: " +baseExercise.getPriority());
        Log.d(TAG, "isRecovered:" +baseExercise.getRecovered());


        if (baseExercise.getTargetMuscleGroup().getExerciseGroupFromObject(baseExercise).toString().equals("Upper_Body")) {
            upperBodyExercises.add(baseExercise);
            Log.d(TAG, "Added to upperBodyExercises");
        } else if (baseExercise.getTargetMuscleGroup().getExerciseGroupFromObject(baseExercise).toString().equals("Lower_Body")) {
            lowerBodyExercises.add(baseExercise);
            Log.d(TAG, "Added to lowerBodyExercises");
        } else if (baseExercise.getTargetMuscleGroup().getExerciseGroupFromObject(baseExercise).toString().equals("Core")) {
            coreExercises.add(baseExercise);
            Log.d(TAG, "Added to coreExercises");
        }
    }

    /**
     * converts a string value to isCompound bool
     * @param isCompoundToBool
     * @return
     */
    public boolean getIsCompoundBool(String isCompoundToBool) {
        boolean isCompound = true;
        if (isCompoundToBool == "Isolation") {
            isCompound = false;
        }
        return isCompound;
    }
}
