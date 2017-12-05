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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Setting extends AppCompatActivity {
    TextView settingInformation, lastBackup;
    Button btnBackup, btnRestore, btnLoginSetting, btnLogoutSetting;
    DataBaseHandler dbHandler;
    ArrayList<Backup> backups = new ArrayList<Backup>();
    ArrayList<UserBackupManga> userBackupMangas = new ArrayList<UserBackupManga>();
    ArrayList<UserFavoritesManga> userFavoritesMangas = new ArrayList<UserFavoritesManga>();


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
            }
        });

        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchBackupRestore();
            }
        });
    }

    private void fetchBackupRestore()
    {
        String url = "http://comiccafe.tk/myappdb/fetchBackup.php";
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
                                        backups.clear();
                                        String mangadata = jsonObject.getString("dataBackup");
                                        JSONArray jsonArray = new JSONArray(mangadata);
                                        for (int i=0; i<jsonArray.length(); i++)
                                        {
                                            JSONObject obj = (JSONObject) jsonArray.get(i);
                                            Backup backup = new Backup(obj.getInt("id"), obj.getInt("id_user"), ""+obj.getString("date"));
                                            backups.add(backup);
                                        }
                                    }
                                    fetchUserBackupManga();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Setting.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
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

    private void fetchUserBackupManga()
    {
        String url = "http://comiccafe.tk/myappdb/fetchUserBackupManga.php";
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
                                        userBackupMangas.clear();
                                        String mangadata = jsonObject.getString("dataUserBackupManga");
                                        JSONArray jsonArray = new JSONArray(mangadata);
                                        for (int i=0; i<jsonArray.length(); i++)
                                        {
                                            JSONObject obj = (JSONObject) jsonArray.get(i);
                                            UserBackupManga userBackupManga = new UserBackupManga(obj.getInt("id"), obj.getInt("id_backup"), obj.getInt("id_manga"));
                                            userBackupMangas.add(userBackupManga);
                                        }
                                    }
                                    fetchUserFavoritesManga();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Setting.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
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

    private void fetchUserFavoritesManga()
    {
        int count = 1;
        for (Backup a : backups) {
            for (UserBackupManga b : userBackupMangas) {
                if (b.getId_backup() == a.getId()) {
                    UserFavoritesManga c = new UserFavoritesManga(count++, a.getId_user(), b.getId_manga());
                    userFavoritesMangas.add(c);
                }
            }
        }
        dbHandler.deleteAllUserFavoritesManga();
        int i=0;
        for (Manga manga : SplashScreen.allManga)
        {
            for (UserFavoritesManga userFavoritesManga : userFavoritesMangas)
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
        for (Backup a : SplashScreen.backups)
        {
            if(a.getId_user()==dbHandler.getUser().get(0).getId())
            {
                lastBackup.setText(a.getDate());
                break;
            }
        }
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
                    fetchBackup();
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

    private void fetchBackup()
    {
        String url = "http://comiccafe.tk/myappdb/fetchBackup.php";
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
                                        backups.clear();
                                        String mangadata = jsonObject.getString("dataBackup");
                                        JSONArray jsonArray = new JSONArray(mangadata);
                                        for (int i=0; i<jsonArray.length(); i++)
                                        {
                                            JSONObject obj = (JSONObject) jsonArray.get(i);
                                            Backup backup = new Backup(obj.getInt("id"), obj.getInt("id_user"), ""+obj.getString("date"));
                                            backups.add(backup);
                                        }
                                    }
                                    addDatabase();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Setting.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
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

    public void addDatabase()
    {
        User currentUser = dbHandler.getUser().get(0);
        for (Backup backup : backups)
        {
            if(backup.getId_user()==currentUser.getId()) {
                for (UserFavoritesManga userFavoritesManga : dbHandler.getAllUserFavoritesManga())
                {
                    if(userFavoritesManga.getId_user()==currentUser.getId())
                    {
                        addUserBackupManga(backup.getId(), userFavoritesManga.getId_manga());
                    }
                }
            }
        }
        Toast.makeText(this, "Backup Success!", Toast.LENGTH_SHORT).show();
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
