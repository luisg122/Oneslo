package com.example.oneslo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Gig {

    private String mName;
    private String mLink;

    public Gig(){}

    public Gig(String name, String link){
        mName = name;
        mLink = link;
    }

    public String getmName() {
        return mName;
    }

    public String getmLink() {
        return mLink;
    }
}
