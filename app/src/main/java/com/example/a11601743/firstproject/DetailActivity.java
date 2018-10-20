package com.example.a11601743.firstproject;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends FragmentActivity { //AppCompatActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        String movieTitle = intent.getStringExtra("title");

        ((TextView) findViewById(R.id.title)).setText(movieTitle);
    }
}
