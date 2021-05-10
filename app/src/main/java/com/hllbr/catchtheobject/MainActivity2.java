package com.hllbr.catchtheobject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    TextView scoretext;
    TextView timeText ;

    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;

    ImageView [] imageArrays;

    Handler handler ;

    Runnable runnable ;

    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        scoretext = findViewById(R.id.scoreText);
        timeText = findViewById(R.id.timeText);
        imageView = findViewById(R.id.imageView);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);

        imageArrays = new ImageView[]{imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8};

        score = 0;
        hideImage();
        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Time "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                timeText.setText("time off");
                handler.removeCallbacks(runnable);
                for(ImageView image : imageArrays){
                    image.setVisibility(View.INVISIBLE);
                }
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);

                intent.putExtra("sc",score);

                startActivity(intent);
            }
        }.start();

    }
    public void tık(View view){
        score++;
        scoretext.setText("Score "+score);

    }
    public void hideImage(){
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageArrays){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i =random.nextInt(9);
                imageArrays[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);

    }
}