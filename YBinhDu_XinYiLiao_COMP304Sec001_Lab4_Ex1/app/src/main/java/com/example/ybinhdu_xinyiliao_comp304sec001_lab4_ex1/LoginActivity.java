package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText editUsername, editPassword;
    String username  = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = findViewById(R.id._editUsername);
        editPassword = findViewById(R.id._editPassword);
        btnLogin = findViewById(R.id._btnLogin);

        username = editUsername.getText().toString();
        password = editPassword.getText().toString();


    }

    public void login(View v){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        SharedPreferences sharedPreferences = getSharedPreferences("MyShared",0);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();

        if (username.isEmpty() && password.isEmpty()){
            Toast.makeText(this, "Username/Password cannot be null!", Toast.LENGTH_SHORT).show();

        } else {
            prefEditor.putString("ExaminerId", username);
            prefEditor.commit();
            startActivity(intent);
        }


    }
}