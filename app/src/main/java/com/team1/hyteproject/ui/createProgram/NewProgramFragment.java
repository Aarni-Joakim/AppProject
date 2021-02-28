package com.team1.hyteproject.ui.createProgram;

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
import com.team1.hyteproject.enums.Experience;
import com.team1.hyteproject.enums.Focus;
import com.team1.hyteproject.enums.Goal;
import com.team1.hyteproject.program.ExerciseList;
import com.team1.hyteproject.program.ProgramGenerator;

public class NewProgramFragment extends Fragment {

    private static final String TAG = "NewProgramFragment";

    private NewProgramViewModel newProgramViewModel;

    private Button createProgram;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newProgramViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(NewProgramViewModel.class);
        View view = inflater.inflate(R.layout.fragment_new_program, container, false);
        //TextView textView = view.findViewById(R.id.textView);
        Log.d(TAG, "onCreateView: start.");

        createProgram = view.findViewById(R.id.createAddShared);

        ((HomeActivity)getActivity()).updateStatusBarColor("#202124");

        createProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ExerciseList exerciseList = ExerciseList.getInstance();

                Log.d(TAG, "createWorkout clicked.");
                ProgramGenerator programGenerator = new ProgramGenerator("testing", Focus.CHEST, Goal.STRENGTH, 17, 5, Experience.BEGINNER, 8, 3);
            }
        });

                newProgramViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        //textView.setText(s);
                    }
                });
        return view;
    }
}

