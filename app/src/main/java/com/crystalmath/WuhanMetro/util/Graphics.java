package com.crystalmath.WuhanMetro.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

public class Graphics {
    public static Bitmap makeTintBitmap(Bitmap inputBitmap, int tintColor) {
        if (inputBitmap == null) {
            return null;
        }

        Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap.getWidth(), inputBitmap.getHeight(), inputBitmap.getConfig());
        Canvas canvas = new Canvas(outputBitmap);
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(tintColor, PorterDuff.Mode.MULTIPLY));
        canvas.drawBitmap(inputBitmap, 0, 0, paint);
        return outputBitmap;
    }
}
