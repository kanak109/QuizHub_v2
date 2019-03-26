package com.example.hp.quizhub;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class QuizActivity extends AppCompatActivity {
     private static final long START_TIME_IN_MILLIS=6000;
     private TextView mTextViewCountDown,mScoreView;
     private CountDownTimer mCountDownTimer;
     private boolean mTimerRunning;
     private long mTimerLeftInMillis=START_TIME_IN_MILLIS;
     private int score=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTextViewCountDown=findViewById(R.id.text_view_Countdown);
        mScoreView=findViewById(R.id.Score_View);

        String scoreView2=String.format(Locale.getDefault(),"%d",score);
        mScoreView.setText("Score:"+scoreView2);

        if(mTimerRunning){
            pauseTimer();
        }
        else
        {
            startTimer();
        }

    }
    private void startTimer()
    {
        mCountDownTimer=new CountDownTimer(mTimerLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimerLeftInMillis=millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                 mTimerRunning=false;
                Toast.makeText(getApplicationContext(), "You Have Scored:"+score, Toast.LENGTH_SHORT).show();
                 startQuiz3();
            }
        }.start();
        mTimerRunning=true;
    }
    private void pauseTimer()
    {
        mCountDownTimer.cancel();
        mTimerRunning=false;
    }
    private void updateCountDownText()
    {
        int minutes=(int)(mTimerLeftInMillis/1000)/60;
        int seconds=(int)(mTimerLeftInMillis/1000)%60;

        String timeLeftFormatted=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        mTextViewCountDown.setText(timeLeftFormatted);
    }
    private void startQuiz3()
    {
        Intent intent=new Intent(QuizActivity.this,StartingScreen.class);
        startActivity(intent);
    }
}
