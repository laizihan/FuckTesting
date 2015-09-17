package com.hp.fucktesting.Service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

public class PlayService extends Service {
    private MediaPlayer mMediaPlayer;

    public PlayService() {
        mMediaPlayer = new MediaPlayer();
    }

    @Override
    public void onCreate() {
        Log.e("playservice", "onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("playservice", "onstartCommand" + "flags : " + flags + " startId : " + startId);
        


        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        Log.e("playservice", "onDestroy");
        super.onDestroy();
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    public void play() {
        String uri = "http://yinyueshiting.baidu.com/data2/music/124383833/12438064524840064.mp3?xcode=9f2d0c05047de59eb6f28ebc1a3b5868";

        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mMediaPlayer.setDataSource(uri);
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    Log.e("eeeee", mp + "");
                    mp.start();
                }
            });
            mMediaPlayer.prepareAsync();
//                    mediaPlayer.prepare();
//                    mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        return new PlayBinder();

    }

    public class PlayBinder extends Binder {

        public PlayService getService() {
            return PlayService.this;
        }

    }

}
