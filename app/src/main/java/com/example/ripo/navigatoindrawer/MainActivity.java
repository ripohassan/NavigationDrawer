package com.example.ripo.navigatoindrawer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // initToolbar();
        setToolBarTittle("Tv App");
        mToolbar = findViewById(R.id.toolbar);
        mDrawerLayout = findViewById(R.id.nav_Drawer);
        mNavigationView = findViewById(R.id.nv_View);
        mNavigationView.setNavigationItemSelectedListener(this);
        mNavigationView.setItemIconTintList(null);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        toggle.syncState();
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    public void setToolBarTittle(String toolBarTitle) {
        TextView toolTitle = findViewById(R.id.toolbar_title);
        toolTitle.setText(toolBarTitle);

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();

        if (id == R.id.nav_home){

            mDrawerLayout.closeDrawer(GravityCompat.START);

        }else if(id == R.id.nav_channel_list){

            Intent intent = new Intent(MainActivity.this,ChannelListActivity.class);
            startActivity(intent);
            mDrawerLayout.closeDrawer(GravityCompat.START);

        }else if(id == R.id.nav_share){

            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else if(id == R.id.nav_about) {
            mDrawerLayout.closeDrawer(GravityCompat.START);

        }else if (mDrawerLayout != null && mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }

        return true;
    }
}
