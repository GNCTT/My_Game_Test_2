package com.example.mygametest.Entities;

import static com.example.mygametest.GameView.canvas;
import static com.example.mygametest.GameView.paint;

import android.content.res.Resources;
import android.graphics.Bitmap;

import com.example.mygametest.Sprite.Sprite;

import java.util.Random;

public class Item_Big extends Entity{

    public Sprite sprite;
    public Resources res;
    private int scale;
    private int check_scale;
    private boolean check_loop;

    public Item_Big(int x, int y, Resources res) {
        super(x, y);
        this.res = res;
        x = 50;
        check_loop = false;
        y = 50;
        width = 80;
        height = 80;
        scale = 1;
        sprite = new Sprite(res);
        ImageEntity = sprite.Image_Item_Big;
    }


    @Override
    public void update() {
        y += 5;
        check_scale++;
        if (check_scale == 50 && check_loop == false) {
            scale++;
            check_scale = 0;
        }
//        width += 1;
//        height += 1;
        if (y > 1000) {
            check_loop = true;
            x = new Random().nextInt(1800) + 20;
            y = -4000;
        }
        if (y <= 0) {
            check_scale = 0;
            scale = 1;
            check_loop = false;
        }
        scale(width, height);
    }

    public void scale(int width, int height) {
        ImageEntity = Bitmap.createScaledBitmap(ImageEntity, width * scale, height * scale, false);
    }

    @Override
    public void draw() {
        canvas.drawBitmap(ImageEntity, x, y, paint);
    }
}
