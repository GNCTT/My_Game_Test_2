package com.example.mygametest.Sprite;

import static com.example.mygametest.GameView.screenRatioX;
import static com.example.mygametest.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.mygametest.R;

public class SpriteFactory {

    public static Bitmap Image;
    public SpriteFactory() {
    }

    public static Bitmap createImage(Resources res, int id) {
        Image = BitmapFactory.decodeResource(res, R.drawable.walk1);
        int width = Image.getWidth();
        int height = Image.getHeight();
        width *= (int) screenRatioX;
        height *= (int) screenRatioY;

        width = width / 2;
        height = height / 2;
        Image = Bitmap.createScaledBitmap(Image, width, height, false);
        return Image;
    }


}
