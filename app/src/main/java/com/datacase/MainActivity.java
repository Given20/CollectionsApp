package com.datacase;

import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {

    //FragmentManager fragmentManager;
    //FragmentTransaction transaction;
    BottomNavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.btmNavBar);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.library:
                        OpenLibraryFragment();
                        break;
                    case R.id.feed:
                        OpenFeedFragment();
                        break;
                    case R.id.search:
                        OpenSearchFragment();
                        break;
                }
                    return true;
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.itmSettings:
                        IntentHelper.openIntent(MainActivity.this, SettingsActivity.class);
                        return true;
                }
                return false;
            }
        });

    }



    private void OpenFeedFragment() {
        toolbar.setTitle("Feed");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.fragment, FeedFragment.class, null).commit();
    }

    private void OpenLibraryFragment() {
        toolbar.setTitle("Library");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.fragment, LibraryFragment.class, null).commit();
    }

    private void OpenSearchFragment() {
        toolbar.setTitle("Search");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.fragment, SearchFragment.class, null).commit();
    }

}