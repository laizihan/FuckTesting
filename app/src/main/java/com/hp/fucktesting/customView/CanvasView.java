package com.hp.fucktesting.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.hp.fucktesting.R;

/**
 * Created by laizihan on 9/14/15.
 */
public class CanvasView extends View {
    private Paint mPaint;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#00ff00"));

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        Rect bounds = drawable.getBounds();
        canvas.drawLine(bounds.left,bounds.top,bounds.right,bounds.bottom,mPaint);
        drawable.draw(canvas);
    }
}
