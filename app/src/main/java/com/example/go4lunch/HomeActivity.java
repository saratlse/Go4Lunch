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
        btnNav.setOnNavigationItemSelectedListener(bottomNavMethod);
        //Initialize fragment
        Fragment fragment = new MapsRestoFragment();

        //Open fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout,fragment)
                .commit();


    }

    //Listener Nav Bar
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()){
                case R.id.map:
                    selectedFragment = new MapsRestoFragment();
                    break;

                case R.id.restaurante:
                    selectedFragment = new ListViewRestoFragment();
                    break;

                case R.id.workmates:
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