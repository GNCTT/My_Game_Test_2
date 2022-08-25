package com.example.mygametest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;

    private Button btn_left;
    private Button btn_right;
    private Button btn_jump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        gameView = new GameView(this, point.x, point.y);

        FrameLayout game = new FrameLayout(this);
        LinearLayout gameWidgets = new LinearLayout(this);
        btn_left = new Button(this);

        btn_left.setX(1700);
        btn_left.setY(800);
        btn_left.setWidth(20);
        btn_left.setHeight(20);

        btn_right = new Button(this);
        btn_right.setX(1700);
        btn_right.setY(800);
        btn_right.setWidth(20);
        btn_right.setHeight(20);

        btn_jump = new Button(this);
        btn_jump.setX(0);
        btn_jump.setY(800);
        btn_jump.setWidth(20);
        btn_jump.setHeight(20);

        gameWidgets.addView(btn_left);
        gameWidgets.addView(btn_right);
        gameWidgets.addView(btn_jump);

        game.addView(gameView);
        game.addView(gameWidgets);
        setContentView(game);
        btn_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        GameView.left = true;
                        Log.i("test_button", "press");
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        GameView.left = false;
                        Log.i("test_button", "realea");
                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });

        btn_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        GameView.right = true;
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        GameView.right = false;
                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });

        btn_jump.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        GameView.jump = true;
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        GameView.jump = false;
                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }

}