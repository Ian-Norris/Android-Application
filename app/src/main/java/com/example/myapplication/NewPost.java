package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPost extends AppCompatActivity {
    Button b1;
    EditText title;
    EditText price;
    EditText description;
    EditText contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public void onSubmitClick(View view){
        title = findViewById(R.id.editTextTitle);
        price = findViewById(R.id.editTextPrice);
        description = findViewById(R.id.editTextDescription);
        contact = findViewById(R.id.editTextContact);

        String titleString = title.getText().toString();
        String priceString = price.getText().toString();
        String descriptionString = description.getText().toString();
        String contactString = contact.getText().toString();

        Log.d("NewPost", "Submitted title:" + titleString + ", price" + priceString + ", description" + descriptionString + ", contact" + contactString);

    }
}