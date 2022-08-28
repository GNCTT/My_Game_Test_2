package com.example.mygametest;

import static com.example.mygametest.GameView.brick;
import static com.example.mygametest.GameView.canvas;
import static com.example.mygametest.GameView.left;
import static com.example.mygametest.GameView.paint;
import static com.example.mygametest.GameView.right;
import static com.example.mygametest.GameView.screenRatioX;
import static com.example.mygametest.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;

import com.example.mygametest.Entities.Block;
import com.example.mygametest.Entities.Brick;
import com.example.mygametest.Entities.Entity;
import com.example.mygametest.Sprite.Sprite;

import java.util.ArrayList;


public class Player extends Entity {

    private int strength_jump;

    public boolean is_jumping;

    public static int dir_player;
    public Block brick2;
    public static Sprite sprite;

    public Player(int screenX, int screenY, Resources res) {
        super(screenX, screenY);
        sprite = new Sprite(res);
        dir_player = -1;
        is_jumping = false;


        strength_jump = 50;
        speed = 3;
        width = 80;
        height = 80;
        brick2 = new Block(100, 50 + 190, res);

        x = 50;
        y = 50;
    }


    public Rect getBound() {
        return new Rect(x + 50, y + 190 - height,x + 50 + width,y + 190);
    }

    public void update() {
        if (animate < 7500) {
            animate ++;
        } else {
            animate = 0;
        }
//        if (y < 500) {
//            y += 5;
//        }
        if (y >= 500) {
            is_jumping = false;
            strength_jump = 50;
        }

        int deltax = 0;
        int deltay = 0;
        if (GameView.left) {
            deltax -= speed;

        }
        if (GameView.right) {
            deltax = speed;

        }
        if (GameView.jump) {
            deltay = - 5;
        }
        if (GameView.down) {
            deltay = 5;
        }



        Rect rect = brick2.getBound();
        Rect rect1 = getBound();
        Log.i("brickCollide", "" + rect.intersect(rect1) + " " + rect.toString() + " " + rect1.toString());
        brick2.update();
        x += deltax;
        if (brick2.collide(this)) {
            if (deltax > 0) {
                x = brick2.getBound().left - 80;
            } else {
                if (deltax < 0) {
                    x = brick2.getBound().right;
                }
            }
        }
        deltax = 0;
        y += deltay;
        if (brick2.collide(this)) {
            if (deltay > 0) {
                y = brick2.getBound().bottom;
            } else {
                if (deltay < 0) {
                    y = brick2.getBound().top;
                }
            }

        }
        deltay = 0;

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
        canvas.drawRect(getBound(), paint);
        canvas.drawRect(brick2.getBound(), paint);
    }

    public void setDir_player(int x) {
        this.dir_player = x;
    }

}
