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
import com.team1.hyteproject.program.Workout;

import java.util.ArrayList;
/**
 * Author Aarni Pesonen, Johannes Jokinen
 * For displaying Workout objects in workoutListView
 */
public class WorkoutViewAdapter extends ArrayAdapter<Workout> {

    public WorkoutViewAdapter(@NonNull Context context, ArrayList<Workout> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View WorkoutItemView = convertView;

        //sets layout for view
        if (WorkoutItemView == null) {
            WorkoutItemView = LayoutInflater.from(getContext()).inflate(R.layout.program_workout_list_layout2, parent, false);
        }

        //get item position
        Workout currentNumberPosition = getItem(position);

        TextView workoutDate = WorkoutItemView.findViewById(R.id.workoutDateDisplay);
        workoutDate.setText(currentNumberPosition.getWorkoutDate());

        TextView workoutType = WorkoutItemView.findViewById(R.id.programExerciseNameDisplay);
        workoutType.setText(currentNumberPosition.getWorkoutType());

        return WorkoutItemView;
    }
}
