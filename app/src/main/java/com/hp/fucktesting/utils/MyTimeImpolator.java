package com.hp.fucktesting.utils;

import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.graphics.Color;

/**
 * Created by laizihan on 9/14/15.
 */
public class MyTimeImpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        return 0;
    }

    static class MyTypeEvaluator implements TypeEvaluator<Color>{

        @Override
        public Color evaluate(float fraction, Color startValue, Color endValue) {
            return null;
        }
    }


}



