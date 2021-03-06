package com.example.go4lunch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        FirebaseAuth.getInstance().signOut();

        mAuth = FirebaseAuth.getInstance();


        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();


        //if the user is not authenticated, send him to SignInActivity to authenticate first
        //else send him to the dashboard
        if (currentUser != null){
            Intent menuIntent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(menuIntent);
            finish();

        }else {
            Intent signIntent = new Intent(MainActivity.this, AuthLoginActivity.class);
            startActivity(signIntent);
            finish();
        }
    }

}

