package com.team1.hyteproject.ui.profile;

import java.util.ArrayList;

public class ProfileSingleton {

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String> userNames = new ArrayList<>();
    private static ProfileSingleton mInstance;

    public static ProfileSingleton getInstance() {
        if(mInstance == null){
            mInstance = new ProfileSingleton();
        }
        return mInstance;
    }

    private ProfileSingleton() {


    }

    public ArrayList<User> getArray(){
        return users;
    }

    public void addToArray(String userName, String eMail, String age){
        users.add(new User(userName, eMail, age));
    }

    public void addUser(String userName, String eMail, String age){
        users.add(new User(userName, eMail, age));
    }

    public void addUserName(String userName){
        userNames.add(userName);
    }




}

