package com.example.dfl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class SecondActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        NavController navController = Navigation.findNavController(findViewById(R.id.fragmentContainerView));
        int currentFragmentId = navController.getCurrentDestination().getId();
        if (item.getItemId() == R.id.videoNav) {
            if (currentFragmentId != R.id.viewVideoFragment) {
                navController.navigate(R.id.viewVideoFragment);
            }
            return true;
        } else if (item.getItemId() == R.id.imageNav) {
            if (currentFragmentId != R.id.imageFragment) {
                navController.navigate(R.id.imageFragment);
            }
            return true;
        } else if (item.getItemId() == R.id.liDarNav) {
            if (currentFragmentId != R.id.liDarFragment) {
                navController.navigate(R.id.liDarFragment);
            }
            return true;
        } else if (item.getItemId() == R.id.radarNav) {
            if (currentFragmentId != R.id.radarFragment) {
                navController.navigate(R.id.radarFragment);
            }
            return true;
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
