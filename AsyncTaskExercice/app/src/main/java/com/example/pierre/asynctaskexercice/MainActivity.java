package com.example.pierre.asynctaskexercice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageIV;
    Button loadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.imageIV = (ImageView) findViewById(R.id.image);
        this.loadButton = (Button) findViewById(R.id.loadButton);

        this.loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyImage mi = new MyImage("http://www.jqueryscript.net/images/Simplest-Responsive-jQuery-Image-Lightbox-Plugin-simple-lightbox.jpg", imageIV);
                new DownloadImageTask().execute(mi);
            }
        });
    }
}
