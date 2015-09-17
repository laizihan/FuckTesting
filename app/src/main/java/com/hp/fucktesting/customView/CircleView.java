package com.hp.fucktesting.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by laizihan on 9/16/15.
 */
public class CircleView extends View {

    private Paint mPaint;

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleView(Context context) {
        super(context);
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#ffffff"));

    }


    @Override
    protected void onDraw(Canvas canvas) {
        Rect rect = new Rect(100, 100, 500, 500);
        canvas.drawCircle(rect.centerX(),rect.centerY(),rect.height()/2,mPaint);

    }
}
