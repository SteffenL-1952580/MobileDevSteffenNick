package com.example.a11601743.firstproject;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a11601743.firstproject.DbHelper.DataBaseHelper;
import com.example.a11601743.firstproject.Notification.NotificationBuilder;

public class DetailFragment extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState){


        final View view = inflater.inflate(R.layout.activity_detail_fragment, container , false);

        TextView titleTextView = (TextView) view.findViewById(R.id.title);
        TextView yearTextView = (TextView) view.findViewById(R.id.year);
        TextView descriptionTextView = (TextView) view.findViewById(R.id.description);
        TextView ratingTextView = (TextView) view.findViewById(R.id.rating);

        Bundle bundle = getArguments();

        if(bundle != null){
            titleTextView.setText(getArguments().getString("title"));
            yearTextView.setText(getArguments().getString("year"));
            descriptionTextView.setText(getArguments().getString("description"));
            ratingTextView.setText(getArguments().getString("rating"));

        }


        Button favoriteButton = (Button) view.findViewById(R.id.favoriteButton);

        View.OnClickListener favoriteButtonListener = new View.OnClickListener(){
            Toast myToast;
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                DataBaseHelper db = new DataBaseHelper(getContext());
                Movie movieToAdd = new Movie();
                TextView detailview = view.findViewById(R.id.title);
                movieToAdd.setTitle((String) detailview.getText());

                TextView yearview = view.findViewById(R.id.year);
                movieToAdd.setYear((String) yearview.getText());

                TextView descriptionview = view.findViewById(R.id.description);
                movieToAdd.setDescription((String) descriptionview.getText());


                myToast = Toast.makeText(getContext(), movieToAdd.title + " added", Toast.LENGTH_SHORT);
                myToast.show();



                db.addMovie(movieToAdd);
                //db.addMovie(new Movie("TESTING" , "1999", 10.5, "A movie based on the life of Nick"));
            }
        };

        /*Button removeButton = (Button) view.findViewById(R.id.removeButton);
        View.OnClickListener removeButtonListener = new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                DataBaseHelper db = new DataBaseHelper(getContext());

            }
        };

        removeButton.setOnClickListener(removeButtonListener);*/
        favoriteButton.setOnClickListener(favoriteButtonListener);

        return view;
    }
}
