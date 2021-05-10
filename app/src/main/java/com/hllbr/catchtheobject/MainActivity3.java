package com.hllbr.catchtheobject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    int score1 ;
    TextView scoretext1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        scoretext1= findViewById(R.id.scoretext1);
        Intent intent = getIntent();

        score1 = intent.getIntExtra("sc",0);
        scoretext1.setText("Level 1 Score "+score1);

    }
    public void levelup(View view){
        Intent intent1 = new Intent(MainActivity3.this,MainActivity4.class);

        intent1.putExtra("scc",score1);

        startActivity(intent1);
    }
}