package com.josh.test.course;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Josh on 7/2/2016.
 */
public class CourseDBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="GolfOuting.db";
    public static final String TABLE_NAME="Course_Table";

    public static final String ID_COL ="ID";
    public static final String NAME_COL ="NAME";
    public static final String LOCATION_COL ="LOCATION";
    public static final String LOCALE_COL ="LOCALE";

    public CourseDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);

        SQLiteDatabase db = getWritableDatabase();
    }

    public void createDB()
    {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT "+
                NAME_COL +" TEXT "+
                LOCATION_COL +" TEXT "+
                LOCALE_COL +" TEXT )");

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
                + NAME_COL +" TEXT, "
                + LOCATION_COL +" TEXT, "
                + LOCALE_COL + " TEXT)");

    }

    public void addCourse(GolfCourse tempCourse)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME_COL,tempCourse.getName());
        cv.put(LOCATION_COL,tempCourse.getLocation());
        cv.put(LOCALE_COL,tempCourse.getLocale());


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
            returnString+= c.getString(c.getColumnIndex(NAME_COL))+ "\n";
            returnString+= c.getString(c.getColumnIndex(LOCATION_COL))+ "\n";
            returnString+= c.getString(c.getColumnIndex(LOCALE_COL))+ "\n";
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

    public ArrayList<GolfCourse> getLocale (String locale)
    {
        ArrayList<GolfCourse> returnCourses= new ArrayList<>();
        GolfCourse tempCourse;
        String tempName = "";
        String tempLocation = "";

        String queryString = "SELECT * FROM "+ TABLE_NAME + " WHERE "+LOCALE_COL+" = '"+locale+"';";
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(queryString,null);

        if(c != null)
        {
            c.moveToFirst();

            while(!c.isAfterLast())
            {
                tempName=c.getString(c.getColumnIndex(NAME_COL));
                tempLocation=c.getString(c.getColumnIndex(LOCATION_COL));

                tempCourse = new GolfCourse(tempName,tempLocation,locale);
                if(!returnCourses.contains(tempCourse))
                {
                    returnCourses.add(tempCourse);
                }

                c.moveToNext();
            }
            db.close();

        }

        return returnCourses;
    }

}
