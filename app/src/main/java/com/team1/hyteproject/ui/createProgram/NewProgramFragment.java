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

import com.team1.hyteproject.HomeActivity;
import com.team1.hyteproject.R;
import com.team1.hyteproject.enums.Experience;
import com.team1.hyteproject.enums.Focus;
import com.team1.hyteproject.enums.Goal;
import com.team1.hyteproject.program.ExerciseList;
import com.team1.hyteproject.program.ProgramGenerator;
import com.team1.hyteproject.ui.SaveLoad;
import com.team1.hyteproject.ui.SharedViewModel;
import com.team1.hyteproject.ui.profile.UserProfile;

import java.util.ArrayList;


public class NewProgramFragment extends Fragment {

    private static final String TAG = "NewProgramFragment";
    private static final String TEST = "Test";

    private SharedViewModel SharedViewModel;

    private Button createProgram;
    private EditText editProgramName;
    private String programName;
    private ArrayList<String> programLength = new ArrayList<>();
    private ArrayList<Integer> programIntensity = new ArrayList<>();
    private ArrayList<Integer> exercisesPerWeek = new ArrayList<>();

    Spinner trainingXpSpinner;
    Spinner goalSpinner;
    Spinner intensitySpinner;
    Spinner focusSpinner;
    Spinner exercisesWeekSpinner;
    Spinner lengthSpinner;

    private int numberOfProgramsCreated = 1;
    private ArrayList programExercises;

    private UserProfile userProfile = new UserProfile();

    // TODO: increase numberOfProgramsCreated automatically. Program name generator.

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SharedViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);
        View view = inflater.inflate(R.layout.fragment_new_program, container, false);
        Log.d(TAG, "onCreateView: start.");

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

        trainingXpSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, Experience.values()));
        goalSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, Goal.values()));
        intensitySpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, programIntensity));
        focusSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, Focus.values()));
        exercisesWeekSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, exercisesPerWeek));
        lengthSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, programLength));



        ((HomeActivity)getActivity()).updateStatusBarColor("#202124");

        createProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ExerciseList exerciseList = ExerciseList.getInstance();
                int age = SharedViewModel.getAge();
                int exercisesPerWeek = (exercisesWeekSpinner.getSelectedItemPosition() + 1);
                int length = (lengthSpinner.getSelectedItemPosition() + 4);
                int intensity = (intensitySpinner.getSelectedItemPosition() +1);
                String goal = goalSpinner.getSelectedItem().toString();
                String focus = focusSpinner.getSelectedItem().toString();
                String experience = trainingXpSpinner.getSelectedItem().toString();
                String name = "user input";

                Log.d(TAG, "createWorkout clicked.");


                ProgramGenerator programGenerator = new ProgramGenerator(programName, focus, goal, age, intensity, experience, length, exercisesPerWeek);
                programExercises = programGenerator.getProgramExercises();
                numberOfProgramsCreated++;
                SaveLoad.getInstance().saveDataList(getActivity(), programExercises, TEST);
                ArrayList testList = new ArrayList();
                testList = SaveLoad.getInstance().loadDataList(getActivity(), TEST);
                Log.d(TAG, "testList is empty:"+testList.isEmpty());

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

