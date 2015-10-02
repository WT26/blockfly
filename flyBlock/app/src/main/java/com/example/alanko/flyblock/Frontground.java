package com.example.alanko.flyblock;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Frontground {

    private Bitmap image;
    private int x, y, dx;

    public Frontground(Bitmap res)
    {
        image = res;
    }
    public void update()
    {
        dx = -(Missile.overallMissileSpeed/5)-3;
        x+=dx;
        if(x<-GamePanel.WIDTH){
            x=0;
        }
    }
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image, x, y,null);
        if(x<0)
        {
            canvas.drawBitmap(image, x+GamePanel.WIDTH, y, null);
        }
    }
    public void setVector(int dx)
    {
        this.dx = dx;
    }
}