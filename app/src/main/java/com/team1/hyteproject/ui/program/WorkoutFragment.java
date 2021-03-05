package com.team1.hyteproject.ui.program;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.team1.hyteproject.HomeActivity;
import com.team1.hyteproject.R;
import com.team1.hyteproject.program.BaseExercise;
import com.team1.hyteproject.program.ExerciseList;
import com.team1.hyteproject.ui.SaveLoad;
import com.team1.hyteproject.ui.SharedViewModel;

import java.util.ArrayList;

public class WorkoutFragment extends Fragment {

    private static final String TAG = "WorkoutFragment";
    private static final String TEST = "Test";

    private SharedViewModel sharedViewModel;

    private FloatingActionButton generateProgram;
    private FloatingActionButton createOwnWorkout;
    private ListView listView;

    private ArrayList<BaseExercise> programExercises;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sharedViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);
        View view = inflater.inflate(R.layout.fragment_workout, container, false);
        //TextView textView = view.findViewById(R.id.textViewWorkout);
        Log.d(TAG, "onCreateView: start.");

        generateProgram = view.findViewById(R.id.generateProgram);
        createOwnWorkout = view.findViewById(R.id.createOwnWorkout);

        ((HomeActivity)getActivity()).updateStatusBarColor("#303134");

        //sharedViewModel.setAge(13);
        //Log.d(TAG, "ikä: " + sharedViewModel.getAge());


        generateProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "generateProgram clicked.");

                Navigation.findNavController(view).navigate(R.id.action_navigation_workout_to_navigation_new_program);
            }
        });

        createOwnWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "createOwnWorkout clicked.");
                Log.d(TAG, "Trying to load programExercisesList.");

                programExercises = new ArrayList();
                Log.d(TAG, "Program exercises index 0: " +programExercises.size());
                programExercises = SaveLoad.getInstance().loadDataList(getActivity(), TEST);
                Log.d(TAG, "Program exercises index 0: " +programExercises.isEmpty());

                ArrayList testList = new ArrayList();
                testList = SaveLoad.getInstance().loadDataList(getActivity(), TEST);
                Log.d(TAG, "testList is empty:"+testList.isEmpty());
            }
        });

                /*SharedViewModel.class.getName().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        textView.setText(s);
                    }
                });*/
        return view;
    }
}

