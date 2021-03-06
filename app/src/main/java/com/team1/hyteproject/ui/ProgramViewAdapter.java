package com.team1.hyteproject.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.team1.hyteproject.R;
import com.team1.hyteproject.program.Program;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class ProgramViewAdapter extends ArrayAdapter<Program> {

    // invoke the suitable constructor of the ArrayAdapter class
    public ProgramViewAdapter(@NonNull Context context, ArrayList<Program> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View ProgramItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (ProgramItemView == null) {
            ProgramItemView = LayoutInflater.from(getContext()).inflate(R.layout.program_list_layout, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        Program currentNumberPosition = getItem(position);


        // then according to the position of the view assign the desired TextView 1 for the same
        TextView programName = ProgramItemView.findViewById(R.id.programNameDisplay);
        programName.setText(currentNumberPosition.getProgramName());

        // then according to the position of the view assign the desired TextView 2 for the same
        //TextView nextWorkoutDate = ProgramItemView.findViewById(R.id.nextWorkoutDateText);
        //nextWorkoutDate.setText(currentNumberPosition.getNumbersInText());

        ProgressBar programProgress = ProgramItemView.findViewById(R.id.programProgressBar);
        //programProgress.

        // then return the recyclable view
        return ProgramItemView;
    }
}
