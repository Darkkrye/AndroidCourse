package com.example.pierre.asynctaskexercice;

import android.widget.ImageView;

/**
 * Created by Pierre on 26/04/2017.
 */

public class MyImage {
    String URL;
    ImageView iv;

    public MyImage(String URL, ImageView iv) {
        this.URL = URL;
        this.iv = iv;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public ImageView getIv() {
        return iv;
    }

    public void setIv(ImageView iv) {
        this.iv = iv;
    }
}
