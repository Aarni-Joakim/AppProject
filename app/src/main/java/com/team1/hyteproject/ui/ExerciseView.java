package com.team1.hyteproject.ui;

public class ExerciseView {

        // the resource ID for the imageView
        private String exerciseName;

        private String exerciseMuscleGroup;

        private String exerciseGroup;

        // TextView 1
        private String sets;

        // TextView 1
        private String reps;

        // create constructor to set the values for all the parameters of the each single view
        public ExerciseView(String exerciseName, String exerciseMuscleGroup, String exerciseGroup) {
            this.exerciseName = exerciseName;
            this.exerciseMuscleGroup = exerciseMuscleGroup;
            this.exerciseGroup = exerciseGroup;
        }

        // getter method for returning the ID of the imageview
        public String getExerciseName() {
            return exerciseName;
        }
        public String getExerciseMuscleGroup() {
                return exerciseMuscleGroup;
        }
        public String getExerciseGroup() {
                return exerciseGroup;
        }

        // getter method for returning the ID of the TextView 1
        public String getSets() {
            return sets;
        }

        public String getReps() {return reps; }
}
