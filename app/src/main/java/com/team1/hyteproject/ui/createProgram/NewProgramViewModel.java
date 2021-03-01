package com.team1.hyteproject.ui.createProgram;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewProgramViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NewProgramViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Generate a new program");
    }

    public LiveData<String> getText() {
        return mText;
    }
}