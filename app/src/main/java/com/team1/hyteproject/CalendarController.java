package com.team1.hyteproject;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import android.util.Log;

public class CalendarController {

    private final String TAG= "CalendarController";

    public CalendarController() {
        Log.d(TAG, "Calendar Controller created.");
    }

    public void addEvent(Context context) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setData(CalendarContract.Events.CONTENT_URI);
        intent.putExtra(CalendarContract.Events.TITLE, TAG);
        intent.putExtra(CalendarContract.Events.DESCRIPTION, TAG);
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, TAG);
        intent.putExtra(CalendarContract.Events.ALL_DAY, true);

        context.startActivity(intent);
    }

    public void getEvents() {

    }

    public void removeEvent() {

    }
}
