package com.example.matemo.comiccafe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChapterImages extends AppCompatActivity {
    ArrayList<String> url = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_images);

        Chapter currentChapter = (Chapter) getIntent().getSerializableExtra("chapter_has_images");
        url = currentChapter.getUrlImg();

        ListView listViewImages = findViewById(R.id.listViewImages);
        ChapterImageAdapter adapter = new ChapterImageAdapter(this, url);
        listViewImages.setAdapter(adapter);

        listViewImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(ChapterImages.this, url.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
