package com.example.mygametest.Entities;

import static com.example.mygametest.GameView.canvas;
import static com.example.mygametest.GameView.paint;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;

import com.example.mygametest.Player;
import com.example.mygametest.Sprite.Sprite;

public class Brick extends Entity{

    public Sprite sprite;

    public Brick(int x, int y, Resources res) {
        super(x, y);
        width = 80;
        height = 80;
        sprite = new Sprite(res);
        ImageEntity = sprite.brickImage;
    }

    public boolean collide(Player other) {
//        Log.i("coxlide", " " + player.getBound().right + " " + getBound().left);
//        Log.i("coylide", " " + player.getBound().bottom + " " + getBound().top);
//        boolean noXoverlap = player.getBound().right <= getBound().left || player.getBound().left >= getBound().right;
//        boolean noYoverlap = player.getBound().bottom <= getBound().top || player.getBound().top >= getBound().bottom;
//        if (noXoverlap || noYoverlap) {
//            return false;
//        }
//        return true;
        return getBound().intersect(other.getBound());
    }


    @Override
    public void update() {

    }

    public Rect getBound() {
        return new Rect(x, y + 80, x + width, y + 80 - height);
    }

    @Override
    public void draw() {
        canvas.drawBitmap(ImageEntity, x, y, paint);
        canvas.drawRect(getBound(), paint);
    }
}
