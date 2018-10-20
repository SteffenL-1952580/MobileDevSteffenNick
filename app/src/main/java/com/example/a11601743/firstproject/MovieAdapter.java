package com.example.a11601743.firstproject;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    private Context context;
    private List<Movie> list;

    public MovieAdapter(Context context, List<Movie> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
       // View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_recycler_view_list_item, parent, false);
        View v = LayoutInflater.from(context).inflate(R.layout.movie_recycler_view_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {

        Movie movie = list.get(position);

        holder.textTitle.setText(movie.getTitle());
        //holder.textRating.setText(String.valueOf(movie.getRating()));
       // holder.textYear.setText(String.valueOf(movie.getYear()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public Movie getMovie(int position){
        return list.get(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textTitle, textRating, textYear;
        Toast myToast;
        public ViewHolder(View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.title);
            //textRating = itemView.findViewById(R.id.rating);
            //textYear = itemView.findViewById(R.id.main_year);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();

            if(myToast != null){
                myToast.cancel();
            }

            myToast = Toast.makeText(context, "item " + clickedPosition + " clicked", Toast.LENGTH_SHORT);
            myToast.show();

            Movie movieToPass = getMovie(clickedPosition);


            Class destinationActivity= DetailActivity.class;
            Intent startChildActivityIntent = new Intent(context, destinationActivity);

            startChildActivityIntent.putExtra("title",movieToPass.title );
            context.startActivity(startChildActivityIntent);
        }
    }
}
