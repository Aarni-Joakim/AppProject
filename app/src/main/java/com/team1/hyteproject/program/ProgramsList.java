package com.team1.hyteproject.program;

import java.util.ArrayList;

/**
 * @author Aarni Pesonen
 * Object of this class saved to shared preferences as json string
 */
public class ProgramsList {

    private ArrayList<Program> programsList;
    private Program program;

    /**
     * default constructor
     */
    public ProgramsList() {
        programsList = new ArrayList<>();
    }

    /**
     * add arraylist containing all user programs
     * @param arraylist arraylist to be set as programsList
     */
    public void setProgramsList(ArrayList arraylist) {
        this.programsList = arraylist;
    }

    /**
     * get full list of programs stored in app
     * @return programs list stored in app
     */
    public ArrayList getProgramsList() {
        return programsList;
    }

    /**
     * get program at specified index at programsList
     * used to display program workout content in workoutListView
     * @param index get program at specified index
     * @return return program specified by index
     */
    public Program getProgram(int index) {
        return programsList.get(index);
    }

    /**
     * add program to complete list of programs
     * @param program to be added
     */
    public void addProgram(Program program) {
        programsList.add(program);
    }
}
