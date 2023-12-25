package com.example.quizbee1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openAboutDevelopers(View view) {
        startActivity(new Intent(MainActivity.this, MeetDevelopers.class));
    }

    public void openModeSelection(View view) {
        startActivity(new Intent(MainActivity.this, GameModeSelection.class));
    }
}