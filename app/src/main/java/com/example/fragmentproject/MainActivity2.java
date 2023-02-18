package com.example.fragmentproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity2 extends AppCompatActivity {
    Button btnFrag1, btnFrag2, btnFrag3;
    private static final String TAG = "Main Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnFrag1 = findViewById(R.id.b1);
        btnFrag2 = findViewById(R.id.b2);
        btnFrag3 = findViewById(R.id.b3);
        btnFrag1.setOnClickListener(v -> {
            loadFrag(new ChatFragment());

        });

        btnFrag2.setOnClickListener(v -> {
            loadFrag(new ContactsFragment());
        });


        btnFrag3.setOnClickListener(v -> {
            loadFrag(new historyFragment());
        });


    }

    public void loadFrag(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frameContainer, fragment);
        ft.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "STOP");

    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "Destroy");
        super.onDestroy();
    }
}