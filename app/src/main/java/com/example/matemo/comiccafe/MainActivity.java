package com.example.matemo.comiccafe;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{
    //defining widgets
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    Fragment fragment=null;
    FragmentTransaction fragmentTransaction=null;
    ImageView toolbar_search;
    public User currentUser;
    DataBaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHandler = new DataBaseHandler(this);

        //initialising the widgets
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        navigationView=(NavigationView)findViewById(R.id.navigationview);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        toolbar_search = findViewById(R.id.toolbar_search);
//        allManga = createTempManga();

//        if(dbHandler.getAllGenre().size()!=0)
//            Toast.makeText(this, dbHandler.getAllManga().get(0).getTag().get(0), Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show();

        initHeader(navigationView.getHeaderView(0));
        //setting the toolbar as actionbar
        setSupportActionBar(toolbar);

        //setting background color of toolbar
//        toolbar.setBackgroundColor(Color.parseColor("#0081c9"));

        toolbar_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //To Search Layout
                Toast.makeText(getApplicationContext(), "Search Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //handling click of Navigation View items
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if(menuItem.isChecked())
                    menuItem.setChecked(false);
                else
                    menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return displayFragment(menuItem.getItemId());
            }
        });

        //creating ActionBarDrawerToggle
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.draweropened,R.string.drawerclosed)
        {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        //binding ActionBarDrawerToggle to DrawerLayout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is compulsory to avoid unusual behaviour as home button wont show up
        actionBarDrawerToggle.syncState();

        //showing Fragment for FirstTime
        if(savedInstanceState==null)
        {
            displayFragment(R.id.allmanga);
        }
    }

    public void initHeader(View view)
    {
        TextView userEmail;
        ImageView profileImage, ic_setting, ic_notification;

        userEmail = view.findViewById(R.id.userEmail);
        profileImage = view.findViewById(R.id.profileImage);
        ic_setting = view.findViewById(R.id.ic_setting);
        ic_notification = view.findViewById(R.id.ic_notification);

        if(currentUser!=null)
        {
            profileImage.setImageResource(currentUser.getProfileImage());
            userEmail.setText(currentUser.getUserEmail());
        }

        userEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentUser==null) {
                    Intent loginIntent = new Intent(MainActivity.this, LoginScreen.class);
                    startActivity(loginIntent);
                }
                else
                {
                    //Go To Profile Page
                    Toast.makeText(getApplicationContext(), "Email Clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentUser==null)
                {
                    Intent loginIntent = new Intent(MainActivity.this, LoginScreen.class);
                    startActivity(loginIntent);
                }
                else
                {
                    //Go To Profile Page
                    Toast.makeText(getApplicationContext(), "Profile Clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ic_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Setting Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        ic_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Notification Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean displayFragment(int id)
    {
        switch (id)
        {
            case R.id.allmanga:
//                Toast.makeText(getApplicationContext(), "Sent Selected", Toast.LENGTH_SHORT).show();.
                fragment= (Fragment) new AllManga();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.favorites:
                fragment= (Fragment) new Favorites();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.discover:
                fragment= (Fragment) new Discover();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.aboutus:
                fragment= (Fragment) new AboutUs();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.commit();
                return true;

        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //   getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Toast.makeText(getApplicationContext(), String.valueOf(id), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
