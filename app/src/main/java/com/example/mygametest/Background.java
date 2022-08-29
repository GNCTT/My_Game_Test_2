package com.example.mygametest;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Background {

    public static int checkChange = 1;

    int x = 0, y = 0;
    Bitmap ImageBackGround;
    Bitmap background;
    Bitmap background2;
    public Resources res;
    public int screenX;
    public int screenY;

    Background(int screenX, int screenY, Resources res) {
        this.res = res;
        this.screenX = screenX;
        this.screenY = screenY;
        background = BitmapFactory.decodeResource(res, R.drawable.cityskyline);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);

        background2 = BitmapFactory.decodeResource(res, R.drawable.background_01);
        background2 = Bitmap.createScaledBitmap(background, screenX, screenY, false);
        ImageBackGround = background;
    }

    public void update() {
        if (checkChange == 1) {
            ImageBackGround = BitmapFactory.decodeResource(res, R.drawable.background_01);
        } else {
            ImageBackGround = BitmapFactory.decodeResource(res, R.drawable.cityskyline);
        }
        ImageBackGround = Bitmap.createScaledBitmap(background, screenX, screenY, false);
    }

}
