package com.abhilasha.androidclass.recyclerview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


public class DbHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME="database_one";
    public static final int DATABASE_VERSION=4;
    public static final String CREATE_TABLE= "CREATE TABLE user_login(username text,password text)";


    public DbHelper(@Nullable MainActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DbHelper(RecyclerViewActivity context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
