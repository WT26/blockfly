package com.example.alanko.flyblock;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;



public class Smokepuff extends GameObject{
    public int r;
    public Smokepuff(int x, int y)
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
        paint.setColor(Color.rgb(0,150,190));
        paint.setStyle(Paint.Style.STROKE);


        canvas.drawCircle(x + 30, y + 40, r + 5, paint);

        //paint.setStyle(Paint.Style.FILL);
        //canvas.drawCircle(x+20, y + 40, r, paint);



    }

}