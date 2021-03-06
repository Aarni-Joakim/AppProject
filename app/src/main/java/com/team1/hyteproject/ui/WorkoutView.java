package com.team1.hyteproject.ui;

public class WorkoutView {

        // the resource ID for the imageView
        private String workoutDate;

        // TextView 1
        private String workoutType;


        // create constructor to set the values for all the parameters of the each single view
        public WorkoutView(String workoutDate) {
            this.workoutDate = workoutDate;
        }

        // getter method for returning the ID of the imageview
        public String getProgramName() {
            return workoutDate;
        }

        // getter method for returning the ID of the TextView 1
        public String getNextWorkoutDate() {
            return workoutType;
        }
}
