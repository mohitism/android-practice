package com.example.achilles.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;

/**
 * Created by Achilles on 11/27/2016.
 */

public class Mybringback extends View {


    Bitmap gball;
    int changingY;
    Typeface font;
    public Mybringback(Context context) {
        super(context);
        gball = BitmapFactory.decodeResource(getResources(),R.drawable.win);
        changingY=0;
        font = Typeface.createFromAsset(context.getAssets(),"gsf.ttf");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.MAGENTA);
        Paint mypaint = new Paint();
        mypaint.setARGB(255,255,255,255);
        mypaint.setTextAlign(Paint.Align.CENTER);
        mypaint.setTextSize(50);
        mypaint.setTypeface(font);
        canvas.drawText("MyBringBack",(canvas.getWidth())/2,200,mypaint);


        canvas.drawBitmap(gball,(canvas.getWidth())/4,changingY, null);
        if(changingY<canvas.getHeight())
        {
            changingY+=10;
        }
        else
        {
            changingY=0;
        }
        Rect middleRect = new Rect();
        middleRect.set(0,400,canvas.getWidth(),550);
        Paint ourblue = new Paint();
        ourblue.setColor(Color.BLUE);
        canvas.drawRect(middleRect,ourblue);


        invalidate();
    }
}
