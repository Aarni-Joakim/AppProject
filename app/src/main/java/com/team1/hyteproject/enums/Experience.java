package com.team1.hyteproject.enums;

//public enum Experience { BEGINNER, INTERMEDIATE, ADVANCED}

public enum Experience{
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");

    private String realName;

    private Experience(String realName){
        this.realName = realName;
    }

    @Override public String toString(){
        return realName;
    }
}
