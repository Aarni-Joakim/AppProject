package com.team1.hyteproject.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Date;


public class SharedViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private final String TAG = "SharedViewModel";

    private Date date;
    private String dateAsString;
    // user profile data
    private int age = 16;
    private String userName;
    private String userEmail;


    public SharedViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Generated workouts will be listed here.");
    }

    public int getAge(){
        return this.age;
    }

    public String dateToString (Date date) {
       return dateAsString = date.toString();
    }

    public String getDate() {
        return dateAsString;
    }

    public LiveData<String> getText() {
        return mText;
    }
}


