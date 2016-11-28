package com.example.mikeacre.habittracker;

import android.provider.BaseColumns;

/**
 * Created by mikeacre on 11/27/2016.
 */

public final class HabitContract {


        private HabitContract() {}

        public static final class HabitEntry implements BaseColumns {

            public final static String TABLE_NAME = "habits";
            public final static String _ID = BaseColumns._ID;
            public final static String COLUMN_HABIT_TYPE ="type";
            public final static String COLUMN_HABIT_TIME = "time";
            public final static String COLUMN_HABIT_REQ = "required";

            public static final int HABIT_REQ = 1;
            public static final int HABIT_NO_REQ = 0;


        }


}
