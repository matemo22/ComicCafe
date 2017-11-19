package com.example.matemo.comiccafe;

import android.content.Context;
import android.support.v4.content.ContextCompat;
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

/**
 * Created by Jeffrey Phinardi on 11/6/2017.
 */
public class CustomGrid extends BaseAdapter {
    private Context mContext;
    private final String[] titleB;
    private final String[] authorB;
    private final Integer[] Imageid;

    public CustomGrid(Context c, String[] titleB, String[] authorB, Integer[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.titleB = titleB;
        this.authorB = authorB;
    }

    @Override
    public int getCount() {
        return titleB.length;
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
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_Image);
            ImageView more = grid.findViewById(R.id.grid_More);
            LinearLayout layout = grid.findViewById(R.id.grid_Layout);
            tit.setText(titleB[i]);
            au.setText(authorB[i]);
            imageView.setImageResource(Imageid[i]);

            final View finalGrid = grid;
            more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popupMenu = new PopupMenu(finalGrid.getContext(), view);
                    popupMenu.inflate(R.menu.book_popup_menu);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            int id = item.getItemId();
                            TextView a = finalGrid.findViewById(R.id.grid_Title);
                            if(id==R.id.popUpReadNow)
                            {
                                Toast.makeText(finalGrid.getContext(), "Read Now!"+a.getText().toString(), Toast.LENGTH_SHORT).show();
                            }
                            else if(id==R.id.popUpFavorite)
                            {
                                Toast.makeText(finalGrid.getContext(), "Favorite!"+a.getText().toString(), Toast.LENGTH_SHORT).show();
                            }
                            else if(id==R.id.popUpLike)
                            {
                                Toast.makeText(finalGrid.getContext(), "Like!"+a.getText().toString(), Toast.LENGTH_SHORT).show();
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });
        }
        else
        {
            grid = (View) view;
        }
        return grid;
    }
}

