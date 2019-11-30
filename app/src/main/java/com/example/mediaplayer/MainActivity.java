package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn2;
    private boolean state;
    private boolean playPause;
    private MediaPlayer mediaPlayer;
    private ProgressDialog progressDialog;
    private boolean initialStage = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn2 = (Button) findViewById(R.id.btn2);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        progressDialog = new ProgressDialog(this);

        //progressDialog.setMessage("Buffering...");
        //progressDialog.show();
        //if (progressDialog.isShowing()) {
        //    progressDialog.cancel();
        //}
    }

    public void startservice(View view) {

        if (state==false) {
            btn2.setText("Stop");
            state=true;
            startService(new Intent(this, MyService.class));
        }
        else{
            btn2.setText("Play");
            stopService(new Intent(this, MyService.class));
            state=false;
       }
   }
}

