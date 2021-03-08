package com.team1.hyteproject.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.team1.hyteproject.R;
import com.team1.hyteproject.program.BaseExercise;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ExerciseViewAdapter extends ArrayAdapter<BaseExercise> {

    // invoke the suitable constructor of the ArrayAdapter class
    public ExerciseViewAdapter(@NonNull Context context, ArrayList<BaseExercise> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View ExerciseItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (ExerciseItemView == null) {
            ExerciseItemView = LayoutInflater.from(getContext()).inflate(R.layout.program_exercise_list3, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        BaseExercise currentNumberPosition = getItem(position);

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView exerciseName = ExerciseItemView.findViewById(R.id.programExerciseNameDisplay);
        exerciseName.setText(currentNumberPosition.getName());

        TextView exerciseSets = ExerciseItemView.findViewById(R.id.setsNumberText);
        exerciseSets.setText(currentNumberPosition.getSets());

        TextView exerciseReps = ExerciseItemView.findViewById(R.id.repsNumberText);
        exerciseReps.setText(currentNumberPosition.getReps());


        // then according to the position of the view assign the desired TextView 2 for the same
        //TextView nextWorkoutDate = ProgramItemView.findViewById(R.id.nextWorkoutDateText);
        //nextWorkoutDate.setText(currentNumberPosition.getNumbersInText());


        // then return the recyclable view
        return ExerciseItemView;
    }
}
