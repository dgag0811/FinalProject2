package com.example.monikagarg.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by monikagarg on 6/30/2016.
 */
public class Notesdao {
    SQLiteDatabase db = null;


    public void addRecords(Context context, Note note) {
        DatabaseHandler databaseHandler = new DatabaseHandler(context);
        db = databaseHandler.getReadableDatabase();
        db.beginTransaction();

        String query = " insert or replace into " + UtilConstants.NOTES_TABLE_NAME + "( "
                + UtilConstants.note_index + " , "
                + UtilConstants.IMAGE_NOTE + " , "
                + UtilConstants.DESCRIPTION_NOTE + " ) " + " values(?,?,?) ";

        db.execSQL(query.toString(), new Object[]{note.getImage(), note.getDescription()});
        db.close();

    }

    public List<Note> retrieveRecords(Context context) {
        Cursor cursor = null;
        List<Note> noteList = new ArrayList<>();

        Note note = null;
        DatabaseHandler databaseHandler = new DatabaseHandler(context);
        db = databaseHandler.getReadableDatabase();
        String query = " select "
                + UtilConstants.note_index + " , "
                + UtilConstants.IMAGE_NOTE + " , "
                + UtilConstants.DESCRIPTION_NOTE +
                " from " + UtilConstants.NOTES_TABLE_NAME;

        cursor = db.rawQuery(query, new String[]{});


        if (cursor.moveToFirst()) {
            do {
                note = new Note();
                note.setIndex(cursor.getInt(0));
                note.setImage(cursor.getBlob(1));
                note.setDescription(cursor.getString(2));
                noteList.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return noteList;


    }
}

