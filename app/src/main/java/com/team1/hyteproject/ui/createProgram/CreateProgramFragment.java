package com.team1.hyteproject.ui.createProgram;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.team1.hyteproject.HomeActivity;
import com.team1.hyteproject.R;
import com.team1.hyteproject.enums.Experience;
import com.team1.hyteproject.enums.ExerciseGroup;
import com.team1.hyteproject.enums.Goal;
import com.team1.hyteproject.enums.TargetMuscleGroup;
import com.team1.hyteproject.program.BaseExercise;
import com.team1.hyteproject.program.ExerciseList;
import com.team1.hyteproject.program.Program;
import com.team1.hyteproject.program.ProgramGenerator;
import com.team1.hyteproject.program.ProgramsList;
import com.team1.hyteproject.ui.SaveLoad;
import com.team1.hyteproject.ui.SharedViewModel;

import java.util.ArrayList;

/**
 * Author Aarni Pesonen
 * Allows for custom program creation based on user input
 */
public class CreateProgramFragment extends Fragment {

    private static final String TAG = "NewProgramFragment";


    private EditText editProgramName;
    private Button createProgram;
    private String programName;
    private ProgramsList completeProgramsList;                              //holds a list of all programs in app, saved as an abstract object
    private Program program;                                                //single program info
    private ProgramGenerator programGenerator;
    private ArrayList<Program> programsList = new ArrayList();
    private ArrayList<String> programLength = new ArrayList<>();
    private ArrayList<Integer> programIntensity = new ArrayList<>();
    private ArrayList<Integer> exercisesPerWeek = new ArrayList<>();
    private SaveLoad saveLoad = SaveLoad.getInstance();

    Spinner trainingXpSpinner;
    Spinner goalSpinner;
    Spinner intensitySpinner;
    Spinner focusSpinner;
    Spinner exercisesWeekSpinner;
    Spinner lengthSpinner;

    // TODO: increase numberOfProgramsCreated automatically. Program name generator.

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new_program, container, false);
        Log.d(TAG, "onCreateView: start.");

        ((HomeActivity)getActivity()).updateStatusBarColor("#202124");

        editProgramName = view.findViewById(R.id.editProgramName);
        createProgram = view.findViewById(R.id.createAddShared);
        editProgramName = view.findViewById(R.id.editProgramName);
        editProgramName.setGravity(Gravity.END);

        trainingXpSpinner = view.findViewById(R.id.trainingXPInput);
        goalSpinner = view.findViewById(R.id.goalInput);
        intensitySpinner = view.findViewById(R.id.programIntensityInput);
        focusSpinner = view.findViewById(R.id.programFocusInput);
        exercisesWeekSpinner = view.findViewById(R.id.exercisesPerWeekInput);
        lengthSpinner = view.findViewById(R.id.programLengthInput);

        createSpinnerData();

        setSpinnerAdapters();

        program = new Program();
        programGenerator = new ProgramGenerator();
        completeProgramsList = (ProgramsList) saveLoad.loadProgramListObject(getActivity(), ProgramsList.class);

        createProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createProgram();

                Navigation.findNavController(view).navigate(R.id.action_navigation_new_program_to_navigation_program);
            }
        });

        editProgramName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "programNameButton clicked.");
                editProgramName = view.findViewById(R.id.editProgramName);
                programName = editProgramName.getText().toString();
            }
        });

        return view;
    }
    //TODO: create a class for all below methods

    /**
     * sets custom adapters for spinners
     */
    //sets custom adapters for spinners
    private void setSpinnerAdapters() {
        trainingXpSpinner.setAdapter(new ArrayAdapter<>(getActivity(), R.layout.spinner_item, Experience.values()));
        goalSpinner.setAdapter(new ArrayAdapter<>(getActivity(), R.layout.spinner_item, Goal.values()));
        intensitySpinner.setAdapter(new ArrayAdapter<>(getActivity(), R.layout.spinner_item, programIntensity));
        focusSpinner.setAdapter(new ArrayAdapter<>(getActivity(), R.layout.spinner_item, TargetMuscleGroup.values()));
        exercisesWeekSpinner.setAdapter(new ArrayAdapter<>(getActivity(), R.layout.spinner_item, exercisesPerWeek));
        lengthSpinner.setAdapter(new ArrayAdapter<>(getActivity(), R.layout.spinner_item, programLength));
    }

    /**
     * get input data from spinners, start program generation and save data
     * TODO: extract single methods for each function
     */
    //gets data from spinners, starts program generation, saves created program as an abstract object
    private void createProgram() {
        ExerciseList exerciseList = ExerciseList.getInstance();
        int age = 25;
        int workoutsPerWeek = (exercisesWeekSpinner.getSelectedItemPosition() + 1);
        int lengthInWeeks = (lengthSpinner.getSelectedItemPosition() + 4);
        int desiredIntensity = (intensitySpinner.getSelectedItemPosition() +1);
        String goal = goalSpinner.getSelectedItem().toString();
        String focus = focusSpinner.getSelectedItem().toString();
        String experience = trainingXpSpinner.getSelectedItem().toString();
        String programName = editProgramName.getText().toString();

        Log.d(TAG, "createWorkout clicked.");

        ProgramGenerator programGenerator = new ProgramGenerator(programName, focus, goal, age, desiredIntensity, experience, lengthInWeeks, workoutsPerWeek);
        program = programGenerator.getProgram();

        completeProgramsList.addProgram(program);
        saveLoad.saveProgramListObject(getActivity(), completeProgramsList);

    }

    /**
     * populates three spinners with data using loops
     */
    //populates spinners program intensity, exercises per week and program length
    //first iteration only allows for 12 week long programs max
    private void createSpinnerData() {
        for (int i = 1; i < 6; i++) {
            programIntensity.add(i);

        }
        for (int i = 1; i < 7; i++){
            exercisesPerWeek.add(i);
        }

        for (int i = 4; i <= 12; i++) {
            programLength.add(String.valueOf(i) + " weeks");
        }
    }
}

