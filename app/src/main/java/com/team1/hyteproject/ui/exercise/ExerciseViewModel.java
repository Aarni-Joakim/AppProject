package com.team1.hyteproject.ui.exercise;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class ExerciseViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ExerciseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("List of exercises. Create exercise.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}