package com.example.mygametest.Entities;

import static com.example.mygametest.GameView.canvas;
import static com.example.mygametest.GameView.paint;

import android.content.res.Resources;
import android.graphics.Rect;

import com.example.mygametest.Player;
import com.example.mygametest.Sprite.Sprite;

public class Block extends Entity{
    public Sprite sprite;
    public Block(int x, int y, Resources res) {
        super(x, y);
        sprite = new Sprite(res);
        width = 80;
        height = 80;
        ImageEntity = sprite.brickImage;
    }


    @Override
    public void update() {

    }

    @Override
    public void draw() {
        canvas.drawBitmap(ImageEntity, x, y, paint);
        canvas.drawRect(getBound(), paint);
    }

    public Rect getBound() {
        return new Rect(x, y - height,x + width, y);
    }

    public boolean collide(Player player) {
        return getBound().intersect(player.getBound());
    }


}
