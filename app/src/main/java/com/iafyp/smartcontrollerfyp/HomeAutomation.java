package com.iafyp.smartcontrollerfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeAutomation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_automation);

        Button btn1, btn2, btn3;
        btn1 = findViewById(R.id.Device1);
        btn2 = findViewById(R.id.Device2);
        btn3 = findViewById(R.id.HOME);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h = new Intent(
                        HomeAutomation.this,
                        HomePage.class
                );
                startActivity(h);
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("Check1");
//        myRef.setValue("Bye");
        DatabaseReference devices = database.getReference("devices");

        Toast.makeText(HomeAutomation.this, "Please wait Till the Updation of Button Text", Toast.LENGTH_LONG).show();
        devices.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String bulb1 = dataSnapshot.child("bulb1").getValue(String.class);
                String bulb2 = dataSnapshot.child("bulb2").getValue(String.class);

                btn1.setText(bulb1);
                btn2.setText(bulb2);
            }
            @Override
            public void onCancelled(DatabaseError error) {}
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn1.getText().equals("ON")){
                    btn1.setText("OFF");
                    devices.child("bulb1").setValue("OFF");
                    Toast.makeText(HomeAutomation.this, "Firebase Updated...", Toast.LENGTH_SHORT).show();
                }
                else if (btn1.getText().equals("OFF")){
                    btn1.setText("ON");
                    devices.child("bulb1").setValue("ON");
                    Toast.makeText(HomeAutomation.this, "Firebase Updated...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn2.getText().equals("ON")){
                    btn2.setText("OFF");
                    devices.child("bulb2").setValue("OFF");
                    Toast.makeText(HomeAutomation.this, "Firebase Updated...", Toast.LENGTH_SHORT).show();
                }
                else if (btn2.getText().equals("OFF")){
                    btn2.setText("ON");
                    devices.child("bulb2").setValue("ON");
                    Toast.makeText(HomeAutomation.this, "Firebase Updated...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}