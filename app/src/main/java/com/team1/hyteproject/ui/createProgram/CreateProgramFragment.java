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
import com.team1.hyteproject.program.BaseExercise;
import com.team1.hyteproject.program.ExerciseList;
import com.team1.hyteproject.program.Program;
import com.team1.hyteproject.program.ProgramGenerator;
import com.team1.hyteproject.ui.SaveLoad;
import com.team1.hyteproject.ui.SharedViewModel;

import java.util.ArrayList;


public class CreateProgramFragment extends Fragment {

    private static final String TAG = "NewProgramFragment";
    private static final String TEST = "Test";

    private SharedViewModel SharedViewModel;

    private EditText editProgramName;
    private Button createProgram;
    private String programName;
    private Program program;
    private ProgramGenerator programGenerator;
    private ArrayList<Program> programsList = new ArrayList();
    private ArrayList<BaseExercise> programExercises;
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

    private int numberOfProgramsCreated = 1;
    //private ArrayList programExercises;

    // TODO: increase numberOfProgramsCreated automatically. Program name generator.

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SharedViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);
        View view = inflater.inflate(R.layout.fragment_new_program, container, false);
        Log.d(TAG, "onCreateView: start.");

        editProgramName = view.findViewById(R.id.editProgramName);
        createProgram = view.findViewById(R.id.createAddShared);
        editProgramName = view.findViewById(R.id.editProgramName);
        editProgramName.setGravity(Gravity.END);

        for (int i = 1; i < 6; i++) {
            programIntensity.add(i);

        }
        for (int i = 1; i < 7; i++){
            exercisesPerWeek.add(i);
        }

        for (int i = 4; i <= 12; i++) {
            programLength.add(String.valueOf(i) + " weeks");
        }

        trainingXpSpinner = view.findViewById(R.id.trainingXPInput);
        goalSpinner = view.findViewById(R.id.goalInput);
        intensitySpinner = view.findViewById(R.id.programIntensityInput);
        focusSpinner = view.findViewById(R.id.programFocusInput);
        exercisesWeekSpinner = view.findViewById(R.id.exercisesPerWeekInput);
        lengthSpinner = view.findViewById(R.id.programLengthInput);

        trainingXpSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, Experience.values()));
        goalSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, Goal.values()));
        intensitySpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, programIntensity));
        focusSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, ExerciseGroup.values()));
        exercisesWeekSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, exercisesPerWeek));
        lengthSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, programLength));

        ((HomeActivity)getActivity()).updateStatusBarColor("#202124");

        program = new Program();
        programGenerator = new ProgramGenerator();

        createProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ExerciseList exerciseList = ExerciseList.getInstance();
                int age = SharedViewModel.getAge();
                int workoutsPerWeek = (exercisesWeekSpinner.getSelectedItemPosition() + 1);
                int lengthInWeeks = (lengthSpinner.getSelectedItemPosition() + 4);
                int desiredIntensity = (intensitySpinner.getSelectedItemPosition() +1);
                String goal = goalSpinner.getSelectedItem().toString();
                String focus = focusSpinner.getSelectedItem().toString();
                String experience = trainingXpSpinner.getSelectedItem().toString();
                String name = editProgramName.getText().toString();

                Log.d(TAG, "createWorkout clicked.");

                ProgramGenerator programGenerator = new ProgramGenerator(programName, focus, goal, age, desiredIntensity, experience, lengthInWeeks, workoutsPerWeek);
                program = programGenerator.getProgram();
                programsList.add(program);
                // SAVING PROGRAM LIST HERE
                saveLoad.saveProgramList(getActivity(), programsList);
                Log.d(TAG, "Total programs in list: " + programsList.size());

                //ProgramGenerator programGenerator = new ProgramGenerator(programName, focus, goal, age, intensity, experience, length, exercisesPerWeek);
                //programExercises = programGenerator.generateProgram(programName, focus, goal, age, intensity, experience, length, exercisesPerWeek);
                //programExercises = programGenerator.getProgramExercises();
                numberOfProgramsCreated++;
                SaveLoad.getInstance().saveDataList(getActivity(), programExercises, TEST);
                ArrayList testList = new ArrayList();
                testList = SaveLoad.getInstance().loadProgramList(getActivity(), TEST);
                Log.d(TAG, "testList is empty:"+testList.isEmpty());
                Log.d(TAG, "age: " + SharedViewModel.getAge());

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

                SharedViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        //textView.setText(s);
                    }
                });
        return view;
    }
}

