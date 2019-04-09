package com.example.hp.quizhub;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    DatabaseHelper db;

    public String username2,userpassword2;
    private EditText e1,e2,e3 ;
    private Button b1,b2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        db=new DatabaseHelper(this);

        e1=(EditText)findViewById(R.id.user_name);
        e2=(EditText)findViewById(R.id.Password);
        e3=(EditText)findViewById(R.id.ConfirmPassword);

        b1=(Button)findViewById(R.id.Save);
        b2=(Button)findViewById(R.id.backbuttonID) ;



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();

                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_LONG).show();

                }
                else{
                    if(s2.equals(s3)){
                        Boolean chkmail=db.chkemail(s1);
                        if(chkmail==true)
                        {
                            Boolean insert=db.insert(s1,s2);
                            if(insert==true)
                            {
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Username already exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                    //Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startingScreen2();
            }
        });
    }
    private void startingScreen2()
    {
        Intent intent=new Intent(Registration.this,MainActivity.class);
        startActivity(intent);
    }
}
