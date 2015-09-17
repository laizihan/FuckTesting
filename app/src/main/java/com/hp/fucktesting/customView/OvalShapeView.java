package com.hp.fucktesting.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by laizihan on 9/15/15.
 */
public class OvalShapeView extends View {
    private ShapeDrawable mShapeDrawable;
    private onScrollToPositionListner listner;

    public static interface onScrollToPositionListner {
        public void onScrollTo(int x, int y);
    }


    public void setOnscrollListener(onScrollToPositionListner l) {
        this.listner = l;
    }

    public OvalShapeView(Context context) {
        super(context);
        int x = 10;
        int y = 10;
        int width = 400;
        int height = 50;

        RectShape rectShape = new RectShape();
        OvalShape ovalShape = new OvalShape();
        mShapeDrawable = new ShapeDrawable(ovalShape);
        mShapeDrawable.getPaint().setColor(Color.parseColor("#ffffff"));
        mShapeDrawable.setBounds(x, y, width, height);


    }

    public OvalShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(0, 0, 200, 200, mShapeDrawable.getPaint());
        mShapeDrawable.draw(canvas);

    }


    public void startView() {
        this.scrollTo(-200, 0);
    }


}
