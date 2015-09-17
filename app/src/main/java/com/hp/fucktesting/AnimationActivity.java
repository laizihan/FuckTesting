package com.hp.fucktesting;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private static int count = 0;
    private Toolbar toolbar;
    private RelativeLayout mContentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        mContentLayout = (RelativeLayout) findViewById(R.id.content_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Animation");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
        mContentLayout.setOnClickListener(this);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.e("onWindowFocusChange", "onWindowFocusChange has focus :"+hasFocus + "");

        super.onWindowFocusChanged(hasFocus);
    }

    public void startAnimation(View view) {
//        animatorColor(view);
//        animateKeyFrame(view);
        animateFromXML(view);
    }


    private void animatorY(View view) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "translationY", 600);
        alpha.setDuration(5000);
        alpha.start();
    }

    private void animateKeyFrame(View view) {
        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
        Keyframe kf1 = Keyframe.ofFloat(.5f, 360f);
        Keyframe kf2 = Keyframe.ofFloat(.6f, 720f);
        Keyframe kf3 = Keyframe.ofFloat(.9f, 1080f);
        Keyframe kf4 = Keyframe.ofFloat(1f, 0f);

        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("rotation", kf0, kf1, kf2, kf3, kf4);
        ObjectAnimator rotationAnim = ObjectAnimator.ofPropertyValuesHolder(view, pvhRotation);
        rotationAnim.setDuration(5000);
        rotationAnim.start();
    }

    private void animateFromXML(View view) {
        AnimatorSet animator = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.simple_animator);
        animator.setTarget(view);
        animator.start();
    }


    private void animatorColor(View view) {
        Test test = new Test(view);
        ObjectAnimator color = ObjectAnimator.ofFloat(test, "color", 0f, 1f);
        color.setDuration(3000);
        color.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 20000);
                valueAnimator.setDuration(3000);
                valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Log.e("animation", animation.getAnimatedValue().toString());
                        count++;
                    }
                });
                valueAnimator.start();

                break;
        }


    }


    public class Test {
        private final DisplayMetrics displayMetrics;
        private View wrapper;

        private float color;


        public Test(View view) {
            wrapper = view;
            displayMetrics = getResources().getDisplayMetrics();
        }


        public void setColor(float color) {
            wrapper.setAlpha(color);
            wrapper.setTranslationX(color * displayMetrics.widthPixels);
//            wrapper.setTranslationY(color * displayMetrics.heightPixels);
        }


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("activity", "activity excute");

        return super.onTouchEvent(event);
    }
}
