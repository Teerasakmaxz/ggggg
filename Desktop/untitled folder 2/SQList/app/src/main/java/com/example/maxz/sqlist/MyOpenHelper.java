package com.example.maxz.sqlist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by maxz on 6/8/16.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME="my_weight.db ";
    private static final int DATABASE_VERSION=1;
    private static final String CREATE_TABLE="create table weightTABLE (_id integer primary key,"+" Date text, Weight double);";


    public MyOpenHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION );
    } //construtor

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(CREATE_TABLE);
    }// สร้างฐานข้อมูล

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }//แก้ไขฐานข้อมูล
}//main clss
