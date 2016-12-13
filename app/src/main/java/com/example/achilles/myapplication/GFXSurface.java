package com.example.achilles.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by Achilles on 11/28/2016.
 */

public class GFXSurface extends Activity implements View.OnTouchListener{


    float x,y,sx,sy,fx,fy,dx,dy,animx,animy,scaledx,scaledy;
    Bitmap reso;
    Bitmap res;
    PowerManager.WakeLock wl;
    MybringbackSurface oursurfaceview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        oursurfaceview = new MybringbackSurface(this);
        reso = BitmapFactory.decodeResource(getResources(),R.drawable.win2);
        res = BitmapFactory.decodeResource(getResources(),R.drawable.win1);
        oursurfaceview.setOnTouchListener(this);
        x=0;
        y=0;
        sx=0;
        sy=0;
        fx=0;
        fy=0;
        animx=0;
        animy=0;
        scaledx=scaledy=dx=dy=0;
        setContentView(oursurfaceview);
    }

    @Override
    protected void onResume() {
        super.onResume();
        oursurfaceview.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();

            oursurfaceview.pause();
            wl.release();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x=motionEvent.getX();
        y=motionEvent.getY();
        switch(motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN :
                sx = motionEvent.getX();
                sy = motionEvent.getY();
                fx=0;
                fy=0;
                animx=0;
                animy=0;
                scaledx=scaledy=dx=dy=0;
                break;
            case MotionEvent.ACTION_UP:
                fx = motionEvent.getX();
                fy = motionEvent.getY();
                dx= fx-sx;
                dy = fy-sy;
                scaledx = dx/30;
                scaledy = dy/30;
                x=0;
                y=0;
                break;
        }
        return true;
    }

    public class MybringbackSurface extends SurfaceView implements Runnable{

        SurfaceHolder ourholder;
        Thread ourThread=null;
        boolean isrunning = false;


        public MybringbackSurface(Context context) {
            super(context);
            ourholder = getHolder();

        }
        public void resume()
        {
            isrunning = true;
            ourThread = new Thread(this);
            ourThread.start();
        }

        public void pause()
        {
            isrunning = false;
            ourThread.interrupt();
            ourThread = null;
            finish();
        }
        @Override
        public void run() {
            while(isrunning)
            {

                if(!ourholder.getSurface().isValid())
                    continue;

                Canvas canvas = ourholder.lockCanvas();
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.drawARGB(0,0,0,0);
                if( x!=0 && y!=0)
                {
                    canvas.drawBitmap(res,x-(res.getWidth())/2,y-(res.getHeight())/2,null);
                }
                if( sx!=0 && sy!=0)
                {
                    canvas.drawBitmap(reso,sx-(reso.getWidth())/2,sy-(reso.getHeight())/2,null);
                }
                if( fx!=0 && fy!=0)
                {
                    canvas.drawBitmap(res,fx-(res.getWidth())/2-animx,fy-(res.getHeight())/2-animy,null);
                    canvas.drawBitmap(reso,fx-(reso.getWidth())/2-animx,fy-(reso.getHeight())/2-animy,null);
                }
                animx = animx + scaledx;
                animy = animy + scaledy;
                ourholder.unlockCanvasAndPost(canvas);
            }

        }
    }
}
