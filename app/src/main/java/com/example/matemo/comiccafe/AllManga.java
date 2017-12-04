package com.example.matemo.comiccafe;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
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

public class AllManga extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;

    // SwipeToRefresh
    SwipeRefreshLayout swLayout;
    LinearLayout llayout;
    GridView grid;

    //ArrayList
    ArrayList<Genre> allGenre = new ArrayList<Genre>();
    ArrayList<MangaHasGenre> mangaHasGenres = new ArrayList<MangaHasGenre>();
    ArrayList<MangaHasChapter> mangaHasChapters = new ArrayList<MangaHasChapter>();
    ArrayList<ChapterHasImages> chapterHasImages = new ArrayList<ChapterHasImages>();
    ArrayList<UserBackupManga> userBackupMangas = new ArrayList<UserBackupManga>();
    ArrayList<UserLikesManga>userLikesMangas = new ArrayList<UserLikesManga>();
    DataBaseHandler dbHandler;

    public AllManga() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllManga.
     */
    // TODO: Rename and change types and number of parameters
    public static AllManga newInstance(String param1, String param2) {
        AllManga fragment = new AllManga();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_all_manga, container, false);
        //SwipeRefreshLayout
        swLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipelayout);
        llayout = (LinearLayout) view.findViewById(R.id.swiperefresh);
        swLayout.setColorSchemeResources(R.color.purple,R.color.pomegranate,R.color.grey);
        //customgrid
        CustomGrid cgrid = new CustomGrid(getContext(), SplashScreen.allManga);
        grid = view.findViewById(R.id.grid);
        grid.setAdapter(cgrid);
        cgrid.notifyDataSetChanged();
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailManga = new Intent(getActivity(), DetailManga.class);
                Manga currentManga = SplashScreen.allManga.get(i);
                detailManga.putExtra("currentManga", currentManga);
                startActivity(detailManga);
            }
        });
        swLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Berhenti putar
                        swLayout.setRefreshing(false);

                        //Action setelah refresh berhenti
<<<<<<< HEAD
                        //fetchUser();
=======
>>>>>>> df70ce94b8b614990672db2cdd83be35a1687e53
                    }
                }, 3000);
            }
        });
        return view;
    }
/*    private void dataDBLocal()
    {
        SplashScreen.allManga = dbHandler.getAllManga();
        allGenre = dbHandler.getAllGenre();
        mangaHasGenres = dbHandler.getAllMangaHasGenre();
        mangaHasChapters = dbHandler.getAllMangaHasChapter();
        chapterHasImages = dbHandler.getAllChapterHasImages();
        SplashScreen.userFavoritesMangas = dbHandler.getAllUserFavoritesManga();//UBAH
        userLikesMangas = dbHandler.getAllUserLikesManga();

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
                                Toast.makeText(getContext(), "No Internet Connection!", Toast.LENGTH_SHORT).show();
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

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
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
                                    fetchBackup();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getContext(), "No Internet Connection!", Toast.LENGTH_SHORT).show();
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

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
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
                                        SplashScreen.backups.clear();
                                        String mangadata = jsonObject.getString("dataBackup");
                                        JSONArray jsonArray = new JSONArray(mangadata);
                                        for (int i=0; i<jsonArray.length(); i++)
                                        {
                                            JSONObject obj = (JSONObject) jsonArray.get(i);
                                            Backup backup = new Backup(obj.getInt("id"), obj.getInt("id_user"), ""+obj.getString("date"));
                                            SplashScreen.backups.add(backup);
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
                                Toast.makeText(getContext(), "No Internet Connection!", Toast.LENGTH_SHORT).show();
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

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
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
                                Toast.makeText(getContext(), "No Internet Connection!", Toast.LENGTH_SHORT).show();
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

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

    private void fetchUserFavoritesManga()
    {
        int count=1;
        for (Backup a : SplashScreen.backups)
        {
            for (UserBackupManga b : userBackupMangas)
            {
                if(b.getId_backup()==a.getId()) {
                    UserFavoritesManga c = new UserFavoritesManga(count++, a.getId_user(), b.getId_manga());
                    SplashScreen.userFavoritesMangas.add(c);
                }
            }
        }
        dbHandler.deleteAllUserFavoritesManga();
        dbHandler.addUserFavoritesManga(SplashScreen.userFavoritesMangas);
        fetchGenre();
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
                                Toast.makeText(getContext(), "No Internet Connection!", Toast.LENGTH_SHORT).show();
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

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
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
                                Toast.makeText(getContext(), "No Internet Connection!", Toast.LENGTH_SHORT).show();
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

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
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
                                Toast.makeText(getContext(), "No Internet Connection!", Toast.LENGTH_SHORT).show();
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

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
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
                                Toast.makeText(getContext(), "No Internet Connection!", Toast.LENGTH_SHORT).show();
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

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
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
                                Toast.makeText(getContext(), "ChapterHasImages : "+chapterHasImages.size(), Toast.LENGTH_SHORT).show();
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    int statusCode = jsonObject.getInt("code");
                                    String message = jsonObject.getString("message");
                                    if(statusCode == 1)
                                    {
                                        SplashScreen.allManga.clear();
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
                                            int favorite = 0;
                                            if(dbHandler.getUser().size()!=0)
                                            {
                                                for (UserFavoritesManga userFavoritesManga : dbHandler.getAllUserFavoritesManga())
                                                {
                                                    if(obj.getInt("id")==userFavoritesManga.getId_manga() && dbHandler.getUser().get(0).getId()==userFavoritesManga.getId_user())
                                                    {
                                                        favorite = 1;
                                                        break;
                                                    }
                                                }
                                            }
                                            Manga manga = new Manga(obj.getInt("id"), obj.getString("name"), obj.getString("author"), obj.getString("status"), obj.getString("description"), favorite, obj.getString("img_cover"));
                                            manga.setTag(tag);
                                            manga.setChapters(chapters);
                                            SplashScreen.allManga.add(manga);
                                        }
                                    }
                                    dbHandler.cleanDB();
                                    dbHandler.addDB(SplashScreen.allManga, allGenre, mangaHasGenres, mangaHasChapters, chapterHasImages, SplashScreen.userFavoritesMangas, userLikesMangas);
//                                    Toast.makeText(SplashScreen.this, "SUCCESS!!!!!", Toast.LENGTH_SHORT).show();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getContext(), "No Internet Connection!", Toast.LENGTH_SHORT).show();
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

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }*/
}
