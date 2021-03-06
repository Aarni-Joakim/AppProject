package com.team1.hyteproject.ui.program.workoutList.exerciseList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.team1.hyteproject.HomeActivity;
import com.team1.hyteproject.R;
import com.team1.hyteproject.program.BaseExercise;
import com.team1.hyteproject.ui.SharedViewModel;

import java.util.ArrayList;

public class ExerciseListFragment extends Fragment {

    private static final String TAG = "WorkoutListFragment";
    private static final String TEST = "Test";

    private SharedViewModel sharedViewModel;

    private Button testButton;

    private ArrayList<BaseExercise> programExercises;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sharedViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);
        View view = inflater.inflate(R.layout.program_list1, container, false);
        //TextView textView = view.findViewById(R.id.textViewWorkout);
        Log.d(TAG, "onCreateView: start.");

        testButton = view.findViewById(R.id.generateProgram);

        ((HomeActivity)getActivity()).updateStatusBarColor("#303134");

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "generateProgram clicked.");

                Navigation.findNavController(view).navigate(R.id.action_navigation_workout_to_navigation_new_program);
            }
        });

        return view;
    }
}

