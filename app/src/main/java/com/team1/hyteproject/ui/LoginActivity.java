package com.team1.hyteproject.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.team1.hyteproject.HomeActivity;
import com.team1.hyteproject.R;
import com.team1.hyteproject.program.Credentials;
import com.team1.hyteproject.ui.profile.User;

import java.util.ArrayList;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private Button registerButton;
    private TextView eAttemptsInfo;
    private CheckBox eRememberMe;
    private CheckBox showPassword;
    private ArrayList<User> users;

    boolean isValid = false;        //Validates the username and password
    private int counter = 5;        //int for locking the login button

    public Credentials credentials; //Credential class, logic behind the login

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eName = findViewById(R.id.usernameText);
        ePassword = findViewById(R.id.passwordText);
        eLogin = findViewById(R.id.btnLogin);
        eAttemptsInfo = findViewById(R.id.tvAttemptsInfo);
        registerButton = findViewById(R.id.buttonRegister);
        eRememberMe = findViewById(R.id.cbRememberMe);
        showPassword = findViewById(R.id.showPassword);

        /**
         * If ShowPassword checkbox is active, changes password text type
         */
        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ePassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    ePassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });


        credentials = new Credentials();

        sharedPreferences = getApplicationContext().getSharedPreferences("CredentialsDB", MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();

        /**
         * If SharedPreferences has more than 1 item inside loads preferencesMap.
         * Loads LastSaved username and password if RememberMe checkBox is active
         */
        if(sharedPreferences != null){

            Map<String, ?> preferencesMap = sharedPreferences.getAll();

            if(preferencesMap.size() != 0){
                credentials.loadCredentials(preferencesMap);
            }

            String savedUsername = sharedPreferences.getString("LastSavedUsername", "");
            String savedPassword = sharedPreferences.getString("LastSavedPassword", "");

            if(sharedPreferences.getBoolean("RememberMeCheckbox", false)){
                eName.setText(savedUsername);
                ePassword.setText(savedPassword);
                eRememberMe.setChecked(true);
            }
        }

        //OnClick for checkBox
        eRememberMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferencesEditor.putBoolean("RememberMeCheckbox", eRememberMe.isChecked());
                sharedPreferencesEditor.apply();
            }
        });

        //Load Registration Activity
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });

        /**
         * OnClickListener for login button
         * Calls validate method
         * Saves username and password to Saved for the RememberMe
         * If validate returns true transfers user into HomeActivity
         */
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Please enter all the details correctly!", Toast.LENGTH_SHORT).show();
                }else{

                    isValid = validate(inputName, inputPassword);

                    if(!isValid){

                        counter--;

                        Toast.makeText(LoginActivity.this, "Incorrect credentials entered!", Toast.LENGTH_SHORT).show();

                        eAttemptsInfo.setText("No. of attempts remaining: " + counter);

                        if(counter == 0){
                            eLogin.setEnabled(false);
                        }
                    } else{


                        Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

                        sharedPreferencesEditor.putString("LastSavedUsername", inputName);
                        sharedPreferencesEditor.putString("LastSavedPassword", inputPassword);

                        sharedPreferencesEditor.apply();


                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }

                }

            }
        });
    }

    /**
     * Validates user inputted username and password from Credentials HashMap.
     * @param name
     * @param password
     * @return
     */
    private boolean validate(String name, String password){
        return credentials.checkCredentials(name, password);
    }
    //users list can be set from registration activity
    private void setUserList (ArrayList arraylist) {
        this.users = arraylist;
    }
}