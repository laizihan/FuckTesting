package com.hp.fucktesting;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.hp.fucktesting.Service.PlayService;

public class MediaActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton;
    private Button mPlayCommandButton;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        initViews();

    }

    private void initViews() {
        mButton = (Button) findViewById(R.id.btn_play_sound);
        mButton.setOnClickListener(this);
        mPlayCommandButton = (Button) findViewById(R.id.btn_play_via_start_command);
        mPlayCommandButton.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_media, menu);
        return true;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unbindService(mConnection);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_play_sound:
                Intent intent = new Intent(this, PlayService.class);

                bindService(intent, mConnection, BIND_AUTO_CREATE);


//                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.nokia);


                break;

            case R.id.btn_play_via_start_command:

//                Log.e("play", "btn_via_start");
                Intent playIntent = new Intent(this, PlayService.class);
                startService(playIntent);
                break;


        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            PlayService.PlayBinder playBinder = (PlayService.PlayBinder) service;
            PlayService playService = playBinder.getService();
            playService.play();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("playservice", name.getClassName());
        }
    };

}
