package com.example.mygametest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.GnssAntennaInfo;
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

public class GameActivity extends AppCompatActivity implements SensorEventListener {

    private GameView gameView;

    public interface Listener {
        void onTranslation ();
    }
    private Listener listener;
    
    public void setListener(Listener l) {
        this.listener = l;
    }

    private Button btn_left;
    private Button btn_right;
    private Button btn_jump;
    private Button btn_down;
    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        gameView = new GameView(this, point.x, point.y);
        sensorManager = (SensorManager) this.getSystemService(this.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (listener != null) {
                    Log.i("valuee", "" + sensorEvent.values[1]);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        FrameLayout game = new FrameLayout(this);
        LinearLayout gameWidgets = new LinearLayout(this);
        btn_left = new Button(this);

        btn_left.setX(1700);
        btn_left.setY(800);
        btn_left.setWidth(20);
        btn_left.setHeight(20);

        btn_down = new Button(this);

        btn_down.setX(300);
        btn_down.setY(800);
        btn_down.setWidth(20);
        btn_down.setHeight(20);

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
        gameWidgets.addView(btn_down);

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
                        Background.checkChange *= -1;
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

        btn_down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        GameView.down = true;
                        Log.i("test_button", "press");
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        GameView.down = false;
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

    public void register() {
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    public void unregister() {
        sensorManager.unregisterListener(sensorEventListener);
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

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}