package com.josh.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;

import com.josh.test.course.GolfCourse;
import com.josh.test.outing.OutingDBHandler;

public class CreateCourseActivity extends AppCompatActivity  {

    OutingDBHandler myDB;
    EditText name ;
    AutoCompleteTextView location ;
    Spinner locale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_course);
        myDB = new OutingDBHandler(this,null,null,1);



    }

    public void addCourse(View view)
    {
        name = (EditText)findViewById(R.id.editTextName);
        location = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextViewLocation);
        locale = (Spinner) findViewById(R.id.spinnerLocale);

        GolfCourse tempCourse = new GolfCourse(name.getText().toString(),location.getText().toString(),locale.getSelectedItem().toString());
        myDB.addOuting(null);
        startActivity(new Intent(CreateCourseActivity.this,MainActivity.class));
    }



}
