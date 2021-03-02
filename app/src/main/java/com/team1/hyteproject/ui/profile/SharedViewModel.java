package com.team1.hyteproject.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SharedViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("User Profile1");
    }

    public LiveData<String> getText() {
        return mText;
    }
}