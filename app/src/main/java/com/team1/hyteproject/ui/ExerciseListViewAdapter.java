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
 * @Author Aarni Pesonen, Johannes Jokinen
 * Custom adapter for displaying all exercises in exerciseListView
 */
public class ExerciseListViewAdapter extends ArrayAdapter<BaseExercise> {

    public ExerciseListViewAdapter(@NonNull Context context, ArrayList<BaseExercise> arrayList) {

        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View ExerciseListItemView = convertView;

        //sets layout for view
        if (ExerciseListItemView == null) {
            ExerciseListItemView = LayoutInflater.from(getContext()).inflate(R.layout.exercise_list_layout, parent, false);
        }

        //get item position
        BaseExercise currentNumberPosition = getItem(position);

        TextView exerciseName = ExerciseListItemView.findViewById(R.id.exerciseListNameDisplay);
        exerciseName.setText(currentNumberPosition.getName());

        TextView exerciseTargetMuscleGroup = ExerciseListItemView.findViewById(R.id.targetMuscleGroupDisplay);
        exerciseTargetMuscleGroup.setText(currentNumberPosition.getTargetMuscleGroup().toString());

        TextView exerciseGroup = ExerciseListItemView.findViewById(R.id.exerciseListExerciseGroupDisplay);
        exerciseGroup.setText(currentNumberPosition.getExerciseGroup().toString());

        return ExerciseListItemView;
    }
}
