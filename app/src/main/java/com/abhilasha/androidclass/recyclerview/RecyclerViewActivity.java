package com.abhilasha.androidclass.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rv_data;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<model> modelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        rv_data = (RecyclerView) findViewById(R.id.rv_data);

        modelArrayList = new ArrayList<model>();
        rv_data.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter( modelArrayList,this);



        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] cols={"username","password"};
        Cursor cursor=db.query("user_login",cols,"",null,"","","","");

        while (cursor.moveToNext())
        {
            String userName=cursor.getString(cursor.getColumnIndexOrThrow("username"));
            String passWord=cursor.getString(cursor.getColumnIndexOrThrow("password"));

            model model = new model(" " + userName, "" + passWord);
            modelArrayList.add(model);


        }

        cursor.close();
       // recyclerViewAdapter = new RecyclerViewAdapter(modelArrayList, this);//passing model arraylist and this

        rv_data.setAdapter(recyclerViewAdapter);

    }
}