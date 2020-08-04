package com.example.mobilecw01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class IdentifytheDog extends AppCompatActivity {
    private TypedArray icons, icons1, icons2;
    private ImageView iv, iv1, iv2;
    private Button btnGenerate;
    private TextView countdownText;
    private Button countdownButton;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliSeconds = 11000; //11 seconds
    private boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identifythe_dog);

        icons = getResources().obtainTypedArray(R.array.icons);
        icons1 = getResources().obtainTypedArray(R.array.icons1);
        icons2 = getResources().obtainTypedArray(R.array.icons2);

        iv = (ImageView) findViewById(R.id.iv);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);

        btnGenerate = (Button) findViewById(R.id.btnChange);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage();
            }
        });

        countdownText = findViewById(R.id.countdown_text);
        countdownButton = findViewById(R.id.countdown_button);

        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });


    }

    private void changeImage() {
        Random random = new Random();
        int randomNumber = random.nextInt(4);
        iv.setBackgroundResource(icons.getResourceId(randomNumber, 1));
        iv1.setBackgroundResource(icons1.getResourceId(randomNumber, 1));
        iv2.setBackgroundResource(icons2.getResourceId(randomNumber, 1));

    }

    public void startStop() {
        if (timerRunning) {
        } else {
            startTimer();
        }
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliSeconds, 1000) {  //interval 1 sec
            @Override
            public void onTick(long l) {
                timeLeftInMilliSeconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        timerRunning = true;
    }

    public void updateTimer() {
        int minuits = (int) timeLeftInMilliSeconds / 60000; //divided by 60 sec
        int seconds = (int) timeLeftInMilliSeconds % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + minuits;
        timeLeftText += ":";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;

        countdownText.setText(timeLeftText);
    }

}