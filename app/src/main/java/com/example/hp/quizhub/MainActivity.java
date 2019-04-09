package com.example.hp.quizhub;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText e1,e2;
    private Button b1;
    DatabaseHelper db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new DatabaseHelper(this);

        e1=findViewById(R.id.UserName);
        e2=findViewById(R.id.Password);
        b1=findViewById(R.id.Sign_IN);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=e1.getText().toString();
                String password=e2.getText().toString();

                Boolean Chkemailpass=db.emailpassword(username,password);
                if(Chkemailpass==true)
                {
                    Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_SHORT).show();
                    startQuiz3();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();
                }


            }
        });

        Button sign_up=findViewById(R.id.Sign_UP);
        sign_up.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                createregistration();
            }
        });


    }
   private void startQuiz3()
   {
       Intent intent=new Intent(MainActivity.this,StartingScreen.class);
       startActivity(intent);
   }
   private void createregistration()
   {
       Intent intent2=new Intent(MainActivity.this,Registration.class);
       startActivity(intent2);
   }
}
