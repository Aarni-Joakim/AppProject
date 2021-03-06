package com.team1.hyteproject.ui.addExercise;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
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
import com.team1.hyteproject.enums.ExerciseGroup;
import com.team1.hyteproject.enums.IntensityPriority;
import com.team1.hyteproject.enums.IsCompound;
import com.team1.hyteproject.enums.RecoveryTime;
import com.team1.hyteproject.enums.TargetMuscleGroup;
import com.team1.hyteproject.program.BaseExercise;
import com.team1.hyteproject.program.ExerciseList;

import java.util.ArrayList;

public class AddExerciseFragment extends Fragment {

    private static final String TAG = "AddExerciseFragment";

    private AddExerciseViewModel addExerciseViewModel;
    private ArrayList<Integer> exerciseIntensityList = new ArrayList<>();
    private ArrayList<String> recoveryTimeList = new ArrayList<>();
    private ArrayList<String> isCompoundList = new ArrayList<>();
    private ArrayList<String> exerciseGroupList = new ArrayList<>();
    String[] exerciseGroups;

    private BaseExercise baseExercise;
    private EditText editExerciseName;
    private Button addNewExercise;
    Spinner groupSpinner;
    Spinner targetMuscleGroupSpinner;
    Spinner intensitySpinner;
    Spinner exerciseTypeSpinner;
    Spinner exercisePrioritySpinner;
    Spinner recoveryTimeSpinner;
    private String exerciseName;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addExerciseViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(AddExerciseViewModel.class);
        View view = inflater.inflate(R.layout.fragment_add_exercise, container, false);
        //TextView textView = view.findViewById(R.id.textView);
        Log.d(TAG, "onCreateView: start.");

        //ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.exerciseGroupsSpinner, R.layout.spinner_layout_test);

        editExerciseName = view.findViewById(R.id.editExerciseName);
        addNewExercise = view.findViewById(R.id.createAddShared);

        ((HomeActivity)getActivity()).updateStatusBarColor("#202124");

        groupSpinner = (Spinner)view.findViewById(R.id.exerciseGroupInput);
        targetMuscleGroupSpinner = view.findViewById(R.id.targetMuscleGroupInput);
        intensitySpinner = view.findViewById(R.id.intensityInput);
        exerciseTypeSpinner = view.findViewById(R.id.exerciseTypeInput);
        exercisePrioritySpinner = view.findViewById(R.id.exercisePriorityInput);
        recoveryTimeSpinner = view.findViewById(R.id.recoveryTimeInput);

        groupSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, ExerciseGroup.values()));
        targetMuscleGroupSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, TargetMuscleGroup.values()));
        intensitySpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, IntensityPriority.values()));
        exerciseTypeSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, IsCompound.values()));
        exercisePrioritySpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, IntensityPriority.values()));
        recoveryTimeSpinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, RecoveryTime.values()));

        //arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        //groupSpinner.setAdapter(arrayAdapter);
        isCompoundList.add("Compound");
        isCompoundList.add("Isolation");

        exerciseGroupList.add("Upper Body");
        exerciseGroupList.add("Lower Body");
        exerciseGroupList.add("Core");

        Resources res = getResources();
        exerciseGroups = res.getStringArray(R.array.exerciseGroupsSpinner);



        for (int i = 1; i < 6 ; i++) {
            exerciseIntensityList.add(i);
        }

        for (int i = 1; i < 8 ; i++) {
            recoveryTimeList.add(String.valueOf(i) + " days");
        }


        addNewExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ExerciseList exerciseList = ExerciseList.getInstance();
                String exerciseGroupString = groupSpinner.getSelectedItem().toString();
                String targetMuscleGroupString = targetMuscleGroupSpinner.getSelectedItem().toString();
                int exerciseIntensityInt = (intensitySpinner.getSelectedItemPosition() +1);
                boolean isCompound = compoundToBool(exerciseTypeSpinner.getSelectedItem().toString());
                int exercisePrioryInt = (exercisePrioritySpinner.getSelectedItemPosition() +1);
                int recoveryTimeInt = (recoveryTimeSpinner.getSelectedItemPosition()+1);
                exerciseName = editExerciseName.getText().toString();

                Log.d(TAG, "createWorkout clicked.");
                Log.d(TAG, "Exercise type is: " + isCompound);
                //ExerciseList.getInstance().addExercise(exerciseName, recoveryTimeInt, exerciseIntensityInt, isCompound, TargetMuscleGroup.valueOf(targetMuscleGroupString.toUpperCase()));
                baseExercise = new BaseExercise(exerciseName, recoveryTimeInt, exerciseIntensityInt, exercisePrioryInt, isCompound, TargetMuscleGroup.valueOf(targetMuscleGroupSpinner.getSelectedItem().toString().toUpperCase()), ExerciseGroup.valueOf(groupSpinner.getSelectedItem().toString().toUpperCase()));
                //SaveLoad.getInstance().saveDataList(getActivity(), programExercises, TEST);

                Log.d(TAG, "Added " + baseExercise.getName() + " to exercise list.");
                Log.d(TAG, "Exercise group: " + baseExercise.getExerciseGroup() + " to exercise list.");
                Log.d(TAG, "Intensity: " +baseExercise.getExerciseIntensity());
                Log.d(TAG, "IsCompound: " +baseExercise.getIsCompound());
                Log.d(TAG, "Priority: " +baseExercise.getPriority());
                Log.d(TAG, "Muscle group: " +baseExercise.getTargetMuscleGroup());
                Log.d(TAG, "Recovery days:" +baseExercise.getRecoveryDays());

                ExerciseList.getInstance().addExercise(baseExercise);
            }
        });

                addExerciseViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        //textView.setText(s);
                    }
                });
        return view;
    }

    public Boolean compoundToBool (String exerciseType) {
        if (exerciseType.equals("Compound")) {
            return true;
        } else {
            return false;
        }
    }
}

