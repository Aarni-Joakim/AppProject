package com.team1.hyteproject.ui.program;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.team1.hyteproject.HomeActivity;
import com.team1.hyteproject.R;
import com.team1.hyteproject.enums.TargetMuscleGroup;
import com.team1.hyteproject.program.BaseExercise;
import com.team1.hyteproject.program.Program;
import com.team1.hyteproject.program.Workout;
import com.team1.hyteproject.ui.ProgramViewAdapter;
import com.team1.hyteproject.ui.SaveLoad;
import com.team1.hyteproject.ui.SharedViewModel;
import com.team1.hyteproject.ui.profile.User;

import java.util.ArrayList;

public class ProgramFragment extends Fragment {

    private static final String TAG = "ProgramFragment";
    private static final String TEST = "Test";

    private SharedViewModel sharedViewModel;
    private SaveLoad saveLoad = SaveLoad.getInstance();

    private FloatingActionButton generateProgram;
    private FloatingActionButton createOwnWorkout;

    private ArrayList<Program> programs = new ArrayList<>();
    private ArrayList<BaseExercise> programExercises;
    private ArrayList<BaseExercise> programExercises2;
    private ArrayList<Program> programsList;
    private ArrayList<Program> loaderCache;

    private Workout workout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sharedViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);
        View view = inflater.inflate(R.layout.fragment_program1, container, false);
        //TextView textView = view.findViewById(R.id.textViewWorkout);
        Log.d(TAG, "onCreateView: start.");

        generateProgram = view.findViewById(R.id.generateProgram);
        createOwnWorkout = view.findViewById(R.id.createOwnWorkout);

        ((HomeActivity)getActivity()).updateStatusBarColor("#303134");

        /*Program program = new Program("test program");
        programs.add(program);
        Program program2 = new Program("noob program");
        programs.add(program2);
        Program program3 = new Program("noob program2");
        programs.add(program3);
        Program program4 = new Program("noob program3");
        programs.add(program4);*/

        programsList = new ArrayList<>();
        loaderCache = new ArrayList<>();
        //ProgramView programView = new ProgramView(programs.get(0).getProgramName());

        // the context and arrayList created above

        // create the instance of the ListView to set the numbersViewAdapter

        // set the numbersViewAdapter for ListView

        //ATTEMPTING TO LOAD programsLIST IF NULL. IF LOADED LIST NOT NULL, LOAD STORED LIST.
        if (programsList == null) {
            loaderCache = saveLoad.loadProgramList(getActivity(), "programsList");
            if (loaderCache != null){
                programsList = loaderCache;
            }

        }
        Log.d(TAG, "Total programs in list: " + programsList.size());

        //Custom ProgramViewAdapter
        ProgramViewAdapter programViewAdapter = new ProgramViewAdapter(getActivity(), programsList);
        ListView programListView = view.findViewById(R.id.programListView);
        programListView.setAdapter(programViewAdapter);


            Program program = new Program("Testiohjelma");
            workout = new Workout();
            workout.addExercise(new BaseExercise("Hauberikääntö", TargetMuscleGroup.BICEPS, "4", "8-12"));
            workout.addExercise(new BaseExercise("Hauberikääntö2", TargetMuscleGroup.BICEPS, "4", "8-12"));
            program.addWorkout(new Workout("07.03.2020", "Legs"));
            programsList.add(program);
            Program program2 = new Program("noob program");
            programsList.add(program2);




        ArrayList<User> users = SaveLoad.getInstance().loadUserList(getActivity(), "users");

        /*if (users != null) {
            for (int i = 0; i < users.size(); i++)
            Log.d(TAG, "users list names: " + users.get(i).getUserName());
        }
        programExercises2 = SaveLoad.getInstance().loadDataList(getActivity(), "Test");*/

        //FIND OUT WHAT HAPPENS HERE
        if (programExercises2 != null) {
            for (int i = 0; i < programExercises2.size(); i++) {
                Log.d(TAG, "Program exercises contains: " + programExercises2.get(i).getName() +" " + programExercises2.get(i).getTargetMuscleGroup());
            }

            Log.d(TAG, "programExercises is empty: " + programExercises2.isEmpty());
            if (programExercises2 == null) {
                Log.d(TAG, "programExercises is null.");
            }
        }

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
                programExercises = SaveLoad.getInstance().loadProgramList(getActivity(), TEST);
                Log.d(TAG, "Program exercises index 0: " +programExercises.isEmpty());

                ArrayList testList = new ArrayList();
                testList = SaveLoad.getInstance().loadProgramList(getActivity(), TEST);
                Log.d(TAG, "testList is empty:"+testList.isEmpty());
            }
        });

        programListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> programListView, View view, int i, long l) {
                Log.d("onClick", "onItemClick(" + i + ")");
                saveLoad.saveListIndex(getActivity(), i);
                Navigation.findNavController(view).navigate(R.id.action_navigation_program_to_navigation_workout_list);
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

