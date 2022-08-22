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
import com.example.mygametest.Sprite.Sprite;

import java.util.ArrayList;


public class Player extends Entity {

    int x, y,  animate = 0;
    int width, height;

    public boolean isUp;
    public boolean is_moving;
    public static int dir_player;
    public static Sprite sprite;
    Bitmap [] arrPlayer;
    ArrayList<Bitmap> arrPlayer_walk;

    public Player(int screenX, int screenY, Resources res) {
        super(screenX, screenY);
        arrPlayer = new Bitmap[3];
        arrPlayer[0] = BitmapFactory.decodeResource(res, R.drawable.walk1);
        sprite = new Sprite(res);

        is_moving = false;
        width = arrPlayer[0].getWidth();
        height = arrPlayer[0].getHeight();
        dir_player = 0;

        width *= (float) screenRatioX;
        height *= (float) screenRatioY;
        speed = 2;

        width /= 3/2;
        height /= 3/2;
        Log.i("widthh", "" + width + " " + height);
        arrPlayer[0] = Bitmap.createScaledBitmap(arrPlayer[0], width, height, false);
        ImageEntity = sprite.player_walk1;
        arrPlayer_walk = sprite.player_walk;

        x = screenX / 2;
        x = (int) (64 * screenRatioX);
    }

    Bitmap getImagePlayer() {
        return arrPlayer[0];


    }

    @Override
    public boolean collide(Entity other) {
        return false;
    }

    public void update() {
        if (animate < 7500) {
            animate ++;
        } else {
            animate = 0;
        }
        ImageEntity = sprite.moving(sprite.player_walk, animate, 20);
        switch (dir_player) {
            case 0:
                y ++;
                break;
            case 1:
                x += speed;
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
        canvas.drawBitmap(ImageEntity, x, y, paint);
    }

    public void setDir_player(int x) {
        this.dir_player = x;
    }

}
