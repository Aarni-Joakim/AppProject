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

    public ProgramViewAdapter(@NonNull Context context, ArrayList<Program> arrayList) {

        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View ProgramItemView = convertView;

        if (ProgramItemView == null) {
            ProgramItemView = LayoutInflater.from(getContext()).inflate(R.layout.program_list_layout, parent, false);
        }

        Program currentNumberPosition = getItem(position);

        TextView programName = ProgramItemView.findViewById(R.id.programNameDisplay);
        programName.setText(currentNumberPosition.getProgramName());

        //TextView nextWorkoutDate = ProgramItemView.findViewById(R.id.nextWorkoutDateText);
        //nextWorkoutDate.setText(currentNumberPosition.getNumbersInText());

        ProgressBar programProgress = ProgramItemView.findViewById(R.id.programProgressBar);
        //programProgress.

        return ProgramItemView;
    }
}
