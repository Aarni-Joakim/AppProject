package com.team1.hyteproject.ui;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.team1.hyteproject.program.BaseExercise;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


public class SaveLoad  {

    private static final String TAG = "SaveLoad";
    private ArrayList loadedList = new ArrayList();
    private SharedPreferences sharedPreferences;

    private static final SaveLoad instance = new SaveLoad();

    public static SaveLoad getInstance() { return instance; }

    private SaveLoad() {

    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(TAG, MODE_PRIVATE);
    }

    public void saveDataList(Context context, ArrayList arrayList, String listName) {
        //this.listToSave = arrayList;
        sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        prefEditor.putString(listName, json);
        prefEditor.apply();
        Log.d(TAG, "Saving");
    }

    public ArrayList loadDataList(Context context, String listName) {
        sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(listName, null);
        Type type = new TypeToken<ArrayList<BaseExercise>>() {}.getType();
        ArrayList loadedList = gson.fromJson(json, type);

        if (loadedList == null) {
            loadedList = new ArrayList();
            Log.d(TAG, "Loaded list was null");
        }

        Log.d(TAG, "Loading");
        return loadedList;
    }

    public ArrayList loadUserList(Context context, String listName) {
        sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(listName, null);
        Type type = new TypeToken<ArrayList<BaseExercise>>() {}.getType();
        ArrayList loadedList = gson.fromJson(json, type);

        if (loadedList == null) {
            loadedList = new ArrayList();
            Log.d(TAG, "Loaded list was null");
        }

        Log.d(TAG, "Loading");
        return loadedList;
    }

    public ArrayList loadUsernameList(Context context, String listName) {
        sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(listName, null);
        Type type = new TypeToken<ArrayList<BaseExercise>>() {}.getType();
        ArrayList loadedList = gson.fromJson(json, type);

        if (loadedList == null) {
            loadedList = new ArrayList();
            Log.d(TAG, "Loaded list was null");
        }

        Log.d(TAG, "Loading");
        return loadedList;
    }
}
