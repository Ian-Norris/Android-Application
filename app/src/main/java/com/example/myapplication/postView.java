package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class postView extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.Wonder);
        setSupportActionBar(toolbar);
        toolbar.setTitle("The Wonder App");
        Posts post = (Posts)getIntent().getSerializableExtra("Posts");

        TextView t1 = findViewById(R.id.itemTitle);
        TextView t2 = findViewById(R.id.textView2);
        TextView t3 = findViewById(R.id.textView3);
        TextView t4 = findViewById(R.id.textView4);

        t1.setText(post.getTitle());
        t2.setText(post.getDescription());
        t4.setText(Double.toString(post.getPrice()));
        String phoneNumberFormatted = post.getContact().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        t3.setText(phoneNumberFormatted);
    }
}