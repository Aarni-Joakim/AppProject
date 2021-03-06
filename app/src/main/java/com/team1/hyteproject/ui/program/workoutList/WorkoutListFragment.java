package com.team1.hyteproject.ui.program.workoutList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.team1.hyteproject.HomeActivity;
import com.team1.hyteproject.R;
import com.team1.hyteproject.program.BaseExercise;
import com.team1.hyteproject.program.Workout;
import com.team1.hyteproject.ui.SharedViewModel;
import com.team1.hyteproject.ui.WorkoutView;
import com.team1.hyteproject.ui.WorkoutViewAdapter;

import java.util.ArrayList;

/**
 * Author Aarni Pesonen
 */
public class WorkoutListFragment extends Fragment {

    private static final String TAG = "WorkoutListFragment";
    private static final String TEST = "Test";

    private SharedViewModel sharedViewModel;
    private ListView workoutListView;
    private Button testButton;

    private ArrayList<BaseExercise> programExercises;
    private ArrayList<Workout> workouts;

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sharedViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);
        View view = inflater.inflate(R.layout.fragment_workout_list2, container, false);
        //TextView textView = view.findViewById(R.id.textViewWorkout);
        Log.d(TAG, "onCreateView: start.");

        testButton = view.findViewById(R.id.generateProgram);

        ((HomeActivity)getActivity()).updateStatusBarColor("#303134");

        workouts = new ArrayList<>();
        workouts.add(new Workout("06.03.2021", "Noobdev"));

        WorkoutView workoutView = new WorkoutView(workouts.get(0).getWorkoutDate());

        WorkoutViewAdapter workoutViewAdapter = new WorkoutViewAdapter(getActivity(), workouts);
        workoutListView = view.findViewById(R.id.workoutListView);
        workoutListView.setAdapter(workoutViewAdapter);

        workoutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> programListView, View view, int i, long l) {
                Log.d("onClick", "onItemClick(" + i + ")");

                Navigation.findNavController(view).navigate(R.id.action_navigation_workout_list_to_navigation_program_exercise_list);
            }
        });

        return view;
    }
}

