package com.example.oneslo;

import androidx.recyclerview.widget.RecyclerView;
import static androidx.constraintlayout.widget.Constraints.TAG;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerVIewAdapter extends RecyclerView.Adapter<RecyclerVIewAdapter.ViewHolder>{

    private ArrayList<CardView> mApps;
    private boolean mHorizontal;
    private boolean mPager;
    private Context mContext;

    public RecyclerVIewAdapter(boolean horizontal, boolean pager, ArrayList<CardView> apps){
        mHorizontal = horizontal;
        mPager = pager;
        mApps  = apps;
    }
    // =========================================================================================
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        if(mPager) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
            return new ViewHolder(view);
        } else {
            return new ViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_view, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        CardView app = mApps.get(position);
        viewHolder.name.setText(app.getmName());

        // Using the Glide library to compress file size of image
        mContext = viewHolder.image.getContext();
        Glide.with(mContext)
                .asBitmap()
                .load(app.getmDrawable())
                .into(viewHolder.image);

        viewHolder.image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(TAG, "onClick: clicked on an image" + mApps.get(position).getmName());
                Toast.makeText(mContext, mApps.get(position).getmName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemViewType(int position){
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mApps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView  name;
        public ViewHolder(View itemView){
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image_view);
            name  = (TextView)  itemView.findViewById(R.id.name);
        }
    }
}