package com.example.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Name = (EditText)findViewById(R.id.txtID);
        Password = (EditText)findViewById(R.id.txtPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }

    private void validate(String userName,String userPassword ){

        if ((userName=="Admin") && (userPassword=="1234")){

            Intent intent= new Intent(MainActivity.this,SecondAct.class);
            startActivity(intent);
        }
        else{

            counter--;


            Info.setText("number of attempts remaining"+ String.valueOf(counter));


            if(counter==0){

                Login.setEnabled(false);
            }
        }


    }

}
