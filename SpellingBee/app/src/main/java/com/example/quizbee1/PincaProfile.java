package com.example.quizbee1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class PincaProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinca_profile);
    }
    public void backToDevelopersPage(View view) {
        startActivity(new Intent(PincaProfile.this, MeetDevelopers.class));
    }
    public void openDevFb(View view) {
        String dev_fb = getResources().getString(R.string.pinca_fb_link);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(dev_fb);
        intent.setData(uri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void openDebIg(View view) {
        String dev_fb = getResources().getString(R.string.pinca_ig_link);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(dev_fb);
        intent.setData(uri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void openDevTwitter(View view) {
        String dev_fb = getResources().getString(R.string.pinca_twitter_link);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(dev_fb);
        intent.setData(uri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}