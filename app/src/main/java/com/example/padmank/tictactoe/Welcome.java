package com.example.padmank.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Welcome extends AppCompatActivity {
   public static final String EXTRA_TEXT = "nameo";
    public static final String EXTRA_TEXT2 = "nameo2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button start = (Button) findViewById(R.id.startBtn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMainScrn();
            }
        });

        Button tutorial = (Button) findViewById(R.id.tutorial);
        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                goToVideo();
            }
        });
    }

    private void goToMainScrn() {
        EditText p1Text = (EditText) findViewById(R.id.p1EditText);
        String p1Name = p1Text.getText().toString();
        EditText p2Text = (EditText) findViewById(R.id.p2EditText);
        String p2Name = p2Text.getText().toString();

        Intent intent = new Intent(Welcome.this, MainActivity.class);
        intent.putExtra(EXTRA_TEXT, p1Name);
        intent.putExtra(EXTRA_TEXT2, p2Name);
        Welcome.this.startActivity(intent);
    }

    private void goToVideo() {
        Intent intent = new Intent(Welcome.this, videoScrn.class);
        Welcome.this.startActivity(intent);
    }


}
