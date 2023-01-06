package com.example.myloginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
DatabaseHelper databaseHelper;
private Button signInButton, signUpHereButton;
private EditText userNameEditText;
private EditText passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton = findViewById(R.id.signInButtonId);
        signUpHereButton = findViewById(R.id.signUpHereButtonId);
        userNameEditText = findViewById(R.id.signInusernameEditTextId);
        passwordEditText = findViewById(R.id.signInpasswordEditTextId);


        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        signInButton.setOnClickListener(this);
        signUpHereButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(v.getId()==R.id.signInButtonId){
                Boolean result = databaseHelper.findPassword(username,password);
            if (result == true) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "username and Password didnt match", Toast.LENGTH_SHORT).show();
            }
        }else if(v.getId()==R.id.signUpHereButtonId){
            Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);
        }

    }
}