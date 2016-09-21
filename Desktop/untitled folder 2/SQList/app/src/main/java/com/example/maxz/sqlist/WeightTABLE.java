package com.example.maxz.sqlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by maxz on 6/8/16.
 */
public class WeightTABLE {

    private MyOpenHelper odjMyOpenHelper;

    private SQLiteDatabase writeSQLite, readSQLite;
    private double douweight;

    public static final String TABLE_WEIGHT="weightTABLE";
    public static final String  COLUMN_ID ="_id";
    public static final String COLUMN_DATE ="Date";
    public static final String COLUMN_WEIGHT="Weight";


    public WeightTABLE(Context context) {
        odjMyOpenHelper = new MyOpenHelper(context);
        //การเขียนและอ่านข้อมูล
        writeSQLite = odjMyOpenHelper.getWritableDatabase();
        readSQLite = odjMyOpenHelper.getReadableDatabase();
    }//con
    public double currentwight() {

        Cursor objCursor = readSQLite.query(TABLE_WEIGHT, new String[]{COLUMN_ID, COLUMN_DATE, COLUMN_WEIGHT}, null, null, null, null, null);

        if (objCursor != null) {

            objCursor.moveToLast();

            douweight = objCursor.getDouble(objCursor.getColumnIndex(COLUMN_WEIGHT));
        }
            return douweight;
        }



    //add value to SQLite
    public long addNewvalue(String strDate,double douWeight){


        // ContentValues = เรียกใช้คลาสเพื่อโยนข้อมูล
        ContentValues objContentValues =new ContentValues();

        objContentValues.put(COLUMN_DATE,strDate);
        objContentValues.put(COLUMN_WEIGHT,douWeight);


        // return การอ่าน .เข้าไปใน(ชื่อตาราง,null,ชื่ออ็อฟเจ็ตที่โยนเข้าไป)
        return writeSQLite.insert(TABLE_WEIGHT,null,objContentValues);

    }//add New value
}//main class
