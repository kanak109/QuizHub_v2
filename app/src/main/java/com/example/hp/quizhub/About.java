package com.example.hp.quizhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {  Button buttonback=findViewById(R.id.Button_Back);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Button backbutton=findViewById(R.id.Button_Back);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });


    }
     private void startMainActivity()
     {
         Intent intent2=new Intent(About.this,MainActivity.class);
         startActivity(intent2);
     }
}
