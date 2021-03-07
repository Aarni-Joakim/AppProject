package com.team1.hyteproject.ui;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.team1.hyteproject.program.BaseExercise;
import com.team1.hyteproject.program.Program;
import com.team1.hyteproject.program.ProgramsList;
import com.team1.hyteproject.ui.profile.User;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import static android.content.Context.MODE_PRIVATE;


public class SaveLoad  {

    private static final String TAG = "SaveLoad";
    private static final String PROGRAM_TAG = "programList";
    private static final String INDEX_TAG = "index";
    private static final String USER_TAG = "userData";
    //private ArrayList loadedList = new ArrayList();
    //private ArrayList<Program> programsList = new ArrayList<>();
    private SharedPreferences sharedPreferences;
    private ArrayList<Program> loadedList = new ArrayList<>();
    private ArrayList<Program> programsList = new ArrayList<>();
    private ProgramsList completeProgramsList;
    private int listIndex;

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
        prefEditor.putInt(INDEX_TAG, index);
        prefEditor.commit();
        Log.d(TAG, "Saving list index");
    }

    public int loadListIndex(Context context) {

        sharedPreferences = getSharedPreferences(context);
        listIndex = sharedPreferences.getInt(INDEX_TAG, 0);

        Log.d(TAG, "Loaded list index was: " + listIndex);
        Log.d(TAG, "Loading");

        return listIndex;
    }

    public void saveDataList(Context context, ArrayList arrayList, String listName) {
        sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        prefEditor.putString(listName, json);
        prefEditor.apply();
        Log.d(TAG, "Saving");
    }

    //SAVE USER DATA AS OBJECT
    public void saveUserObject(Context context, Object objectValue) {
        sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String userObject = gson.toJson(objectValue);
        prefEditor.putString(USER_TAG, userObject);
        prefEditor.commit();
        Log.d(TAG, "Saving");
    }

    //LOAD USER DATA OBJECT
    public Object loadUserObject(Context context, Class targetClass) {
        sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        Object userList = sharedPreferences.getString(USER_TAG, null);
        //Type programsListType = new TypeToken<Class<ProgramsList>>() {}.getType();
        if(userList != null)
            userList = gson.fromJson((String)userList, targetClass);
        else
            Log.d(TAG, "Loaded user list was null");

        Log.d(TAG, "Loading User object");
        return userList;
    }

    //SAVE PROGRAMSLIST AS OBJECT
    public void saveProgramListObject(Context context, Object objectValue) {
        sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(objectValue);
        prefEditor.putString(PROGRAM_TAG, json);
        prefEditor.commit();
        Log.d(TAG, "Saving");
    }

    //LOAD PROGRAMSLIST AS OBJECT
    public Object loadProgramListObject(Context context, Class targetClass) {
        sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        Object programsList = sharedPreferences.getString(PROGRAM_TAG, null);
        //Type programsListType = new TypeToken<Class<ProgramsList>>() {}.getType();
        if(programsList != null)
        programsList = gson.fromJson((String)programsList, targetClass);
        else
            Log.d(TAG, "Loaded programs list was null");

        Log.d(TAG, "Loading ProgramsList object");
        return programsList;
    }


    public ArrayList loadProgramList(Context context) {

        sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(PROGRAM_TAG, null);
        Type type = new TypeToken<Collection<Program>>() {}.getType();
        this.programsList = gson.fromJson(json, type);

        if (programsList == null) {
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
    public ArrayList getProgramsList() {
        return programsList;
    }
}
