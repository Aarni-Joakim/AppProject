package com.team1.hyteproject;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity {
/*
    private Animation rotateOpen = AnimationUtils.loadAnimation(this, R.anim.rotate_open);
    private Animation rotateClose = AnimationUtils.loadAnimation(this, R.anim.rotate_close);
    private Animation expandBottom = AnimationUtils.loadAnimation(this, R.anim.expand_bottom);
    private Animation collapseBottom = AnimationUtils.loadAnimation(this, R.anim.collapse_bottom);
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_workout, R.id.navigation_exercise, R.id.navigation_calendar, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }

}