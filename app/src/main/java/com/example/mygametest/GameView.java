package com.example.mygametest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable{

    private Thread thread;
    private boolean isPlaying;
    private int screenX, screenY;
    private Player player;
    public static float screenRatioX, screenRatioY;
    private Background background1;
    public static Paint paint;
    public static Canvas canvas;

    public GameView(Context context, int screenX, int screenY) {
        super(context);
        this.screenX = screenX;
        this.screenY = screenY;
        background1 = new Background(screenX, screenY, getResources());
        screenRatioX = 1920f / screenX;
        screenRatioY = 1000f / screenY;

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
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case  MotionEvent.ACTION_DOWN:
                if (event.getX() < screenX / 2) {
                    player.setDir_player(1);
                }
                break;
            case MotionEvent.ACTION_UP:
                if (event.getX() < screenX / 2) {
                    player.setDir_player(3);
                }
                break;
            default:
                player.isUp = true;
        }
        return true;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.i("tagg", "startPress");
        switch (keyCode) {
            case KeyEvent.KEYCODE_D:
                player.setDir_player(1);
                Log.i("keyPress", "" + "1");
                return true;
            case KeyEvent.KEYCODE_A:
                player.setDir_player(3);
                return true;
            case KeyEvent.KEYCODE_W:
                player.setDir_player(0);
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }
}
