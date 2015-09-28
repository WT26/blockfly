package com.example.alanko.flyblock;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Alanko on 28.9.2015.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
    public static final int WIDTH = 856;
    public static final int HEIGHT = 480;
    private MainThread thread;
    private Backgroud bg;

    public GamePanel(Context context)
    {
        super(context);


        //add the call back to the surfaceholder to entercept events
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        //make gamePanel focusable so it can handle events
        setFocusable(true);
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

    @Override
     public void surfaceDestroyed(SurfaceHolder holder){
        //Try to retry game/end game
        boolean retry = true;
        while (retry)
        {
            try {
                thread.setRunning(false);
                thread.join();
            }catch (InterruptedException e){e.printStackTrace();}
            retry = false;
        }
    }

    @Override
     public void surfaceCreated(SurfaceHolder holder){

        //inserting background png file to background.java
        bg = new Backgroud(BitmapFactory.decodeResource(getResources(), R.drawable.grassbg1));
        bg.setVector(-5);
        //we can safelyt start the game loop
        thread.setRunning(true);
        thread.start();

    }
    @Override
     public boolean onTouchEvent(MotionEvent event)
    {
        return super.onTouchEvent(event);
    }
    public void update()
    {

        bg.update();

    }
    @Override
    public void draw(Canvas canvas)
    {
        final float scaleFactorX = getWidth()/WIDTH;
        final float scaleFactorY = getHeight()/HEIGHT;
        if(canvas!=null){
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX,scaleFactorY);
            bg.draw(canvas);
            canvas.restoreToCount(savedState);
        }
    }
}
