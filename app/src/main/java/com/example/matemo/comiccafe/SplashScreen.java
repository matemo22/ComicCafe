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
//    private static int SPLASH_TIME_OUT = 3000;
    public static ArrayList<Manga> allManga = new ArrayList<Manga>();
    ArrayList<Genre> allGenre = new ArrayList<Genre>();
    ArrayList<MangaHasGenre> mangaHasGenres = new ArrayList<MangaHasGenre>();
    ArrayList<MangaHasChapter> mangaHasChapters = new ArrayList<MangaHasChapter>();
    ArrayList<ChapterHasImages> chapterHasImages = new ArrayList<ChapterHasImages>();
    public static ArrayList<User> users = new ArrayList<User>();
    ArrayList<UserFavoritesManga> userFavoritesMangas = new ArrayList<UserFavoritesManga>();
    ArrayList<UserLikesManga>userLikesMangas = new ArrayList<UserLikesManga>();
    DataBaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        dbHandler = new DataBaseHandler(this);
        fetchUser();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent homeIntent = new Intent(SplashScreen.this, MainActivity.class);
//                startActivity(homeIntent);
//                finish();
//            }
//        }, 0);
    }

    private void dataDBLocal()
    {
        allManga = dbHandler.getAllManga();
        allGenre = dbHandler.getAllGenre();
        mangaHasGenres = dbHandler.getAllMangaHasGenre();
        mangaHasChapters = dbHandler.getAllMangaHasChapter();
        chapterHasImages = dbHandler.getAllChapterHasImages();
        userFavoritesMangas = dbHandler.getAllUserFavoritesManga();
        userLikesMangas = dbHandler.getAllUserLikesManga();
        Intent homeIntent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(homeIntent);
        finish();
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
                                        users.clear();
                                        String mangadata = jsonObject.getString("dataUser");
                                        JSONArray jsonArray = new JSONArray(mangadata);
                                        for (int i=0; i<jsonArray.length(); i++)
                                        {
                                            JSONObject obj = (JSONObject) jsonArray.get(i);
                                            User user = new User(obj.getInt("id"), obj.getString("username"),obj.getString("password"), obj.getString("email"), obj.getInt("img_profile"));
                                            users.add(user);
                                        }
                                    }
                                    fetchUserLikesManga();
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
                                dataDBLocal();
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

    private void fetchUserLikesManga()
    {
        String url = "http://comiccafe.tk/myappdb/fetchUserLikesManga.php";
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
                                        userLikesMangas.clear();
                                        String mangadata = jsonObject.getString("dataUserLikesManga");
                                        JSONArray jsonArray = new JSONArray(mangadata);
                                        for (int i=0; i<jsonArray.length(); i++)
                                        {
                                            JSONObject obj = (JSONObject) jsonArray.get(i);
                                            UserLikesManga userLikesManga = new UserLikesManga(obj.getInt("id"), obj.getInt("id_user"), obj.getInt("id_manga"));
                                            userLikesMangas.add(userLikesManga);
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
                                Toast.makeText(SplashScreen.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
                                dataDBLocal();
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
        String url = "http://comiccafe.tk/myappdb/fetchUserFavoritesManga.php";
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
                                        userFavoritesMangas.clear();
                                        String mangadata = jsonObject.getString("dataUserFavoritesManga");
                                        JSONArray jsonArray = new JSONArray(mangadata);
                                        for (int i=0; i<jsonArray.length(); i++)
                                        {
                                            JSONObject obj = (JSONObject) jsonArray.get(i);
                                            UserFavoritesManga userFavoritesManga = new UserFavoritesManga(obj.getInt("id"), obj.getInt("id_user"), obj.getInt("id_manga"));
                                            userFavoritesMangas.add(userFavoritesManga);
                                        }
                                    }
                                    fetchGenre();
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
                                dataDBLocal();
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
                                    fetchMangaHasGenre();
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
                                dataDBLocal();
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
                                    fetchMangaHasChapter();
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
                                dataDBLocal();
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
                                    fetchChapterHasImages();
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
                                dataDBLocal();
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
                                    fetchManga();
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
                                dataDBLocal();
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

    private void fetchManga()
    {
//        final ArrayList<Manga> temp = new ArrayList<Manga>();
        String url = "http://comiccafe.tk/myappdb/fetchManga.php";
        StringRequest stringRequest = new StringRequest
                (
                        Request.Method.POST,
                        url,
                        new Response.Listener<String>()
                        {

                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(SplashScreen.this, "ChapterHasImages : "+chapterHasImages.size(), Toast.LENGTH_SHORT).show();
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
                                            for (MangaHasChapter a:mangaHasChapters)
                                            {
                                                if(obj.getInt("id")==a.getId_manga())
                                                {
                                                    Chapter chapter = new Chapter(a.getTitle(), a.getNum_chapter());
                                                    ArrayList<String> addImages = new ArrayList<String>();
                                                    for (ChapterHasImages b:chapterHasImages)
                                                    {
                                                        if(b.getId_chapter()==a.getId())
                                                        {
                                                            addImages.add(b.getUrl());
                                                        }
                                                    }
//                                                    Toast.makeText(SplashScreen.this, String.valueOf(addImages.size()), Toast.LENGTH_SHORT).show();
                                                    chapter.setUrlImg(addImages);
                                                    chapters.add(chapter);
                                                }
                                            }

                                            //Bikin for untuk ambil data user favorite manga
                                            //DO HERE

                                            Manga manga = new Manga(obj.getInt("id"), obj.getString("name"), obj.getString("author"), obj.getString("status"), obj.getString("description"), 0, obj.getString("img_cover"));
                                            manga.setTag(tag);
                                            manga.setChapters(chapters);
                                            allManga.add(manga);
                                        }
                                    }
                                    dbHandler.cleanDB();
                                    dbHandler.addDB(allManga, allGenre, mangaHasGenres, mangaHasChapters, chapterHasImages, userFavoritesMangas, userLikesMangas);
                                    Intent homeIntent = new Intent(SplashScreen.this, MainActivity.class);
                                    startActivity(homeIntent);
                                    finish();
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
                                dataDBLocal();
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
