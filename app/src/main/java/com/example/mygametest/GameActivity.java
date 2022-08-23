package com.example.mygametest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        gameView = new GameView(this, point.x, point.y);
        FrameLayout game = new FrameLayout(this);
        LinearLayout gameWidgets = new LinearLayout(this);
        ImageButton endGameButton = new ImageButton(this);
        endGameButton.setImageResource(R.drawable.walk1);
        TextView myText = new TextView(this);

        endGameButton.setMaxWidth(30);
        endGameButton.setMaxHeight(30);
        myText.setText("rIZ..i");

        gameWidgets.addView(myText);
        gameWidgets.addView(endGameButton);

        game.addView(gameView);
        game.addView(gameWidgets);
        setContentView(game);
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