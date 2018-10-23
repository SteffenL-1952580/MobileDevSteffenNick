package com.example.a11601743.firstproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a11601743.firstproject.DbHelper.DataBaseHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

   /*
    private RecyclerView movieList;
    private Cursor cursor;

    public TextView jsonTextView;*/

   private RecyclerView mList;
   private LinearLayoutManager linearLayoutManager;
   private DividerItemDecoration dividerItemDecoration;
   private List<Movie> movieLijst;
   private RecyclerView.Adapter adapter;

    //private String url =  "https://api.themoviedb.org/3/movie/550?api_key=7878b83d58394c2db83e16b69d3c57d0";
    private String url =  "https://api.themoviedb.org/3/movie/now_playing?api_key=7878b83d58394c2db83e16b69d3c57d0&page=1";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_recyclerview_main);
        setContentView(R.layout.activity_main);

        mList = findViewById(R.id.movie_recycler_view);
        movieLijst= new ArrayList<>();
        adapter = new MovieAdapter(getApplicationContext(), movieLijst);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(),linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);

        this.deleteDatabase("MovieDbApp");

        DataBaseHelper db = new DataBaseHelper(this);
        db.addMovie(new Movie("NickMovie" , 2018, 10, "A movie based on the life of Nick"));
        db.addMovie(new Movie("SteffenMovie" , 2017, 9, "a documentary about Steffen himself"));

        List<Movie> movies = db.getAllMovies();
        String text = "";

        for (Movie m : movies){
            String log = "ID" + m.getId() + ", Title: " + m.getTitle() + ", Rating: " + m.getRating() + " Year: " + m.getYear() + " Description: " + m.description +"\n";
            text = text + log;
        }

        TextView textviewmovie = (TextView) findViewById(R.id.textViewMovie);
        textviewmovie.setText(text);

        //getData();

    }

    private void getData() {


    }

  /*      JsonObjectRequest jsonObjectRequest = new JsonObjectRequest (Request.Method.GET,url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray results = response.getJSONArray("results");

                    for (int i = 0; i < results.length(); i++){
                            JSONObject object = results.getJSONObject(i);

                            Movie movie = new Movie();
                            movie.setTitle(object.getString("title"));
                            movieLijst.add(movie);
                    }


                }catch(Exception e){
                    e.printStackTrace();
                }


                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.e("Volley", error.toString());

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

    }
*/



}
