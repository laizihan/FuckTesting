package com.hp.fucktesting;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.hp.fucktesting.customView.CircleView;
import com.hp.fucktesting.customView.OvalShapeView;

public class DrawActivity extends AppCompatActivity {
    private Button mButton;
    private ImageView mImageView;

    private TabLayout tabLayout;
    private OvalShapeView ovalShapeView;
    private ViewGroup parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        parent = (ViewGroup) findViewById(R.id.draw_content_view);
        mButton = (Button) findViewById(R.id.btn_draw);
        mImageView = (ImageView) findViewById(R.id.iv_test_draw);
        ovalShapeView = new OvalShapeView(this);
        parent.addView(ovalShapeView);


    }


    public void testDraw(View view) {
//        Drawable drawable = getResources().getDrawable(R.drawable.expand_collapse);
//        mImageView.setImageDrawable(drawable);
//        ovalShapeView.startView();
        CircleView circleView = new CircleView(this);
        circleView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        parent.addView(circleView);


    }


}
