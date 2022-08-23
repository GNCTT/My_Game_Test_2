package com.example.mygametest;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

public class GameView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isPlaying;
    private int screenX, screenY;
    private Player player;
    public static float screenRatioX, screenRatioY;
    private Background background1;
    public static Paint paint;
    public static Canvas canvas;

    //
    public static Boolean jump = false;
    public static Boolean left = false;
    public static Boolean right = false;

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    public GameView(GameActivity context, int screenX, int screenY) {
        super(context);
        setFocusable(true);
        this.screenX = screenX;
        this.screenY = screenY;
        background1 = new Background(screenX, screenY, getResources());
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;

        player = new Player(screenX, screenY, getResources());
        paint = new Paint();
    }


    @Override
    public void run() {
        while (isPlaying) {
            update();
            draw();
            sleep();
        }
    }

    public void update() {
        player.update();

    }

    public void draw() {

        if (getHolder().getSurface().isValid()) {
            canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.background, background1.x, background1.y, paint);
            canvas.drawBitmap(background1.background2, background1.x, background1.y, paint);

            player.draw();

            getHolder().unlockCanvasAndPost(canvas);
        }

    }

    public void sleep () {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_D:
                player.setDir_player(1);
                Log.i("tagg", "" + "startPressD");
                return true;
            case KeyEvent.KEYCODE_A:
                Log.i("tagg", "endPr");
                left = true;
                return false;
            case KeyEvent.KEYCODE_W:
                player.setDir_player(0);
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }

    }

    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        return super.dispatchKeyEventPreIme(event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_D:
                player.setDir_player(1);
                Log.i("tagg", "" + "startPressD");
                return true;
            case KeyEvent.KEYCODE_A:
                Log.i("tagg", "endPressA");
                left = false;
                return false;
            case KeyEvent.KEYCODE_W:
                player.setDir_player(0);
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }

}
