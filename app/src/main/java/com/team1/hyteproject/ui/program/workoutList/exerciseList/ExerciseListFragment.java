package com.team1.hyteproject.ui.program.workoutList.exerciseList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.team1.hyteproject.HomeActivity;
import com.team1.hyteproject.R;
import com.team1.hyteproject.enums.ExerciseGroup;
import com.team1.hyteproject.enums.TargetMuscleGroup;
import com.team1.hyteproject.program.BaseExercise;
import com.team1.hyteproject.program.Program;
import com.team1.hyteproject.program.Workout;
import com.team1.hyteproject.ui.ExerciseViewAdapter;
import com.team1.hyteproject.ui.ProgramViewAdapter;
import com.team1.hyteproject.ui.SaveLoad;
import com.team1.hyteproject.ui.SharedViewModel;

import java.util.ArrayList;

public class ExerciseListFragment extends Fragment {

    private static final String TAG = "WorkoutListFragment";
    private static final String TEST = "Test";

    private SharedViewModel sharedViewModel;
    private SaveLoad saveLoad = SaveLoad.getInstance();
    private ListView exerciseListView;
    private int listIndex;

    private ArrayList<BaseExercise> programExercises = new ArrayList<>();
    private ArrayList<Program> programsList = new ArrayList<>();
    private Program program;
    private Workout workout;

    private int index = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sharedViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);
        View view = inflater.inflate(R.layout.fragment_exercise_list3, container, false);
        //TextView textView = view.findViewById(R.id.textViewWorkout);
        Log.d(TAG, "onCreateView: start.");

        exerciseListView = view.findViewById(R.id.exerciseListView);

        ((HomeActivity)getActivity()).updateStatusBarColor("#303134");

        listIndex = saveLoad.loadListIndex(getActivity());


        Program program = new Program("Testiohjelma");
        workout = new Workout("07.03", "Legs");
        workout.addExercise(new BaseExercise("Hauberikääntö", TargetMuscleGroup.BICEPS, "4", "8-12"));
        workout.addExercise(new BaseExercise("Hauberikääntö2", TargetMuscleGroup.BICEPS, "4", "8-12"));
        program.addWorkout(workout);
        programsList.add(program);
        Program program2 = new Program("noob program");
        programsList.add(program2);

        ExerciseViewAdapter exerciseViewAdapter = new ExerciseViewAdapter(getActivity(), program.getWorkout(index).getExerciseList());
        exerciseListView.setAdapter(exerciseViewAdapter);
        BaseExercise baseExercise = new BaseExercise("noob", 5, 5, 5, true, TargetMuscleGroup.BICEPS, ExerciseGroup.LOWER_BODY);
        programExercises.add(baseExercise);

        /*exerciseListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "generateProgram clicked.");

                //Navigation.findNavController(view).navigate(R.id.action_navigation_workout_list_to_navigation_exercise_list);
            }
        });*/

        return view;
    }
}

