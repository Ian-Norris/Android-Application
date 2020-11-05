package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        Button b1 = (Button) findViewById(R.id.logout);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth firebase = FirebaseAuth.getInstance();
                firebase.signOut();
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
