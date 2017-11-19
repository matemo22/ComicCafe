package com.example.matemo.comiccafe;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matemo on 11/20/2017.
 */

public class ChapterAdapter extends ArrayAdapter<Chapter>{
    public ChapterAdapter(Context context, ArrayList<Chapter> data)
    {
        super(context, R.layout.list_single, data);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Chapter chapter = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_single, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.listChapterTitle);

        title.setText("Chapter "+chapter.getNum()+" "+chapter.getTitle());
        if(chapter.getStatus()==0) {
            title.setTextColor(Color.parseColor("#000000"));
        }
        else {
            title.setTextColor(Color.parseColor("#FFFFFF"));
        }

        return convertView;
    }
}
