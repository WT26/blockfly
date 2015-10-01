package com.example.alanko.flyblock;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;



public class Smokepuff2 extends GameObject{
    public int r;
    public Smokepuff2(int x, int y)
    {
        r = 5;
        super.x = x;
        super.y = y;
    }
    public void update()
    {
        y+=5;
        x-=8;
    }
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x+20, y + 40, r, paint);



    }

}