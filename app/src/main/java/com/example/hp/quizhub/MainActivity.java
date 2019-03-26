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

    private EditText userNameEdit,passwordEdit;
    DatabaseHelper db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new DatabaseHelper(this);

        userNameEdit=findViewById(R.id.UserName);
        passwordEdit=findViewById(R.id.Password);
        Button sign_in=findViewById(R.id.Sign_IN);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             /*   String user=userNameEdit.getText().toString().trim();
                String pwd=passwordEdit.getText().toString().trim();
                Boolean res=db.checkUser(user,pwd);

                if(res==true)
                {
                    Toast.makeText(MainActivity.this, "You have logged in successfully", Toast.LENGTH_SHORT).show();
                    startQuiz3();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                }*/

                if(v.getId()==R.id.Sign_IN)
                {
                    String userName1=userNameEdit.getText().toString().trim();
                    String password1=passwordEdit.getText().toString().trim();
                   Registration rg=new Registration();

                    if(userName1.equals("Rakesh")|| password1.equals("6430"))
                    {
                        Toast.makeText(getApplicationContext(), "Data is entered correctly", Toast.LENGTH_SHORT).show();
                        startQuiz3();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "You entered wrong information", Toast.LENGTH_SHORT).show();
                    }
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
