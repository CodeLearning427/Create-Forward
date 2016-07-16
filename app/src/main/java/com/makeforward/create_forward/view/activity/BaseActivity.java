package com.makeforward.create_forward.view.activity;

import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import patrickwoodburn.com.kidsreader.R;

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.outershell)
    DrawerLayout drawerLayout;

    @BindView(R.id.content_area)
    FrameLayout content;

    @BindView(R.id.left_drawer)
    ListView navList;

    ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set up butternife and base activity.
        setContentView(R.layout.base_activity);
        ButterKnife.bind(this);

        //set up title
        setTitle(provideHeaderTitle());

        //set up content
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(getContentId(), content);

        // set up the slidding drawer
        navList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item,
                getNaveList().toArray(new String[getNaveList().size()])));
        navList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("pat", i+"");
            }
        });
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, 0, 0);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    abstract String provideHeaderTitle();
    abstract int getContentId();

    public List<String> getNaveList() {
        List<String> out = new ArrayList<>();
        out.add("profile");
        out.add("My stories");
        out.add("new stories");
        return out;
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
            return false;
        }
        return super.onOptionsItemSelected(item);
    }



    // this may be up to the abstract class to overive, no menue by default?
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.appbar, menu);
        return true;
    }*/

}
