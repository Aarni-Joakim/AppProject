package com.team1.hyteproject;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import android.util.Log;

/**
 * @author Aarni Pesonen
 * Controls calendar function
 */
public class CalendarController {

    private final String TAG= "Workout #1";

    /**
     * default constructor
     */
    public CalendarController() {
        Log.d(TAG, "Calendar Controller created.");
    }

    /**
     * Add event to calendar using intents
     * @param context activity of fragment calling the method
     */
    public void addEvent(Context context) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setData(CalendarContract.Events.CONTENT_URI);
        intent.putExtra(CalendarContract.Events.TITLE, TAG);
        intent.putExtra(CalendarContract.Events.DESCRIPTION, TAG);
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, TAG);
        intent.putExtra(CalendarContract.Events.ALL_DAY, true);

        context.startActivity(intent);
    }

    /**
     * not yet implemented
     */
    public void getEvents() { }

    /**
     * not yet implemented
     */
    public void removeEvent() { }
}
