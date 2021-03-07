package com.team1.hyteproject.ui;

public class ProgramView {

        // the resource ID for the imageView
        private String programName;

        // TextView 1
        private String nextWorkoutDate;

        // TextView 1
        private String mNumbersInText;

        // create constructor to set the values for all the parameters of the each single view
        public ProgramView(String programName) {
            this.programName = programName;
        }

        // getter method for returning the ID of the imageview
        public String getProgramName() {
            return programName;
        }

        // getter method for returning the ID of the TextView 1
        public String getNextWorkoutDate() {
            return nextWorkoutDate;
        }
}
