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

public class BottomNavActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        bottomNavigationView = findViewById(R.id.nav);
        bottomNavigationView.setSelectedItemId(R.id.contacts);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d("NAV", "onNavigationItemSelected");

                int id = item.getItemId();
                String s = String.valueOf(id);
                if (id == R.id.contacts) {
                    Log.d("NAV", "contacts");
                    loadFrag(new ContactsFragment());
                    return true;
                } else if (id == R.id.history) {
                    Log.d("NAV", "history");
                    loadFrag(new historyFragment());
                    return true;


                } else if (id == R.id.chat) {
                    loadFrag(new ChatFragment());
                    return true;

                } else loadFrag(new HomeFragment());
                return true;
            }
        });
    }


    public void loadFrag(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frameContainers, fragment);
        ft.commit();
    }


}