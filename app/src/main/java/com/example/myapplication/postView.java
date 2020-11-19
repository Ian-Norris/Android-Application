package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class postView extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_view);

        Posts post = (Posts)getIntent().getSerializableExtra("Posts");


        TextView t1 = findViewById(R.id.itemTitle);
        TextView t2 = findViewById(R.id.textView2);
        TextView t3 = findViewById(R.id.textView3);
        TextView t4 = findViewById(R.id.textView4);

        t1.setText(post.getTitle());
        t2.setText(Double.toString(post.getPrice()));
        t3.setText(post.getDescription());
        t4.setText(post.getContact());


    }
}
