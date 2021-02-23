package com.team1.hyteproject.ui.workout;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class WorkoutViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WorkoutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Generated workouts will be listed here.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}