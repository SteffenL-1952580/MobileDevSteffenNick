package com.example.a11601743.firstproject;

import android.app.AlarmManager;
import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a11601743.firstproject.Notification.NotificationBuilder;

public class DetailFragment extends Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.activity_detail_fragment, container , false);



        TextView titleTextView = (TextView) view.findViewById(R.id.titleText);
        TextView ratingTextView = (TextView) view.findViewById(R.id.ratingText);
        Button buttonNotifi = (Button) view.findViewById(R.id.NotificatieButton);

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                NotificationBuilder notificationBuilder = new NotificationBuilder(getActivity());

                notificationBuilder.giveNotification("MovieApp" , "You have a new notification");


            }
        };

        buttonNotifi.setOnClickListener(buttonListener);

        return view;
    }
}
