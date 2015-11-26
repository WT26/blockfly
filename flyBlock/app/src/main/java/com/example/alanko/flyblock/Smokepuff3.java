package com.example.alanko.flyblock;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;



public class Smokepuff3 extends GameObject{
    public int r;
    public Smokepuff3(int x, int y)
    {
        r = 7;
        super.x = x;
        super.y = y;
    }
    public void update()
    {
        y+=4;
        x-=6;
    }
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.rgb(0,82,135));
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x+10, y + 30, r, paint);



    }

}