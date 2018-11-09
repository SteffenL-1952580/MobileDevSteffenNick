package com.example.a11601743.firstproject;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity { //FragmentActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =(Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();



        String movieTitle = intent.getStringExtra("title");
        String movieYear = intent.getStringExtra("year");
        String movieRating = intent.getStringExtra("rating");
        String movieDescription = intent.getStringExtra("description");
        ((TextView) findViewById(R.id.title)).setText(movieTitle);
        ((TextView) findViewById(R.id.year)).setText(movieYear);
        ((TextView) findViewById(R.id.description)).setText(movieDescription);
        ((TextView) findViewById(R.id.rating)).setText(movieRating);
    }
}
