package com.example.mygametest.Entities;

import static com.example.mygametest.GameView.canvas;
import static com.example.mygametest.GameView.paint;

import android.content.res.Resources;

import com.example.mygametest.Sprite.Sprite;

public class Item_Normal extends Entity{

    public static Sprite sprite;

    public Item_Normal(int x, int y, Resources res) {
        super(x, y);
        sprite = new Sprite(res);
        width = 80;
        height = 80;
        ImageEntity = sprite.Image_Item_Normal;
    }

    @Override
    public void update() {
        x += 5;
        if (x > 1800) {
            x = -100;
        }
    }

    @Override
    public void draw() {
        canvas.drawBitmap(ImageEntity, x, y, paint);
    }
}
