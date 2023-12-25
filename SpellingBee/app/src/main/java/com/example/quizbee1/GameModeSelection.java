package com.example.quizbee1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GameModeSelection extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String selected_mode = "Enumeration";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode_selection);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.modes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setDropDownVerticalOffset(110);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selected_mode = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void openQuestionOne(View view) {
        if (selected_mode.equals("Enumeration")) {
            startActivity(new Intent(GameModeSelection.this, EnumerationQuestion.class));
        }
        else {
            startActivity(new Intent(GameModeSelection.this, MultichoiceQuestion.class));
        }
    }

    public void backToLandingPage(View view) {
        startActivity(new Intent(GameModeSelection.this, MainActivity.class));
    }
}