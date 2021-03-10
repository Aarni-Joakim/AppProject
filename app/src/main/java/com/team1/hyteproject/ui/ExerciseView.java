package com.team1.hyteproject.ui;

/**
 * @author Aarni Pesonen
 * @author Johannes Jokinen
 * For manually displaying values in exerciseListView
 * not yet in use
 */
public class ExerciseView {

        private String exerciseName;
        private String exerciseMuscleGroup;
        private String exerciseGroup;
        private String sets;
        private String reps;

        public ExerciseView(String exerciseName, String exerciseMuscleGroup, String exerciseGroup) {
            this.exerciseName = exerciseName;
            this.exerciseMuscleGroup = exerciseMuscleGroup;
            this.exerciseGroup = exerciseGroup;
        }

        public String getExerciseName() { return exerciseName; }
        public String getExerciseMuscleGroup() { return exerciseMuscleGroup; }
        public String getExerciseGroup() { return exerciseGroup; }
        public String getSets() { return sets; }
        public String getReps() { return reps; }
}
