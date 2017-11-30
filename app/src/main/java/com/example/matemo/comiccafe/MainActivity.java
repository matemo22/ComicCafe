package com.example.matemo.comiccafe;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
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

public class MainActivity extends AppCompatActivity{
    //defining widgets
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    Fragment fragment=null;
    FragmentTransaction fragmentTransaction=null;
    ImageView toolbar_search;
    public static User currentUser;
    public static ArrayList<Manga> allManga = new ArrayList<Manga>();
    ArrayList<Genre> allGenre = new ArrayList<Genre>();
    ArrayList<MangaHasGenre> mangaHasGenres = new ArrayList<MangaHasGenre>();
    ArrayList<MangaHasChapter> mangaHasChapters = new ArrayList<MangaHasChapter>();
    ArrayList<ChapterHasImages> chapterHasImages = new ArrayList<ChapterHasImages>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialising the widgets
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        navigationView=(NavigationView)findViewById(R.id.navigationview);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        toolbar_search = findViewById(R.id.toolbar_search);
        fetchManga();
//        allManga = createTempManga();
        fetchGenre();
        fetchMangaHasGenre();
        fetchMangaHasChapter();
        fetchChapterHasImages();

        if(getIntent()!= null && getIntent().getExtras()!=null) {
            currentUser = getIntent().getExtras().getParcelable("currentUser");
        }

        initHeader(navigationView.getHeaderView(0));
        //setting the toolbar as actionbar
        setSupportActionBar(toolbar);

        //setting background color of toolbar
//        toolbar.setBackgroundColor(Color.parseColor("#0081c9"));

        toolbar_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //To Search Layout
                Toast.makeText(getApplicationContext(), "Search Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //handling click of Navigation View items
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if(menuItem.isChecked())
                    menuItem.setChecked(false);
                else
                    menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return displayFragment(menuItem.getItemId());
            }
        });

        //creating ActionBarDrawerToggle
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.draweropened,R.string.drawerclosed)
        {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        //binding ActionBarDrawerToggle to DrawerLayout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is compulsory to avoid unusual behaviour as home button wont show up
        actionBarDrawerToggle.syncState();

        //showing Fragment for FirstTime
        if(savedInstanceState==null)
        {
            displayFragment(R.id.allmanga);
        }
    }

    public void initHeader(View view)
    {
        TextView userEmail;
        ImageView profileImage, ic_setting, ic_notification;

        userEmail = view.findViewById(R.id.userEmail);
        profileImage = view.findViewById(R.id.profileImage);
        ic_setting = view.findViewById(R.id.ic_setting);
        ic_notification = view.findViewById(R.id.ic_notification);

        if(currentUser!=null)
        {
            profileImage.setImageResource(currentUser.getProfileImage());
            userEmail.setText(currentUser.getUserEmail());
        }

        userEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentUser==null) {
                    Intent loginIntent = new Intent(MainActivity.this, LoginScreen.class);
                    startActivity(loginIntent);
                }
                else
                {
                    //Go To Profile Page
                    Toast.makeText(getApplicationContext(), "Email Clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentUser==null)
                {
                    Intent loginIntent = new Intent(MainActivity.this, LoginScreen.class);
                    startActivity(loginIntent);
                }
                else
                {
                    //Go To Profile Page
                    Toast.makeText(getApplicationContext(), "Profile Clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ic_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Setting Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        ic_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Notification Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean displayFragment(int id)
    {
        switch (id)
        {
            case R.id.allmanga:
//                Toast.makeText(getApplicationContext(), "Sent Selected", Toast.LENGTH_SHORT).show();.
                fragment= (Fragment) new AllManga();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.favorites:
                fragment= (Fragment) new Favorites();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.discover:
                fragment= (Fragment) new Discover();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.aboutus:
                fragment= (Fragment) new AboutUs();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.commit();
                return true;

        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //   getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Toast.makeText(getApplicationContext(), String.valueOf(id), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    //diganti dengan fetch
//    public ArrayList<Manga> createTempManga()
//    {
//        ArrayList<Manga> allManga = new ArrayList<Manga>();
//        Manga a = new Manga("Aharen", "Calvin", "On Going", 0, R.drawable.gradient);
//        a.addTag("School Life"); a.addTag("Romance"); a.addTag("Comedy"); a.addTag("Slice of Life");
//        a.getChapters().add(new Chapter("Pergi Sekolah", 1));
//        a.getChapters().add(new Chapter("Di Sekolah", 2));
//        a.getChapters().add(new Chapter("Pulang Sekolah", 3));
//        Manga b = new Manga("Ore no Imouto ga Konnani Kawaii Wake ga Nai!", "Calvin", "On Going", 0, R.drawable.gradient);
//        b.addTag("School Life"); b.addTag("Romance"); b.addTag("Comedy"); b.addTag("Harem"); b.addTag("Slice of Life");
//        Manga c = new Manga("Cecilia Code", "Calvin", "On Going", 1, R.drawable.gradient);
//        Manga d = new Manga("Dragon Riot", "Calvin", "On Going", 1, R.drawable.gradient);
//        Manga e = new Manga("Eiyuu Densetsu", "Calvin", "On Going", 0, R.drawable.gradient);
//        Manga f = new Manga("Flame of Recca", "Calvin", "On Going", 0, R.drawable.gradient);
//        allManga.add(a);
//        allManga.add(b);
//        allManga.add(c);
//        allManga.add(d);
//        allManga.add(e);
//        allManga.add(f);
//        return allManga;
//    }

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
                                Toast.makeText(MainActivity.this, "A", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(MainActivity.this, "B", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(MainActivity.this, "D", Toast.LENGTH_SHORT).show();
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
                                        ArrayList<String> tag = new ArrayList<String>();
                                        ArrayList<Chapter> chapters = new ArrayList<Chapter>();
                                        for (int i=0; i<jsonArray.length(); i++)
                                        {
                                            JSONObject obj = (JSONObject) jsonArray.get(i);
                                            for (int j=0; j< mangaHasGenres.size(); j++)
                                            {
                                                if(obj.getInt("id")==mangaHasGenres.get(j).getId_manga())
                                                {
                                                    for (int k=0; k<allGenre.size(); k++)
                                                    {
                                                        if(mangaHasGenres.get(j).getId_genre()==allGenre.get(k).getId())
                                                            tag.add(allGenre.get(k).getName());
                                                    }
                                                }
                                            }
                                            for (int j=0; j<mangaHasChapters.size(); j++)
                                            {
                                                if(obj.getInt("id")==mangaHasChapters.get(j).getid_manga())
                                                {
                                                    Chapter chapter = new Chapter(mangaHasChapters.get(j).getTitle(), mangaHasChapters.get(j).getNum_chapter());
                                                    //Bikin for untuk addUrl
                                                    for (int k=0; k<chapterHasImages.size(); k++)
                                                    {
                                                        if(mangaHasChapters.get(j).getid_manga()==chapterHasImages.get(k).getid_chapter())
                                                        {
                                                            chapter.addUrl(chapterHasImages.get(k).getUrl());
                                                        }
                                                    }
                                                    chapters.add(chapter);
                                                }
                                            }

                                            //Bikin for untuk ambil data user favorite manga
                                            //DO HERE

                                            Manga manga = new Manga(obj.getString("title"), obj.getString("author"), obj.getString("status"), obj.getString("description"), 0, obj.getString("img_cover"));
                                            allManga.add(manga);
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
                                Toast.makeText(MainActivity.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
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
