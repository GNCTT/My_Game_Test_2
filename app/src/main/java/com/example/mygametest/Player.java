package com.example.mygametest;

import static com.example.mygametest.GameView.canvas;
import static com.example.mygametest.GameView.paint;
import static com.example.mygametest.GameView.screenRatioX;
import static com.example.mygametest.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.mygametest.Entities.Entity;


public class Player extends Entity {

    int x, y,  animate = 0;
    int width, height;
    public boolean isUp;
    public static int dir_player;
    Bitmap [] arrPlayer;
    Bitmap ImagePlayer;

    public Player(int screenX, int screenY, Resources res) {
        super(screenX, screenY);
        arrPlayer = new Bitmap[3];
        arrPlayer[0] = BitmapFactory.decodeResource(res, R.drawable.walk1);
        arrPlayer[1] = BitmapFactory.decodeResource(res, R.drawable.walk2);
        arrPlayer[2] = BitmapFactory.decodeResource(res, R.drawable.walk3);

        width = arrPlayer[2].getWidth();
        height = arrPlayer[2].getHeight();
        dir_player = 0;

        width *= (float) screenRatioX;
        height *= (float) screenRatioY;
        Log.i("widthh", "" + width + " " + height);
        arrPlayer[0] = Bitmap.createScaledBitmap(arrPlayer[0], width, height, false);
        arrPlayer[1] = Bitmap.createScaledBitmap(arrPlayer[1], width, height, false);
        arrPlayer[2] = Bitmap.createScaledBitmap(arrPlayer[2], width, height, false);

        x = screenX / 2;
        x = (int) (64 * screenRatioX);
    }

    Bitmap getImagePlayer() {
        animate++;
        if (animate < 10) {
            return arrPlayer[0];
        }
        if (animate > 20) {
            animate = 0;
        }
        return arrPlayer[1];


    }

    @Override
    public boolean collide(Entity other) {
        return false;
    }

    public void update() {
        switch (dir_player) {
            case 0:
                y ++;
                break;
            case 1:
                x++;
                break;
            case 2:
                y--;
                break;
            case 3:
                x--;
                break;
            default: x+= 0;
        }
    }

    @Override
    public void draw() {
        canvas.drawBitmap(getImagePlayer(), x, y, paint);
    }

    public void setDir_player(int x) {
        this.dir_player = x;
    }

}
