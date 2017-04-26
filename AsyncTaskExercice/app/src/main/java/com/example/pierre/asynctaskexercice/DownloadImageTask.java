package com.example.pierre.asynctaskexercice;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Pierre on 26/04/2017.
 */

public class DownloadImageTask extends AsyncTask<MyImage, Void, Bitmap> {

    MyImage myImage = null;

    @Override
    protected Bitmap doInBackground(MyImage... params) {
        this.myImage = params[0];
        return downloadImage(this.myImage.getURL());
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        this.myImage.getIv().setImageBitmap(bitmap);
    }

    private Bitmap downloadImage(String url) {
        Bitmap bm = null;
        try {
            URL aURL = new URL(url);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            Log.e("Hub","Error getting the image from server : " + e.getMessage().toString());
        }
        return bm;
    }
}
