package com.example.sachm.reflex;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Activity3 extends AppCompatActivity {

    //public Menu togglemenu;
    public int tu = 1;
    public int f = 0;
    public int b = 0;
    public int score = 0;
    public int time;
    TextView textTimer;
    //int b = 0;
    int score1;
    SharedPreferences perfs;
    TextView highs;
    String initime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        Intent intent = getIntent();
        Log.i("act3","act3");
        time = intent.getIntExtra(MainActivity.BLINK,0);
        initime=String.valueOf(time);
        Log.d("henlo", "time:" + time);
        textTimer = findViewById(R.id.timer);
        textTimer.setText("Hello");
        Button share = findViewById(R.id.button10);
        share.setEnabled(false);
        perfs = getSharedPreferences("keys"+initime, Context.MODE_PRIVATE);
        score1 = perfs.getInt("keys"+initime,0);
        Log.i("score is ", ""+score1);
        highs = (TextView) findViewById(R.id.textView3);
        highs.setText("High Score is: "+ String.valueOf(score1));


    }



    //Declare timer
    CountDownTimer cTimer = null;

    //start timer function
    void startTimer() {
        cTimer = new CountDownTimer(time*1000, 1000) {
            public void onTick(long millisUntilFinished) {
                textTimer = findViewById(R.id.timer);
                Log.i("start", "done");
                textTimer.setText(Integer.toString(time));
                time--;

            }

            public void onFinish() {

                textTimer = findViewById(R.id.timer);
                textTimer.setText("GG");
                Log.i("stopped", "yes");
                b = 1;
                int p;
                for (p = 1; p <= 9; p++) {
                    Button u = (Button) findViewById(getResources().getIdentifier("button" + p, "id", getBaseContext().getPackageName()));
                    u.setBackgroundResource(R.drawable.shape1);
                    u.setOnClickListener(null);
                }
                //togglemenu.findItem(1).setEnabled(true);
                Button share = findViewById(R.id.button10);
                share.setEnabled(true);
                Log.i("enabled", "yes");



            }

        };
        cTimer.start();
    }



    public void clicky(View v) {
        if (f == 0)
            startTimer();
        f = 1;

        Button c = findViewById(getResources().getIdentifier("button" + tu, "id", this.getPackageName()));
        Button d = findViewById(v.getId());
        if (c == d && b == 0)
            score += 1;
        //setContentView(R.layout.activity_main);
        TextView text = findViewById(R.id.textt);
        String debug = (String) text.getText();
        Log.i("plz",debug);

        text.setText("Score is: " + score);
        int p;
        for (p = 1; p <= 9; p++) {
            Button u = (Button) findViewById(getResources().getIdentifier("button" + p, "id", this.getPackageName()));
            u.setBackgroundResource(R.drawable.shape1);
            if(b==1) {
                u.setOnClickListener(null);
                //textTimer.setText("Click here to restart");
                //Log.i("don","yes");
                //textTimer.setOnClickListener(list);
            }
        }
        Random rand = new Random();
        int n = rand.nextInt(9) + 1;
        Button x = (Button) findViewById(getResources().getIdentifier("button" + n, "id", this.getPackageName()));
        x.setBackgroundResource(R.drawable.shape);
        tu = n;
        if(score>score1)
        {
            Log.i("Score is greater","greater");
            highs = (TextView) findViewById(R.id.textView3);
            //perfs = getSharedPreferences("high", MODE_MULTI_PROCESS);
            SharedPreferences.Editor editor = perfs.edit();
            editor.putInt("keys"+initime,score);
            editor.apply();
            score1=perfs.getInt("keys"+initime,0);
            Log.i("scoreee",String.valueOf(score1));
            highs.setText("High Score is: " + String.valueOf(score1));

        }

    }

    public void share(View view)
    {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "I just had a score of " + score+ " in reflex";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Score");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }



}
