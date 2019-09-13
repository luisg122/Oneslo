package com.example.oneslo;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.rubensousa.gravitysnaphelper.GravityPagerSnapHelper;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;



public class SnapAdapter extends RecyclerView.Adapter<SnapAdapter.ViewHolder> implements GravitySnapHelper.SnapListener{

    public static final int VERTICAL   = 0;     // value indicator for vertical   scrolling
    public static final int HORIZONTAL = 1;     // value indicator for horizontal scrolling

    private ArrayList<Snap> snaps;

    public SnapAdapter(){
        snaps = new ArrayList<>();
    }

    public void addSnap(Snap snap){
        snaps.add(snap);
    }

    @Override
    public int getItemViewType(int position){
        Snap snap = snaps.get(position);
        switch(snap.getGravity()){
            case Gravity.CENTER_VERTICAL:
                return VERTICAL;
            case Gravity.CENTER_HORIZONTAL:
                return HORIZONTAL;
            case Gravity.START:
                return HORIZONTAL;
            case Gravity.TOP:
                return VERTICAL;
            case Gravity.END:
                return HORIZONTAL;
            case Gravity.BOTTOM:
                return VERTICAL;
        }
        return HORIZONTAL;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = viewType == VERTICAL ? LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_vertical, parent, false)
                :LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.bind(snaps.get(position));
        Snap snap = snaps.get(position);

        if (!snap.getPadding()) {
            holder.recyclerView.setPadding(0, 0, 0, 0);
        }

        if (snap.getGravity() == Gravity.START || snap.getGravity() == Gravity.END) {
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder
                    .recyclerView.getContext(), RecyclerView.HORIZONTAL, false));
            new GravitySnapHelper(snap.getGravity(), false, this).attachToRecyclerView(holder.recyclerView);
        }
        if (snap.getGravity() == Gravity.CENTER) { // Pager snap
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder
                    .recyclerView.getContext(), RecyclerView.HORIZONTAL, false));
            new GravityPagerSnapHelper(Gravity.START).attachToRecyclerView(holder.recyclerView);
        }

        holder.recyclerView.setAdapter(new RecyclerVIewAdapter(snap.getGravity() == Gravity.START
                || snap.getGravity() == Gravity.END || snap.getGravity() == Gravity.CENTER_HORIZONTAL,
                snap.getGravity() == Gravity.CENTER, snap.getApps()));
    }

    @Override
    public int getItemCount() {
        return snaps.size();
    }

    @Override
    public void onSnap(int position) {
        Log.d("Snapped", position + "");
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView snapTextView;
        public RecyclerView recyclerView;
        private Snap snap;

        public ViewHolder(View itemView){
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerView);
            snapTextView = itemView.findViewById(R.id.snapTextView);
        }

        public void bind(Snap snap){
            this.snap = snap;
            snapTextView.setText(snap.getText());
        }

        @Override
        public void onClick(View v) {
            RecyclerView.OnFlingListener listener = recyclerView.getOnFlingListener();
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

            if (listener instanceof GravitySnapHelper
                    && layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager lm = (LinearLayoutManager) layoutManager;

                int firstVisiblePosition = snap.getGravity() == Gravity.START ?
                        lm.findFirstCompletelyVisibleItemPosition()
                        : lm.findLastCompletelyVisibleItemPosition();

                if (firstVisiblePosition != RecyclerView.NO_POSITION) {
                    ((GravitySnapHelper) listener).smoothScrollToPosition(
                            firstVisiblePosition + 1);
                }
            }
        }
    }
}