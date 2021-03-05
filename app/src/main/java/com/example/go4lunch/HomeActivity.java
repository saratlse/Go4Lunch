package com.example.go4lunch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView btnNav = findViewById(R.id.bottom_navigation);
        btnNav.setOnNavigationItemSelectedListener(navListener);

        //Setting Home Fragment as main fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout, new MapsRestoFragment()).commit();

    }

    //Listener Nav Bar
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.map:
                    selectedFragment = new MapsRestoFragment();
                    break;

                case R.id.list_view_resto:
                    selectedFragment = new ListViewRestoFragment();
                    break;
                    
                case R.id.list_view_workmates:
                    selectedFragment = new WorkmateListViewFragment();
                    break;
            }

            //Begin Transaction
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_layout, selectedFragment).commit();
            return true;
        }
    };
}