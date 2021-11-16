package com.example.dfl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText name, password;
    private TextView info;
    private Button login;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        info = (TextView) findViewById(R.id.info);
        login = (Button) findViewById(R.id.login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });


    }

    private void validate(String userName, String userPassword){
        if ((userName.equals("Admin")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }else {
            counter --;

            info.setText("Number of attempts remaining " + String.valueOf(counter));


            if (counter == 0){
                login.setEnabled(false);
            }
        }
    }
}