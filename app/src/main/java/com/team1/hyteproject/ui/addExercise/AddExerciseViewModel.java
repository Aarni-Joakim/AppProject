package com.team1.hyteproject.ui.addExercise;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddExerciseViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AddExerciseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Add new exercise");
    }

    public LiveData<String> getText() {
        return mText;
    }
}