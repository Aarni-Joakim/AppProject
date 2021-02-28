package com.team1.hyteproject.program;

import android.util.Log;

import com.team1.hyteproject.enums.Experience;
import com.team1.hyteproject.enums.Focus;
import com.team1.hyteproject.enums.Goal;
import com.team1.hyteproject.enums.ProgramVolume;
import com.team1.hyteproject.enums.Split;

import java.util.ArrayList;

public class ProgramGenerator {

    private final String TAG = "ProgramGenerator";

    // user input fields
    private String programName;

    private Goal goal;                        // muscle mass, strength, power building, toning
    private Focus focus;                       // Adds volume/frequency for selected muscle group. Can be null/none.
    private Experience experience;              // replaced int with enum

    private int age;                            // from user input
    private int desiredIntensity;               // from user input desiredIntensity
    private int lengthInWeeks;                  // from user input
    private int exercisesPerWeek;               // from user input

    // fields determined based on user input
    private double intensityMultiplier = 1.0;   // calculated from age, experience and desiredIntensity, used to determine program volume
    private Split split;                        // determined by exercises per week
    private ProgramVolume programVolume;        // replaced int with enum: LOW(iM < 0.75), LOW-MED(iM < 1), HIGH-MED(iM < 1.25), HIGH(iM > 1.25)
    private boolean startRampUp = false;        // true if experience = 0

    //fields determined based on programSplit and goal
    private int numberOfCompoundExercises;
    private int numberOfIsolationExercises;

    private int index;
    private int exerciseIndex;                  // used to set exercise priorities

    private ArrayList<BaseExercise> programExercises;
    private BaseExercise baseExercise;

    //TODO: Correct compound/isolation exercise amounts for each split

    public ProgramGenerator(String programName, Focus focus, Goal goal, int age, int desiredIntensity, Experience experience, int lengthInWeeks, int exercisesPerWeek) {
        this.programName = programName;
        this.focus = focus;
        this.goal = goal;
        this.age = age;
        this.desiredIntensity = desiredIntensity;
        this.experience = experience;
        if (experience == Experience.BEGINNER)
            startRampUp = true;
        this.lengthInWeeks = lengthInWeeks;
        this.exercisesPerWeek = exercisesPerWeek;

        programExercises = new ArrayList<>();

        Log.d(TAG, "Program generation started.");

        programVolume = getProgramVolume();
        split = getSplit();

        Log.d(TAG, programVolume + " " + split);

        getExerciseDistribution();
        getCompoundExercises();
        resetIsSelected();
        getIsolationExercises();
        resetIsSelected();
    }


    private Split getSplit() {
        Log.d(TAG, "getSplit() called.");

        if (exercisesPerWeek < 3)
            split = Split.FULL_BODY;
        else if (exercisesPerWeek < 5)
            split = Split.UPPER_LOWER;
        else
            split = Split.PPL;

        return split;
    }

    private ProgramVolume getProgramVolume() {
        Log.d(TAG, "getProgramVolume() called.");

        if (desiredIntensity < 3)
            intensityMultiplier -= 0.3 / desiredIntensity;
        else if (desiredIntensity > 3)
            intensityMultiplier += (0.15 * (desiredIntensity - 3));

        if (experience == Experience.ADVANCED)
            intensityMultiplier *= 1.2;

        if (age > 17)
            intensityMultiplier *= 0.8;
        else if (age > 35 && age < 41)
            intensityMultiplier *= 0.9;
        else if (age > 40 && age < 51)
            intensityMultiplier *= 0.8;
        else if (age > 50 && age < 61)
            intensityMultiplier *= 0.6;

        if (intensityMultiplier < 0.75)
            programVolume = ProgramVolume.LOW;
        else if (intensityMultiplier < 1)
            programVolume = ProgramVolume.MED_LOW;
        else if (intensityMultiplier < 1.25)
            programVolume = ProgramVolume.MED_HIGH;
        else if (intensityMultiplier > 1.25)
            programVolume = ProgramVolume.HIGH;

        Log.d(TAG, "programVolume is " + programVolume);
        return programVolume;
    }

    private void getExerciseDistribution() {
        Log.d(TAG, "getExerciseDistribution() called.");

        switch (split) {
            case FULL_BODY: {
                Log.d(TAG, "Picking full body split exercises.");

                if (goal == Goal.MUSCLE) {
                    numberOfCompoundExercises = 3;
                    numberOfIsolationExercises = 4;
                } else if (goal == Goal.STRENGTH) {
                    numberOfCompoundExercises = 4;
                    numberOfIsolationExercises = 2;
                } else if (goal == Goal.POWER_BUILDING) {
                    numberOfCompoundExercises = 3;
                    numberOfIsolationExercises = 3;
                } else {
                    numberOfCompoundExercises = 1;
                    numberOfIsolationExercises = 4;
                }

                break;
            }
            case UPPER_LOWER: {
                Log.d(TAG, "Picking upper/lower split exercises.");

                if (goal == Goal.MUSCLE) {
                    numberOfCompoundExercises = 3;
                    numberOfIsolationExercises = 4;
                } else if (goal == Goal.STRENGTH) {
                    numberOfCompoundExercises = 4;
                    numberOfIsolationExercises = 2;
                } else if (goal == Goal.POWER_BUILDING) {
                    numberOfCompoundExercises = 3;
                    numberOfIsolationExercises = 3;
                } else {
                    numberOfCompoundExercises = 1;
                    numberOfIsolationExercises = 4;
                }

                break;
            }

            case PPL: {
                Log.d(TAG, "Picking PPL split exercises");

                if (goal == Goal.MUSCLE) {
                    numberOfCompoundExercises = 3;
                    numberOfIsolationExercises = 4;
                } else if (goal == Goal.STRENGTH) {
                    numberOfCompoundExercises = 4;
                    numberOfIsolationExercises = 2;
                } else if (goal == Goal.POWER_BUILDING) {
                    numberOfCompoundExercises = 3;
                    numberOfIsolationExercises = 3;
                } else {
                    numberOfCompoundExercises = 1;
                    numberOfIsolationExercises = 4;
                }

                break;
            }

            default: {
                Log.d(TAG, "Something went wrong. Check split code.");
            }
        }
    }

    private void getExercisesPerMuscleGroup() {
        // TODO:
    }

        /*private void getProgramExercises2() {


            Log.d(TAG, "determineProgramExercises() called");

            for (index = 0; index < ExerciseList.getInstance().getAllUpperBodyExercises().size(); index++)
                Log.d(TAG, ExerciseList.getInstance().getUpperBodyExercise(index).getName());
                baseExercise = ExerciseList.getInstance().stream();

            programExercises.set(index, baseExercise);
            //programExercises.add(ExerciseList.getInstance().getAllUpperBodyExercises().get(index));
            Log.d(TAG, programExercises.get(index).getName());

        }*/

    /*private void getProgramExercises() {


        Log.d(TAG, "getProgramExercises2() called");
        Log.d(TAG, "Compound Exercises: " + numberOfCompoundExercises + ". Isolation exercises: " +numberOfIsolationExercises);


        baseExercise = ExerciseList.getInstance().getAllUpperBodyExercises().stream().filter(BaseExercise -> BaseExercise.getPriority() == 3 && !BaseExercise.getIsCompound() && !BaseExercise.getIsSelected()).findFirst().get();
        exerciseIndex = ExerciseList.getInstance().getAllUpperBodyExercises().indexOf(baseExercise);
        if (baseExercise != null)
            programExercises.add(baseExercise);

        ExerciseList.getInstance().getUpperBodyExercise(exerciseIndex).setIsSelected(true);
        Log.d(TAG, "Priority of " +ExerciseList.getInstance().getUpperBodyExercise(exerciseIndex).getName() + " set to: " + ExerciseList.getInstance().getUpperBodyExercise(exerciseIndex).getPriority());
        Log.d(TAG, programExercises.get(index).getName());

        baseExercise = ExerciseList.getInstance().getAllUpperBodyExercises().stream().filter(BaseExercise -> BaseExercise.getPriority() == 3 && BaseExercise.getIsCompound() && !BaseExercise.getIsSelected()).findFirst().get();
        exerciseIndex = ExerciseList.getInstance().getAllUpperBodyExercises().indexOf(baseExercise);
        if (baseExercise != null)
            programExercises.add(baseExercise);

        ExerciseList.getInstance().getUpperBodyExercise(exerciseIndex).setIsSelected(true);
        Log.d(TAG, "Priority of " +ExerciseList.getInstance().getUpperBodyExercise(exerciseIndex).getName() + " set to: " + ExerciseList.getInstance().getUpperBodyExercise(exerciseIndex).getPriority());
        Log.d(TAG, programExercises.get(index+1).getName());

    }*/

    private void getCompoundExercises() {


        Log.d(TAG, "getCompoundExercises() called");
        Log.d(TAG, "Compound Exercises: " + numberOfCompoundExercises + ".");

        for (int index = 0; index < numberOfCompoundExercises; index++) {
            baseExercise = ExerciseList.getInstance().getAllUpperBodyExercises().stream().filter(BaseExercise -> BaseExercise.getPriority() == 3 && BaseExercise.getIsCompound() && !BaseExercise.getIsSelected()).findFirst().get();
            exerciseIndex = ExerciseList.getInstance().getAllUpperBodyExercises().indexOf(baseExercise);
            if (baseExercise != null)
                programExercises.add(baseExercise);

            ExerciseList.getInstance().getUpperBodyExercise(exerciseIndex).setIsSelected(true);
            Log.d(TAG, "Priority of " + ExerciseList.getInstance().getUpperBodyExercise(exerciseIndex).getName() + " set to: " + ExerciseList.getInstance().getUpperBodyExercise(exerciseIndex).getPriority());
            Log.d(TAG, programExercises.get(index).getName());
        }
    }

        private void getIsolationExercises () {

            //TODO: Optional isPresent check

            Log.d(TAG, "getIsolationExercises() called");
            Log.d(TAG, "Compound Exercises: " + numberOfIsolationExercises + ".");

            for (int index = 0; index < numberOfIsolationExercises; index++) {
                baseExercise = ExerciseList.getInstance().getAllUpperBodyExercises().stream().filter(BaseExercise -> BaseExercise.getPriority() == 3 && !BaseExercise.getIsCompound() && !BaseExercise.getIsSelected()).findFirst().get();
                exerciseIndex = ExerciseList.getInstance().getAllUpperBodyExercises().indexOf(baseExercise);
                if (baseExercise != null)
                    programExercises.add(baseExercise);

                ExerciseList.getInstance().getUpperBodyExercise(exerciseIndex).setIsSelected(true);
                Log.d(TAG, "Priority of " + ExerciseList.getInstance().getUpperBodyExercise(exerciseIndex).getName() + " set to: " + ExerciseList.getInstance().getUpperBodyExercise(exerciseIndex).getPriority());
                Log.d(TAG, programExercises.get(index).getName());
            }

        }
        public ArrayList<BaseExercise> getProgramExerciseList () {
            Log.d(TAG, "getProgramExerciseList called");

            return programExercises;
        }

        private void resetIsSelected () {
            for (int index = 0; index < ExerciseList.getInstance().getAllUpperBodyExercises().size(); index++) {
                ExerciseList.getInstance().getUpperBodyExercise(index).setIsSelected(false);
            }
        }

        private void setExercisePriorities() {
        // TODO: Based on goals, focus, split etc
        }

        private void getWorkoutDates() {
        // TODO: Need calendar arrays or get dates directly from calendar?
        }

        private void getWorkoutExercises() {
        // TODO: Put exercises in each daily workout-list
        }
    }
