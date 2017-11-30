package com.example.matemo.comiccafe;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    public static ArrayList<Manga> allManga = new ArrayList<Manga>();
    ArrayList<Genre> allGenre = new ArrayList<Genre>();
    ArrayList<MangaHasGenre> mangaHasGenres = new ArrayList<MangaHasGenre>();
    ArrayList<MangaHasChapter> mangaHasChapters = new ArrayList<MangaHasChapter>();
    ArrayList<ChapterHasImages> chapterHasImages = new ArrayList<ChapterHasImages>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchGenre();
        fetchMangaHasGenre();
        fetchMangaHasChapter();
        fetchChapterHasImages();
        allManga = getAllManga();
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }

    public ArrayList<Manga> getAllManga()
    {
        ArrayList<Manga> temp = fetchManga();
        return temp;
    }

    private void fetchGenre()
    {
        String url = "http://comiccafe.tk/myappdb/fetchGenre.php";
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
                                        allGenre.clear();
                                        String mangadata = jsonObject.getString("dataGenre");
                                        JSONArray jsonArray = new JSONArray(mangadata);
                                        for (int i=0; i<jsonArray.length(); i++)
                                        {
                                            JSONObject obj = (JSONObject) jsonArray.get(i);
                                            Genre genre=new Genre(obj.getInt("id"), obj.getString("name"));
                                            allGenre.add(genre);
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

    private void fetchMangaHasGenre()
    {
        String url = "http://comiccafe.tk/myappdb/fetchMangaHasGenre.php";
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
                                        mangaHasGenres.clear();
                                        String mangadata = jsonObject.getString("dataMangaHasGenre");
                                        JSONArray jsonArray = new JSONArray(mangadata);
                                        for (int i=0; i<jsonArray.length(); i++)
                                        {
                                            JSONObject obj = (JSONObject) jsonArray.get(i);
                                            MangaHasGenre mangaHasGenre=new MangaHasGenre(obj.getInt("id"), obj.getInt("id_manga"), obj.getInt("id_genre"));
                                            mangaHasGenres.add(mangaHasGenre);
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

    private void fetchMangaHasChapter()
    {
        String url = "http://comiccafe.tk/myappdb/fetchMangaHasChapter.php";
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
                                        mangaHasChapters.clear();
                                        String mangadata = jsonObject.getString("dataMangaHasChapter");
                                        JSONArray jsonArray = new JSONArray(mangadata);
                                        for (int i=0; i<jsonArray.length(); i++)
                                        {
                                            JSONObject obj = (JSONObject) jsonArray.get(i);
                                            MangaHasChapter mangaHasChapter=new MangaHasChapter(obj.getInt("id"), obj.getInt("id_manga"), obj.getInt("number"), obj.getString("title"));
                                            mangaHasChapters.add(mangaHasChapter);
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

    private void fetchChapterHasImages()
    {
        String url = "http://comiccafe.tk/myappdb/fetchChapterHasImages.php";
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
                                        chapterHasImages.clear();
                                        String mangadata = jsonObject.getString("dataChapterHasImages");
                                        JSONArray jsonArray = new JSONArray(mangadata);
                                        for (int i=0; i<jsonArray.length(); i++)
                                        {
                                            JSONObject obj = (JSONObject) jsonArray.get(i);
                                            ChapterHasImages chapterHasImage=new ChapterHasImages(obj.getInt("id"), obj.getInt("id_chapter"), obj.getString("url"));
                                            chapterHasImages.add(chapterHasImage);
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

    private ArrayList<Manga> fetchManga()
    {
        final ArrayList<Manga> temp = new ArrayList<Manga>();
        String url = "http://comiccafe.tk/myappdb/fetchManga.php";
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
                                        allManga.clear();
                                        String mangadata = jsonObject.getString("dataManga");
                                        JSONArray jsonArray = new JSONArray(mangadata);
                                        for (int i=0; i<jsonArray.length(); i++)
                                        {
                                            JSONObject obj = (JSONObject) jsonArray.get(i);
                                            ArrayList<String> tag = new ArrayList<String>();
                                            ArrayList<Chapter> chapters = new ArrayList<Chapter>();
                                            for (MangaHasGenre a:mangaHasGenres) {
                                                if(obj.getInt("id")==a.getId_manga())
                                                {
                                                    for (Genre b:allGenre)
                                                    {
                                                        if(a.getId_genre()==b.getId())
                                                        {
                                                            tag.add(b.getName());
                                                        }
                                                    }
                                                }
                                            }
                                            for (int j=0; j<mangaHasChapters.size(); j++)
                                            {
                                                if(obj.getInt("id")==mangaHasChapters.get(j).getid_manga())
                                                {
                                                    Chapter chapter = new Chapter(mangaHasChapters.get(j).getTitle(), mangaHasChapters.get(j).getNum_chapter());
                                                    for (int k=0; k<chapterHasImages.size(); k++)
                                                    {
                                                        if(mangaHasChapters.get(j).getId()==chapterHasImages.get(k).getid_chapter())
                                                        {
                                                            chapter.addUrl(chapterHasImages.get(k).getUrl());
                                                        }
                                                    }
                                                    chapters.add(chapter);
                                                }
                                            }

                                            //Bikin for untuk ambil data user favorite manga
                                            //DO HERE

                                            Manga manga = new Manga(obj.getString("name"), obj.getString("author"), obj.getString("status"), obj.getString("description"), 0, obj.getString("img_cover"));
                                            manga.setTag(tag);
                                            manga.setChapters(chapters);
//                                            Toast.makeText(MainActivity.this, tag.get(0)+"+"+chapters.get(0), Toast.LENGTH_SHORT).show();
                                            temp.add(manga);
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
                                Toast.makeText(SplashScreen.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
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
        return temp;
    }
}
