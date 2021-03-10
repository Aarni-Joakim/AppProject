package com.team1.hyteproject.ui.program;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.team1.hyteproject.CalendarController;
import com.team1.hyteproject.HomeActivity;
import com.team1.hyteproject.R;
import com.team1.hyteproject.enums.TargetMuscleGroup;
import com.team1.hyteproject.program.BaseExercise;
import com.team1.hyteproject.program.Program;
import com.team1.hyteproject.program.ProgramsList;
import com.team1.hyteproject.program.Workout;
import com.team1.hyteproject.ui.ProgramViewAdapter;
import com.team1.hyteproject.ui.SaveLoad;
import com.team1.hyteproject.ui.SharedViewModel;
import com.team1.hyteproject.ui.profile.User;

import java.util.ArrayList;

/**
 * @author Aarni Pesonen
 * Displays a list of all user generated programs
 * Lists are stored inside ProgramsList class
 */
public class ProgramFragment extends Fragment {

    private static final String TAG = "ProgramFragment";

    private SaveLoad saveLoad = SaveLoad.getInstance();

    private FloatingActionButton generateProgram;
    private FloatingActionButton createOwnWorkout;

    private ArrayList<Program> programs = new ArrayList<>();
    private ProgramsList completeProgramsList;
    private Program program;
    private Workout workout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_program1, container, false);
        Log.d(TAG, "onCreateView: start.");

        generateProgram = view.findViewById(R.id.generateProgram);
        createOwnWorkout = view.findViewById(R.id.createOwnWorkout);

        ((HomeActivity)getActivity()).updateStatusBarColor("#303134");

        //LOAD SAVED ABSTRACT OBJECT AND CAST IT TO ProgramsList OBJECT.
        //Figuring this out based on documentation felt like a breakthrough moment
        //This however broke compatibility with Nexus 5 (API 26) emulator
        completeProgramsList = (ProgramsList) saveLoad.loadProgramListObject(getActivity(), ProgramsList.class);

        if (completeProgramsList == null){
            completeProgramsList = new ProgramsList();
            Log.d(TAG, "complete programs list was null");
        }
        else {
            Log.d(TAG, "complete programs list size: " + completeProgramsList.getProgramsList().size());
        }

        //load custom programViewAdapter
        ProgramViewAdapter programViewAdapter = new ProgramViewAdapter(getActivity(), completeProgramsList.getProgramsList());
        ListView programListView = view.findViewById(R.id.programListView);
        programListView.setAdapter(programViewAdapter);

        //Navigate to CreateProgramFragment
        generateProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "generateProgram clicked.");

                //NEEDS TO BE IN SHARED PREFS OR CRASH (FIXED)
                saveLoad.saveProgramListObject(getActivity(), completeProgramsList);
                Navigation.findNavController(view).navigate(R.id.action_navigation_workout_to_navigation_new_program);
            }
        });
        //Floating action button onClickListener
        createOwnWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Feature not yet implemented.", Toast.LENGTH_SHORT).show();

            }
        });

        //programsListView onItemClickListener
        programListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> programListView, View view, int i, long l) {
                Log.d("onClick", "onItemClick(" + i + ")");
                saveLoad.saveListIndex(getActivity(), i, "index");
                Navigation.findNavController(view).navigate(R.id.action_navigation_program_to_navigation_workout_list);
            }
        });

        return view;
    }
}

