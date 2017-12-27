package com.jarvis.twoword;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "wordsDb";
    public static final String TABLE_WORDS = "words";

    public static final String KEY_ID = "_id";
    public static final String KEY_RUS = "rus";
    public static final String KEY_ENG = "eng";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_WORDS + "(" + KEY_ID
                + " integer primary key," + KEY_RUS + " text," + KEY_ENG + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_WORDS);

        onCreate(db);

    }
}
