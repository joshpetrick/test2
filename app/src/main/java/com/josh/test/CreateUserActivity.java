package com.josh.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.josh.test.user.User;
import com.josh.test.user.UserDBHandler;

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
        first = (EditText)findViewById(R.id.editTextFirst);
        last = (EditText)findViewById(R.id.editTextLast);
        password = (EditText)findViewById(R.id.editTextPassword);
        email = (EditText)findViewById(R.id.editTextEmail);

        //do i need this?
        submit = (Button)findViewById(R.id.submitButton);

        User tempUser = new User(first.getText().toString(),last.getText().toString(),email.getText().toString(),password.getText().toString());

        myDB.addUser(tempUser);

        startActivity(new Intent(CreateUserActivity.this,MainActivity.class));
    }
}
