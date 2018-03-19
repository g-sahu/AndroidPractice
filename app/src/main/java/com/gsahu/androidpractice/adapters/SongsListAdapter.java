package com.gsahu.androidpractice.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gsahu.androidpractice.R;

import java.util.ArrayList;

public class SongsListAdapter extends BaseAdapter {
    private ArrayList<String> trackInfoList;
    private static LayoutInflater inflater = null;

    public SongsListAdapter(Context context, ArrayList<String> trackInfoList) {
        this.trackInfoList = trackInfoList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;
        View rowView;

        if(convertView == null) {
            holder = new Holder();
            rowView = inflater.inflate(R.layout.item_track, null);
            holder.trackTitle = (TextView) rowView.findViewById(R.id.trackTitle);

            rowView.setTag(holder);
        } else {
            rowView = convertView;
            holder = (Holder) rowView.getTag();
        }

        holder.trackTitle.setText(trackInfoList.get(position));
        return rowView;
    }

    @Override
    public int getCount() {
        return trackInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return trackInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class Holder {
        TextView trackTitle;
    }
}