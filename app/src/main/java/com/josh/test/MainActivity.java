package com.josh.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.josh.test.course.CourseDBHandler;
import com.josh.test.user.UserDBHandler;

import java.sql.Timestamp;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    UserDBHandler myUserDB;
    CourseDBHandler myCourseDB;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createShortCut();
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);

        myUserDB = new UserDBHandler(this,null,null,1);
        myCourseDB = new CourseDBHandler(this,null,null,1);

        display = (TextView)findViewById(R.id.userList);
        display.setText( myUserDB.printAllUsers());
        Date testTime = new Date(System.currentTimeMillis());
        System.out.println("Time in Main Activity : "+ new Timestamp(testTime.getTime()));


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

    private void createShortCut() {

        Intent shortcutIntent = new Intent(getApplicationContext(),MainActivity.class);
        shortcutIntent.setAction(Intent.ACTION_MAIN);
        Intent intent = new Intent();
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, R.string.app_name);
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.mipmap.test));
        intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        getApplicationContext().sendBroadcast(intent);
    }
}
