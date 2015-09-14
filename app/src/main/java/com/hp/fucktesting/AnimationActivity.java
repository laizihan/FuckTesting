package com.hp.fucktesting;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

public class AnimationActivity extends AppCompatActivity {

    private static int count = 0;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Animation");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
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
            }
        });


    }

    public void startAnimation(View view) {
        animatorColor(view);

    }

    private void animatorY(View view) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "translationY", 600);
        alpha.setDuration(5000);
        alpha.start();
    }


    private void animatorColor(View view) {
        Test test = new Test(view);
        ObjectAnimator color = ObjectAnimator.ofFloat(test, "color", 0f, 1f);
        color.setDuration(3000);
        color.start();
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


}
