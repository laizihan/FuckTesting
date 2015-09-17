package com.hp.fucktesting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                startActivity(new Intent(this, WebviewActivity.class));
                break;

            case R.id.action_design:
                startActivity(new Intent(this, TestMateralDesignActivity.class));
                break;

            case R.id.action_webview:
                startActivity(new Intent(this, WebviewActivity.class));
                break;

            case R.id.action_zoom:
                startActivity(new Intent(this, ZoomActivity.class));
                break;
            case R.id.action_Mdesign:
                startActivity(new Intent(this, DesignActivity.class));
                break;
            case R.id.action_media:
                startActivity(new Intent(this, MediaActivity.class));
                break;

            case R.id.action_swipe:
                startActivity(new Intent(this, SwipeRefreshActivity.class));
                break;
            case R.id.action_animation:
                startActivity(new Intent(this, AnimationActivity.class));
                break;
            case R.id.action_draw:
                startActivity(new Intent(this, DrawActivity.class));
                break;
            case R.id.action_tab:
                startActivity(new Intent(this, TabLayoutActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
