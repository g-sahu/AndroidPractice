package com.gsahu.androidpractice.activities;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gsahu.androidpractice.R;
import com.gsahu.androidpractice.fragments.FragmentA;
import com.gsahu.androidpractice.fragments.FragmentB;

public class SampleActivity extends AppCompatActivity implements FragmentA.OnTrackSelectedListener {
    private final String LOG_TAG = "SampleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        Log.d(LOG_TAG, "onCreate");
    }

    public void onTrackSelected(int position) {
        FragmentB fragmentB = (FragmentB) getFragmentManager().findFragmentById(R.id.fragment_b);

        if(fragmentB != null) {
            fragmentB.updateFragmentB(position);
        } else {
            FragmentB newFragment = new FragmentB();
            Bundle args = new Bundle();
            args.putInt("ARG_POSITION", position);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
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
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}
