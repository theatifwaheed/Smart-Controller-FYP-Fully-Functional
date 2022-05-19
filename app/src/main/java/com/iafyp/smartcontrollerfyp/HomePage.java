package com.iafyp.smartcontrollerfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button btnH, btnP, btnR, btnA;
        btnH = findViewById(R.id.btn_automation);
        btnP = findViewById(R.id.btn_prediction);
        btnR = findViewById(R.id.btn_recommendation);
        btnA = findViewById(R.id.btn_about);

        btnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openH = new Intent(
                        HomePage.this, HomeAutomation.class
                );
                startActivity(openH);
            }
        });

        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openP = new Intent(
                        HomePage.this, Predictions.class
                );
                startActivity(openP);
            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openR = new Intent(
                        HomePage.this, Recommendations.class
                );
                startActivity(openR);
            }
        });

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openA = new Intent(
                        HomePage.this, AboutApp.class
                );
                startActivity(openA);
            }
        });
        Button elect = findViewById(R.id.btn_elect);
        elect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(
                        HomePage.this, ElectricityAnalysis.class
                );
                startActivity(n);
            }
        });
    }
}