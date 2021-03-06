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

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Jeffrey Phinardi on 11/6/2017.
 */
public class CustomGrid extends BaseAdapter {
    private Context mContext;
    private ArrayList<Manga> mangas;

    public CustomGrid(Context c, ArrayList<Manga> mangas) {
        mContext = c;
        this.mangas = mangas;
    }

    @Override
    public int getCount() {
        return mangas.size();
    }

    @Override
    public Object getItem(int i) {
        return mangas.get(i);
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
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView title = (TextView) grid.findViewById(R.id.grid_Title);
            TextView author = (TextView) grid.findViewById(R.id.grid_Author);
            final ImageView imageView = (ImageView) grid.findViewById(R.id.grid_Image);
            ImageView more = grid.findViewById(R.id.grid_More);
            LinearLayout layout = grid.findViewById(R.id.grid_Layout);
            title.setText(mangas.get(i).getTitle());
            author.setText(mangas.get(i).getAuthor());
            final View finalGrid1 = grid;
            Picasso.with(grid.getContext())
                    .load(mangas.get(i).getImg_cover())
                    .placeholder(R.drawable.ic_launcher_background)
                    .networkPolicy(NetworkPolicy.NO_CACHE)//user this for offline support
                    .into(imageView, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {
                            Picasso.with(finalGrid1.getContext())
                                    .load(mangas.get(i).getImg_cover())
                                    .placeholder(R.drawable.ic_launcher_background)
                                    .networkPolicy(NetworkPolicy.NO_CACHE)//user this for offline support
                                    .into(imageView, new Callback() {
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
//                                Toast.makeText(finalGrid.getContext(), "Read Now!"+a.getText().toString(), Toast.LENGTH_SHORT).show();
                                Toast.makeText(finalGrid.getContext(), mangas.get(i).getImg_cover(), Toast.LENGTH_SHORT).show();
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

