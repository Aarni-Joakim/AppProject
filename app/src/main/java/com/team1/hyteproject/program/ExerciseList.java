package com.team1.hyteproject.program;

import android.util.Log;

import com.team1.hyteproject.enums.TargetMuscleGroup;

import java.util.ArrayList;

public class ExerciseList {
    private final String TAG = "ExerciseList";
    private static final ExerciseList instance = new ExerciseList();

    private ArrayList<BaseExercise> upperBodyExercises;
    private ArrayList<BaseExercise> lowerBodyExercises;
    private ArrayList<BaseExercise> coreExercises;


    public static ExerciseList getInstance() { return instance; }

    private ExerciseList() {
        Log.d(TAG, "Singleton created.");
        upperBodyExercises = new ArrayList<>();
        lowerBodyExercises = new ArrayList<>();
        coreExercises = new ArrayList<>();
        upperBodyExercises.add(new BaseExercise("Deadlift4", 5, 5, true, TargetMuscleGroup.BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift5", 5, 5, true, TargetMuscleGroup.BICEPS));
        upperBodyExercises.add(new BaseExercise("Deadlift6", 5, 5, true, TargetMuscleGroup.TRICEPS));
        upperBodyExercises.add(new BaseExercise("Deadlift7", 5, 5, true, TargetMuscleGroup.CALVES));
        upperBodyExercises.add(new BaseExercise("Deadlift8", 5, 5, true, TargetMuscleGroup.DELTS));
        upperBodyExercises.add(new BaseExercise("Deadlift9", 5, 5, true, TargetMuscleGroup.HAMS));
        upperBodyExercises.add(new BaseExercise("Deadlift10", 5, 5, true, TargetMuscleGroup.CHEST));
        upperBodyExercises.add(new BaseExercise("Deadlift11", 5, 5, true, TargetMuscleGroup.GLUTES));
        upperBodyExercises.add(new BaseExercise("Deadlift12", 5, 5, true, TargetMuscleGroup.LOWER_BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift13", 5, 5, false, TargetMuscleGroup.BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift14", 5, 5, false, TargetMuscleGroup.CHEST));
        upperBodyExercises.add(new BaseExercise("Deadlift15", 5, 5, false, TargetMuscleGroup.TRICEPS));
        upperBodyExercises.add(new BaseExercise("Deadlift16", 5, 5, false, TargetMuscleGroup.BICEPS));
        upperBodyExercises.add(new BaseExercise("Deadlift17", 5, 5, false, TargetMuscleGroup.DELTS));
        upperBodyExercises.add(new BaseExercise("Deadlift18", 5, 5, false, TargetMuscleGroup.CALVES));
        upperBodyExercises.add(new BaseExercise("Deadlift19", 5, 5, false, TargetMuscleGroup.CORE));
        upperBodyExercises.add(new BaseExercise("Deadlift20", 5, 5, false, TargetMuscleGroup.LEGS));
        upperBodyExercises.add(new BaseExercise("Deadlift21", 5, 5, false, TargetMuscleGroup.HAMS));
        upperBodyExercises.add(new BaseExercise("Deadlift22", 5, 5, false, TargetMuscleGroup.LOWER_BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift23", 5, 5, false, TargetMuscleGroup.UPPER_BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift24", 5, 5, false, TargetMuscleGroup.QUADS));
        upperBodyExercises.add(new BaseExercise("Deadlift25", 5, 5, true, TargetMuscleGroup.BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift26", 5, 5, true, TargetMuscleGroup.BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift27", 5, 5, true, TargetMuscleGroup.BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift28", 5, 5, true, TargetMuscleGroup.BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift29", 5, 5, true, TargetMuscleGroup.BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift30", 5, 5, true, TargetMuscleGroup.BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift31", 5, 5, true, TargetMuscleGroup.BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift32", 5, 5, true, TargetMuscleGroup.BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift33", 5, 5, true, TargetMuscleGroup.BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift34", 5, 5, true, TargetMuscleGroup.BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift2", 5, 5, true, TargetMuscleGroup.BACK));
        upperBodyExercises.add(new BaseExercise("Deadlift3", 5, 5, true, TargetMuscleGroup.BACK));
        upperBodyExercises.add(new BaseExercise("Bench Press", 3, 3, true, TargetMuscleGroup.CHEST));
        upperBodyExercises.add(new BaseExercise("Dumbell Chest Fly", 2, 2, false, TargetMuscleGroup.CHEST));
        upperBodyExercises.add(new BaseExercise("Dumbell Lateral Raise", 1, 1, false, TargetMuscleGroup.DELTS));
        upperBodyExercises.add(new BaseExercise("Barbell Bicep Curl", 1, 2, false, TargetMuscleGroup.BICEPS));
        upperBodyExercises.add(new BaseExercise("Tricep Pushdown", 1, 2, false, TargetMuscleGroup.TRICEPS));
        upperBodyExercises.add(new BaseExercise("Dumbell Bicep Curl", 1, 2, false, TargetMuscleGroup.BICEPS));
        upperBodyExercises.add(new BaseExercise("Bodyweight Dip", 2, 3, true, TargetMuscleGroup.TRICEPS));
        lowerBodyExercises.add(new BaseExercise("Barbell Squat", 4, 4, true, TargetMuscleGroup.LEGS));
        lowerBodyExercises.add(new BaseExercise("Standing Calf Raise", 2, 2, false, TargetMuscleGroup.CALVES));
        coreExercises.add(new BaseExercise("Windshield Wiper", 3, 4, false, TargetMuscleGroup.CORE));


    }
    public ArrayList<BaseExercise> getAllUpperBodyExercises() { return upperBodyExercises; }
    public ArrayList<BaseExercise> getAllLowerBodyExercises() { return lowerBodyExercises; }
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

    public BaseExercise getUpperBodyExercise(int index) {
        return upperBodyExercises.get(index);
    }
    public BaseExercise getLowerBodyExercise(int index) {
        return lowerBodyExercises.get(index);
    }
    public BaseExercise getCoreExercise(int index) {
        return coreExercises.get(index);
    }

}
