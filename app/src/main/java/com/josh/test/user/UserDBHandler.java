package com.josh.test.user;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;

/**
 * Created by Josh on 7/2/2016.
 */
public class UserDBHandler extends SQLiteOpenHelper implements Runnable {

    //need to make a property file
    public static final String DATABASE_NAME="GolfOuting.db";
    public static final String TABLE_NAME="User_Table";
    private String taskChoice = "";

    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="LASTNAME";
    public static final String COL_4="EMAIL";
    public static final String COL_5="PASSWORD";

    public UserDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);

        SQLiteDatabase db = getWritableDatabase();
    }
    @Override
    public void onOpen(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, LASTNAME TEXT, EMAIL TEXT, PASSWORD TEXT)");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, LASTNAME TEXT, EMAIL TEXT, PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    public void addUser(User tempUser)
    {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2,tempUser.getFirstName());
        cv.put(COL_3,tempUser.getLastName());
        cv.put(COL_4,tempUser.getEmail());
        cv.put(COL_5,tempUser.getPassword());
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
        +COL_2+" TEXT, "
        +COL_3+" TEXT, "
        +COL_4+" TEXT, "
        +COL_5+" TEXT )");
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

    @Override
    public void run() {

    }

    public class Task extends AsyncTask<User,Void,String>{

        @Override
        protected String doInBackground(User... params) {
            return null;
        }
    }
}
