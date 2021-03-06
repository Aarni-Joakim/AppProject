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

public class WorkoutViewAdapter extends ArrayAdapter<Workout> {

    // invoke the suitable constructor of the ArrayAdapter class
    public WorkoutViewAdapter(@NonNull Context context, ArrayList<Workout> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View WorkoutItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (WorkoutItemView == null) {
            WorkoutItemView = LayoutInflater.from(getContext()).inflate(R.layout.program_workout_list_layout2, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        Workout currentNumberPosition = getItem(position);

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView workoutDate = WorkoutItemView.findViewById(R.id.workoutDateDisplay);
        workoutDate.setText(currentNumberPosition.getWorkoutDate());

        // GET FROM MUSCLE GROUP MAJORITY
        TextView workoutType = WorkoutItemView.findViewById(R.id.workoutTypeDisplay);
        workoutType.setText(currentNumberPosition.getWorkoutType());

        // then according to the position of the view assign the desired TextView 2 for the same
        //TextView nextWorkoutDate = ProgramItemView.findViewById(R.id.nextWorkoutDateText);
        //nextWorkoutDate.setText(currentNumberPosition.getNumbersInText());


        // then return the recyclable view
        return WorkoutItemView;
    }
}
