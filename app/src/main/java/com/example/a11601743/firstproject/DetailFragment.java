package com.example.a11601743.firstproject;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a11601743.firstproject.Notification.NotificationBuilder;

public class DetailFragment extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.activity_detail_fragment, container , false);

        TextView titleTextView = (TextView) view.findViewById(R.id.title);
        //TextView ratingTextView = (TextView) view.findViewById(R.id.rating);

        Bundle bundle = getArguments();

        if(bundle != null){
            titleTextView.setText(getArguments().getString("title"));
        }

        Button buttonNotify = (Button) view.findViewById(R.id.NotificatieButton);

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                NotificationBuilder notificationBuilder = new NotificationBuilder(getActivity());

                notificationBuilder.giveNotification("MovieApp" , "You have a new notification");


            }
        };

        buttonNotify.setOnClickListener(buttonListener);

        return view;
    }
}
