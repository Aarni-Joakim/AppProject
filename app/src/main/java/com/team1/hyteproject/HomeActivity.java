package com.team1.hyteproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.team1.hyteproject.ui.SharedViewModel;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private final String SAVEKEY = "Saved list";
    private final String SHAPREF = "Shared Preferences";
    private ArrayList arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        ViewModel sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_program, R.id.navigation_all_exercise, R.id.navigation_calendar, R.id.navigation_profile,
                R.id.navigation_new_program, R.id.navigation_add_exercise, R.id.navigation_workout_list,
                R.id.navigation_exercise_list)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }
    public void updateStatusBarColor(String color) {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor(color));
    }

    /*public void saveData(ArrayList arrayList) {
        this.arrayList = arrayList;
        SharedPreferences sharedPreferences = getSharedPreferences(SHAPREF, MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        prefEditor.putString(SAVEKEY, json);
        prefEditor.apply();
    }

    public ArrayList loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHAPREF, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(SAVEKEY, null);
        Type type = new TypeToken<ArrayList<BaseExercise>>() {}.getType();
        arrayList = gson.fromJson(json, type);

        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    public void setArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public ArrayList getArrayList() {
        return arrayList;
    }*/
}