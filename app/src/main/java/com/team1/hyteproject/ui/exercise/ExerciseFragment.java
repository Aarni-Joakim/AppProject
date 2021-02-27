package com.team1.hyteproject.ui.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.team1.hyteproject.R;

public class ExerciseFragment extends Fragment {

    private static final String TAG = "ExerciseFragment";
    private ExerciseViewModel exerciseViewModel;

    private FloatingActionButton addExercise;
    private FloatingActionButton modifyExercise;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        exerciseViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ExerciseViewModel.class);
        View view = inflater.inflate(R.layout.fragment_exercise, container, false);
        TextView textView = view.findViewById(R.id.textViewExercise);
        Log.d(TAG, "onCreateView: start.");

        addExercise = view.findViewById(R.id.addExercise);
        modifyExercise = view.findViewById(R.id.modifyExercise);

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

                Log.d(TAG, "generateWorkout clicked. Trying to add calendar event");

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE, TAG);
                intent.putExtra(CalendarContract.Events.DESCRIPTION, TAG);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, TAG);
                intent.putExtra(CalendarContract.Events.ALL_DAY, true);

                getActivity().startActivity(intent);
            }
        });

        exerciseViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return view;
    }

}