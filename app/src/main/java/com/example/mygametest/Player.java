package com.example.mygametest;

import static com.example.mygametest.GameView.canvas;
import static com.example.mygametest.GameView.left;
import static com.example.mygametest.GameView.paint;
import static com.example.mygametest.GameView.right;
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

    public boolean is_moving;
    public boolean is_jumping;

    public static int dir_player;
    public static Sprite sprite;

    Bitmap [] arrPlayer;
    Bitmap originalBm;
    ArrayList<Bitmap> arrPlayer_walk;

    public Player(int screenX, int screenY, Resources res) {
        super(screenX, screenY);
        arrPlayer = new Bitmap[3];
        arrPlayer[0] = BitmapFactory.decodeResource(res, R.drawable.walk1);
        sprite = new Sprite(res);
        originalBm = BitmapFactory.decodeResource(res, R.drawable.background_02); // Let's say this bitmap is 300 x 600 pixels
        originalBm = Bitmap.createBitmap(originalBm, 0, 0, originalBm.getWidth(), (originalBm.getHeight() / 2));
        Bitmap bm2 = Bitmap.createBitmap(originalBm, 0, (originalBm.getHeight() / 2), originalBm.getWidth(), (originalBm.getHeight() / 2));

        is_moving = false;
        width = arrPlayer[0].getWidth();
        height = arrPlayer[0].getHeight();
        dir_player = -1;
        is_jumping = false;

        width *= (float) screenRatioX;
        height *= (float) screenRatioY;
        speed = 3;

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
        if (y < 500) {
            y += 5;
        }
        if (y == 500) {
            is_jumping = false;
        }

//        ImageEntity = sprite.moving(sprite.player_idle, animate, 120);
        if (GameView.left) {
            x -= speed;

        }
        if (GameView.right) {
            x += speed;

        }
        if (GameView.jump && is_jumping == false) {

            is_jumping = true;

        }
        if (is_jumping) {
            y += 8 - (x - 3) * (x - 3);
            x++;
        }

        chooseSprite();
    }



    public void chooseSprite() {
        if (left == true && is_jumping == false) {
            ImageEntity = sprite.moving(sprite.player_walk, animate, 20);
        }
        if (right == true && is_jumping == false) {
            ImageEntity = sprite.moving(sprite.player_walk, animate, 20);
        }
        if (is_jumping) {
            ImageEntity = sprite.moving(sprite.player_jump, animate, 40);
        }
        if (left == false && right == false && is_jumping == false) {
            ImageEntity = sprite.player_idles;
        }
    }

    @Override
    public void draw() {
        canvas.drawBitmap(ImageEntity, x, y, paint);
        canvas.drawBitmap(originalBm, 50, 50, paint);

    }

    public void setDir_player(int x) {
        this.dir_player = x;
    }

}
