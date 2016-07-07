package com.example.monikagarg.finalproject;

/**
 * Created by DELL on 6/23/2016.
 */

//package com.example.dell.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by DELL on 6/23/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ACTIVITIES.db";


    public static final int DATABASE_VERSION = 1;
    //columns name
   /* public static final String COL_1 = "SERIAL_NO";
    public static final String COL_2 = "DATE";
    public static final String COL_3 = "TIME";
    public static final String COL_4 = "VENUE";
    public static final String COL_5 = "ATTENDEES";
    public static final String COL_6 = "PRIORITY";
    public static final String COL_7 = "DESCRIPTION";
*/
    private String CREATE_LOGIN_TABLE = "CREATE TABLE " + UtilConstants.LOGIN_TABLE_NAME + " ( "
            + UtilConstants.NAME + " TEXT, " + UtilConstants.USER_NAME + " TEXT PRIMARY KEY, "
            + UtilConstants.PASSWORD + " TEXT ) ";
    
     private String CREATE_EVENT_TABLE = "CREATE TABLE " + UtilConstants.EVENT_TABLE_NAME + " ( "
            + UtilConstants.DATE + " TEXT, "
            + UtilConstants.no + " TEXT PRIMARY KEY AUTOINCREMENT, "
            +UtilConstants.TITLE + " TEXT, "
            +UtilConstants.VENUE + " TEXT, "
            +UtilConstants.TIME + " TEXT, "
            +UtilConstants.ATTENDEES+" TEXT, "
            + UtilConstants.DESCRIPTION + " TEXT ) ";

    private String CREATE_TIME_TABLE = "CREATE TABLE " + UtilConstants.TIME_TABLE_NAME + " ( "
            + UtilConstants.DAY + " TEXT, "
            + UtilConstants.COURSE + " TEXT, "
            + UtilConstants.TYPE + " TEXT, "
            + UtilConstants.VENUE + " TEXT, "
            + UtilConstants.PROFESSOR + " TEXT "
            + UtilConstants.FROMTIME + " TEXT, "
            + UtilConstants.TOTIME + " TEXT, "
            + UtilConstants.ID + " INTEGER PRIMARY KEY AUTOINCREMENT) ";

    private String CREATE_MEAL_TABLE = "CREATE TABLE " + UtilConstants.MEAL_TABLE_NAME + " ( "
            + UtilConstants.MealDAY + " TEXT PRIMARY KEY, "
            + UtilConstants.BREAKFAST + " TEXT, "
            + UtilConstants.DINNER + " TEXT, "
            + UtilConstants.LUNCH + " TEXT)";

    private String CREATE_NOTE_TABLE = "CREATE TABLE " + UtilConstants.NOTES_TABLE_NAME+ " ( "
            + UtilConstants.DESCRIPTION_NOTE + " TEXT, "
            + UtilConstants.IMAGE_NOTE + " BLOB, "
            + UtilConstants.note_index+ " TEXT PRIMARY KEY AUTOINCREMENT ) ";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LOGIN_TABLE);
        db.execSQL(CREATE_EVENT_TABLE);
        db.execSQL(CREATE_TIME_TABLE);
        db.execSQL(CREATE_MEAL_TABLE);
        db.execSQL(CREATE_NOTE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + CREATE_LOGIN_TABLE);
        db.execSQL("DROP TABLE IF EXISTS" + CREATE_EVENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS" + CREATE_TIME_TABLE);
        db.execSQL("DROP TABLE IF EXISTS" + CREATE_MEAL_TABLE);
        db.execSQL("DROP TABLE IF EXISTS" + CREATE_NOTE_TABLE);

        onCreate(db);
    }
}

