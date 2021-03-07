package com.team1.hyteproject.ui;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.team1.hyteproject.program.BaseExercise;
import com.team1.hyteproject.program.Program;
import com.team1.hyteproject.ui.profile.User;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


public class SaveLoad  {

    private static final String TAG = "SaveLoad";
    private static final String PROGRAM_TAG = "programList";
    private static final String INDEX_TAG = "index";
    private ArrayList loadedList = new ArrayList();
    private ArrayList<Program> programsList;
    private SharedPreferences sharedPreferences;

    private static final SaveLoad instance = new SaveLoad();

    public static SaveLoad getInstance() { return instance; }

    private SaveLoad() {

    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(TAG, MODE_PRIVATE);
    }

    public void saveListIndex (Context context, int index) {
        sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        //Gson gson = new Gson();
        //String json = gson.toJson(index);
        prefEditor.putInt(INDEX_TAG, index);
        prefEditor.apply();
        Log.d(TAG, "Saving list index");
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

    public void saveProgramList(Context context, ArrayList arrayList) {
        //this.listToSave = arrayList;
        sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        prefEditor.putString(PROGRAM_TAG, json);
        prefEditor.apply();
        Log.d(TAG, "Saving");
    }

    public ArrayList loadExerciseList(Context context, String listName) {
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

    public int loadListIndex(Context context) {

        sharedPreferences = getSharedPreferences(context);
        int listIndex = sharedPreferences.getInt(TAG, 0);

            Log.d(TAG, "Loaded list index was: " + listIndex);
            Log.d(TAG, "Loading");

        return listIndex;
    }

    public ArrayList loadDataList(Context context, String listName) {

        sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(TAG, null);
        Type type = new TypeToken<ArrayList<Program>>() {}.getType();
        ArrayList loadedList = gson.fromJson(json, type);

        if (loadedList == null) {
            loadedList = new ArrayList();
            Log.d(TAG, "Loaded programList was null");
        }

        Log.d(TAG, "Loading");
        return loadedList;
    }

    public ArrayList loadProgramList(Context context, String listName) {

        sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(PROGRAM_TAG, null);
        Type type = new TypeToken<ArrayList<Program>>() {}.getType();
        ArrayList loadedList = gson.fromJson(json, type);

        if (loadedList == null) {
            loadedList = new ArrayList();
            Log.d(TAG, "Loaded programList was null");
        }

        Log.d(TAG, "Loading");
        return loadedList;
    }

    public ArrayList loadProgramListTest(Context context, String listName) {

        sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(listName, null);
        Type type = new TypeToken<ArrayList<Program>>() {
        }.getType();
        ArrayList loadedList = gson.fromJson(json, type);

        if (loadedList == null) {
            loadedList = new ArrayList();
            Log.d(TAG, "Loaded programList was null");
        }

        Log.d(TAG, "Loading");
        return loadedList;
    }

        public ArrayList loadUserList(Context context, String listName) {
        sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(listName, null);
        Type type = new TypeToken<ArrayList<User>>() {}.getType();
        ArrayList loadedList = gson.fromJson(json, type);

        if (loadedList == null) {
            //loadedList = new ArrayList();
            Log.d(TAG, "Loaded users list was null");
        }

        Log.d(TAG, "Loading");
        return loadedList;
    }

    public ArrayList loadUsernameList(Context context, String listName) {
        sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(listName, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        ArrayList loadedList = gson.fromJson(json, type);

        if (loadedList == null) {
            loadedList = new ArrayList();
            Log.d(TAG, "Loaded username list was null");
        }

        Log.d(TAG, "Loading");
        return loadedList;
    }
}
