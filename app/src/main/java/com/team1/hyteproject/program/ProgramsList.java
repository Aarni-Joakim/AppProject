package com.team1.hyteproject.program;

import java.util.ArrayList;

/**
 * Author Aarni Pesonen
 * testing gson serialization/deserialization
 */
public class ProgramsList {

    private ArrayList<Program> programsList;
    private Program program;

    public ProgramsList() {
        programsList = new ArrayList<>();
    }

    public void setProgramsList(ArrayList arraylist) {
        this.programsList = arraylist;
    }

    public ArrayList getProgramsList() {
        return programsList;
    }

    public Program getProgram(int index) {
        return programsList.get(index);
    }

    public void addProgram(Program program) {
        programsList.add(program);
    }
}
