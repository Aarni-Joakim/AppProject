package com.team1.hyteproject.ui.exercise;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.team1.hyteproject.R;
import com.team1.hyteproject.ui.workout.WorkoutViewModel;

public class ExerciseFragment extends Fragment {

    private ExerciseViewModel exerciseViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        exerciseViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ExerciseViewModel.class);
        View view = inflater.inflate(R.layout.fragment_exercise, container, false);
        TextView textView = view.findViewById(R.id.textViewExercise);
        exerciseViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return view;
    }
}