package com.team1.hyteproject.ui;

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
    private SharedViewModel sharedViewModel;
    private static final String USER = "user";
    private static final String NAMES = "userNames";

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String> userNames = new ArrayList<>();


    public Credentials credentials;
    private static final String TAG = "RegAct";



    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        sharedViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SharedViewModel.class);

        eRegName = findViewById(R.id.etRegName);
        eRegPassword = findViewById(R.id.etRegPassword);
        eRegister = findViewById(R.id.btnRegister);
        regBday = findViewById(R.id.regBday);
        regMail = findViewById(R.id.regEmail);

        credentials = new Credentials();

        sharedPreferences = getApplicationContext().getSharedPreferences("CredentialsDB", MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();

        if(sharedPreferences != null){

            Map<String, ?> preferencesMap = sharedPreferences.getAll();

            if(preferencesMap.size() != 0){
                credentials.loadCredentials(preferencesMap);
            }
        }

        eRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String regUsername = eRegName.getText().toString();
                String regPassword = eRegPassword.getText().toString();
                String regEMail = regMail.getText().toString();
                String age = regBday.getText().toString();
                if(eRegName.getText().toString().isEmpty()){
                    eRegName.setError("Enter text");
                }else{
                    ProfileSingleton.getInstance().addUser(regUsername, age, regEMail);
                    ProfileSingleton.getInstance().addUserName(regUsername);
                    SaveLoad.getInstance().saveDataList(RegistrationActivity.this,  users,  USER);
                    SaveLoad.getInstance().saveDataList(RegistrationActivity.this,  userNames,  NAMES);

                }

                Log.d(TAG, "ArrayList: "+ ProfileSingleton.getInstance().getArray());
                if(validate(regUsername, regPassword)) {

                    if(credentials.checkUsername(regUsername)){
                        Toast.makeText(RegistrationActivity.this, "Username already taken!", Toast.LENGTH_SHORT).show();
                    }else{

                        credentials.addCredentials(regUsername, regPassword);

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





    private boolean validate(String username, String password){

        if(username.isEmpty() || password.length() < 8){
            Toast.makeText(this, "Please enter all the details, password should be atleast 8 characters!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }




}