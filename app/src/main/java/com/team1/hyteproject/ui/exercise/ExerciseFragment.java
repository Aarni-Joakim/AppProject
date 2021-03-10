package com.team1.hyteproject.ui.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.team1.hyteproject.R;
import com.team1.hyteproject.program.ExerciseList;
import com.team1.hyteproject.ui.ExerciseListViewAdapter;
import com.team1.hyteproject.ui.ProgramViewAdapter;

/**
 * @Author Aarni Pesonen
 * Displays a list of all exercises included in the app
 * List is stored in ExerciseList Singleton
 */
public class ExerciseFragment extends Fragment {

    private static final String TAG = "ExerciseFragment";

    private FloatingActionButton addExercise;
    private FloatingActionButton modifyExercise;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all_exercise_list, container, false);
        Log.d(TAG, "onCreateView: start.");

        addExercise = view.findViewById(R.id.addExercise);
        modifyExercise = view.findViewById(R.id.modifyExercise);

        ExerciseListViewAdapter exerciseListViewAdapter = new ExerciseListViewAdapter(getActivity(), ExerciseList.getInstance().getAllUpperBodyExercises());
        ListView exerciseListView = view.findViewById(R.id.exerciseAllListView);
        exerciseListView.setAdapter(exerciseListViewAdapter);

        addExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "addExercise clicked.");
            }
        });

        modifyExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "modifyExercise clicked.");

                Toast.makeText(getActivity(), "Feature not yet implemented.", Toast.LENGTH_SHORT).show();
            }
        });

        addExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "generateProgram clicked.");

                Navigation.findNavController(view).navigate(R.id.action_navigation_exercise_to_navigation_add_exercise);
            }
        });

        return view;
    }

}