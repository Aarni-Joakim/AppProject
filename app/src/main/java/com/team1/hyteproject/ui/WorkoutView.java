package com.team1.hyteproject.ui;

/**
 * @author Aarni Pesonen
 * @author Johannes Jokinen
 * For manually displaying values in workoutListView
 * not yet in use
 */
public class WorkoutView {

        private String workoutDate;
        private String workoutType;

        public WorkoutView(String workoutDate) {
            this.workoutDate = workoutDate;
        }
        public String getProgramName() {
            return workoutDate;
        }
        public String getNextWorkoutDate() {
            return workoutType;
        }
}
