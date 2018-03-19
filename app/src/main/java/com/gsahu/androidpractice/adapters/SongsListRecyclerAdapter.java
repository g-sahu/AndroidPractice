package com.gsahu.androidpractice.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gsahu.androidpractice.R;

import java.util.ArrayList;

public class SongsListRecyclerAdapter extends RecyclerView.Adapter<SongsListRecyclerAdapter.RecyclerHolder> {
    private ArrayList<String> trackInfoList;
    private static LayoutInflater inflater = null;

    public SongsListRecyclerAdapter(Context context, ArrayList<String> trackInfoList) {
        this.trackInfoList = trackInfoList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public SongsListRecyclerAdapter.RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = inflater.inflate(R.layout.item_track, parent, false);
        return new SongsListRecyclerAdapter.RecyclerHolder(rowView);
    }

    @Override
    public void onBindViewHolder(SongsListRecyclerAdapter.RecyclerHolder holder, int position) {
        holder.trackTitle.setText(trackInfoList.get(position));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return trackInfoList.size();
    }

    class RecyclerHolder extends RecyclerView.ViewHolder {
        TextView trackTitle;

        RecyclerHolder(View itemView) {
            super(itemView);
            trackTitle = (TextView) itemView.findViewById(R.id.trackTitle);
        }
    }
}