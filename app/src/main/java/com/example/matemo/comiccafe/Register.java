package com.example.matemo.comiccafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;
import java.util.zip.Inflater;

public class Register extends AppCompatActivity {
    EditText username, password, confPassword, email;
    Button btnCancel, btnRegister;
    boolean isOnline=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        btnCancel = (Button) findViewById(R.id.button_cancel);
        btnRegister = findViewById(R.id.button_register);
        username = findViewById(R.id.editText_register_username);
        password = findViewById(R.id.editText_password);
        confPassword = findViewById(R.id.editText_register_cp);
        email = findViewById(R.id.editText_email);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, LoginScreen.class);
                startActivity(i);
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isOnline)
                {
                    if (!username.getText().toString().equals("") && !password.getText().toString().equals("") && !confPassword.getText().toString().equals("") && !email.getText().toString().equals(""))
                    {
                        if (password.getText().toString().equals(confPassword.getText().toString()))
                        {
                            registerProcess();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Password didn't match!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Data tidak lengkap", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "No Internet Connection!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void registerProcess()
    {
        String url = "http://comiccafe.tk/myappdb/register.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int statusCode = jsonObject.getInt("code");
                    String message = jsonObject.getString("message");
                    if(statusCode==1)
                    {
                        fetchUser();
                        Intent i = new Intent(Register.this, MainActivity.class);
//                        User currentUser = new User(username.getText().toString(), password.getText().toString(), email.getText().toString(), R.drawable.ic_profile_pict);
//                        i.putExtra("currentUser", currentUser);
                        startActivity(i);
                        finish();
                    }
                    Toast.makeText(Register.this, message, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Register.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
                isOnline=false;
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username.getText().toString());
                params.put("password", password.getText().toString());
                params.put("email", email.getText().toString());
                params.put("img_profile", String.valueOf(R.drawable.ic_profile_pict));
                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }

    public void fetchUser()
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
                                        SplashScreen.users.clear();
                                        String mangadata = jsonObject.getString("dataUser");
                                        JSONArray jsonArray = new JSONArray(mangadata);
                                        for (int i=0; i<jsonArray.length(); i++)
                                        {
                                            JSONObject obj = (JSONObject) jsonArray.get(i);
                                            User user = new User(obj.getInt("id"), obj.getString("username"),obj.getString("password"), obj.getString("email"), obj.getInt("img_profile"));
                                            SplashScreen.users.add(user);
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
                                Toast.makeText(Register.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();

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
