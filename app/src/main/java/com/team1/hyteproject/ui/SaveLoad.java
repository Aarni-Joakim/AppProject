package com.team1.hyteproject.ui;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.team1.hyteproject.program.BaseExercise;
import com.team1.hyteproject.ui.profile.User;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class SaveLoad  {

    private static final String TAG = "SaveLoad";
    private ArrayList loadedList = new ArrayList();

    private static final SaveLoad instance = new SaveLoad();

    public static SaveLoad getInstance() { return instance; }

    private SaveLoad() {

    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
    }

    public void saveDataList(Context context, ArrayList arrayList, String listName) {
        //this.listToSave = arrayList;
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        prefEditor.putString(listName, json);
        prefEditor.apply();
        Log.d(TAG, "Saving");
    }
    public ArrayList loadUserList(Context context, String listName) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(listName, null);
        Type type = new TypeToken<ArrayList<User>>() {}.getType();
        ArrayList loadedList = gson.fromJson(json, type);

        if (loadedList == null) {
            loadedList = new ArrayList();
            Log.d(TAG, "Loaded list was null");
        }

        Log.d(TAG, "Loading");
        return loadedList;
    }

    public ArrayList loadUsernamesList(Context context, String listName) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(listName, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        ArrayList loadedList = gson.fromJson(json, type);

        if (loadedList == null) {
            loadedList = new ArrayList();
            Log.d(TAG, "Loaded list was null");
        }

        Log.d(TAG, "Loading");
        return loadedList;
    }

    public ArrayList loadDataList(Context context, String listName) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
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
