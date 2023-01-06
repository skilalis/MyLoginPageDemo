package com.example.myloginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText, emailEditText,usernameEditText,passwordEditText;
    private Button signUpButton;
    UserDetails userDetails;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        nameEditText = findViewById(R.id.nameEditTextId);
        emailEditText = findViewById(R.id.signUpEmailEditTextId);
        usernameEditText = findViewById(R.id.signUpUsernameEditTextId);
        passwordEditText = findViewById(R.id.signUpPasswordEditTextId);
        databaseHelper = new DatabaseHelper(this);

        signUpButton = findViewById(R.id.signUpButtonId);

        userDetails = new UserDetails();

        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setUsername(username);
        userDetails.setPassword(password);

        long rowID = databaseHelper.insertData(userDetails);
        if (rowID >0) {
            Toast.makeText(this, "Row " + rowID + " is successfully inserted", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Row insertion failed", Toast.LENGTH_SHORT).show();

        }

    }
}