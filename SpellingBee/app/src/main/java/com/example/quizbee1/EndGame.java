package com.example.quizbee1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        TextView score = findViewById(R.id.score);

        Intent intent = getIntent();
        String correct_answers = intent.getStringExtra("correct_answers");
        score.setText("\n  "+correct_answers+"/5");



    }

    public void backToGameMode(View view) {
        startActivity(new Intent(EndGame.this, GameModeSelection.class));
    }

    public void backToLandingPage(View view) {
        startActivity(new Intent(EndGame.this, MainActivity.class));
    }
}