package com.example.pierre.intentexercice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button shareIntent;
    Button insideShareIntent;
    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.label = (TextView) findViewById(R.id.label);
        this.shareIntent = (Button) findViewById(R.id.shareintent);

        this.shareIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT, "Hello World !");
                i.setType("text/plain");
                startActivity(i);
            }
        });





        this.insideShareIntent = (Button) findViewById(R.id.insideshareintent);
        this.insideShareIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ShareActivity.class);
                i.putExtra(Intent.EXTRA_TEXT, "Hello World");
                startActivityForResult(i, RESULT_OK);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Bundle res = data.getExtras();
            String result = res.getString("name");

            label.setText(result);
        }
    }
}
