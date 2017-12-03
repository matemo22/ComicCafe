package com.example.matemo.comiccafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        userDB = SplashScreen.users;

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
            boolean isUsernameFound = false, isPasswordFound = false;
                if (!username.getText().toString().equals("") && !password.getText().toString().equals("")) {
                    for (int i = 0; i < userDB.size(); i++) {
                        isUsernameFound = false;
                        isPasswordFound = false;
                        if (username.getText().toString().equals(userDB.get(i).getUsername())) {
                            isUsernameFound = true;
                            if (password.getText().toString().equals(userDB.get(i).getPassword())) {
                                isPasswordFound = true;
                                Intent mainMenu = new Intent(LoginScreen.this, MainActivity.class);
                                currentUser = userDB.get(i);
                                mainMenu.putExtra("currentUser", currentUser);
                                startActivity(mainMenu);
                                finish();
                                break;
                            }
                        }
                    }
                    if (!isUsernameFound || !isPasswordFound) {
                        Toast.makeText(getApplicationContext(), "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Username and Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
