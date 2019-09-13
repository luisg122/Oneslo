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

public class Home extends Fragment{

    public static final String ORIENTATION = "orientation";
    private RecyclerView mRecyclerView;
    private boolean mHorizontal;
    private Toolbar toolbar;

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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        // Inflate the menu; this adds items to the action bar if it is present
        //getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putBoolean(ORIENTATION, mHorizontal);
    }

    private void setUpAdapter(){
        ArrayList<CardView> apps  = getApps();
        ArrayList<CardView> apps1 = getApps1();
        SnapAdapter snapAdapter   = new SnapAdapter();
        if(mHorizontal){
            snapAdapter.addSnap(new Snap(Gravity.START, "Technology", false, getApps()));
            snapAdapter.addSnap(new Snap(Gravity.START, "Business", false, getApps1()));
            snapAdapter.addSnap(new Snap(Gravity.START, "Education and Tutoring", false, getApps2()));
            snapAdapter.addSnap(new Snap(Gravity.START, "Legal", false, getApps3()));
            snapAdapter.addSnap(new Snap(Gravity.START, "Entertainment and Media", false, getApps4()));
            snapAdapter.addSnap(new Snap(Gravity.START, "Food and Beverage", false, getApps5()));
            snapAdapter.addSnap(new Snap(Gravity.START, "Fashion and Beauty", false, getApps6()));
            snapAdapter.addSnap(new Snap(Gravity.START, "Medical and Health", false, getApps7()));
            snapAdapter.addSnap(new Snap(Gravity.START, "Engineering and Construction", false, getApps8()));
            snapAdapter.addSnap(new Snap(Gravity.START, "Hospitality", false, getApps9()));
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

    private ArrayList<CardView> getApps(){
        ArrayList<CardView> apps = new ArrayList<>();
        apps.add(new CardView("Data Science", R.drawable.datascience));
        apps.add(new CardView("Web Development", R.drawable.webdevelopment));
        apps.add(new CardView("App Development", R.drawable.appdevelopment));
        apps.add(new CardView("Hardware Setup", R.drawable.hardwaresetup));
        apps.add(new CardView("DevOps", R.drawable.devops));
        apps.add(new CardView("Database Design", R.drawable.databse));
        apps.add(new CardView("Information Technology", R.drawable.it));
        apps.add(new CardView("Networking", R.drawable.networking));
        apps.add(new CardView("Graphic Design", R.drawable.design));
        return apps;
    }

    private ArrayList<CardView> getApps1(){
        ArrayList<CardView> apps = new ArrayList<>();
        apps.add(new CardView("Accounting", R.drawable.accounting));
        apps.add(new CardView("Business Intelligence", R.drawable.businessintel));
        apps.add(new CardView("Marketing", R.drawable.advertising));
        apps.add(new CardView("Consulting",  R.drawable.consulting));
        apps.add(new CardView("Actuary", R.drawable.actuary));
        apps.add(new CardView("Finance", R.drawable.finance));
        apps.add(new CardView("Human Resources", R.drawable.humanrec));
        apps.add(new CardView("Entrepreneurship",  R.drawable.entrepren));
        apps.add(new CardView("Real Estate", R.drawable.realestate));
        apps.add(new CardView("Sales", R.drawable.sales));
        return apps;
    }

    private ArrayList<CardView> getApps2(){
        ArrayList<CardView> apps = new ArrayList<>();
        apps.add(new CardView("Mathematics", R.drawable.math));
        apps.add(new CardView("Writing", R.drawable.writinged));
        apps.add(new CardView("Science",  R.drawable.science));
        apps.add(new CardView("Medical Education", R.drawable.medical));
        apps.add(new CardView("Technology Education", R.drawable.teched));
        apps.add(new CardView("Law Education", R.drawable.lawed));
        apps.add(new CardView("Business Education", R.drawable.businessed));
        apps.add(new CardView("Language Education",  R.drawable.lawed));
        apps.add(new CardView("Standardized Testing", R.drawable.standardized));
        return apps;
    }

    private ArrayList<CardView> getApps3(){
        ArrayList<CardView> apps = new ArrayList<>();
        apps.add(new CardView("Lawyer", R.drawable.lawyer));
        apps.add(new CardView("Paralegal", R.drawable.paralegal));
        apps.add(new CardView("Legal Consulting",  R.drawable.legalconsult));
        apps.add(new CardView("Electronic Discovery", R.drawable.ediscov));
        apps.add(new CardView("Mediator", R.drawable.legalmediator));
        apps.add(new CardView("Court Reporting", R.drawable.courtrep));
        apps.add(new CardView("Legal Researcher", R.drawable.legalres));
        apps.add(new CardView("Legal Secretary",  R.drawable.legalsecretary));
        apps.add(new CardView("Legal Translators", R.drawable.legaltrans));
        return apps;
    }

    private ArrayList<CardView> getApps4(){
        ArrayList<CardView> apps = new ArrayList<>();
        apps.add(new CardView("Journalism", R.drawable.journalism));
        apps.add(new CardView("Dancing", R.drawable.dancing));
        apps.add(new CardView("Acting",  R.drawable.acting));
        apps.add(new CardView("Music", R.drawable.music));
        apps.add(new CardView("Art", R.drawable.art));
        apps.add(new CardView("Photography", R.drawable.photography));
        apps.add(new CardView("Film", R.drawable.film));
        apps.add(new CardView("Social Media",  R.drawable.socialmedia));
        apps.add(new CardView("Blogging", R.drawable.blogging));
        return apps;
    }

    private ArrayList<CardView> getApps5(){
        ArrayList<CardView> apps = new ArrayList<>();
        apps.add(new CardView("Catering", R.drawable.catering));
        apps.add(new CardView("Nutritionist", R.drawable.nutrionist));
        apps.add(new CardView("Food Writing",  R.drawable.foodwriting));
        apps.add(new CardView("Food Photography", R.drawable.foodphoto));
        apps.add(new CardView("Urban Farmer", R.drawable.urbanfarm));
        apps.add(new CardView("Chefs", R.drawable.chef));
        apps.add(new CardView("Cooks", R.drawable.cooks));
        apps.add(new CardView("Dietitian", R.drawable.dietician));
        return apps;
    }

    private ArrayList<CardView> getApps6(){
        ArrayList<CardView> apps = new ArrayList<>();
        apps.add(new CardView("Modeling", R.drawable.modeling));
        apps.add(new CardView("Cosmetology", R.drawable.cosmet));
        apps.add(new CardView("Fashion Designer", R.drawable.fashiondes));
        apps.add(new CardView("Fashion writing",  R.drawable.fashionwrite));
        apps.add(new CardView("Fashion Photography", R.drawable.fashionphoto));
        apps.add(new CardView("Fashion Illustrator", R.drawable.fashionillu));
        apps.add(new CardView("Fashion Stylist", R.drawable.fashionstyle));
        apps.add(new CardView("Seamstress", R.drawable.seamstress));
        apps.add(new CardView("Tailor", R.drawable.tailor));
        return apps;
    }

    private ArrayList<CardView> getApps7(){
        ArrayList<CardView> apps = new ArrayList<>();
        apps.add(new CardView("Medical Interpreter", R.drawable.medicalinter));
        apps.add(new CardView("Medical Writing", R.drawable.medicalwrite));
        apps.add(new CardView("Fitness Training", R.drawable.fitness));
        apps.add(new CardView("Medical Consulting",  R.drawable.medicalconsult));
        apps.add(new CardView("Physician", R.drawable.physician));
        apps.add(new CardView("Nurse", R.drawable.nurse));
        apps.add(new CardView("Medical Administration", R.drawable.medicaladmin));
        apps.add(new CardView("Transcription", R.drawable.transcription));
        apps.add(new CardView("Therapy", R.drawable.therapy));
        return apps;
    }

    private ArrayList<CardView> getApps8(){
        ArrayList<CardView> apps = new ArrayList<>();
        apps.add(new CardView("Construction Labor", R.drawable.constructionlabor));
        apps.add(new CardView("Electrician", R.drawable.electrician));
        apps.add(new CardView("Plumbing", R.drawable.plumbing));
        apps.add(new CardView("Mechanic",  R.drawable.mechanic));
        apps.add(new CardView("Architect", R.drawable.architect));
        apps.add(new CardView("Engineering", R.drawable.engineering));
        apps.add(new CardView("Welding", R.drawable.welding));
        apps.add(new CardView("Masonry", R.drawable.masonry));
        apps.add(new CardView("Carpenter", R.drawable.carpenter));
        apps.add(new CardView("Installation", R.drawable.installation));
        return apps;
    }

    private ArrayList<CardView> getApps9(){
        ArrayList<CardView> apps = new ArrayList<>();
        apps.add(new CardView("Event Planning", R.drawable.eventplan));
        //apps.add(new CardView("Wedding Services", R.drawable.wedding));
        apps.add(new CardView("Tourism", R.drawable.tourist));
        //apps.add(new CardView("Restaurant Services",  R.drawable.restaurantser));
        apps.add(new CardView("Cleaning Services", R.drawable.cleaning));
        apps.add(new CardView("Dog Walking", R.drawable.dogwalking));
        apps.add(new CardView("Babysitting", R.drawable.babysitting));
        apps.add(new CardView("Translation Services", R.drawable.translation));
        return apps;
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
}