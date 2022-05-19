package com.iafyp.smartcontrollerfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        setTitle("About Us");

        Intent goHome = new Intent(AboutApp.this, HomePage.class);
        TextView btn = findViewById(R.id.goBack);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(goHome);
            }
        });
    }
}