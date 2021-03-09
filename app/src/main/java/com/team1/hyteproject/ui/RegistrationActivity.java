package com.team1.hyteproject.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.team1.hyteproject.R;
import com.team1.hyteproject.program.Credentials;
import com.team1.hyteproject.ui.profile.ProfileFragment;
import com.team1.hyteproject.ui.profile.ProfileSingleton;
import com.team1.hyteproject.ui.profile.User;

import java.util.ArrayList;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {


    private EditText eRegName;
    private EditText eRegPassword;
    private Button eRegister;
    private EditText regBday;
    private EditText regMail;

    public Credentials credentials; //Credentials for user input saving
    private static final String TAG = "RegAct";



    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        eRegName = findViewById(R.id.etRegName);
        eRegPassword = findViewById(R.id.etRegPassword);
        eRegister = findViewById(R.id.btnRegister);
        regBday = findViewById(R.id.regBday);
        regMail = findViewById(R.id.regEmail);

        credentials = new Credentials();

        sharedPreferences = getApplicationContext().getSharedPreferences("CredentialsDB", MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();


        //If sharedPreferences has more than 1 item load preferencesMap.
        if(sharedPreferences != null){

            Map<String, ?> preferencesMap = sharedPreferences.getAll();

            if(preferencesMap.size() != 0){
                credentials.loadCredentials(preferencesMap);
            }
        }


        eRegister.setOnClickListener(new View.OnClickListener() {

            /**
             * RegisterButton onClick
             * Saves user input to SharedPreferences for Profile Fragment
             * @param v
             */
            @Override
            public void onClick(View v) {
                String regUsername = eRegName.getText().toString();
                String regPassword = eRegPassword.getText().toString();
                String savedUsername = eRegName.getText().toString();
                String eMail = regMail.getText().toString();
                String age = regBday.getText().toString();
                if(eRegName.getText().toString().isEmpty()){
                    eRegName.setError("Enter text");
                }else{
                    sharedPreferencesEditor.putString("savedUsername", savedUsername);
                    sharedPreferencesEditor.putString("regEMail", eMail);
                    sharedPreferencesEditor.putString("age", age);
                    sharedPreferencesEditor.apply();


                }
                /**
                 * If username is not taken saves username and password into Credentials SharedPreferences
                 * Transfers user back to LoginActivity
                 */
                if(validate(regUsername, regPassword)) {

                    if(credentials.checkUsername(regUsername)){
                        Toast.makeText(RegistrationActivity.this, "Username already taken!", Toast.LENGTH_SHORT).show();
                    }else{

                        credentials.addCredentials(regUsername, regPassword, eMail, age);

                        /* Store the credentials */
                        sharedPreferencesEditor.putString(regUsername, regPassword);
                        sharedPreferencesEditor.putString("LastSavedUsername", "");
                        sharedPreferencesEditor.putString("LastSavedPassword", "");

                        /* Commits the changes and adds them to the file */
                        sharedPreferencesEditor.apply();

                        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                    }
                }
            }


        });

    }


    /**
     * Checks if password over needed 8 characters
     * @param username
     * @param password
     * @return
     */
    private boolean validate(String username, String password){

        if(username.isEmpty() || password.length() < 8){
            Toast.makeText(this, "Please enter all the details, password should be atleast 8 characters!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }




}