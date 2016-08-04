package com.josh.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.josh.test.user.User;
import com.josh.test.user.UserDBHandler;
import com.josh.test.user.UserTaskHandler;

import java.sql.Timestamp;
import java.util.Date;

public class CreateUserActivity extends AppCompatActivity {
    UserDBHandler myDB;
    EditText first;
    EditText last;
    EditText password;
    EditText email;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        myDB = new UserDBHandler(this,null,null,1);
    }

    public void submitUser(View view)
    {
        Date d1 = new Date(System.currentTimeMillis());
        System.out.println("Button Clicked at : "+new Timestamp(d1.getTime()));
        first = (EditText)findViewById(R.id.editTextFirst);
        last = (EditText)findViewById(R.id.editTextLast);
        password = (EditText)findViewById(R.id.editTextPassword);
        email = (EditText)findViewById(R.id.editTextEmail);

        //do i need this?
        submit = (Button)findViewById(R.id.submitButton);

        User tempUser = new User(first.getText().toString(),last.getText().toString(),email.getText().toString(),password.getText().toString());

        //myDB.addUser(tempUser);

        //should display toast n stuff
        new UserTaskHandler(this,myDB).addUser(tempUser);
       // Intent t = new Intent(this,AddUserIntent.class);

        //new Thread(myDB).start();

        startActivity(new Intent(CreateUserActivity.this,MainActivity.class));
    }
}
