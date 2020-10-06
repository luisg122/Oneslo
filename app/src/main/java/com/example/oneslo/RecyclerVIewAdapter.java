package com.example.oneslo;

import androidx.recyclerview.widget.RecyclerView;
import static androidx.constraintlayout.widget.Constraints.TAG;

import android.content.Context;
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

    private ArrayList<Gig> mApps;
    private boolean mHorizontal;
    private boolean mPager;
    private Context mContext;

    public RecyclerVIewAdapter(boolean horizontal, boolean pager, ArrayList<Gig> apps){
        mHorizontal = horizontal;
        mPager = pager;
        mApps  = apps;
    }
    // ================================================================================================================
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
        Gig app = mApps.get(position);
        viewHolder.name.setText(app.getmName());

        // Using the Glide library to compress file size of image
        mContext = viewHolder.image.getContext();
        Glide.with(mContext)
                .asBitmap()
                .load("https://images.squarespace-cdn.com/content/v1/52a0da60e4b0dfa4e47795de/1535498535340-PVPKE7556TCT3PE81QS1/ke17ZwdGBToddI8pDm48kHJjM-Evnp5g-1kf5Yv15cUUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYxCRW4BPu10St3TBAUQYVKcpWKe3KzaCrFDKPR1a1Ob8xobjReaxMuaKtrvUDoDmPO9EsdBHei1w8jR6w0UZiby/Errigal%2C-autumn-hues-X2.jpg")
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