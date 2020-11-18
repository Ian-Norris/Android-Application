package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.FirebaseFirestore;

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
    private FirebaseFirestore mDb = FirebaseFirestore.getInstance();

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
        int priceInt = Integer.parseInt(priceString);
        String descriptionString = description.getText().toString();
        String contactString = contact.getText().toString();

        Posts p = new Posts(titleString, priceInt, descriptionString, contactString);
        Log.d("NewPost", "Submitted title:" + titleString + ", price" + priceString + ", description" + descriptionString + ", contact" + contactString);
        mDb.collection("posts").add(p);
    }
}