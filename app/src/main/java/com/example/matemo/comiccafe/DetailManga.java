package com.example.matemo.comiccafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

/**
 * Created by Matemo on 11/19/2017.
 */

public class DetailManga extends AppCompatActivity {
    Manga currentManga;
    ImageView cover, favorite, like;
    TextView title, author, status, description, chapter, tag;
    Button btnRead;
    DataBaseHandler dbHandler;

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
        like = findViewById(R.id.bookDetailLike);
        btnRead = findViewById(R.id.bookDetailBtnRead);
        dbHandler = new DataBaseHandler(this);

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
        Picasso.with(getBaseContext())
                .load(currentManga.getImg_cover())
                .placeholder(R.drawable.ic_launcher_background)
                .networkPolicy(NetworkPolicy.NO_CACHE)//user this for offline support
                .into(cover, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        NetworkPolicy a;
                        Picasso.with(getBaseContext())
                                .load(currentManga.getImg_cover())
                                .placeholder(R.drawable.ic_launcher_background)
                                .networkPolicy(NetworkPolicy.NO_CACHE)//user this for offline support
                                .into(cover, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError() {
                                        //get error if image not loaded
                                    }
                                });
                    }
                });
//        cover.setImageResource(currentManga.getImg_cover());
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
                if(dbHandler.getUser().size()!=0)
                {
                    int x = -1;
                    for (int i = 0; i < SplashScreen.allManga.size(); i++) {
                        if (SplashScreen.allManga.get(i).getTitle().equals(currentManga.getTitle())) {
                            x = i;
                            break;
                        }
                    }
                    if (currentManga.getFavorite() == 0)
                    {
                        currentManga.setFavorite(1);
                        favorite.setImageResource(R.drawable.ic_favorite_on);
                        UserFavoritesManga userFavoritesManga = new UserFavoritesManga(0, dbHandler.getUser().get(0).getId(), currentManga.getId());
                        dbHandler.addUserFavoritesManga(userFavoritesManga);
                        Toast.makeText(getApplicationContext(), "Added to Favorite", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        currentManga.setFavorite(0);
                        favorite.setImageResource(R.drawable.ic_favorite_off);
                        for (UserFavoritesManga userFavoritesManga : dbHandler.getAllUserFavoritesManga()) {
                            if (userFavoritesManga.getId_user() == dbHandler.getUser().get(0).getId() && userFavoritesManga.getId_manga() == currentManga.getId()) {
                                dbHandler.deleteUserFavoritesManga(userFavoritesManga.getId());
                                break;
                            }
                        }
                        Toast.makeText(getApplicationContext(), "Removed from Favorite", Toast.LENGTH_SHORT).show();
                    }
                    SplashScreen.allManga.set(x, currentManga);
                }
                else Toast.makeText(DetailManga.this, "Login First!", Toast.LENGTH_SHORT).show();
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
