package com.example.matemo.comiccafe;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AllManga extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;

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

    GridView grid;

    ArrayList<Manga> allManga = new ArrayList<Manga>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        createTempManga();
        view = inflater.inflate(R.layout.fragment_all_manga, container, false);
        //customgrid
        CustomGrid cgrid = new CustomGrid(getContext(), allManga);
        grid = view.findViewById(R.id.grid);
        grid.setAdapter(cgrid);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailManga = new Intent(getActivity(), DetailManga.class);
                Manga currentManga = allManga.get(i);
                detailManga.putExtra("currentManga", currentManga);
                startActivity(detailManga);
            }
        });
        return view;
    }

    //diganti dengan fetch
    public void createTempManga()
    {
        Manga a = new Manga("Aharen", "Calvin", "On Going", 0, R.drawable.gradient);
        Manga b = new Manga("Ore no Imouto ga Konnani Kawaii Wake ga Nai!", "Calvin", "On Going", 0, R.drawable.gradient);
        Manga c = new Manga("Cecilia Code", "Calvin", "On Going", 1, R.drawable.gradient);
        Manga d = new Manga("Dragon Riot", "Calvin", "On Going", 1, R.drawable.gradient);
        Manga e = new Manga("Eiyuu Densetsu", "Calvin", "On Going", 0, R.drawable.gradient);
        Manga f = new Manga("Flame of Recca", "Calvin", "On Going", 0, R.drawable.gradient);
        allManga.add(a);
        allManga.add(b);
        allManga.add(c);
        allManga.add(d);
        allManga.add(e);
        allManga.add(f);
    }
}
