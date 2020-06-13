package com.moallem.task.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import com.moallem.task.R;

public class Video extends AppCompatActivity {

    VideoView videoView;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent mIntent = getIntent();
        final String v = mIntent.getStringExtra("Video");

        videoView = (VideoView) findViewById(R.id.video_view);
        final int resId = getResources().getIdentifier(v, "array", getBaseContext().getPackageName());
        String[] testArray = getResources().getStringArray(resId);

        videoView.setVideoPath(testArray[0]);
        mediaController = new MediaController(this); //Creating the media controller
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}