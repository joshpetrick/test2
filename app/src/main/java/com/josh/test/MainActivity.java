package com.josh.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.josh.test.outing.OutingDBHandler;
import com.josh.test.user.UserDBHandler;

public class MainActivity extends AppCompatActivity {
    UserDBHandler myUserDB;
    OutingDBHandler myCourseDB;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myUserDB = new UserDBHandler(this,null,null,1);
        myCourseDB = new OutingDBHandler(this,null,null,1);

        display = (TextView)findViewById(R.id.userList);
        display.setText( myUserDB.printAllUsers());



    }

    public void addUser(View view)
    {
        startActivity(new Intent(MainActivity.this,CreateUserActivity.class));
    }

    public void toCourses(View view)
    {
        startActivity(new Intent(MainActivity.this, CreateCourseActivity.class));
    }

    public void viewCourses(View view)
    {
        startActivity(new Intent(MainActivity.this, ShowCourseActivity.class));
    }

    public void doClean(View view)
    {
        myCourseDB.dropTable();
        myUserDB.dropTable();
    }

    public void addOuting(View view)
    {
        startActivity(new Intent(MainActivity.this,CreateOutingActivity.class));
    }
}
