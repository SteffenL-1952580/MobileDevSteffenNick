package com.example.a11601743.firstproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a11601743.firstproject.DbHelper.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment {

    private RecyclerView mList;
    private List<Movie> movieLijst;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favorite_recyclerview, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mList = getView().findViewById(R.id.favorite_recycler_view);
        movieLijst= new ArrayList<>();
        adapter = new FavoriteAdapter(getContext(), movieLijst);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(),linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);

       getData();

    }

    private void getData() {
        DataBaseHelper db = new DataBaseHelper(getContext());

        List<Movie> helpList = new ArrayList<>();

        helpList = db.getAllMovies();
        for(int i = 0; i < helpList.size(); i++)
        {
            movieLijst.add(helpList.get(i));
        }

        adapter.notifyDataSetChanged();
    }

}
