package com.iafyp.smartcontrollerfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ElectricityAnalysis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_analysis);

        setTitle("Electricity Analysis");

        ImageView img_add_ee = (ImageView) findViewById(R.id.imageViewURL_Elec);
        FirebaseDatabase databasee = FirebaseDatabase.getInstance();
        DatabaseReference devicees = databasee.getReference("electricity");

        Toast.makeText(ElectricityAnalysis.this, "Please wait until App LOADS the IMAGE", Toast.LENGTH_LONG).show();
        devicees.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String imgLinkee = dataSnapshot.child("graph").getValue(String.class);
                Picasso.get().load(imgLinkee).into(img_add_ee);
//                img_add.setImageBitmap(
//                        getBitmapFromURL(
//                                imgLink
//                        )
//                );
            }
            @Override
            public void onCancelled(DatabaseError error) {}
        });

        Button btn1 = findViewById(R.id.btn_home_elec);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ElectricityAnalysis.this,
                        HomePage.class
                );
                startActivity(intent);
            }
        });
    }
}