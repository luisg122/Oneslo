package com.example.oneslo;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;

public class Home extends Fragment {

    public static final String ORIENTATION = "orientation";
    private RecyclerView mRecyclerView;
    private boolean mHorizontal;
    private Toolbar toolbar;
    private SnapAdapter snapAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.home_activity, container, false);
        initRecyclerView(view);
        if(savedInstanceState == null) {
            mHorizontal = true;
        }
        else{
            mHorizontal = savedInstanceState.getBoolean(ORIENTATION);   // does this evaluate to false?
        }

        setUpAdapter();
        setHasOptionsMenu(true);
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater){
        // Inflate the menu; this adds items to the action bar if it is present
        // getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putBoolean(ORIENTATION, mHorizontal);
    }

    private void initRecyclerView(View view){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemViewCacheSize(20);
        mRecyclerView.setDrawingCacheEnabled(true);
        mRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
    }

    private void setUpAdapter(){
        ArrayList<Gig> apps  = getApps();
        ArrayList<Gig> apps1 = getApps1();
        snapAdapter  = new SnapAdapter();
        if(mHorizontal){
            snapAdapter.addSnap(new Snap(Gravity.START, "Technology", false, getApps()));
            snapAdapter.addSnap(new Snap(Gravity.START, "Business", false, getApps1()));
            snapAdapter.addSnap(new Snap(Gravity.START, "Education and Tutoring", false, getApps2()));
            snapAdapter.addSnap(new Snap(Gravity.START, "Entertainment and Media", false, getApps4()));
            snapAdapter.addSnap(new Snap(Gravity.START, "Fashion and Beauty", false, getApps6()));
            mRecyclerView.setAdapter(snapAdapter);
        }
        else{
            RecyclerVIewAdapter adapter = new RecyclerVIewAdapter(false, false, apps);
            mRecyclerView.setAdapter(adapter);
            new GravitySnapHelper(Gravity.TOP, false, new GravitySnapHelper.SnapListener(){
                @Override
                public void onSnap(int position){
                    Log.d("Snapped", position + " ");
                }
            }).attachToRecyclerView(mRecyclerView);
        }
    }

    private ArrayList<Gig> getApps(){
        ArrayList<Gig> apps = new ArrayList<>();
        apps.add(new Gig("Data Science", " "));
        apps.add(new Gig("Web Development", " "));
        apps.add(new Gig("App Development", " "));
        apps.add(new Gig("Hardware Setup", " "));
        apps.add(new Gig("DevOps", " "));
        apps.add(new Gig("Database Design", " "));
        apps.add(new Gig("Information Technology", " "));
        apps.add(new Gig("Networking", " "));
        apps.add(new Gig("Graphic Design", " "));
        return apps;
    }

    private ArrayList<Gig> getApps1(){
        ArrayList<Gig> apps = new ArrayList<>();
        apps.add(new Gig("Accounting", " "));
        apps.add(new Gig("Business Intelligence", " "));
        apps.add(new Gig("Marketing", " "));
        apps.add(new Gig("Consulting",  " "));
        apps.add(new Gig("Actuary", " "));
        apps.add(new Gig("Finance", " "));
        apps.add(new Gig("Human Resources", " "));
        apps.add(new Gig("Entrepreneurship",  " "));
        apps.add(new Gig("Real Estate", " "));
        apps.add(new Gig("Sales", " "));
        return apps;
    }

    private ArrayList<Gig> getApps2(){
        ArrayList<Gig> apps = new ArrayList<>();
        apps.add(new Gig("Mathematics", " "));
        apps.add(new Gig("Writing", " "));
        apps.add(new Gig("Science",  " "));
        apps.add(new Gig("Medical Education", " "));
        apps.add(new Gig("Technology Education", " "));
        apps.add(new Gig("Law Education", " "));
        apps.add(new Gig("Business Education", " "));
        apps.add(new Gig("Language Education",  " "));
        apps.add(new Gig("Standardized Testing", " "));
        return apps;
    }

    private ArrayList<Gig> getApps4(){
        ArrayList<Gig> apps = new ArrayList<>();
        apps.add(new Gig("Journalism", " "));
        apps.add(new Gig("Dancing", " "));
        apps.add(new Gig("Acting", " "));
        apps.add(new Gig("Music"," "));
        apps.add(new Gig("Art", " "));
        apps.add(new Gig("Photography"," "));
        apps.add(new Gig("Film", " "));
        apps.add(new Gig("Social Media",  " "));
        apps.add(new Gig("Blogging", " "));
        return apps;
    }

    private ArrayList<Gig> getApps6(){
        ArrayList<Gig> apps = new ArrayList<>();
        apps.add(new Gig("Modeling", " "));
        apps.add(new Gig("Cosmetology", " "));
        apps.add(new Gig("Fashion Designer", " "));
        apps.add(new Gig("Fashion writing",  " "));
        apps.add(new Gig("Fashion Photography", " "));
        apps.add(new Gig("Fashion Illustrator", " "));
        apps.add(new Gig("Fashion Stylist", " "));
        apps.add(new Gig("Seamstress", " "));
        apps.add(new Gig("Tailor", " "));
        return apps;
    }
}