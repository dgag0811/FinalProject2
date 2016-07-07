package com.example.monikagarg.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by monikagarg on 7/5/2016.
 */
public class Mealdao {
    SQLiteDatabase db = null;

    public void addRecords(Context context, Meal meal) {
        DatabaseHandler databaseHandler = new DatabaseHandler(context);
        db = databaseHandler.getReadableDatabase();
        db.beginTransaction();

        String query = " insert or replace into " + UtilConstants.MEAL_TABLE_NAME + "( "
                + UtilConstants.MealDAY + " , "
                + UtilConstants.BREAKFAST + " , "
                + UtilConstants.LUNCH + " , "
                + UtilConstants.DINNER +
                ")"
                + " values(?,?,?,?) ";
        db.execSQL(query.toString(), new String[]{meal.getDay(), meal.getBreakfast()
                , meal.getLunch(), meal.getDinner()});
        db.close();
    }

    public List<Meal> retrieveRecords(Context context) {
        List<Meal> mealList = new ArrayList<>();
        Meal meal = null;
        DatabaseHandler databaseHandler = new DatabaseHandler(context);
        db = databaseHandler.getReadableDatabase();
        String query = " select "
                + UtilConstants.MealDAY + " , "
                + UtilConstants.BREAKFAST + " , "
                + UtilConstants.LUNCH + " , "
                + UtilConstants.DINNER +
                " from " + UtilConstants.MEAL_TABLE_NAME;
        Cursor cursor = db.rawQuery(query, new String[]{});


        if (cursor.moveToFirst()) {
            do {
                meal = new Meal();
                meal.setDay(cursor.getString(0));
                meal.setBreakfast(cursor.getString(1));
                meal.setLunch(cursor.getString(2));
                meal.setDinner(cursor.getString(3));

                mealList.add(meal);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return mealList;
    }
}