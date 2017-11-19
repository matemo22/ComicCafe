package com.example.matemo.comiccafe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Matemo on 11/19/2017.
 */

public class DetailManga extends AppCompatActivity {
    Manga currentManga;
    ImageView cover, favorite;
    TextView title, author, status, description, chapter, tag;
    Button btnResume;

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
        btnResume = findViewById(R.id.bookDetailBtnRead);

        if(getIntent()!= null && getIntent().getExtras()!=null) {
            currentManga = getIntent().getExtras().getParcelable("currentManga");
            title.setText(currentManga.getTitle());
            author.setText(currentManga.getAuthor());
            status.setText(currentManga.getStatus());
            description.setText(currentManga.getDescription());
            chapter.setText(currentManga.getChapters()+" Chapters");
            String tempTag="";
            for (int i=0; i<currentManga.getTag().size(); i++)
            {
                if(i==currentManga.getTag().size()-1)
                    tempTag += tempTag+currentManga.getTag().get(i);
                else
                    tempTag += tempTag+currentManga.getTag().get(i)+", ";
            }
            tag.setText(tempTag);
            cover.setImageResource(currentManga.getImg_cover());
            if(currentManga.getFavorite()==0)
            {
                favorite.setImageResource(R.drawable.ic_favorite0);
            }
            else
            {
                favorite.setImageResource(R.drawable.ic_favorite1);
            }
        }

    }
}
