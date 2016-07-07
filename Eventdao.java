package com.example.monikagarg.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by monikagarg on 6/30/2016.
 */
public class Eventdao {
    SQLiteDatabase db = null;

    public void addRecords(Context context, Event event) {
        DatabaseHandler databaseHandler = new DatabaseHandler(context);
        db = databaseHandler.getReadableDatabase();
        db.beginTransaction();
        //String queryDelete="delete from table_name where no=?";
        String query = " insert or replace into " + UtilConstants.EVENT_TABLE_NAME + "( "
                + UtilConstants.no + " , "
                + UtilConstants.DATE + " , "
                + UtilConstants.TITLE + " , "
                + UtilConstants.DESCRIPTION + " , "
                + UtilConstants.VENUEevent + " , "
                + UtilConstants.TIME + " , "
                + UtilConstants.ATTENDEES
                + ")"
                + " values(?,?,?,?,?,?,?,?) ";
        db.execSQL(query.toString(), new String[]{event.getDate(), event.getTitle()
                ,event.getDescription(),event.getVenue(),event.getTime(),event.getAttendees()});
        db.close();
    }

    public List<Event> retrieveRecords(Context context) {
        List<Event> eventList = new ArrayList<>();
        Event event = null;
        DatabaseHandler databaseHandler = new DatabaseHandler(context);
        db = databaseHandler.getReadableDatabase();
        String query = " select "
                + UtilConstants.no + " , "
                + UtilConstants.DATE + " , "
                + UtilConstants.TITLE + " , "
                + UtilConstants.DESCRIPTION + " , "
                + UtilConstants.VENUEevent + " , "
                + UtilConstants.TIME + " , "
                + UtilConstants.ATTENDEES + " , " +
                " from " + UtilConstants.EVENT_TABLE_NAME;
        Cursor cursor = db.rawQuery(query, new String[]{});


        if (cursor.moveToFirst()) {
            do {
                event = new Event();
                event.setDate(cursor.getString(0));
                event.setTitle(cursor.getString(1));
                event.setDescription(cursor.getString(2));
                event.setVenue(cursor.getString(3));
                event.setTime(cursor.getString(4));
                event.setAttendees(cursor.getString(5));

                eventList.add(event);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return eventList;
    }
}
