package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.io.ByteArrayDataInput;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button b2;

    //Firebase values
    private static final FirebaseFirestore mDb = FirebaseFirestore.getInstance();
    private static final String POSTS = "posts";
    private static final String TAG = "FirestoreListActivity";

    private ArrayAdapter<Posts> adapter;

    private ArrayList<Posts> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        Button b1 = (Button) findViewById(R.id.logout);
        toolbar = (Toolbar) findViewById(R.id.Wonder);
        setSupportActionBar(toolbar);
        toolbar.setTitle("The Wonder App");
        posts = new ArrayList<>();

        //Getting data from firebase
        mDb.collection(POSTS)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        //ArrayList<Posts> posts = new ArrayList<>();
                        for (QueryDocumentSnapshot document: queryDocumentSnapshots){
                            Posts p = document.toObject(Posts.class);
                            posts.add(p);
                            Log.d(TAG, p.getTitle() + " " + p.getPrice());
                        }
                        Log.d(TAG, "Amount of post => " +  String.valueOf(posts.size()));
                        adapter.clear();
                        adapter.addAll(posts);
                    }
                });

        //Setting up ListView
        ListView postsListView = findViewById(R.id.itemPosts);
        adapter = new ArrayAdapter<Posts>(
                DetailActivity.this,
                android.R.layout.simple_expandable_list_item_1,
                new ArrayList<Posts>()
        );
        postsListView.setAdapter(adapter);

        postsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DetailActivity.this, postView.class);
                intent.putExtra("Posts", posts.get(i));
                startActivity(intent);
            }
        });

        //End of ListView configuration

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth firebase = FirebaseAuth.getInstance();
                firebase.signOut();
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        b2 = findViewById(R.id.newPost);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, NewPost.class);
                startActivity(intent);
            }
        });


    }//END OF onCreate
}