package com.example.upasanam.netconfig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//This activity handles the welcome screen - The initial screen that provides app information and redirects to the Login screen
public class Welcome extends AppCompatActivity {
    protected Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        button=(Button) findViewById(R.id.butt2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Welcome.this, Login.class));
            }
        });
    }
}
