package com.example.mikeacre.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private HabitHelper habitHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        habitHelper = new HabitHelper(this);
    }

    public boolean addHabit(String habitType, String habitTime, int isReq){
        SQLiteDatabase db = habitHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_TYPE, habitType);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_TIME, habitTime);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_REQ, isReq);

        if (db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values) < 0)
            return false;
        else
            return true;

    }

    public Cursor getHabit(int habitid){
        SQLiteDatabase db = habitHelper.getReadableDatabase();
        String[] projection ={
                HabitContract.HabitEntry._ID,
                HabitContract.HabitEntry.COLUMN_HABIT_TYPE,
                HabitContract.HabitEntry.COLUMN_HABIT_TIME,
                HabitContract.HabitEntry.COLUMN_HABIT_REQ};

        String  whereColumns = HabitContract.HabitEntry._ID;

        String[] whereValues = {""+habitid};


        Cursor c = db.query(HabitContract.HabitEntry.TABLE_NAME, projection, whereColumns, whereValues, null, null, null);
        return c;
    }
}
