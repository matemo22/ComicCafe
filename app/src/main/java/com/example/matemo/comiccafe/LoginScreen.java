package com.example.matemo.comiccafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginScreen extends AppCompatActivity {

    TextView register;
    Button login;
    EditText username, password;
    User currentUser;
    ArrayList<User> userDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        register = (TextView) findViewById(R.id.textView_register);
        login = findViewById(R.id.button_login);
        username = findViewById(R.id.editText_username);
        password = findViewById(R.id.editText_password);
        userDB = new ArrayList<User>();
        userDB.add(new User(R.drawable.ic_launcher_background, "matemo2204@gmail.com", "matemo22", "1234"));

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginScreen.this, Register.class);
                startActivity(registerIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!username.getText().toString().equals("") && !password.getText().toString().equals(""))
                {
                    for (int i=0; i<userDB.size(); i++)
                    {
                        if(username.getText().toString().equals(userDB.get(i)))
                        {
                            if(password.getText().toString().equals("123"))
                            {
                                Intent mainMenu = new Intent(LoginScreen.this, MainActivity.class);
                                currentUser = userDB.get(i);
                                mainMenu.putExtra("currentUser", currentUser);
                                startActivity(mainMenu);
                                finish();
                            }
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Username and Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
