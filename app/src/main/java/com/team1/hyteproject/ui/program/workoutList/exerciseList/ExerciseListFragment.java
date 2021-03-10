package com.team1.hyteproject.ui.program.workoutList.exerciseList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.team1.hyteproject.CalendarController;
import com.team1.hyteproject.HomeActivity;
import com.team1.hyteproject.R;
import com.team1.hyteproject.enums.ExerciseGroup;
import com.team1.hyteproject.enums.TargetMuscleGroup;
import com.team1.hyteproject.program.BaseExercise;
import com.team1.hyteproject.program.Program;
import com.team1.hyteproject.program.ProgramsList;
import com.team1.hyteproject.program.Workout;
import com.team1.hyteproject.ui.ExerciseViewAdapter;
import com.team1.hyteproject.ui.SaveLoad;
import com.team1.hyteproject.ui.SharedViewModel;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author Aarni Pesonen, Samu Wahlroos
 * Lists all exercises inside an individual program workout
 */
public class ExerciseListFragment extends Fragment {

    private static final String TAG = "WorkoutListFragment";

    private Button addCalendarbutton;
    private ListView exerciseListView;
    private SaveLoad saveLoad = SaveLoad.getInstance();
    private TextView dateView;
    private int programIndex;
    private int workoutIndex;

    private ArrayList<BaseExercise> programExercises = new ArrayList<>();
    private ArrayList<Program> programsList = new ArrayList<>();
    private ProgramsList completeProgramsList;
    private Program program;
    private Workout workout;

    private int index = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_exercise_list3, container, false);
        Log.d(TAG, "onCreateView: start.");
        //gets current calendar date and displays it at the top of workout view
        //TODO: change display to specific workouts workoutDate string value
        dateView = view.findViewById(R.id.dateTextView);
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar.getTime());
        dateView.setText(currentDate);

        exerciseListView = view.findViewById(R.id.exerciseListView);
        addCalendarbutton = view.findViewById(R.id.addCalendarButton);

        ((HomeActivity)getActivity()).updateStatusBarColor("#303134");

        //load listView index values for current program and workout
        programIndex = saveLoad.loadListIndex(getActivity(), "index");
        workoutIndex = saveLoad.loadListIndex(getActivity(), "index2");

        if (completeProgramsList == null) {
            completeProgramsList = (ProgramsList) saveLoad.loadProgramListObject(getActivity(), ProgramsList.class);
        }

        //load custom listViewAdapter
        ExerciseViewAdapter exerciseViewAdapter = new ExerciseViewAdapter(getActivity(), completeProgramsList.getProgram(programIndex).getWorkout(workoutIndex).getExerciseList());
        exerciseListView.setAdapter(exerciseViewAdapter);

        //addCalendar button, add events to google calendar
        addCalendarbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarController calendarController = new CalendarController();
                calendarController.addEvent(getActivity());
            }
        });

        //Include this when exercise specific fragment/view is created
        /*exerciseListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Navigation.findNavController(view).navigate(R.id.action_navigation_workout_list_to_navigation_exercise_list);
            }
        });*/

        return view;
    }

}

