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
    public Bitmap player_idles;

    public ArrayList<Bitmap> player_walk = new ArrayList<>();
    public ArrayList<Bitmap> player_idle = new ArrayList<>();
    public ArrayList<Bitmap> player_jump = new ArrayList<>();
    public ArrayList<Bitmap> player_walk_flip = new ArrayList<>();
    public Bitmap brickImage;
    public Bitmap brickImage2;
    public Bitmap Image_Item_Normal;

    public Bitmap Image_Item_Big;

    public Sprite(Resources res) {

        player_walk1 = createBitMap(res, R.drawable.run1_removebg_preview);
        player_walk2 = createBitMap(res, R.drawable.run1_removebg_preview);
        player_walk3 = createBitMap(res, R.drawable.run1_removebg_preview);
        player_walk4 = createBitMap(res, R.drawable.run1_removebg_preview);
        player_walk5 = createBitMap(res, R.drawable.run1_removebg_preview);
        player_walk6 = createBitMap(res, R.drawable.run1_removebg_preview);
        player_walk.add(createBitMap(res, R.drawable.background_01));
        player_walk.add(createBitMap(res, R.drawable.run1_removebg_preview));
        player_walk.add(createBitMap(res, R.drawable.run1_removebg_preview));
        player_walk.add(createBitMap(res, R.drawable.run1_removebg_preview));
        player_walk.add(createBitMap(res, R.drawable.run1_removebg_preview));
        player_walk.add(createBitMap(res, R.drawable.run1_removebg_preview));

        player_walk_flip = createBitMap2(player_walk);

        brickImage = createBitMap(res, R.raw.crate, 80, 80);
        brickImage = createBitMap(res, R.raw.high_jump12, 80, 80);


        //idle_Sprite
        player_idles = createBitMap(res, R.drawable.run1_removebg_preview);
        player_idle.add(createBitMap(res, R.drawable.idle1));
        player_idle.add(createBitMap(res, R.drawable.idle1));
        player_idle.add(createBitMap(res, R.drawable.idle1));
        player_idle.add(createBitMap(res, R.drawable.idle1));
        player_idle.add(createBitMap(res, R.drawable.idle1));
        player_idle.add(createBitMap(res, R.drawable.idle1));
        player_idle.add(createBitMap(res, R.drawable.idle1));
        player_idle.add(createBitMap(res, R.drawable.idle2));
        player_idle.add(createBitMap(res, R.drawable.idle3));
        player_idle.add(createBitMap(res, R.drawable.idle4));
        player_idle.add(createBitMap(res, R.drawable.idle5));
        player_idle.add(createBitMap(res, R.drawable.idle6));
        player_idle.add(createBitMap(res, R.drawable.idle7));
        player_idle.add(createBitMap(res, R.drawable.idle8));
        player_idle.add(createBitMap(res, R.drawable.idle9));
//        player_idle.add(createBitMap(res, R.drawable.idle10));
//        player_idle.add(createBitMap(res, R.drawable.idle12));
//        player_idle.add(createBitMap(res, R.drawable.idle13));
//        player_idle.add(createBitMap(res, R.drawable.idle14));
//        player_idle.add(createBitMap(res, R.drawable.idle15));
//        player_idle.add(createBitMap(res, R.drawable.idle16));
//        player_idle.add(createBitMap(res, R.drawable.idle17));
//        player_idle.add(createBitMap(res, R.drawable.idle18));

        player_jump.add(createBitMap(res, R.raw.high_jump1));
        player_jump.add(createBitMap(res, R.raw.high_jump2));
        player_jump.add(createBitMap(res, R.raw.high_jump3));
        player_jump.add(createBitMap(res, R.raw.high_jump4));
        player_jump.add(createBitMap(res, R.raw.high_jump5));
        player_jump.add(createBitMap(res, R.raw.high_jump6));
        player_jump.add(createBitMap(res, R.raw.high_jump7));
        player_jump.add(createBitMap(res, R.raw.high_jump8));
        player_jump.add(createBitMap(res, R.raw.high_jump9));
        player_jump.add(createBitMap(res, R.raw.high_jump10));
        player_jump.add(createBitMap(res, R.raw.high_jump11));
        player_jump.add(createBitMap(res, R.raw.high_jump12));

        //
        Image_Item_Big = createBitMap(res, R.drawable.apple, 80, 80);
        Image_Item_Normal = createBitMap(res, R.drawable.bubble, 80, 80);
    }



    public Bitmap createBitMap(Resources res, int id) {
        Bitmap image = BitmapFactory.decodeResource(res, id);
        int width = image.getWidth();
        int height = image.getHeight();
        width = width * 2 / 3;
        height = height * 2 / 3;
        image = Bitmap.createScaledBitmap(image, width, height, false);

//        Matrix matrix = new Matrix();
//
//        matrix.postScale(-1, 1, width, height);
//
//        Bitmap scaledBitmap = Bitmap.createScaledBitmap(image, width, height, true);
//
//        image = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, true);

        return image;
    }

    public Bitmap createBitMap(Resources res, int id, int width, int height) {
        Bitmap image = BitmapFactory.decodeResource(res, id);
        image = Bitmap.createScaledBitmap(image, width, height, false);

//        Matrix matrix = new Matrix();
//
//        matrix.postScale(-1, 1, width, height);
//
//        Bitmap scaledBitmap = Bitmap.createScaledBitmap(image, width, height, true);
//
//        image = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, true);

        return image;
    }

    public ArrayList<Bitmap> createBitMap2(ArrayList<Bitmap> bitmaps) {
        ArrayList<Bitmap> bitmaps1 = new ArrayList<>();
        for (int i = 0; i < bitmaps.size(); i++) {
            Bitmap image = bitmaps.get(i);
            image = Bitmap.createScaledBitmap(image, image.getWidth(), image.getHeight(), false);

            Matrix matrix = new Matrix();

            matrix.postScale(-1, 1, image.getWidth(), image.getHeight());

            image = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
            bitmaps1.add(image);

        }


        return bitmaps1;
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
