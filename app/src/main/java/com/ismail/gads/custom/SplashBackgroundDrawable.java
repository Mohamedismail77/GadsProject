package com.ismail.gads.custom;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class SplashBackgroundDrawable extends Drawable {
    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void draw(@NonNull Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawRect(getBounds(),paint);
        paint.setColor(Color.parseColor("#141414"));
        paint.setStyle(Paint.Style.FILL);
        Path mPath = new Path();
        mPath.reset();
        mPath.moveTo(0,0);
        mPath.lineTo(getBounds().right*0.3f,0);
        mPath.cubicTo(getBounds().right*0.26f,getBounds().bottom*0.25f,0,getBounds().bottom*0.25f,0,getBounds().bottom*0.25f);
        canvas.drawPath(mPath,paint);
        mPath.reset();
        mPath.moveTo(0,getBounds().bottom);
        mPath.lineTo(0,(getBounds().bottom-getBounds().bottom*0.05f));
        mPath.quadTo(0,(getBounds().bottom-getBounds().bottom*0.2f),getBounds().right,(getBounds().bottom-getBounds().bottom*0.3f));
        //mPath.cubicTo(,0,(getBounds().bottom-getBounds().bottom*0.2f),);
        mPath.lineTo(getBounds().right,getBounds().bottom);

        canvas.drawPath(mPath,paint);
    }

    private float getRight(int right, double v) {
        return (float) ((float)right * v);
    }


}

