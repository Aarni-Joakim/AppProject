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

import java.util.ArrayList;

/**
 * Author Aarni Pesonen
 */
public class ExerciseListViewAdapter extends ArrayAdapter<BaseExercise> {

    // invoke the suitable constructor of the ArrayAdapter class
    public ExerciseListViewAdapter(@NonNull Context context, ArrayList<BaseExercise> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View ExerciseListItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (ExerciseListItemView == null) {
            ExerciseListItemView = LayoutInflater.from(getContext()).inflate(R.layout.exercise_list_layout, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        BaseExercise currentNumberPosition = getItem(position);

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView exerciseName = ExerciseListItemView.findViewById(R.id.exerciseListNameDisplay);
        exerciseName.setText(currentNumberPosition.getName());

        TextView exerciseMuscleGroup = ExerciseListItemView.findViewById(R.id.targetMuscleGroupDisplay);
        exerciseName.setText(currentNumberPosition.getTargetMuscleGroup().toString());

        TextView ExerciseGroup = ExerciseListItemView.findViewById(R.id.exerciseListExerciseGroupDisplay);
        exerciseName.setText(currentNumberPosition.getExerciseGroup().toString());


        // then according to the position of the view assign the desired TextView 2 for the same
        //TextView nextWorkoutDate = ProgramItemView.findViewById(R.id.nextWorkoutDateText);
        //nextWorkoutDate.setText(currentNumberPosition.getNumbersInText());


        // then return the recyclable view
        return ExerciseListItemView;
    }
}
