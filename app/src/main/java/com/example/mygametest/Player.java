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

    private int strength_jump;

    public boolean is_jumping;

    public static int dir_player;
    public static Sprite sprite;


    public Player(int screenX, int screenY, Resources res) {
        super(screenX, screenY);
        sprite = new Sprite(res);
        dir_player = -1;
        is_jumping = false;

        strength_jump = 50;
        speed = 3;

        x = 50;
        y = 50;
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
        if (y >= 500) {
            is_jumping = false;
            strength_jump = 50;
        }

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
            y -= strength_jump;
            strength_jump -= 5;
        }

        chooseSprite();
    }



    public void chooseSprite() {
        if (left == true && is_jumping == false) {
            ImageEntity = sprite.moving(sprite.player_walk_flip, animate, 20);
        }
        if (right == true && is_jumping == false) {
            ImageEntity = sprite.moving(sprite.player_walk, animate, 20);
        }
        if (is_jumping) {
            ImageEntity = sprite.moving(sprite.player_jump, animate, 60);
        }
        if (left == false && right == false && is_jumping == false) {
            ImageEntity = sprite.player_idles;
            animate = 0;
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
