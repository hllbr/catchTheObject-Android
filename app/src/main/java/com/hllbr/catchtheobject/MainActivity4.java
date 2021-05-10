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

public class MainActivity4 extends AppCompatActivity {
    TextView scoreText2;
    TextView timeText1 ;
    Handler handler ;
    Runnable runnable ;
    int scorebb ;
    ImageView image1 ;
    ImageView image2 ;
    ImageView image3 ;
    ImageView image4 ;
    ImageView image5 ;
    ImageView image6 ;
    ImageView image7 ;
    ImageView image8 ;
    ImageView image9 ;
    ImageView[] imagesArray ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        scoreText2 = findViewById(R.id.scoreText2);
        timeText1 = findViewById(R.id.timeText1);
        scorebb = 0 ;
        image1 = findViewById(R.id.imageView9);
        image2 = findViewById(R.id.imageView10);
        image3 = findViewById(R.id.imageView11);
        image4 = findViewById(R.id.imageView12);
        image5 = findViewById(R.id.imageView13);
        image6 = findViewById(R.id.imageView14);
        image7 = findViewById(R.id.imageView15);
        image8 = findViewById(R.id.imageView16);
        image9 = findViewById(R.id.imageView17);

        imagesArray = new ImageView[]{image1,image2,image3,image4,image5,image6,image7,image8,image9};


        hıdeOnBuys();

        new CountDownTimer(15000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText1.setText("Time " +millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {
                timeText1.setText("Time off");
                handler.removeCallbacks(runnable);
                for(ImageView image : imagesArray){
                    image.setVisibility(View.INVISIBLE);

                }
                Intent intent2 = new Intent(MainActivity4.this,MainActivity5.class);

                intent2.putExtra("sss",scorebb);
                startActivity(intent2);
            }
        }.start();

    }
    public void tıkone(View view){
            scorebb++;
            scoreText2.setText("Score "+scorebb);


    }
    public void hıdeOnBuys(){
    handler = new Handler();
    runnable = new Runnable() {
        @Override
        public void run() {
            for(ImageView images : imagesArray){
                images.setVisibility(View.INVISIBLE);
            }
            Random random = new Random();
            int i = random.nextInt(9);
            imagesArray[i].setVisibility(View.VISIBLE);
            handler.postDelayed(this,400);
        }
    };
    handler.post(runnable);


    }
}