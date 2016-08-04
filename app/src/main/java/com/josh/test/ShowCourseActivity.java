package com.josh.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.josh.test.course.CourseDBHandler;

public class ShowCourseActivity extends AppCompatActivity {
    CourseDBHandler myDB;
    EditText courses ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_course);
        myDB = new CourseDBHandler(this,null,null,1 );

        courses = (EditText)findViewById(R.id.editTextCourses);
        courses.setText(myDB.printAllUsers());
    }

    public void goHome(View view)
    {
        startActivity(new Intent(ShowCourseActivity.this, MainActivity.class));
    }
}
