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

/**
 * @author Aarni Pesonen
 * Class to handle saving and loading of data
 * Saved in shared preferences in json gson format
 */
public class SaveLoad  {

    private static final String TAG = "SaveLoad";                       //For Log.d identification
    private static final String PROGRAM_TAG = "programList";            //tag for saved programList
    private static final String INDEX_TAG = "index";                    //tag to find program index in following listView
    private static final String INDEX2_TAG = "index2";                  //tag to find workout index in following listView
    private static final String USER_TAG = "userData";                  //tag to identify saved user data
    private SharedPreferences sharedPreferences;
    //private ArrayList<Program> loadedList = new ArrayList<>();
    private ArrayList<Program> programsList = new ArrayList<>();
    private ProgramsList completeProgramsList;
    private int listIndex;

    private static final SaveLoad instance = new SaveLoad();

    public static SaveLoad getInstance() { return instance; }

    private SaveLoad() {

    }

    /**
     * Get shared preferences
     * @param context activity or fragment calling this method
     * @return shared preferences with specified "SaveLoad" tag and MODE_PRIVATE
     */
    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(TAG, MODE_PRIVATE);
    }

    /**
     * Saves listView indexes
     * @param context activity or fragment calling this method
     * @param index takes in a listView index to save
     * @param indexTag to identify
     */
    //IF index2 ISN'T USED, PASS 0
    public void saveListIndex (Context context, int index, String indexTag) {
        sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(indexTag, index);
        prefEditor.commit();
        Log.d(TAG, "Saving list index");
    }

    /**
     * Loads listView indexes
     * @param context activity or fragment calling this method
     * @param indexTag takes in a listView index to load
     * @return loaded index
     */
    public int loadListIndex(Context context, String indexTag) {

        sharedPreferences = getSharedPreferences(context);
        listIndex = sharedPreferences.getInt(indexTag, 0);

        Log.d(TAG, "Loaded list index was: " + listIndex);
        Log.d(TAG, "Loading");

        return listIndex;
    }

    /**
     * Saves list of all programs as an abstract object
     * @param context activity or fragment calling this method
     * @param objectValue object to save
     */
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

    /**
     * Loads list of all programs
     * Loaded abstract object needs to be cast to specific class/object
     * @param context activity or fragment calling this method
     * @param targetClass class the loaded object is cast to
     * @return loaded object
     */
    //LOAD PROGRAMSLIST AS OBJECT
    public Object loadProgramListObject(Context context, Class targetClass) {
        sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        Object programsList = sharedPreferences.getString(PROGRAM_TAG, null);
        if(programsList != null)
        programsList = gson.fromJson((String)programsList, targetClass);
        else
            Log.d(TAG, "Loaded programs list was null");

        Log.d(TAG, "Loading ProgramsList object");
        return programsList;
    }

    /*public ArrayList getProgramsList() {
        return programsList;
    }*/
}

