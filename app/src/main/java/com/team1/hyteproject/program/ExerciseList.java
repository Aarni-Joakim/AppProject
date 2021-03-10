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
     * @return instance
     */
    public static ExerciseList getInstance() { return instance; }

    /**
     * default contructor
     * currently simulates loading data from a web server
     */
    private ExerciseList() {
        Log.d(TAG, "Singleton created.");
        upperBodyExercises = new ArrayList<>();
        lowerBodyExercises = new ArrayList<>();
        coreExercises = new ArrayList<>();
        upperBodyExercises.add(new BaseExercise("Lateral Pulldown", 5, 5, 3, true, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Standing Bicep Curl", 5, 5, 3,true, TargetMuscleGroup.BICEPS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Cable Tricep Pushdown", 5, 5, 3,true, TargetMuscleGroup.TRICEPS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Calf raise", 5, 5, 3,true, TargetMuscleGroup.CALVES, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Dumbbell Raise", 5, 5, 3,true, TargetMuscleGroup.DELTS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Deadlift", 5, 5, 3,true, TargetMuscleGroup.HAMSTRINGS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Bench Press", 5, 5, 3,true, TargetMuscleGroup.CHEST, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Sumo Squat", 5, 5, 3,true, TargetMuscleGroup.GLUTES, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Pelvic Tilt", 5, 5, 3,true, TargetMuscleGroup.LOWER_BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Inverted Row", 5, 5, 3,false, TargetMuscleGroup.BACK, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Bench Dip", 5, 5, 3,false, TargetMuscleGroup.TRICEPS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Zottman Curl", 5, 5, 3,false, TargetMuscleGroup.BICEPS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Rear Delt Fly", 5, 5, 3,false, TargetMuscleGroup.DELTS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Seated Calf Raise", 5, 5, 3,false, TargetMuscleGroup.CALVES, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Bench Press", 3, 3, 3,true, TargetMuscleGroup.CHEST, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Dumbbell Chest Fly", 2, 2, 3,false, TargetMuscleGroup.CHEST, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Lateral Raise", 1, 1, 3,false, TargetMuscleGroup.DELTS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Barbell Bicep Curl", 1, 2, 3,false, TargetMuscleGroup.BICEPS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Tricep Pushdown", 1, 2, 3,false, TargetMuscleGroup.TRICEPS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Dumbbell Bicep Curl", 1, 2, 3,false, TargetMuscleGroup.BICEPS, ExerciseGroup.UPPER_BODY));
        upperBodyExercises.add(new BaseExercise("Bodyweight Dip", 2, 3, 3,true, TargetMuscleGroup.TRICEPS, ExerciseGroup.UPPER_BODY));
        lowerBodyExercises.add(new BaseExercise("Barbell Squat", 4, 4, 3,true, TargetMuscleGroup.LEGS, ExerciseGroup.UPPER_BODY));
        lowerBodyExercises.add(new BaseExercise("Standing Calf Raise", 2, 2, 3,false, TargetMuscleGroup.CALVES, ExerciseGroup.UPPER_BODY));
        coreExercises.add(new BaseExercise("Windshield Wiper", 3, 4, 3,false, TargetMuscleGroup.CORE, ExerciseGroup.UPPER_BODY));


    }

    /**
     * gets list of upper body exercises
     * @return upper body exercises list
     */
    public ArrayList<BaseExercise> getAllUpperBodyExercises() { return upperBodyExercises; }

    /**
     * gets list of lower body exercises
     * @return lower body exercises list
     */
    public ArrayList<BaseExercise> getAllLowerBodyExercises() { return lowerBodyExercises; }

    /**
     * gets list of core exercises
     * @return core exercises list
     */
    public ArrayList<BaseExercise> getAllCoreExercises() { return coreExercises; }

    /**
     * return upper body exercise at given index
     * @param index of exercise to return
     * @return exercise at given index
     */
    public BaseExercise getUpperBodyExercise(int index) {
        return upperBodyExercises.get(index);
    }

    /**
     * return lower body exercise at given index
     * @param index of exercise to return
     * @return exercise at given index
     */
    public BaseExercise getLowerBodyExercise(int index) {
        return lowerBodyExercises.get(index);
    }

    /**
     * return core exercise at given index
     * @param index of exercise to return
     * @return exercise at given index
     */
    public BaseExercise getCoreExercise(int index) {
        return coreExercises.get(index);
    }

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
     * @param isCompoundToBool string to be converted to bool
     * @return true or false depending on input string value
     */
    public boolean getIsCompoundBool(String isCompoundToBool) {
        boolean isCompound = true;
        if (isCompoundToBool == "Isolation") {
            isCompound = false;
        }
        return isCompound;
    }
}
