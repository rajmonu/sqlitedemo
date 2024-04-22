package com.raj.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText reg_name, reg_email, reg_pass, reg_gender;
    DbHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reg_name = (EditText) findViewById(R.id.reg_name);
        reg_email = (EditText) findViewById(R.id.reg_email);
        reg_pass = (EditText) findViewById(R.id.reg_password);
        reg_gender = (EditText) findViewById(R.id.reg_gender);

        dbHelper = new DbHelper(getApplicationContext());
    }

    public void registerUser(View view) {
        String name1 = reg_name.getText().toString();
        String email1 = reg_email.getText().toString();
        String pass1 = reg_pass.getText().toString();
        String gender1 = reg_gender.getText().toString();

        dbHelper.registerUserHelper(name1, email1, pass1, gender1);
        Toast.makeText(this,"User Registered Successfully",Toast.LENGTH_SHORT).show();
        reg_name.setText("");
        reg_email.setText("");
        reg_pass.setText("");
        reg_gender.setText("");

    }
}