package com.example.sql;
import android.content.ContentValues;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_Name = "Course_DB";
    private static final int DB_Version = 1;
    private static final String Table_name = "Courses";
    private static final String ID_col = "id";
    private static final String Name_col = "name";
    private static final String Dur_col = "duration";
    private static final String Descrp_col = "description";
    private static final String Track_col = "tracks";

    public DBHandler(@Nullable Context context) {
        super(context, DB_Name, null, DB_Version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + Table_name + " ("
                + ID_col + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Name_col + " TEXT,"
                + Dur_col + " TEXT,"
                + Descrp_col + " TEXT,"
                + Track_col + " TEXT)";
        db.execSQL(query);
    }

    public void addNewCourse(String courseName, String courseDuration, String courseDescription, String courseTracks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Name_col, courseName);
        values.put(Dur_col, courseDuration);
        values.put(Descrp_col, courseDescription);
        values.put(Track_col, courseTracks);
        db.insert(Table_name, null, values);
        db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(db);
    }
}
