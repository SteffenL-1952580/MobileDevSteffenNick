package com.example.a11601743.firstproject;

import android.Manifest;
import android.content.Context;
import android.content.res.Configuration;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.a11601743.firstproject.Notification.NotificationBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements LocationListener {


   private RecyclerView mList;
   private LinearLayoutManager linearLayoutManager;
   private DividerItemDecoration dividerItemDecoration;
   private List<Movie> movieLijst;
   private RecyclerView.Adapter adapter;
   private PageAdapter pageAdapter;
   //private ViewPager viewPager;
   private TabLayout tabLayout;
   private Toolbar toolbar;
   private LocationManager locationManager;
    //private String url =  "https://api.themoviedb.org/3/movie/550?api_key=7878b83d58394c2db83e16b69d3c57d0";
    private String url =  "https://api.themoviedb.org/3/movie/now_playing?api_key=7878b83d58394c2db83e16b69d3c57d0&page=1";



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);


       final FragmentManager manager = getSupportFragmentManager();
       final FragmentTransaction transaction = manager.beginTransaction();

       if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

           transaction.add(R.id.detail, new DetailFragment());
           transaction.commit();
       }


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_Layout);
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Favorites"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        getLocation();

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        final PageAdapter adapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    Fragment fragment = manager.findFragmentById(R.id.detail);
                    FragmentTransaction transaction1 = manager.beginTransaction();


                    if (tab.getPosition() == 1) {

                        transaction1.remove(fragment);
                        transaction1.commit();
                    }else{
                        transaction1.add(R.id.detail, new DetailFragment());
                        transaction1.commit();
                    }
                }

                viewPager.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


        }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this);

            //Location l = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onLocationChanged(Location location) {
        try {

            double lat = location.getLatitude();
            double lon = location.getLongitude();
            NotificationBuilder notificationBuilder = new NotificationBuilder(this);

            notificationBuilder.giveNotification("MovieApp" , "You are at location lon: " + lon + " lat: " + lat);
            locationManager = null;


        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {
        Toast.makeText(MainActivity.this, "Please enable GPS know when you can watch to the stars.", Toast.LENGTH_SHORT).show();
    }


}
