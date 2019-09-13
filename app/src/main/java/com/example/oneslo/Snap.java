package com.example.oneslo;


import java.util.ArrayList;

public class Snap {
    private boolean padding;
    private int gravity;
    private String text;
    private ArrayList<CardView> apps;

    public Snap(int gravity, String text, boolean padding, ArrayList<CardView> apps) {
        this.gravity = gravity;
        this.text = text;
        this.padding = padding;
        this.apps = apps;
    }

    public int getGravity() {
        return gravity;
    }

    public String getText() {
        return text;
    }

    public ArrayList<CardView> getApps() {
        return apps;
    }

    public boolean getPadding() {
        return padding;
    }
}
