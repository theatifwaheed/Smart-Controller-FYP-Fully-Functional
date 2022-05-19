package com.iafyp.smartcontrollerfyp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Recommendations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);

        setTitle("Recommendations");

        TextView tv1 = findViewById(R.id.tv_b1), tv2 = findViewById(R.id.tv_b2);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("Check1");
//        myRef.setValue("Bye");
        DatabaseReference recom = database.getReference("recommendations");

        Toast.makeText(Recommendations.this, "Please wait Till the Updation of Button Text", Toast.LENGTH_LONG).show();
        recom.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String bulb1 = dataSnapshot.child("bulb1").getValue(String.class);
                String bulb2 = dataSnapshot.child("bulb2").getValue(String.class);

                tv1.setText(bulb1);
                tv2.setText(bulb2);
            }
            @Override
            public void onCancelled(DatabaseError error) {}
        });

        Button btn1 = findViewById(R.id.goBackR);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        Recommendations.this,
                        HomePage.class
                );
                startActivity(intent);
            }
        });

    }
}