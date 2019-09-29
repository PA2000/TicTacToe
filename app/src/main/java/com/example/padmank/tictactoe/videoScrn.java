package com.example.padmank.tictactoe;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class videoScrn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_scrn);

        VideoView video = (VideoView) findViewById(R.id.videoView);
        String path = "android.resource://com.example.padmank.tictactoe/" + R.raw.tttvid;
        Uri uri = Uri.parse(path);
        video.setVideoURI(uri);

        MediaController mediaBar = new MediaController(this);
        mediaBar.setAnchorView(video);
        video.setMediaController(mediaBar);

        video.start();
    }
}
