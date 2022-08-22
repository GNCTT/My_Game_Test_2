package com.example.mygametest.Sprite;

import android.graphics.Bitmap;

import com.example.mygametest.Player;
import com.example.mygametest.R;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

public class Sprite {

    private Resources res;
    public Bitmap player_walk1;
    public Bitmap player_walk2;
    public Bitmap player_walk3;
    public Bitmap player_walk4;
    public Bitmap player_walk5;
    public Bitmap player_walk6;

    public ArrayList<Bitmap> player_walk = new ArrayList<>();
    public Sprite(Resources res) {
        player_walk1 = createBitMap(res, R.drawable.walk1);
        player_walk2 = createBitMap(res, R.drawable.walk2);
        player_walk3 = createBitMap(res, R.drawable.walk3);
        player_walk4 = createBitMap(res, R.drawable.walk4);
        player_walk5 = createBitMap(res, R.drawable.walk5);
        player_walk6 = createBitMap(res, R.drawable.walk6);
        player_walk.add(createBitMap(res, R.drawable.walk1));
        player_walk.add(createBitMap(res, R.drawable.walk2));
        player_walk.add(createBitMap(res, R.drawable.walk3));
        player_walk.add(createBitMap(res, R.drawable.walk4));
        player_walk.add(createBitMap(res, R.drawable.walk5));
        player_walk.add(createBitMap(res, R.drawable.walk6));
    }



    public Bitmap createBitMap(Resources res, int id) {
        Bitmap image = BitmapFactory.decodeResource(res, id);
        int width = image.getWidth();
        int height = image.getHeight();
//        width = width / 2;
//        height = height / 2;
        image = Bitmap.createScaledBitmap(image, width, height, false);

        Matrix matrix = new Matrix();

        matrix.postScale(-1, 1, width, height);

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(image, width, height, true);

        image = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, true);

        return image;
    }

    public Bitmap moving(Bitmap bitmap1, Bitmap bitmap2, Bitmap bitmap3, int animate, int time) {
        int cal = animate % time;
        if (cal < time / 3) {
            return  bitmap1;
        } else {
            if (cal < time * 2 / 3) {
                return bitmap2;
            }
            return bitmap3;
        }

    }

    public Bitmap moving(ArrayList<Bitmap> bitmaps, int animate, int time) {
        int cal = animate % time;
        Log.i("animate :" ,"" + bitmaps.size());
        int maxImage = bitmaps.size();
        for (int i = 1; i <= bitmaps.size(); i++) {
            if (cal < i * time / maxImage) {
                return bitmaps.get(i - 1);
            }
        }
        return bitmaps.get(maxImage - 1);

    }
}
