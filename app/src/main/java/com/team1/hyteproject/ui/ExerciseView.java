package com.team1.hyteproject.ui;

public class ExerciseView {

        // the resource ID for the imageView
        private String exerciseName;

        // TextView 1
        private String sets;

        // TextView 1
        private String reps;

        // create constructor to set the values for all the parameters of the each single view
        public ExerciseView(String exerciseName) {
            this.exerciseName = exerciseName;
        }

        // getter method for returning the ID of the imageview
        public String getExerciseName() {
            return exerciseName;
        }

        // getter method for returning the ID of the TextView 1
        public String getSets() {
            return sets;
        }

        public String getReps() {return reps; }
}
