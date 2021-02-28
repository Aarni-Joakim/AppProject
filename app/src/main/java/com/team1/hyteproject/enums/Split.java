package com.team1.hyteproject.enums;

public enum Split{
    FULL_BODY("Full-body"),
    UPPER_LOWER("Upper lower"),
    PPL("PPL");

    private String realName;

    private Split(String realName){
        this.realName = realName;
    }

    @Override public String toString(){
        return realName;
    }
}
