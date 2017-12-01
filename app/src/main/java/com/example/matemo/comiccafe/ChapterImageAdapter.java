package com.example.matemo.comiccafe;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

public class ChapterImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> url;

    public ChapterImageAdapter(Context c, ArrayList<String> url) {
        mContext = c;
        this.url = url;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null)
        {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.list_images_single, null);
            final ImageView img_chapter = grid.findViewById(R.id.img_chapter);
            final View finalGrid1 = grid;
            Picasso.with(grid.getContext())
                    .load(url.get(i))
                    .placeholder(R.drawable.ic_launcher_background)
                    .networkPolicy(NetworkPolicy.NO_CACHE)//user this for offline support
                    .into(img_chapter, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {
                            Picasso.with(finalGrid1.getContext())
                                    .load(url.get(i))
                                    .placeholder(R.drawable.ic_launcher_background)
                                    .networkPolicy(NetworkPolicy.NO_CACHE)//user this for offline support
                                    .into(img_chapter, new Callback() {
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
//            imageView.setImageResource(mangas.get(i).getImg_cover());
        }
        else
        {
            grid = (View) view;
        }
        return grid;
    }
}
