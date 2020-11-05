package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    EditText inputEmail;
    EditText inputPassword;
    FirebaseAuth firebase;

    public MainActivity() {
        b1 = (Button) findViewById(R.id.loginto);
        b2 = (Button) findViewById(R.id.newAccount);
        inputEmail = (EditText) findViewById(R.id.Email);
        inputPassword = (EditText) findViewById(R.id.Password);
    }

    public void onStart(){
        super.onStart();
        if (firebase.getCurrentUser() != null){
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(intent);
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firebase = FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                firebase.signInWithEmailAndPassword(email,password);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                firebase.createUserWithEmailAndPassword(email,password);
            }
        });
    }
}
