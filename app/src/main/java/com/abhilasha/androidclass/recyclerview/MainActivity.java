package com.abhilasha.androidclass.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user_name,pass_word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_name=findViewById(R.id.username);
        pass_word=findViewById(R.id.password);



    }



    public void SendData(View view) {

        String Username = user_name.getText().toString().trim();
        String Password = pass_word.getText().toString().trim();

        //DbHelper is a class, creating its  object named dbhelper
        DbHelper dbHelper=new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //content  values is used to put values that we want to put in the table
        ContentValues values = new ContentValues();
        values.put("username", Username);
        values.put("password", Password);

        long rowId = db.insert("user_login", null, values);

        Log.e("Row Id", "**********" + rowId);
        Toast.makeText(this, " Data Inserted successfully\n"+"Username : " + Username + "\n "+"Password : " + Password + "\n " + rowId, Toast.LENGTH_LONG).show();

    }


    public void ShowData(View view) {
        startActivity(new Intent(MainActivity.this,RecyclerViewActivity.class));

    }
}