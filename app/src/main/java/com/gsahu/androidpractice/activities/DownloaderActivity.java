package com.gsahu.androidpractice.activities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.gsahu.androidpractice.R;

public class DownloaderActivity extends Activity implements Response.Listener<Bitmap>, Response.ErrorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloader);
    }

    public void startDownload(View view) {
        //String url = "http://starlord.hackerearth.com/gotjson";
        String url = "http://images.freeimages.com/images/previews/ad1/digital-hello-1532405.jpg";
        /*DownloadTask task = new DownloadTask(this);
        task.execute(url);*/

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        // Request a string response from the provided URL.
        //StringRequest stringRequest = new StringRequest(Request.Method.GET, params[0], this, this);
        ImageRequest imageRequest = new ImageRequest(url, this, 200, 200, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, this);

        // Add the request to the RequestQueue.
        //queue.add(stringRequest);
        queue.add(imageRequest);
        Log.d("Downloading image from", url);
    }

    @Override
    //public void onResponse(String response) {
    public void onResponse(Bitmap response) {
        Toast toast = Toast.makeText(this, "Response: " + response, Toast.LENGTH_SHORT);
        toast.show();

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(response);
        Log.d("DownloadTask", "Image downloaded");
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast toast = Toast.makeText(this, "Error:" + error.getMessage(), Toast.LENGTH_SHORT);
        toast.show();
    }
}
