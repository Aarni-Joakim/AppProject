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
/**
 * @Author Aarni Pesonen, Johannes Jokinen
 * Custom adapter for displaying BaseExercise objects in programExerciseListView
 */
public class ExerciseViewAdapter extends ArrayAdapter<BaseExercise> {

    public ExerciseViewAdapter(@NonNull Context context, ArrayList<BaseExercise> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View ExerciseItemView = convertView;

        //sets layout for view
        if (ExerciseItemView == null) {
            ExerciseItemView = LayoutInflater.from(getContext()).inflate(R.layout.program_exercise_list3, parent, false);
        }

        //get item position
        BaseExercise currentNumberPosition = getItem(position);

        TextView exerciseName = ExerciseItemView.findViewById(R.id.programExerciseNameDisplay);
        exerciseName.setText(currentNumberPosition.getName());

        TextView exerciseSets = ExerciseItemView.findViewById(R.id.setsNumberText);
        exerciseSets.setText(currentNumberPosition.getSets());

        TextView exerciseReps = ExerciseItemView.findViewById(R.id.repsNumberText);
        exerciseReps.setText(currentNumberPosition.getReps());

        return ExerciseItemView;
    }
}
