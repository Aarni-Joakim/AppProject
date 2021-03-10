package com.team1.hyteproject.program;

import android.util.Log;

import com.team1.hyteproject.enums.Goal;
import com.team1.hyteproject.enums.ProgramVolume;
import com.team1.hyteproject.enums.Split;
import com.team1.hyteproject.enums.TargetMuscleGroup;
import com.team1.hyteproject.ui.SaveLoad;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author Aarni Pesonen
 * This class handles functions related to program creation.
 * After making a few calculations based on user input, generator finds dates for all workouts based on workout split using java's calendar
 * When total number of workouts is known, two methods containing three loops each then assign exercises for each workout included in program
 */
public class ProgramGenerator {

    private final String TAG = "ProgramGenerator";

    private ArrayList<BaseExercise> programExercises;               // All exercises included in the program
    private ArrayList<Workout> programWorkouts = new ArrayList<>(); // All workouts included in the program
    private ArrayList<BaseExercise> workoutExercises;               // Exercises included in each workout
    private ArrayList<WorkoutMuscleGroup> splitGroupList;             // List of all muscle groups included in a single workout
    private BaseExercise baseExercise;                              // Used to hold a single instance of BaseExercise
    private SplitInfo splitInfo;                                    // Holds a list of all split related muscle group distributions
    private WorkoutMuscleGroup workoutMuscleGroup;                  // Holds lists of all different muscle group distributions available in a split

    private ProgramsList completeProgramsList;                              // Holds list of all programs
    private Program program;                                        // All program information is ultimately stored in this class
    private Workout workout;                                        // Instance of a single workout
    //private SaveLoad saveLoad;                                    // not needed

    // user input fields
    private Date programStartDate;                                  // user input calendar pop up
    private String programName;
    private String goal;                                            // muscle mass, strength, power building, toning
    private String focus;                                           // Adds volume/frequency for selected muscle group. Can be null/none.
    private String experience;                                      // from enum toString()
    private int desiredIntensity;                                   // from user input desiredIntensity
    private int lengthInWeeks;                                      // from user input
    private int workoutsPerWeek;// from user input
    private int exerciseInProgram;                                  // total amount of exercises in program
    private boolean evenlySpacedRecovery = true;                    // TODO: not implemented, should determine of each workout week "resets" and exercises start from Monday instead of following daysToAdvance

    // from profile
    private int age;                                                // from user input

    // fields determined based on user input
    private Split split;                                            // determined by exercises per week
    private ProgramVolume programVolume;                            // replaced int with enum: LOW(iM < 0.75), LOW-MED(iM < 1), HIGH-MED(iM < 1.25), HIGH(iM > 1.25)
    private double intensityMultiplier = 1.0;                       // calculated from age, experience and desiredIntensity, used to determine program volume (later also frequency)
    private boolean startRampUp = false;                            // true if experience = "Beginner"

    //fields determined based on programSplit and goal
    private int numberOfCompoundExercises;                          // compound exercises per workout
    private int numberOfIsolationExercises;                         // isolation exercises per workout
    private int workoutsInProgram;                                  // total number of workouts in a program

    private int daysToAdvance;                                      // how many days to advance (java)calendar until next workout
    private int exerciseIndex;                                      // used to set exercise priorities
    private int index;

    // calendar and time keeping related variables
    ArrayList<Date> workoutDates;                                   // calculated workout dates are stored here
    Date dateCreated;                                               // program creation date, is no startDate is given, this will be used instead
    Date workoutDate;                                               // date of an individual workout
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");


    //TODO: Correct compound/isolation exercise amounts for each split

    public ProgramGenerator() {
        completeProgramsList = new ProgramsList();
        program = new Program();
        programExercises = new ArrayList<>();
        workoutDates = new ArrayList<>();
    }

    /**
     * constructor of ProgramGenerator, creates a program based on user input parameters
     * @param programName user input name for the program
     * @param focus user input parameter that adds exercises for select muscle group *not in full use*
     * @param goal user input program exercise selection and priority is based on
     * @param age of the user
     * @param desiredIntensity affects program intensity volume and frequency(not yet implemented)
     * @param experience user gym training experience
     * @param lengthInWeeks length of the program in weeks
     * @param workoutsPerWeek  number of workouts per week, determines program split and exercise distribution
     */
    public ProgramGenerator(String programName, String focus, String goal, int age, int desiredIntensity, String experience, int lengthInWeeks, int workoutsPerWeek) {

        this.programName = programName;
        Log.d(TAG, "program name is: " +programName);
        this.focus = focus;
        this.goal = goal;
        this.age = age;
        this.desiredIntensity = desiredIntensity;
        this.experience = experience;
        if (experience.equals("Beginner"))
            startRampUp = true;
        this.lengthInWeeks = lengthInWeeks;
        this.workoutsPerWeek = workoutsPerWeek;

        program = new Program();
        programExercises = new ArrayList<>();
        workoutDates = new ArrayList<>();

/*
        Log.d(TAG, "Program generation started.");

        programVolume = getProgramVolumeIntensity();
        split = getSplit();

        Log.d(TAG, programVolume + " " + split);

        getExerciseDistribution();
        getCompoundExercises();
        resetIsSelected(programExercises);                          // TODO: Make sure this works correctly. Tested #1 working as intended?
        getIsolationExercises();
        resetIsSelected(programExercises);
        Log.d(TAG, "Program name is:" + programName);
        Log.d(TAG, "Exercises per week: " + workoutsPerWeek);
        Log.d(TAG, "Program length in weeks: " + lengthInWeeks);
        Log.d(TAG, "Program intensity is:" + desiredIntensity);
        Log.d(TAG, "int mult: " + intensityMultiplier);
        Log.d(TAG, "Training experience:" + experience);
        Log.d(TAG, "Age: " + age);

        getWorkoutsInProgram();
        getWorkoutDates();

        Log.d(TAG, "# workouts in program: " + workoutsInProgram);

        megaLoop();*/

        generateProgram();
    }

    /**
     * gets program exercise distribution based on split value
     */
    //GETS TOTAL NUMBER OF COMPOUND AND ISOLATION EXERCISES TO BE ADDED TO PROGRAM
    private void getExerciseDistribution() { //TODO Make a dedicated Split class
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

    /**
     * returns ArrayList programExercises
     * @return complete list of exercises included in the program
     */
    public ArrayList getProgramExercises() {
        return programExercises;
    }

    /**
     * gets split value based on number of weekly workouts
     * @return program split value based on number of weekly exercises
     */
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

    /**
     * calculates program intensity multiplier and program volume based on prior experience level, desired intensity and user age
     * returns program volume
     * @return not yet implemented
     */
    //DETERMINES PROGRAM VOLUME AND INTENSITY MULTIPLIER BASED ON PRIOR USER EXPERIENCE, DESIRED PROGRAM INTENSITY AND AGE
    private ProgramVolume getProgramVolumeIntensity() {
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
        else if (age > 60) {
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


    /**
     * gets all compound exercises to be included in the program from ExerciseList singleton
     */
    //GETS ALL COMPOUND EXERCISES TO BE INCLUDED IN THE PROGRAM FROM EXERCISELIST SINGLETON
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

    /**
     * gets all isolation exercises to be included in the program from ExerciseList singleton
     */
    //GETS ALL ISOLATION EXERCISES TO BE INCLUDED IN THE PROGRAM FROM EXERCISELIST SINGLETON
    private void getIsolationExercises() {

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

    /**
     * complete list of program exercises
     * @return list of exercises included in program, previously selected by stream reader
     */
    //RETURNS A COMPLETE LIST OF ALL PROGRAM EXERCISES
    public ArrayList<BaseExercise> getProgramExerciseList() {
        Log.d(TAG, "getProgramExerciseList called");

        return programExercises;
    }

    /**
     * resets isSelected bool value of input list elements
     * bool dictates if a selected exercise "is seen" as stream reader goes through the list of exercises
     * @param arrayList reset isSelected value of BaseExercise arraylist
     */
    // TODO: Make arrayList detection more "safe". CHECK THE FUNCTION OF THIS METHOD!!!!!
    //RESETS isSelected BOOLEAN OF ALL EXERCISES IN LIST ENTERED AS PARAMETER
    private void resetIsSelected(ArrayList<BaseExercise> arrayList) {

        if (arrayList.size() > 20)
            for (int index = 0; index < ExerciseList.getInstance().getAllUpperBodyExercises().size(); index++) {
                ExerciseList.getInstance().getUpperBodyExercise(index).setIsSelected(false);
            }
        else {
            for (int index = 0; index < arrayList.size(); index++) {
                arrayList.get(index).setIsSelected(false);
            }
        }
    }

    /**
     * calulates the amount of workout sessions in a program
     */
    //DETERMINE HOW MANY INDIVIDUAL WORKOUTS THERE ARE IN A PROGRAM
    public void getWorkoutsInProgram() {
        workoutsInProgram = workoutsPerWeek * lengthInWeeks;
        Log.d(TAG, "Total workouts in program: " + workoutsInProgram);
    }

    //SET WEEKS TO 0 IF THERE IS NO NEED TO ADVANCE CALENDAR WEEKS
    public Date getFutureDate(Date currentDate, int weeksToAdvance, int daysToAdvance) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, daysToAdvance);
        if (weeksToAdvance > 0) {
            calendar.add(Calendar.WEEK_OF_MONTH, weeksToAdvance);
        }
        Date futureDate = calendar.getTime();
        return futureDate;
    }

    /**
     * finds dates for all workouts included in the program using java calendar
     */
    //USES getCurrentDate() AND daysToAdvance value TO DETERMINE DATES FOR ALL WORKOUTS, REQUIRED SPLIT INFO
    private void getWorkoutDates() {

        int numberOfWorkouts = workoutsInProgram;

        Calendar calendar = Calendar.getInstance();
        dateCreated = calendar.getTime();
        if (programStartDate == null)
            workoutDates.add(dateCreated);
        else
            workoutDates.add(programStartDate);

        Log.d(TAG, "dateCreated: " + dateCreated);


        while (numberOfWorkouts > 0) {
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
                    numberOfWorkouts--;
                    Log.d(TAG, "workoutsInProgram remaining: " + workoutsInProgram);
                }
            }
            Log.d(TAG, "Finished creating workout dates.");
            Log.d(TAG, "Date created: " + dateCreated);
            for (int i = 0; i < workoutDates.size(); i++)
                Log.d(TAG, "Displaying workout dates: " + workoutDates.get(i));
        }
    }

    //TODO: NOT YET IMPLEMENTED. COMPARE WORKOUT DATES TO RECOVERY DAYS TO DETERMINE IF A MUSCLE GROUP HAS RECOVERED
    private void compareDatesToRecovery() {
        // TODO: Find out what muscle groups have recovered based on time elapsed
        //  Use calendar controller to get time and save it to SharedViewModel
    }

    // based, on split, goals, focus
    private void getExercisesPerMuscleGroup() {
        // TODO:
    }

    /**
     * intended to set exercise priorities based on program goal *not yet implemented*
     */
    //TODO: NOT YET IMPLEMENTED. SETS EXERCISE PRIORITIES BASED ON PROGRAM SPLIT
    private void setExercisePriorities() {
        // TODO: Based on goals, focus.
        int legsPriority, backPriority, chestPriority, armsPriority, shouldersPriority, corePriority;

        if (goal.equals(Goal.MUSCLE)) {

        } else if (goal.equals(Goal.STRENGTH)) {

        } else if (goal.equals(Goal.POWER_BUILDING)) {

        } else {

        }
    }

    /**
     * distributes exercises to all workouts included in a program
     * first while loop: loops through times total of individual exercises in a program
     * second for loop: loops as many times as there are workouts in a week
     * third for loop: loops once for each muscle group in a single workout session
     * inside this third loop is a method for getting all single workout session exercises per each included muscle group
     */
    //GETS ALL WORKOUT SPECIFIC EXERCISES
    // workoutLists is the amount of different exercises compositions in a split, that are used to determine exercises for daily workouts
    // SplitInfo class holds all unique muscle group lists (object of class SplitMuscleGroup) for each different workout split.
    // targetMuscleGroupsList stores each different muscle group that is trained in a single workout
    public void getDailyWorkoutExercises() {

        Log.d(TAG, "getting dailyWorkoutExercises");
        splitInfo = new SplitInfo(split, workoutsPerWeek);

        //LOOP AS MANY TIMES AS THERE ARE WORKOUTS IN A PROGRAM.
        while(workoutsInProgram > 0) {

            for (int workouts = 0; workouts < workoutsPerWeek; workouts++) {           // CREATES AS MANY DIFFERENT WORKOUTS AS THERE ARE workoutsPerWeek
                Log.d(TAG, "First loop reached. Looping times == workoutsPerWeek");

                    for (int muscleGroups = 0; muscleGroups < splitInfo.getWorkoutMuscleGroupsList().get(workouts).targetMuscleGroupsList.size(); muscleGroups++) {
                        Log.d(TAG, "Third loop reached. Looping times == there are muscle groups to be trained per session/workout.");
                        getSessionExercisesPerMuscleGroup(splitInfo.getWorkoutMuscleGroupsList().get(workouts).getTargetMuscleGroup(muscleGroups),
                                numberOfCompoundExercises, numberOfIsolationExercises,
                                splitInfo.getWorkoutMuscleGroupsList().get(workouts).getTargetMuscleGroupList().size());
                    }
                }
            }
        Log.d(TAG, "Finished adding programWorkouts! Congratulations you filthy animal!!!");
        Log.d(TAG, "Exercises created: " + programWorkouts.size());
        //ALL GENERATED WORKOUTS ADDED TO PROGRAM OBJECT
        program.setProgramWorkouts(programWorkouts);
        }

    /**
     * gets all compound and isolation exercises for each muscle group included in a single workout session
     * first for loop: loops once for each different muscle group included in session
     * second for loop: gets compound exercises for above muscle group
     * third for loop: gets isolation exercises for above muscle group
     * working in tandem with getDailyWorkoutExercises() these methods are able to populate all workout session in a program
     * getDailyWorkouts() inputs all parameters below
     * @param targetMuscleGroup of exercises to be selected from programExercises list
     * @param dailyCompoundExercises number of workout compound exercises to be selected per muscle group
     * @param dailyIsolationExercises number of workout isolation exercises to be selected per muscle group
     * @param muscleGroupsPerDay how many muscle groups are included in a specific workout session
     */
    // This methods take in amounts of daily exercises depending on the split. Use this method inside getDailyWorkoutExercises()
    public void getSessionExercisesPerMuscleGroup(TargetMuscleGroup targetMuscleGroup, int dailyCompoundExercises, int dailyIsolationExercises, int muscleGroupsPerDay) {

        numberOfIsolationExercises = 2;
        numberOfCompoundExercises = 2;

        Log.d(TAG, "getting dailyMuscleGroupExercises");

        workout = new Workout();
        workoutExercises = new ArrayList<>();
        muscleGroupsPerDay = 1;

        //HOW MANY DIFFERENT MUSCLE GROUPS IN A DAILY WORKOUT SESSION
        for (int i = 0; i < muscleGroupsPerDay; i++) {
            Log.d(TAG, "Reached second loop of getDailyMuscleGroupExercises.");
            //WORKOUT COMPOUND EXERCISES PER MUSCLE GROUP
            for (int j =  0; j < dailyCompoundExercises; j++) {
                Log.d(TAG, "Reached third loop of getDailyMuscleGroupExercises.");
                Log.d(TAG, "programExercises is selected:" + programExercises.get(1).getIsSelected());
                baseExercise = programExercises.stream().filter(BaseExercise -> BaseExercise.getPriority() == 3 && BaseExercise.getIsCompound() && !BaseExercise.getIsSelected()).findFirst().get();                //TODO: -> was this the culprit? && BaseExercise.getTargetMuscleGroup() == targetMuscleGroup
                Log.d(TAG, "Filtering for suitable BaseExercise");
                exerciseIndex = programExercises.indexOf(baseExercise);
                Log.d(TAG, "Getting index of found BaseExercise");

                if (baseExercise != null) {
                    Log.d(TAG, "Base exercise was not null");
                    workout.addExercise(baseExercise);  // TODO: add exercise date to ArrayList workoutExercises or just get it from a separate list when needed? Could be added to Workout class!!!!!
                    Log.d(TAG, "Workout added to workoutExercises.");

                }

                programExercises.get(exerciseIndex).setIsSelected(false);               //TODO: testing
            }

            //WORKOUT ISOLATION EXERCISES PER MUSCLE GROUP
            for (int k = 0; k < dailyIsolationExercises; k++) {
                Log.d(TAG, "Reached fourth loop of getDailyMuscleGroupExercises. k: " +k);
                baseExercise = programExercises.stream().filter(BaseExercise -> BaseExercise.getPriority() == 3 && !BaseExercise.getIsCompound() && !BaseExercise.getIsSelected()).findFirst().get();  //   && BaseExercise.getTargetMuscleGroup() == targetMuscleGroup)
                exerciseIndex = programExercises.indexOf(baseExercise);
                if (baseExercise != null){
                    workout.addExercise(baseExercise);
                }
                programExercises.get(exerciseIndex).setIsSelected(false);

            }
        }
        programWorkouts.add(workout);
        workoutsInProgram--;
    }

    /**
     * easy to remember method name for running the program workout generation loops!
     */
    public void megaLoop() {
        getDailyWorkoutExercises();
    }

    /**
     * Runs the methods for program generation in the correct order
     */
    public void generateProgram () {

        split = getSplit();

        getExerciseDistribution();
        getCompoundExercises();
        resetIsSelected(programExercises);                          // TODO: Make sure this works correctly. Tested #1 working as intended?
        getIsolationExercises();
        resetIsSelected(programExercises);
        getWorkoutsInProgram();
        getWorkoutDates();
        megaLoop();

        Log.d(TAG, "Program name is:" + programName);
        Log.d(TAG, "Exercises per week: " + workoutsPerWeek);
        Log.d(TAG, "Program length in weeks: " + lengthInWeeks);
        Log.d(TAG, "Program intensity is:" + desiredIntensity);
        Log.d(TAG, "int mult: " + intensityMultiplier);
        Log.d(TAG, "Training experience:" + experience);
        Log.d(TAG, "Age: " + age);
        Log.d(TAG, "# workouts in program: " + workoutsInProgram);

        assignWorkoutDates();
        program.setProgramExercises(programExercises);
        program.setProgramWorkouts(programWorkouts);
        program.setProgramName(programName);
        program.setProgramType(goal);

    }

    public Program getProgram() {
        return program;
    }

    /**
     * Adds generated program to list of all programs included in the app
     * list is if one is present in shared preference at the time of object instantiation
     * @return complete list of programs with newest generated program added in
     */
    public ProgramsList getCompleteProgramsList() {
        completeProgramsList.addProgram(program);
        return completeProgramsList;
    }

    //ASSIGNS STRING DATES FOR EACH PROGRAM WORKOUT FROM workoutDates list | WIP!!!
    private void assignWorkoutDates() {
        for (int index = 0; index < programWorkouts.size(); index++) {
            Log.d(TAG, "workout dates index " + index + " is: "+ workoutDates.get(index));
            //String date = simpleDateFormat.format(workoutDates.get(index));
            String date = workoutDates.get(index).toString();
            programWorkouts.get(index).setWorkoutDate(date);
            Log.d(TAG, "date of index " +index + "is " + programWorkouts.get(index).getWorkoutDate());
        }

    }
}