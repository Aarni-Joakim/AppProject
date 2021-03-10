package com.team1.hyteproject.ui.profile;

/**
 * @Author Samu Wahlroos
 * Class to store user data
 */
public class User {
    private String userName;
    private String eMail;
    private String age;



    public User(String userName, String eMail, String age){
        this.userName = userName;
        this.age = age;
        this.eMail = eMail;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getAge(){
        return this.age;
    }

    public String getEMail(){
        return this.eMail;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setEMail(String eMail){
        this.eMail = eMail;
    }

    public void setAge(String age){
        this.age = age;
    }



}
