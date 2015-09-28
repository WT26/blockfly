package com.example.alanko.flyblock;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Alanko on 28.9.2015.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
    private MainThread thread;
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

    }
}
