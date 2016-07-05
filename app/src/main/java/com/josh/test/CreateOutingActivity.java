package com.josh.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.josh.test.course.CourseDBHandler;
import com.josh.test.course.GolfCourse;

import java.util.ArrayList;

public class CreateOutingActivity extends AppCompatActivity {

    Spinner locale ;
    Spinner location2;
    Spinner course;

    CourseDBHandler myCourseDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_outing);

        myCourseDB = new CourseDBHandler(this,null,null,1);

        locale = (Spinner)findViewById(R.id.spinnerLocale) ;
        locale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getSelectedItemPosition()!= 0) {
                    String localeSelected = parent.getSelectedItem().toString();

                    ArrayList<GolfCourse> locationList = myCourseDB.getLocale(localeSelected);

                    //make location
                }
                else
                {
                    //still at prompt
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void createOuting(View view)
    {

    }
}
