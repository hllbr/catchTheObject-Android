package com.hllbr.catchtheobject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {
    TextView scoreTabel ;
    int ss1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        scoreTabel = findViewById(R.id.scoretabel);


        Intent intent1 =getIntent();
        ss1 = intent1.getIntExtra("sss",0);
        scoreTabel.setText("Level 2 score "+ss1);

    }
    public void fın(View view){
        scoreTabel.setText("Thank you so much ");

    }
}