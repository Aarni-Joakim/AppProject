package com.team1.hyteproject.ui.exercise;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.team1.hyteproject.R;

public class ExerciseFragment extends Fragment {

    private FloatingActionButton fabMenu;
    private FloatingActionButton fabCreateExercise;
    private FloatingActionButton fabEditExercise;

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