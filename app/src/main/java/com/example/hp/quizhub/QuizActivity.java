package com.example.hp.quizhub;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    private Question mQuestionLibrary=new Question();



     private static final long START_TIME_IN_MILLIS=30000;
     private TextView mTextViewCountDown;
     private CountDownTimer mCountDownTimer;
     private boolean mTimerRunning;
     private long mTimerLeftInMillis=START_TIME_IN_MILLIS;
     private int score=0;

    private TextView mScoreView;
    private TextView mQuestionView;
    private RadioButton mButtonChoice1;
    private RadioButton mButtonChoice2;
    private RadioButton mButtonChoice3;
    private Button confirmnext;


    private String mAnswer;
    private int mScore=0;
    private int mQuestionNumner=0;
    private int mQuestionRemaining=4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);



        mScoreView=(TextView) findViewById(R.id.score);
        mQuestionView=(TextView)findViewById(R.id.text_view_Question);
        mButtonChoice1=(RadioButton)findViewById(R.id.radio_button_Option1);
        mButtonChoice2=(RadioButton) findViewById(R.id.radio_button_Option2);
        mButtonChoice3=(RadioButton) findViewById(R.id.radio_button_Option3);
        confirmnext=(Button)findViewById(R.id.button_confirm);
        updateQuestion();
        mTextViewCountDown=findViewById(R.id.text_view_Countdown);


        String scoreView2=String.format(Locale.getDefault(),"%d",mScore);
        mScoreView.setText(""+scoreView2);

        if(mTimerRunning){
            pauseTimer();
        }
        else
        {
            startTimer();
        }



        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice1.getText()==mAnswer){
                    mScore=mScore+1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(QuizActivity.this,"correct",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(QuizActivity.this,"wrong",Toast.LENGTH_SHORT).show();
                   // updateQuestion();
                }
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice2.getText()==mAnswer){
                    mScore=mScore+1;
                    updateScore(mScore);
                   updateQuestion();
                    Toast.makeText(QuizActivity.this,"correct",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(QuizActivity.this,"wrong",Toast.LENGTH_SHORT).show();
                   // updateQuestion();
                }
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice3.getText()==mAnswer){
                    mScore=mScore+1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(QuizActivity.this,"correct",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(QuizActivity.this,"wrong",Toast.LENGTH_SHORT).show();
                   // updateQuestion();
                }
            }
        });


        confirmnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });


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
                Toast.makeText(getApplicationContext(), "You Have Scored:"+mScore, Toast.LENGTH_SHORT).show();
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



    private void updateQuestion(){
       mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumner));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumner));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumner));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumner));

        mAnswer=mQuestionLibrary.getCorrectAnswer(mQuestionNumner);
        mQuestionNumner++;
        mQuestionRemaining--;
    }

    private void updateScore(int point){
        mScoreView.setText(""+mScore);
    }


    private void startQuiz3()
    {
        Intent intent=new Intent(QuizActivity.this,StartingScreen.class);
        startActivity(intent);
    }




}
