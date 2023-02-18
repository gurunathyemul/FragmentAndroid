package com.example.fragmentproject;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BackStackFragments extends AppCompatActivity {
    private static final String TAG = "BackStackFragments";
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        bottomNavigationView = findViewById(R.id.nav);
        Log.d(TAG, "onCreate");
//        bottomNavigationView.setSelectedItemId(R.id.home);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int flag = 0;
                Log.d("NAV", "onNavigationItemSelected");

                int id = item.getItemId();
                String s = String.valueOf(id);
                if (id == R.id.contacts) {
                    Log.d(TAG, "contacts");
                    loadFrag(new ContactsFragment(), 1);
                    return true;
                } else if (id == R.id.history) {
                    Log.d(TAG, "history");
                    loadFrag(new historyFragment(), 1);
                    return true;


                } else if (id == R.id.chat) {
                    Log.d(TAG, "chat");
                    loadFrag(new ChatFragment(), 1);
                    return true;

                } else {
                    Log.d(TAG, "home");
                    loadFrag(new HomeFragment(), 0);
                }
                return true;

            }
        });
    }


    public void loadFrag(Fragment fragment, int flag) {
        Log.d(TAG, "loadFrag");
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag == 0)
            ft.add(R.id.frameContainers, fragment);

        else
            ft.replace(R.id.frameContainers, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed");
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            String fragmentTag = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
            Fragment fragment = fragmentManager.findFragmentByTag(fragmentTag);

    }
        super.onBackPressed();
    }}


