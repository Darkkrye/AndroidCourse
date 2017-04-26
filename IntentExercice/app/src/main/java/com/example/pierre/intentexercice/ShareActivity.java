package com.example.pierre.intentexercice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    TextView sharedLabel;
    Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        this.sharedLabel = (TextView) findViewById(R.id.sharedLabel);
        this.returnButton = (Button) findViewById(R.id.returnButton);

        Intent i = getIntent();
        this.sharedLabel.setText(this.sharedLabel.getText() + " " + i.getStringExtra(Intent.EXTRA_TEXT));

        this.returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity();
            }
        });
    }

    private void finishActivity() {
        Bundle conData = new Bundle();
        conData.putString("name", (String) sharedLabel.getText());

        Intent i = new Intent();
        i.putExtras(conData);

        setResult(RESULT_OK, i);
        finish();
    }
}
