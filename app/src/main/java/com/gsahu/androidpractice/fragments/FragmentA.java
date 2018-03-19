package com.gsahu.androidpractice.fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.gsahu.androidpractice.R;
import com.gsahu.androidpractice.adapters.SongsListAdapter;
import com.gsahu.androidpractice.utilities.Utilities;

import java.util.ArrayList;

/**
 * Created by gasahu on 28-Feb-17.
 */

public class FragmentA extends ListFragment {
    private final String LOG_TAG = "FragmentA";
    private Context context;
    private OnTrackSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnTrackSelectedListener {
        void onTrackSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(LOG_TAG, "onAttach");
        this.context = context;

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnTrackSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnTrackSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreateView");
        View view = null;
        ArrayList<String> trackInfoList;
        ListAdapter songsListAdapter;

        try {
            //Inflating the view
            view = inflater.inflate(R.layout.fragment_a, container, false);
            ListView trackListView = (ListView) view.findViewById(android.R.id.list);
            trackInfoList = Utilities.getTrackInfoList();
            songsListAdapter = new SongsListAdapter(context, trackInfoList);
            trackListView.setAdapter(songsListAdapter);
        } catch(Exception e) {
            String LOG_TAG_EXCEPTION = "Exception";
            Log.e(LOG_TAG_EXCEPTION, e.getMessage());
            //Utilities.reportCrash(e);
        }

        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Send the event to the host activity
        mCallback.onTrackSelected(position);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "onDetach");
    }
}

