package com.example.hp.quizhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen);

        Button buttonstartquiz=findViewById(R.id.Button_Start);
        Button buttonAbout=findViewById(R.id.Button_About);
        buttonstartquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                about();
            }
        });

        // error in finding R, couldn't find why.




    }
    private void startQuiz()
    {
        Intent intent=new Intent(StartingScreen.this,QuizActivity.class);
        startActivity(intent);
    }
    private void about()
    {
        Intent intent1=new Intent(StartingScreen.this,About.class);
        startActivity(intent1);
    }
}
