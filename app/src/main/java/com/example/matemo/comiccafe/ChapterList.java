package com.example.matemo.comiccafe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

//AllManga.java
public class ChapterList extends AppCompatActivity {
    ListView listViewChapter;
    ChapterAdapter adapter;
    ArrayList<Chapter> arrChapter;
    Manga currentManga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_list);
        currentManga = (Manga) getIntent().getSerializableExtra("currentManga");
        arrChapter = currentManga.getChapters();

        listViewChapter = findViewById(R.id.list_chapter);
        adapter = new ChapterAdapter(this, arrChapter);
        listViewChapter.setAdapter(adapter);

        Collections.reverse(arrChapter);
        adapter.notifyDataSetChanged();

        listViewChapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Collections.reverse(arrChapter);

                i=arrChapter.size()-i-1;
                int x=-1;
                for (int j=0; j<SplashScreen.allManga.size(); j++)
                {
                    if(SplashScreen.allManga.get(j).getTitle().equals(currentManga.getTitle()))
                    {
                        x=j;
                        break;
                    }
                }
                Chapter currentChapter = currentManga.getChapters().get(i);
                currentChapter.setStatus(1);
                currentManga.getChapters().get(i).setStatus(1);
                Toast.makeText(ChapterList.this, String.valueOf(i), Toast.LENGTH_SHORT).show();
                SplashScreen.allManga.set(x,currentManga);
                Collections.reverse(arrChapter);

                TextView title = adapterView.findViewById(R.id.listChapterTitle);
                title.setTextColor(Color.parseColor("#000000"));
                adapter.notifyDataSetChanged();

                Intent chapterImages = new Intent(getApplicationContext(), ChapterImages.class);
                chapterImages.putExtra("chapter_has_images", currentChapter);
                startActivity(chapterImages);

                Collections.reverse(arrChapter);
//                Intent chapterList = new Intent(getApplicationContext(), ChapterList.class);
//                chapterList.putExtra("urlImage", currentChapter.getUrlImg());
//                startActivity(chapterList);
            }
        });
    }

}
