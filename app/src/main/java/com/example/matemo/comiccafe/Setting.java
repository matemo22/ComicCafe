package com.example.matemo.comiccafe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Setting extends AppCompatActivity {
    TextView settingInformation, lastBackup;
    Button btnBackup, btnRestore, btnLoginSetting, btnLogoutSetting;
    DataBaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        dbHandler = new DataBaseHandler(this);
        settingInformation = findViewById(R.id.settingInformation);
        lastBackup = findViewById(R.id.lastBackup);
        btnBackup = findViewById(R.id.btnBackup);
        btnRestore = findViewById(R.id.btnRestore);
        btnLoginSetting = findViewById(R.id.btnLoginSetting);
        btnLogoutSetting = findViewById(R.id.btnLogoutSetting);

        if(dbHandler.getUser().size()!=0)
        {
            for (Backup a : SplashScreen.backups)
            {
                if(a.getId_user()==dbHandler.getUser().get(0).getId())
                {
                    lastBackup.setText(a.getDate());
                    break;
                }
            }
            btnLoginSetting.setVisibility(View.INVISIBLE);
            btnLogoutSetting.setVisibility(View.VISIBLE);
            settingInformation.setVisibility(View.INVISIBLE);
            btnBackup.setEnabled(true);
            btnBackup.setTextColor(Color.parseColor("#FFFFFF"));
            btnRestore.setEnabled(true);
            btnRestore.setTextColor(Color.parseColor("#FFFFFF"));
        }

        btnLoginSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(Setting.this, LoginScreen.class);
                startActivity(loginIntent);
            }
        });

        btnLogoutSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=0;
                for (Manga manga : SplashScreen.allManga)
                {
                    manga.setFavorite(0);
                    SplashScreen.allManga.set(i++, manga);
                }
                dbHandler.deleteUser();
                dbHandler.deleteAllUserFavoritesManga();
                Intent menuIntent = new Intent(Setting.this, MainActivity.class);
                startActivity(menuIntent);
                finish();
            }
        });

        btnBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBackup();
                int id_backup = 0;
                for (UserFavoritesManga userFavoritesManga : dbHandler.getAllUserFavoritesManga())
                {
                    addUserBackupManga(id_backup, userFavoritesManga.getId_manga());
                }
            }
        });

        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SplashScreen.userFavoritesMangas.size()!=0)
                {
                    dbHandler.deleteAllUserFavoritesManga();
                    int i=0;
                    for (Manga manga : SplashScreen.allManga)
                    {
                        for (UserFavoritesManga userFavoritesManga : SplashScreen.userFavoritesMangas)
                        {
                            if(manga.getId()==userFavoritesManga.getId_manga() && userFavoritesManga.getId_user()==dbHandler.getUser().get(0).getId())
                            {
                                manga.setFavorite(1);
                                dbHandler.addUserFavoritesManga(userFavoritesManga);
                            }
                        }
                        SplashScreen.allManga.set(i++, manga);
                    }
                    Toast.makeText(Setting.this, "Restore Success", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void addBackup()
    {
        String url = "http://comiccafe.tk/myappdb/addBackup.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int statusCode = jsonObject.getInt("code");
                    String message = jsonObject.getString("message");
                    if(statusCode==1)
                    {

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id_user", String.valueOf(dbHandler.getUser().get(0).getId()));
                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }

    public void addUserBackupManga(final int id_backup, final int id_manga)
    {
        String url = "http://comiccafe.tk/myappdb/addUserBackupManga.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int statusCode = jsonObject.getInt("code");
                    String message = jsonObject.getString("message");
                    if(statusCode==1)
                    {

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id_backup", String.valueOf(id_backup));
                params.put("id_manga", String.valueOf(id_manga));
                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }

}
