package wt.flyblock;


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
        y+=8;
        x-=8;
    }
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.rgb(0,82,105));
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x+20, y + 45, r, paint);



    }

}