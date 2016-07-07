package com.example.monikagarg.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by monikagarg on 6/30/2016.
 */
public class TimeTabledao {
    SQLiteDatabase db = null;

    public void addRecords(Context context, Timetable timetable) {
        DatabaseHandler databaseHandler = new DatabaseHandler(context);
        db = databaseHandler.getWritableDatabase();
        db.beginTransaction();

        String query = " insert or replace into " + UtilConstants.TIME_TABLE_NAME + "( "
                + UtilConstants.DAY + " , "
                + UtilConstants.COURSE + " , "
                + UtilConstants.TYPE + " , "
                + UtilConstants.VENUE + " , "
                + UtilConstants.PROFESSOR + " , "
                + UtilConstants.FROMTIME + " , "
                + UtilConstants.TOTIME + ")"
                + " values(?,?,?,?,?,?,?) ";
        db.execSQL(query.toString(), new String[]{timetable.getDay(), timetable.getCourse()
                , timetable.getType(), timetable.getVenue(), timetable.getFaculty(), timetable.getTotime(), timetable.getFromtime()});
        db.close();
    }

    public List<Timetable> retrieveRecords(Context context) {
        List<Timetable> timetableList = new ArrayList<>();
        Timetable timetable = null;
        DatabaseHandler databaseHandler = new DatabaseHandler(context);
        db = databaseHandler.getReadableDatabase();
        String query = " select "  + UtilConstants.DAY + " , "
                +UtilConstants.COURSE + " , "
                +UtilConstants.TYPE + " , "
                +UtilConstants.VENUE+ " , "
                +UtilConstants.PROFESSOR+ " , "
                +UtilConstants.FROMTIME+ " , "
                + UtilConstants.TOTIME +" from "
                + UtilConstants.TIME_TABLE_NAME;

        Cursor cursor= db.rawQuery(query, new String[]{});

        if (cursor.moveToFirst()) {
            do {
                timetable = new Timetable();
                timetable.setDay(cursor.getString(0));
                timetable.setFromtime(cursor.getString(5));
                timetable.setCourse(cursor.getString(1));
                timetable.setType(cursor.getString(2));
                timetable.setVenue(cursor.getString(3));
                timetable.setFaculty(cursor.getString(4));
                timetable.setTotime(cursor.getString(6));


                timetableList.add(timetable);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return timetableList;



    }
}


