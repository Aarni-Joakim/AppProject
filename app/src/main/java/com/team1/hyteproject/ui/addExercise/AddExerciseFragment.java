package com.team1.hyteproject.ui.addExercise;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.team1.hyteproject.HomeActivity;
import com.team1.hyteproject.R;
import com.team1.hyteproject.program.ExerciseList;

public class AddExerciseFragment extends Fragment {

    private static final String TAG = "AddExerciseFragment";

    private AddExerciseViewModel addExerciseViewModel;

    private Button addNewExercise;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addExerciseViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(AddExerciseViewModel.class);
        View view = inflater.inflate(R.layout.fragment_add_exercise, container, false);
        //TextView textView = view.findViewById(R.id.textView);
        Log.d(TAG, "onCreateView: start.");

        addNewExercise = view.findViewById(R.id.createAddShared);

        ((HomeActivity)getActivity()).updateStatusBarColor("#202124");

        addNewExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ExerciseList exerciseList = ExerciseList.getInstance();

                Log.d(TAG, "addExercise clicked.");
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
}

