package com.example.matemo.comiccafe;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Matemo on 12/1/2017.
 */

public class ChapterImageAdapter extends ArrayAdapter<String> {
    private ArrayList<String> url;

    public ChapterImageAdapter(Context context, ArrayList<String> url) {
        super(context, R.layout.list_images_single, url);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final String url = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_images_single, parent, false);
        }
        final ImageView img = convertView.findViewById(R.id.img_chapter);
        Picasso.with(getContext())
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
//                .error(android.R.drawable.stat_notify_error)
                .networkPolicy(NetworkPolicy.NO_CACHE)//user this for offline support
                .into(img, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        Picasso.with(getContext())
                                .load(url)
                                .placeholder(R.drawable.ic_launcher_background)
//                                .error(android.R.drawable.stat_notify_error)
                                .networkPolicy(NetworkPolicy.NO_CACHE)//user this for offline support
                                .into(img, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError() {
//                                        img.setImageResource(R.drawable.ic_launcher_background);
                                    }
                                });
                    }
                });
        return convertView;
    }
}
