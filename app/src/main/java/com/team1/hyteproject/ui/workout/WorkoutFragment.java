package com.team1.hyteproject.ui.workout;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.team1.hyteproject.HomeActivity;
import com.team1.hyteproject.R;

import java.util.Calendar;

public class WorkoutFragment extends Fragment {

    private static final String TAG = "WorkoutFragment";
    private WorkoutViewModel workoutViewModel;

    private FloatingActionButton generateWorkout;
    private FloatingActionButton createWorkout;
    //private Activity activity;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        workoutViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(WorkoutViewModel.class);
        View view = inflater.inflate(R.layout.fragment_workout, container, false);
        TextView textView = view.findViewById(R.id.textViewWorkout);
        Log.d(TAG, "onCreateView: start.");

        generateWorkout = view.findViewById(R.id.generateWorkout);
        createWorkout = view.findViewById(R.id.createWorkout);

        generateWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "generateWorkout clicked. Trying to add calendar event");

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE, TAG);
                intent.putExtra(CalendarContract.Events.DESCRIPTION, TAG);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, TAG);
                intent.putExtra(CalendarContract.Events.ALL_DAY, true);

                getActivity().startActivity(intent);
                /*
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    getActivity().startActivity(intent);
                } else {
                    Log.d(TAG, "No compatible calendar app found");
                    Toast.makeText(getActivity(), "There is no compatible calendar app!", Toast.LENGTH_SHORT).show();
                }*/
            }
            });

        createWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "createWorkout clicked.");
            }
        });

                workoutViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        textView.setText(s);
                    }
                });
        return view;
    }

}

    /*Calendar cal = Calendar.getInstance();
    long endTime;
    long startTime;


                                    cal.set(Calendar.HOUR_OF_DAY, hour);
                                            cal.set(Calendar.MINUTE,min);
                                            cal.set(Calendar.YEAR, year);
                                            cal.set(Calendar.MONTH, month- 1);
                                            cal.set(Calendar.DAY_OF_MONTH,day );


                                            startTime = cal.getTimeInMillis();
                                            endTime = startTime + 30 * 60 * 1000;
                                            String title="TAG" + student.getName();

                                            long event_id = (startTime+endTime)/10000;

                                            Intent intent = new Intent(Intent.ACTION_EDIT);
                                            intent.setType("vnd.android.cursor.item/event");
                                            intent.putExtra("beginTime", startTime);
                                            intent.putExtra("rrule", "FREQ=YEARLY");
                                            intent.putExtra("endTime", endTime);
                                            intent.putExtra("title", title);*/