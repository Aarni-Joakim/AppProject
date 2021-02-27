package com.team1.hyteproject.program;

import android.util.Log;

import java.util.ArrayList;

public class ProgramGenerator {

    private final String TAG = "ProgramGenerator";

    // user input fields
    private String programName;

    private String goal;                        // muscle mass, strength, power building, toning
    private String focus;                       // Adds volume/frequency for selected muscle group. Can be null/none.

    private int age;                            // from user input
    private int desiredIntensity;               // from user input desiredIntensity
    private int experience;                     // 0 = beginner, 1 = intermediate, 2 = advanced
    private int lengthInWeeks;                  // from user input
    private int exercisesPerWeek;               // from user input

    // fields determined based on user input
    private double intensityMultiplier = 1.0;   // calculated from age, experience and desiredIntensity, used to determine program volume
    private String programSplit;                // determined by exercises per week
    private int programVolume;                  // calculated from intensityMultiplier and experience, should only have 4 stages for starters: 0low(iM < 0.75), 1low-med(iM < 1), 2high-med(iM < 1.25), 3high(iM > 1.25)
    private boolean startRampUp = false;        // true if experience = 0

    private ArrayList<BaseExercise> programExercises;

    public ProgramGenerator(String programName, String focus, String goal, int age, int desiredIntensity, int experience, int lengthInWeeks, int exercisesPerWeek) {
        this.programName = programName;
        this.focus = focus;
        this.goal = goal;
        this.age = age;
        this.desiredIntensity = desiredIntensity;
        this.experience = experience;
        if (experience == 0) { startRampUp = true; }
        this.lengthInWeeks = lengthInWeeks;
        this.exercisesPerWeek = exercisesPerWeek;

        Log.d(TAG, "created");

        programVolume = determineProgramVolume();
        programSplit = determineProgramSplit();
    }


    private String determineProgramSplit() {
        if (exercisesPerWeek < 3)
            programSplit = "Full Body";
        else if (exercisesPerWeek < 5)
            programSplit = "Upper/Lower";
        else
            programSplit = "Push/Pull/Legs";

        return programSplit;
    }

    private int determineProgramVolume() {

        if (desiredIntensity < 3)
            intensityMultiplier -= 0.3 / desiredIntensity;
         else if (desiredIntensity > 3)
            intensityMultiplier += (0.15 * (desiredIntensity -3));

        if (experience == 2)
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
            programVolume = 0;
        else if (intensityMultiplier < 1)
            programVolume = 1;
        else if (intensityMultiplier < 1.25)
            programVolume = 2;
        else if (intensityMultiplier > 1.25)
            programVolume = 3;

        Log.d(TAG, "programVolume is " + programVolume);
        return programVolume;
        }

        private void determineProgramExercises() {
            
        }

        public ArrayList<BaseExercise> getProgramExerciseList () { return programExercises; }
    }

