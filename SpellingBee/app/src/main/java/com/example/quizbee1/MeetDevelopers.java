package com.example.quizbee1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MeetDevelopers extends AppCompatActivity {

    EditText email_field;
    EditText phone_number_field;
    EditText message_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet_developers);


    }

    public void openDevProfile(View view) {
        String clicked_image_id = getResources().getResourceEntryName(view.getId());

        if (clicked_image_id.equals("pinca_image")) {
            startActivity(new Intent(MeetDevelopers.this, PincaProfile.class));
        }
        else if (clicked_image_id.equals("pile_image")) {
            startActivity(new Intent(MeetDevelopers.this, PileProfile.class));
        }
        else {
            startActivity(new Intent(MeetDevelopers.this, EspinaProfile.class));
        }

    }

    public void backToHomePage(View view) {
        startActivity(new Intent(MeetDevelopers.this, MainActivity.class));
    }

    public void sendMessage(View view) {
        email_field = findViewById(R.id.email_field);
        phone_number_field = findViewById(R.id.phone_number_field);
        message_field = findViewById(R.id.message_field);

        if (!message_field.getText().toString().isEmpty()) {
            email_field.setText("");
            phone_number_field.setText("");
            message_field.setText("");

            Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Message is required", Toast.LENGTH_SHORT).show();
        }



    }
}