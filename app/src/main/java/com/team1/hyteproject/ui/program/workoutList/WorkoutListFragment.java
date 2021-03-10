package com.team1.hyteproject.ui.program.workoutList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.team1.hyteproject.HomeActivity;
import com.team1.hyteproject.R;
import com.team1.hyteproject.program.BaseExercise;
import com.team1.hyteproject.program.Program;
import com.team1.hyteproject.program.ProgramsList;
import com.team1.hyteproject.program.Workout;
import com.team1.hyteproject.ui.SaveLoad;
import com.team1.hyteproject.ui.SharedViewModel;
import com.team1.hyteproject.ui.WorkoutViewAdapter;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @@Author Aarni Pesonen
 * Lists all workouts inside an individual program
 */
public class WorkoutListFragment extends Fragment {

    private static final String TAG = "WorkoutListFragment";

    private SaveLoad saveLoad = SaveLoad.getInstance();
    private ListView workoutListView;
    private Button testButton;
    private int programIndex;

    private ArrayList<Program> programsList = new ArrayList<>();
    /*private ArrayList<BaseExercise> programExercises;
    private ArrayList<Workout> workoutList;*/

    private ProgramsList completeProgramsList;
    private Program program;
    private Workout workout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_workout_list2, container, false);
        Log.d(TAG, "onCreateView: start.");

        ((HomeActivity)getActivity()).updateStatusBarColor("#303134");
        //load previous listViews program index
        programIndex = saveLoad.loadListIndex(getActivity(), "index");


        Log.d(TAG, "List index: " + programIndex);

        if (completeProgramsList == null) {
            completeProgramsList = (ProgramsList) saveLoad.loadProgramListObject(getActivity(), ProgramsList.class);
        }

        workoutListView = view.findViewById(R.id.workoutListView);
        //load custom listViewAdapter
        WorkoutViewAdapter workoutViewAdapter = new WorkoutViewAdapter(getActivity(), completeProgramsList.getProgram(programIndex).getWorkoutList());
        workoutListView.setAdapter(workoutViewAdapter);

        workoutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> programListView, View view, int i, long l) {
                Log.d("onClick", "onItemClick(" + i + ")");

                saveLoad.saveListIndex(getActivity(), i, "index2");
                //TODO: Implement navigation class with only one method to handle all navigation?
                Navigation.findNavController(view).navigate(R.id.action_navigation_workout_list_to_navigation_program_exercise_list);
            }
        });

        return view;
    }


}

