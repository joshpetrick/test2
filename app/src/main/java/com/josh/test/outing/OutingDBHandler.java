package com.josh.test.outing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Josh on 7/2/2016.
 */
public class OutingDBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="GolfOuting.db";
    public static final String TABLE_NAME="Outing_Table";

    public static final String COL_1="ID";
    public static final String COL_2="COURSE_ID";
    public static final String COL_3="DATE";
    public static final String COL_4="DESCRIPTION";

    public OutingDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);

        SQLiteDatabase db = getWritableDatabase();
    }

    public void createDB()
    {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT "+
                COL_2+" INTEGER "+
                COL_3+" TEXT "+
                COL_4+" TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COL_2+" INTEGER, "
                +COL_3 +" TEXT, "
                +COL_4+ " TEXT)");
    }

    public void addOuting(Outing tempOuting)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2,tempOuting.getName());
        cv.put(COL_3,tempOuting.getDate());
        cv.put(COL_4,tempOuting.getName());


        db.insert(TABLE_NAME,null,cv);
        db.close();
    }

    public String printAllUsers()
    {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME+ " WHERE 1";
        String returnString="";

        Cursor c = db.rawQuery(query,null);

        c.moveToFirst();

        while(!c.isAfterLast())
        {
            returnString += "***User***\n";
            returnString+= c.getString(c.getColumnIndex(COL_2))+ "\n";
            returnString+= c.getString(c.getColumnIndex(COL_3))+ "\n";
            returnString+= c.getString(c.getColumnIndex(COL_4))+ "\n";
            c.moveToNext();
        }
        db.close();

        return returnString;
    }

    public void dropTable()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.close();
    }


}
