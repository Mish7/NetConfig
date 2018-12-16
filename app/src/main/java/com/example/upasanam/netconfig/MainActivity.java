package com.example.upasanam.netconfig;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    protected TextView textView,textView2,textView3;
    protected Button b1,b2,b3;
    int width = 0;
    int height = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resolution1 = getScreenResolution();
                textView.setText(resolution1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resolution2 = getScreenResolution2();
                textView2.setText(resolution2);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resolution3 = getScreenResolution3();
                textView3.setText(resolution3);
            }
        });
    }

    private String getScreenResolution() {

        try {
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);

            width = size.x;
            height = size.y;

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "{" + width + "," + height + "}";
    }

    private String getScreenResolution2()
    {
        try {
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getRealSize(size);

            width = size.x;
            height = size.y;

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "{" + width + "," + height + "}";
    }

    private String getScreenResolution3()
    {
        width=getResources().getConfiguration().screenWidthDp;
        height=getResources().getConfiguration().screenHeightDp;
        return "{" + width + "," + height + "}";
    }

    @Override
    public void onClick(View view) {

    }
}

