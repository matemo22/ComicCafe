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
    boolean isOnline=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        register = (TextView) findViewById(R.id.textView_register);
        login = findViewById(R.id.button_login);
        username = findViewById(R.id.editText_username);
        password = findViewById(R.id.editText_password);
        userDB = new ArrayList<User>();
        fetchUser();

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
                if(isOnline)
                {
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
                else
                {
                    Toast.makeText(getApplicationContext(), "No Internet Connection!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void fetchUser()
    {
        String url = "http://comiccafe.tk/myappdb/fetchUser.php";
        StringRequest stringRequest = new StringRequest
        (
            Request.Method.POST,
            url,
            new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        int statusCode = jsonObject.getInt("code");
                        String message = jsonObject.getString("message");
                        if(statusCode == 1)
                        {
                            userDB.clear();
                            String userdata = jsonObject.getString("dataUser");
                            JSONArray jsonArray = new JSONArray(userdata);
                            for (int i=0; i<jsonArray.length(); i++)
                            {
                                User user;
                                JSONObject obj = (JSONObject) jsonArray.get(i);
                                if(obj.getInt("img_profile")==0)
                                {
                                    user = new User(obj.getString("username"), obj.getString("password"), obj.getString("email"), R.drawable.ic_profile_pict);
                                }
                                else
                                {
                                    user = new User(obj.getString("username"), obj.getString("password"), obj.getString("email"), obj.getInt("img_profile"));
                                }
                                userDB.add(user);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            },
            new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(LoginScreen.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
                    isOnline=false;
                }
            }
        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
