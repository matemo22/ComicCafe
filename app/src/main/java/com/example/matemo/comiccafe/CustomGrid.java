package com.example.matemo.comiccafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jeffrey Phinardi on 11/6/2017.
 */
public class CustomGrid extends BaseAdapter {
    private Context mContext;
    private final String[] titleB;
    private final String[] authorB;
    private final int[] Imageid;

    public CustomGrid(Context c,String[] titleB,String[] authorB,int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.titleB = titleB;
        this.authorB = authorB;
    }

    @Override
    public int getCount() {
        return titleB.length;
    }

    public int getCount2() {
        return authorB.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null)
        {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView tit = (TextView) grid.findViewById(R.id.grid_Title);
            TextView au = (TextView) grid.findViewById(R.id.grid_Author);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            tit.setText(titleB[i]);
            au.setText(authorB[i]);
            imageView.setImageResource(Imageid[i]);
        }
        else
        {
            grid = (View) view;
        }
        return grid;
    }
}

