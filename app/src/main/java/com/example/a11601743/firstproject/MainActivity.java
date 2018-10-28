package com.example.a11601743.firstproject;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


   private RecyclerView mList;
   private LinearLayoutManager linearLayoutManager;
   private DividerItemDecoration dividerItemDecoration;
   private List<Movie> movieLijst;
   private RecyclerView.Adapter adapter;
   private PageAdapter pageAdapter;
   //private ViewPager viewPager;
   private TabLayout tabLayout;
   private Toolbar toolbar;
    //private String url =  "https://api.themoviedb.org/3/movie/550?api_key=7878b83d58394c2db83e16b69d3c57d0";
    private String url =  "https://api.themoviedb.org/3/movie/now_playing?api_key=7878b83d58394c2db83e16b69d3c57d0&page=1";



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_recyclerview_main);
        setContentView(R.layout.activity_main);

       // mList = findViewById(R.id.movie_recycler_view);
       // movieLijst= new ArrayList<>();
        //adapter = new MovieAdapter(MainActivity.this, movieLijst);

        //linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //dividerItemDecoration = new DividerItemDecoration(mList.getContext(),linearLayoutManager.getOrientation());

       /* mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);*/

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_Layout);
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Favorieten"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        final PageAdapter adapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

            //getData();
        }


    /*private void getData() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest (Request.Method.GET,url,null, new Response.Listener<JSONObject>() {
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
