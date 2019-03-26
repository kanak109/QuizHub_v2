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
    private EditText usernameEditText,passwordEditText,userIDEditText ;
    private Button saveButton,BackButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        db=new DatabaseHelper(this);



        usernameEditText=findViewById(R.id.UserID);
        passwordEditText=findViewById(R.id.Password);
        userIDEditText=findViewById(R.id.UserID);
        saveButton=findViewById(R.id.Save);
        BackButton=findViewById(R.id.backbuttonID);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* String user=usernameEditText.getText().toString().trim();
                String pwd=passwordEditText.getText().toString().trim();
                String userID=userIDEditText.getText().toString().trim();
                long val=db.adduser(user,pwd);

                if(val>0)
                {
                    if(user.equals(" ")&& pwd.equals(""))
                    {
                        Toast.makeText(Registration.this, "You have not add data", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(Registration.this, "You have save succesfully", Toast.LENGTH_SHORT).show();
                    }
                }*/

                if(v.getId()==R.id.Save)
                {
                    String username=usernameEditText.getText().toString();
                    String userpassword=passwordEditText.getText().toString();
                    String userID=userIDEditText.getText().toString();
                    //If User donot give any user name,password,userID
                    if(username.equals("")&&userpassword.equals("")&&userID.equals(""))
                    {
                        Toast.makeText(getApplicationContext(), "Please Enter Some data", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        //Writing Data
                        SharedPreferences sharedPreferences=getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();

                        editor.putString("usernamekey",username);
                        editor.putString("passwordkey",userpassword);
                        editor.putString("userIDkey",userID);

                        editor.commit();
                        String username2=usernameEditText.getText().toString();
                        String userpassword2=passwordEditText.getText().toString();
                        Toast.makeText(getApplicationContext(), "Data is stored successfully", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        BackButton.setOnClickListener(new View.OnClickListener() {
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
