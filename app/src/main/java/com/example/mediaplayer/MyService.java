package com.example.mediaplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaExtractor;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Button;
import android.widget.Toast;

public class MyService extends Service {
    MediaPlayer mediaPlayer=new MediaPlayer();

    public int onStartCommand(Intent intent, int flags, int startId) {
        //TODO write your own code
        Toast.makeText(this,"Started Service",Toast.LENGTH_LONG).show();
        try{
            mediaPlayer.setDataSource("https://www.ssaurel.com/tmp/mymusic.mp3");
            mediaPlayer.prepare();
            mediaPlayer.start();
        }
        catch (Exception e){

        }

        return Service.START_NOT_STICKY;
    }

    public IBinder onBind(Intent intent) {
        //TODO for communication return IBinder implementation
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        // Stopping the player when service is destroyed
        mediaPlayer.stop();
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
    }
}
