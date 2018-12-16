package com.example.upasanam.netconfig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Intermediate extends AppCompatActivity {
    Button b4;
    RadioButton cb1, cb2;
    RadioGroup rg;
    int msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate);
        cb1 = (RadioButton) findViewById(R.id.rd);
        cb2 = (RadioButton) findViewById(R.id.rd2);
        rg = (RadioGroup) findViewById(R.id.radioGroup1);
        onRadioClick();

    }

    public void onRadioClick() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rd:
                        msg = 1;
                        startActivity(new Intent(Intermediate.this, MainActivity.class));
                        break;
                    case R.id.rd2:
                        msg = 2;
                        startActivity(new Intent(Intermediate.this, NetworkTest.class));
                        break;
                    // default: Toast.makeText(this, "Please Select a valid option", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}



