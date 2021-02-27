package com.team1.hyteproject.program;

import java.util.ArrayList;

public class ExerciseList {
    private static final ExerciseList instance = new ExerciseList();

    private ArrayList<BaseExercise> upperBodyExercises;
    private ArrayList<BaseExercise> lowerBodyExercises;
    private ArrayList<BaseExercise> coreExercises;


    public static ExerciseList getInstance() { return instance; }

    private ExerciseList() {


    }
    public ArrayList<BaseExercise> getUpperBodyExercises() { return upperBodyExercises; }
    public ArrayList<BaseExercise> getLowerBodyExercises() { return lowerBodyExercises; }
    public ArrayList<BaseExercise> getCoreExercises() { return coreExercises; }

    public void addUpperBodyExercise(String name, int recoveryDays, int exerciseIntensity) {
        upperBodyExercises.add(new BaseExercise(name, recoveryDays, exerciseIntensity));
    }
    public void addLowerBodyExercise(String name, int recoveryDays, int exerciseIntensity) {
        upperBodyExercises.add(new BaseExercise(name, recoveryDays, exerciseIntensity));
    }
    public void addCoreExercise(String name, int recoveryDays, int exerciseIntensity) {
        upperBodyExercises.add(new BaseExercise(name, recoveryDays, exerciseIntensity));
    }

}
