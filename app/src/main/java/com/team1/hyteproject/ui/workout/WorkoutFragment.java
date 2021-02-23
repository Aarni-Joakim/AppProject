package com.team1.hyteproject.ui.workout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.widget.Toast;

import com.team1.hyteproject.R;

public class WorkoutFragment extends Fragment {

    private static final String TAG = "WorkoutFragment";
    private FloatingActionButton fabMenu;
    private FloatingActionButton fabCreateCustomWorkout;
    private FloatingActionButton fabCreateOwnWorkout;

    private WorkoutViewModel workoutViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        workoutViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(WorkoutViewModel.class);
        View view = inflater.inflate(R.layout.fragment_workout, container, false);
        TextView textView = view.findViewById(R.id.textViewWorkout);

        fabMenu = view.findViewById(R.id.fabMenu);
        fabCreateCustomWorkout = view.findViewById(R.id.fabCreateCustomWorkout);
        fabCreateOwnWorkout = view.findViewById(R.id.fabCreateOwnWorkout);


        workoutViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return view;
    }
}