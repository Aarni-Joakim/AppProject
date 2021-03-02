package com.team1.hyteproject.program;

import android.util.Log;

import com.team1.hyteproject.enums.Goal;
import com.team1.hyteproject.enums.ProgramVolume;
import com.team1.hyteproject.enums.Split;
import com.team1.hyteproject.ui.SaveLoad;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ProgramGenerator {

    private final String TAG = "ProgramGenerator";

    private ArrayList<BaseExercise> programExercises;
    private BaseExercise baseExercise;
    private SaveLoad saveLoad;
    // user input fields

    private Date programStartDate;              // user input calendar pop up
    private String programName;
    private String goal;                        // muscle mass, strength, power building, toning
    private String focus;                       // Adds volume/frequency for selected muscle group. Can be null/none.
    private String experience;                  // from enum toString()
    private int desiredIntensity;               // from user input desiredIntensity
    private int lengthInWeeks;                  // from user input
    private int workoutsPerWeek;               // from user input
    private int exerciseInProgram;              // total amount of exercises in program
    private boolean evenlySpacedRecovery = true;

    // from profile
    private int age;                            // from user input

    // fields determined based on user input
    private Split split;                        // determined by exercises per week
    private ProgramVolume programVolume;        // replaced int with enum: LOW(iM < 0.75), LOW-MED(iM < 1), HIGH-MED(iM < 1.25), HIGH(iM > 1.25)
    private double intensityMultiplier = 1.0;   // calculated from age, experience and desiredIntensity, used to determine program volume (later also frequency)
    private boolean startRampUp = false;        // true if experience = 0

    //fields determined based on programSplit and goal
    private int numberOfCompoundExercises;
    private int numberOfIsolationExercises;
    private int workoutsInProgram = 0;

    private int daysToAdvance;
    private int exerciseIndex;                  // used to set exercise priorities
    private int index;

    // calendar and time keeping related variables
    ArrayList<Date> workoutDates;
    Date dateCreated;
    Date workoutDate;


    //TODO: Correct compound/isolation exercise amounts for each split

    public ProgramGenerator(String programName, String focus, String goal, int age, int desiredIntensity, String experience, int lengthInWeeks, int workoutsPerWeek) {
        this.programName = programName;
        this.focus = focus;
        this.goal = goal;
        this.age = age;
        this.desiredIntensity = desiredIntensity;
        this.experience = experience;
        if (experience.equals("Beginner"))
            startRampUp = true;
        this.lengthInWeeks = lengthInWeeks;
        this.workoutsPerWeek = workoutsPerWeek;

        programExercises = new ArrayList<>();
        workoutDates = new ArrayList<>();

        Log.d(TAG, "Program generation started.");

        programVolume = getProgramVolume();
        split = getSplit();

        Log.d(TAG, programVolume + " " + split);

        getExerciseDistribution();
        getCompoundExercises();
        resetIsSelected();
        getIsolationExercises();
        resetIsSelected();
        Log.d(TAG, "Program name is:" + programName);
        Log.d(TAG, "Exercises per week: " + workoutsPerWeek);
        Log.d(TAG, "Program length in weeks: " + lengthInWeeks);
        Log.d(TAG, "Program intensity is:" + desiredIntensity);
        Log.d(TAG, "int mult: " + intensityMultiplier);
        Log.d(TAG, "Training experience:" + experience);
        Log.d(TAG, "Age: " +age);

        getWorkoutsInProgram();
        getWorkoutDates();

        Log.d(TAG, "# workouts in program: " +workoutsInProgram);
    }

    public ArrayList getProgramExercises() {
        return programExercises;
    }

    private Split getSplit() {
        Log.d(TAG, "getSplit() called.");

        if (workoutsPerWeek < 3)
            split = Split.FULL_BODY;
        else if (workoutsPerWeek < 5)
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

        if (experience.equals("Beginner")) {
            intensityMultiplier *= 0.9;
        } else if (experience.equals("Intermediate")) {
            intensityMultiplier *= 1.1;
        } else if (experience.equals("Advanced")) {
            intensityMultiplier *= 1.2;
        }


        if (age < 17)
            intensityMultiplier *= 0.8;
        else if (age > 35 && age < 41)
            intensityMultiplier *= 0.9;
        else if (age > 40 && age < 51)
            intensityMultiplier *= 0.8;
        else if (age > 50 && age < 61)
            intensityMultiplier *= 0.7;
        else if (age > 60){
            intensityMultiplier *= 0.5;
        }

        if (intensityMultiplier < 0.75)
            programVolume = ProgramVolume.LOW;
        else if (intensityMultiplier < 1)
            programVolume = ProgramVolume.MED_LOW;
        else if (intensityMultiplier < 1.25)
            programVolume = ProgramVolume.MED_HIGH;
        else if (intensityMultiplier > 1.4)
            programVolume = ProgramVolume.HIGH;

        Log.d(TAG, "programVolume is " + programVolume);
        return programVolume;
    }

    private void getExerciseDistribution() {
        Log.d(TAG, "getExerciseDistribution() called.");

        switch (split) {
            case FULL_BODY: {
                Log.d(TAG, "Picking full body split exercises.");

                if (goal.equals("Muscle mass")) {
                    numberOfCompoundExercises = 3;
                    numberOfIsolationExercises = 4;
                } else if (goal.equals("Strength")) {
                    numberOfCompoundExercises = 4;
                    numberOfIsolationExercises = 2;
                } else if (goal.equals("Power building")) {
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

                if (goal.equals("Muscle mass")) {
                    numberOfCompoundExercises = 3;
                    numberOfIsolationExercises = 4;
                } else if (goal.equals("Strength")) {
                    numberOfCompoundExercises = 4;
                    numberOfIsolationExercises = 2;
                } else if (goal.equals("Power building")) {
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

                if (goal.equals("Muscle mass")) {
                    numberOfCompoundExercises = 3;
                    numberOfIsolationExercises = 4;
                } else if (goal.equals("Strength")) {
                    numberOfCompoundExercises = 4;
                    numberOfIsolationExercises = 2;
                } else if (goal.equals("Power building")) {
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
            Log.d(TAG, "Isolation Exercises: " + numberOfIsolationExercises + ".");

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

        public void getWorkoutsInProgram() {
        workoutsInProgram = workoutsPerWeek * lengthInWeeks;
        Log.d(TAG, "Total workouts in program: " + workoutsInProgram);
        }

        // set weeks to 0 if there is no need to advance them
        public Date getFutureDate(Date currentDate, int weeksToAdvance, int daysToAdvance) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, daysToAdvance);
            if (weeksToAdvance > 0) {
                calendar.add(Calendar.WEEK_OF_MONTH, weeksToAdvance);
            }
            Date futureDate = calendar.getTime();
            return futureDate;
        }
        // uses getCurrentDate() and days to advance to determine dates for all workouts, needs split info,
        private void getWorkoutDates() {

        Calendar calendar = Calendar.getInstance();
        dateCreated = calendar.getTime();
        if (programStartDate == null)
            workoutDates.add(dateCreated);
        else
            workoutDates.add(programStartDate);

        Log.d(TAG, "dateCreated: " +dateCreated);

        int workoutsToCreate = workoutsInProgram;

            while (workoutsToCreate > 1) {
            Log.d(TAG, "reached while loop");

            for (int weeks = lengthInWeeks; weeks > 0; weeks--) {
                    Log.d(TAG, "inside weeks loop");

                    for (int workouts = workoutsPerWeek; workouts > 0; workouts--) {
                        Log.d(TAG, "inside workouts loop");
                        daysToAdvance = (7 / workoutsPerWeek);
                        Log.d(TAG, "Days to advance: " + daysToAdvance);
                        if (workoutsPerWeek == 2) {
                            calendar.add(Calendar.DATE, daysToAdvance);
                        }
                        calendar.add(Calendar.DATE, daysToAdvance + 1);
                        workoutDate = calendar.getTime();
                        workoutDates.add(workoutDate);
                        workoutsInProgram--;
                        Log.d(TAG, "workoutsInProgram reamining: " +workoutsInProgram);
                    }
                }
                Log.d(TAG, "Finished creating workout dates.");
                Log.d(TAG, "Date created: " + dateCreated);
            for (int i = 0; i < workoutDates.size(); i++)
                Log.d(TAG, "Displaying workout dates: " + workoutDates.get(i));
            }
        }

        private void compareDatesToRecovery () {
        // TODO: Find out what muscle groups have recovered based on time elapsed
        //  Use calendar controller to get time and save it to SharedViewModel
        }

        // based, on split, goals, focus
        private void getExercisesPerMuscleGroup() {
        // TODO:
        }




        private void getWorkoutExercises() {

        getWorkoutsInProgram();

            while(workoutsInProgram < 0) {

                for (int workouts = workoutsPerWeek; workouts > 0; workouts++) {
                    distributeWeeklyExercises();
                }

            }
        }

    private void setExercisePriorities() {
        // TODO: Based on goals, focus.
        int legsPriority, backPriority, chestPriority, armsPriority, shouldersPriority, corePriority;

        if (goal.equals(Goal.MUSCLE)){

        } else if (goal.equals(Goal.STRENGTH)) {

        } else if (goal.equals(Goal.POWER_BUILDING)) {

        } else {

        }
    }

        private void distributeWeeklyExercises() {

        int legsRecovery, armsRecovery, chestRecovery, backRecovery, shoulderRecovery;

        if (split.equals(Split.FULL_BODY)) {

            for (int workouts = workoutsPerWeek; workouts > 0; workouts++){

            }

        } else if (split.equals(Split.UPPER_LOWER)) {

            for (int workouts = workoutsPerWeek; workouts > 0; workouts++){

            }

        } else {

            for (int workouts = workoutsPerWeek; workouts > 0; workouts++){

            }

        }

        // TODO: Based on recovery, split and goals
        }

        public void getUpperBodyExercises () {
         //TODO:
        }
        public void getLowerBodyExercises () {
        // TODO:
        }
        public void getCoreExercises () {
        // TODO:
        }
    }




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