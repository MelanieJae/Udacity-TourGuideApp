package com.example.melanieh.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_rest) {
            Intent openRests = new Intent(this, RestsActivity.class);
            if (openRests.resolveActivity(getPackageManager()) != null) {
                startActivity(openRests);
            }
        } else if (id == R.id.nav_edu) {
            Intent openRests = new Intent(this, EduActivity.class);
            if (openRests.resolveActivity(getPackageManager()) != null) {
                startActivity(openRests);
            }
        } else if (id == R.id.nav_outdoor) {
            Intent openRests = new Intent(this, OutdoorActivity.class);
            if (openRests.resolveActivity(getPackageManager()) != null) {
                startActivity(openRests);
            }
        } else if (id == R.id.nav_wine) {
            Intent openRests = new Intent(this, WineActivity.class);
            if (openRests.resolveActivity(getPackageManager()) != null) {
                startActivity(openRests);
            }
        } else if (id == R.id.nav_shops) {
            Intent openRests = new Intent(this, ShopsActivity.class);
            if (openRests.resolveActivity(getPackageManager()) != null) {
                startActivity(openRests);
            }
        } else {
            Intent openRests = new Intent(this, CafesActivity.class);
            if (openRests.resolveActivity(getPackageManager()) != null) {
                startActivity(openRests);
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
