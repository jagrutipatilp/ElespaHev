package com.example.a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class LoginActivity extends AppCompatActivity {
    TextView signin;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signin = findViewById(R.id.signIn);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SigninActivity.class);
                startActivity(intent);
            }
        });

        login = findViewById(R.id.loginbtnfornextscreen);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("MenuItemClicked", "home: ");
                Intent intent = new Intent(LoginActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}