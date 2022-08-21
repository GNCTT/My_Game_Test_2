package com.example.mygametest;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Background {

    int x = 0, y = 0;
    Bitmap background;
    Bitmap background2;

    Background(int screenX, int screenY, Resources res) {

        background = BitmapFactory.decodeResource(res, R.drawable.sky);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);

        background2 = BitmapFactory.decodeResource(res, R.drawable.back1);
        background2 = Bitmap.createScaledBitmap(background, screenX, screenY, false);

    }

}
