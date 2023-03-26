package com.fyp.sehatyaab;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.fyp.sehatyaab.databinding.ActivityMainBinding;
import com.fyp.sehatyaab.scan.ScanActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_pharmacy)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        FloatingActionButton btnscan = findViewById(R.id.btn_scan);
        btnscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScanActivity();
            }
        });

        CardView btnmedicines = findViewById(R.id.medicines);
        btnmedicines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMedicinesActivity();
            }
        });

        CardView btnhomeremedies = findViewById(R.id.home_remedies);
        btnhomeremedies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeRemediesActivity();
            }
        });

        CardView btntherapies = findViewById(R.id.therapies);
        btntherapies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTherapiesActivity();
            }
        });

        CardView btnAlarm = findViewById(R.id.alarm);
        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlarmActivity();
            }
        });
    }

    public void openScanActivity() {
        Intent scan = new Intent(this, ScanActivity.class);
        startActivity(scan);
    }

    public void openHomeRemediesActivity() {
        Intent homeremedies = new Intent(this, remediessymptoms.class);
        startActivity(homeremedies);
    }

    public void openMedicinesActivity() {
        Intent medicines = new Intent(this, Medicines.class);
        startActivity(medicines);
    }

    public void openTherapiesActivity() {
        Intent therapies = new Intent(this, therapiessymptoms.class);
        startActivity(therapies);
    }

    public void openAlarmActivity() {
        Intent Alarm = new Intent(this, Alarm.class);
        startActivity(Alarm);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // adding a click listener for option selected on below line.
        int id = item.getItemId();
        switch (id) {
            case R.id.idLogOut:
                // displaying a toast message on user logged out inside on click.
                Toast.makeText(getApplicationContext(), "User Logged Out", Toast.LENGTH_LONG).show();
                // on below line we are signing out our user.
                mAuth.signOut();
                // on below line we are opening our login activity.
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // on below line we are inflating our menu
        // file for displaying our menu options.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


}
