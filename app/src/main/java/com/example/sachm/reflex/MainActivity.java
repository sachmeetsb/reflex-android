package com.example.sachm.reflex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String BLINK = "blink";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view)
    {
        RadioGroup size = (RadioGroup) findViewById(R.id.one);
        RadioGroup time = findViewById(R.id.two);
        int p = size.getCheckedRadioButtonId();
        RadioButton si =  findViewById(p);
        if(si == findViewById(R.id.radioButton5))
        {
            Intent intent1 = new Intent(this, Activity2.class);
            int p1 = time.getCheckedRadioButtonId();
            Log.i("f","firstbutton");
            RadioButton tim = findViewById(p1);
            String timm = (String) tim.getText();
            int timee = Integer.parseInt(timm);
            Log.i("strgg" , "lj: "+ timee);
            intent1.putExtra(BLINK, timee);
            startActivity(intent1);

        }
        if(si == findViewById(R.id.radioButton6))
        {
            Intent intent2 = new Intent(this, Activity3.class);
            Log.i("f","second button");
            int p1 = time.getCheckedRadioButtonId();
            RadioButton tim = findViewById(p1);
            String timm = (String) tim.getText();
            int timee = Integer.parseInt(timm);
            Log.i("strgg" , "lj: "+ timee);
            intent2.putExtra(BLINK, timee);
            startActivity(intent2);
        }

    }

}
