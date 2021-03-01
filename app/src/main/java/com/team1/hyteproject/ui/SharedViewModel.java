package com.team1.hyteproject.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



public class SharedViewModel extends ViewModel {


    private final String TAG = "SharedViewModel";

    private MutableLiveData<String> mText;

    private int age = 16;

    public SharedViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Generated workouts will be listed here.");
    }

    public int getAge(){
        return this.age;
    }

    public LiveData<String> getText() {
        return mText;
    }
}


