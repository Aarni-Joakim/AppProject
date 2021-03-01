/*package com.team1.hyteproject;

import android.content.Intent;
import android.provider.CalendarContract;
import android.util.Log;

public class CalendarController {

    private final String TAG= "CalendarController";

    private CalendarController() {
        Log.d(TAG, "Singleton created.");
    }

    public void addEvent() {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setData(CalendarContract.Events.CONTENT_URI);
        intent.putExtra(CalendarContract.Events.TITLE, TAG);
        intent.putExtra(CalendarContract.Events.DESCRIPTION, TAG);
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, TAG);
        intent.putExtra(CalendarContract.Events.ALL_DAY, true);

        startActivity(intent);
    }

    public void getEvents() {

    }

    public void removeEvent() {

    }
}
*/