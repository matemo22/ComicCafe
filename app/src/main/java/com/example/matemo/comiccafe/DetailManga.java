package com.example.matemo.comiccafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Matemo on 11/19/2017.
 */

public class DetailManga extends AppCompatActivity {
    Manga currentManga;
    ImageView cover, favorite;
    TextView title, author, status, description, chapter, tag;
    Button btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        title = findViewById(R.id.bookDetailTitle);
        author = findViewById(R.id.bookDetailAuthor);
        status = findViewById(R.id.bookDetailStatus);
        description = findViewById(R.id.bookDetailDescription);
        chapter = findViewById(R.id.bookDetailChapter);
        tag = findViewById(R.id.bookDetailTag);
        cover = findViewById(R.id.bookDetailCover);
        favorite = findViewById(R.id.bookDetailFavorite);
        btnRead = findViewById(R.id.bookDetailBtnRead);

        currentManga = (Manga) getIntent().getSerializableExtra("currentManga");
        title.setText(currentManga.getTitle());
        author.setText(currentManga.getAuthor());
        status.setText(currentManga.getStatus());
        description.setText(currentManga.getDescription());
        chapter.setText(currentManga.getChapters().size()+" Chapters");
        String tempTag="";
        for (int i=0; i<currentManga.getTag().size(); i++)
        {
            if(i==currentManga.getTag().size()-1)
                tempTag += currentManga.getTag().get(i);
            else
                tempTag += currentManga.getTag().get(i)+", ";
        }
        tag.setText(tempTag);
        cover.setImageResource(currentManga.getImg_cover());
        if(currentManga.getFavorite()==0)
        {
            favorite.setImageResource(R.drawable.ic_favorite_off);
        }
        else
        {
            favorite.setImageResource(R.drawable.ic_favorite_on);
        }

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Manga temp=null;
                int x=-1;
                for (int i=0; i<MainActivity.allManga.size(); i++)
                {
                    if(MainActivity.allManga.get(i).getTitle().equals(currentManga.getTitle()))
                    {
                        temp = MainActivity.allManga.get(i);
                        x=i;
                        break;
                    }
                }
                if(currentManga.getFavorite()==0) {
                    currentManga.setFavorite(1);
                    favorite.setImageResource(R.drawable.ic_favorite_on);
                    Toast.makeText(getApplicationContext(), "Added to Favorite", Toast.LENGTH_SHORT).show();
                }
                else {
                    currentManga.setFavorite(0);
                    favorite.setImageResource(R.drawable.ic_favorite_off);
                    Toast.makeText(getApplicationContext(), "Removed from Favorite", Toast.LENGTH_SHORT).show();
                }
                MainActivity.allManga.set(x, currentManga);
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chapterList = new Intent(getApplicationContext(), ChapterList.class);
                chapterList.putExtra("currentManga", currentManga);
                startActivity(chapterList);
            }
        });
    }
}
