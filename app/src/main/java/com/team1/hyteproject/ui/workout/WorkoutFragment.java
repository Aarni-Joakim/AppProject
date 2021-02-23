package com.team1.hyteproject.ui.workout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.team1.hyteproject.R;

public class WorkoutFragment extends Fragment {

    private static final String TAG = "WorkoutFragment";
    private WorkoutViewModel workoutViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        workoutViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(WorkoutViewModel.class);
        View view = inflater.inflate(R.layout.fragment_workout, container, false);
        TextView textView = view.findViewById(R.id.textViewWorkout);
        Log.d(TAG, "onCreateView: start.");

        workoutViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return view;
    }

}