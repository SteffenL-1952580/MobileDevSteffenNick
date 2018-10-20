package com.example.a11601743.firstproject;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.activity_detail_fragment, container , false);



        TextView titleTextView = (TextView) view.findViewById(R.id.titleText);
        TextView ratingTextView = (TextView) view.findViewById(R.id.ratingText);


        return view;
    }
}
