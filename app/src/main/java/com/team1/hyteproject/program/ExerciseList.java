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
        upperBodyExercises.add(new BaseExercise("Dead Lift", 5, 5, true, TargetMuscleGroup.BACK));
        upperBodyExercises.add(new BaseExercise("Bench Press", 3, 3, true, TargetMuscleGroup.CHEST));
        upperBodyExercises.add(new BaseExercise("Barbell Bicep Curl", 1, 2, false, TargetMuscleGroup.BICEPS));
        upperBodyExercises.add(new BaseExercise("Bodyweight Dip", 2, 3, true, TargetMuscleGroup.TRICEPS));
        lowerBodyExercises.add(new BaseExercise("Barbell Squat", 4, 4, true, TargetMuscleGroup.LEGS));
        lowerBodyExercises.add(new BaseExercise("Standing Calf Raise", 2, 2, false, TargetMuscleGroup.CALVES));
        coreExercises.add(new BaseExercise("Windshield Wiper", 3, 4, false, TargetMuscleGroup.CORE));


    }
    public ArrayList<BaseExercise> getAllUpperBodyExercises() { return upperBodyExercises; }
    public ArrayList<BaseExercise> getAllLowerBodyExercises() { return lowerBodyExercises; }
    public ArrayList<BaseExercise> getAllCoreExercises() { return coreExercises; }

    public void addUpperBodyExercise(String name, int recoveryDays, int exerciseIntensity, boolean isCompound, TargetMuscleGroup targetMuscleGroup) {
        upperBodyExercises.add(new BaseExercise(name, recoveryDays, exerciseIntensity, isCompound, targetMuscleGroup));
    }
    public void addLowerBodyExercise(String name, int recoveryDays, int exerciseIntensity, boolean isCompound, TargetMuscleGroup targetMuscleGroup) {
        lowerBodyExercises.add(new BaseExercise(name, recoveryDays, exerciseIntensity, isCompound, targetMuscleGroup));
    }
    public void addCoreExercise(String name, int recoveryDays, int exerciseIntensity, boolean isCompound, TargetMuscleGroup targetMuscleGroup) {
        coreExercises.add(new BaseExercise(name, recoveryDays, exerciseIntensity, isCompound, targetMuscleGroup));
    }

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
