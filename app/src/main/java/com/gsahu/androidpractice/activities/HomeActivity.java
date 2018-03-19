package com.gsahu.androidpractice.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.gsahu.androidpractice.R;
import com.gsahu.androidpractice.adapters.MoviesAdapter;
import com.gsahu.androidpractice.model.Movie;
import com.gsahu.androidpractice.model.MoviesResponse;
import com.gsahu.androidpractice.services.IMovieApi;
import com.gsahu.androidpractice.services.MoviesApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends Activity {
    public static final String LOG_TAG_EXCEPTION = "Exception";
    private final static String API_KEY = "41cb5675b2f4f69335d314e12b5c1849";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        try {
            if (API_KEY.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
                return;
            }

            final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            IMovieApi apiService = MoviesApiClient.getClient().create(IMovieApi.class);
            Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);

            call.enqueue(new Callback<MoviesResponse>() {
                @Override
                public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                    List<Movie> movies = response.body().getResults();
                    recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.item_movie, getApplicationContext()));
                }

                @Override
                public void onFailure(Call<MoviesResponse> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(LOG_TAG_EXCEPTION, t.toString());
                }
            });
        } catch(Exception e) {
            Log.e(LOG_TAG_EXCEPTION, e.getMessage());
            //Utilities.reportCrash(e);
        }
    }
}
