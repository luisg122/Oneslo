package com.example.oneslo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CardView extends AppCompatActivity {

    private String mName;
    private int mDrawable;

    public CardView(){
        this.mName = null;
        this.mDrawable = 0;
    }

    public CardView(String name, int drawable){
        mName = name;
        mDrawable = drawable;
    }

    public String getmName() {
        return mName;
    }

    public int getmDrawable() {
        return mDrawable;
    }

}
