package com.team1.hyteproject.ui;

/**
 * @author Aarni Pesonen
 * @author Johannes Jokinen
 * For manually displaying values in programListView
 * not yet in use
 */
public class ProgramView {

        private String programName;
        private String nextWorkoutDate;
        public ProgramView(String programName) {
            this.programName = programName;
        }
        public String getProgramName() {
            return programName;
        }
        public String getNextWorkoutDate() {
            return nextWorkoutDate;
        }
}
