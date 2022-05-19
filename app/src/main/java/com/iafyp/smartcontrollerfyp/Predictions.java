package com.iafyp.smartcontrollerfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Predictions extends AppCompatActivity {
//    Bitmap imageBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predictions);

        setTitle("Predictions");

        ImageView img_add = (ImageView) findViewById(R.id.imageViewURL);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference devices = database.getReference("predictions");

        Toast.makeText(Predictions.this, "Please wait until App LOADS the IMAGE", Toast.LENGTH_LONG).show();
        devices.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String imgLink = dataSnapshot.child("pred").getValue(String.class);
                Picasso.get().load(imgLink).into(img_add);
//                img_add.setImageBitmap(
//                        getBitmapFromURL(
//                                imgLink
//                        )
//                );
            }
            @Override
            public void onCancelled(DatabaseError error) {}
        });

        Button btn1 = findViewById(R.id.btn_home);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        Predictions.this,
                        HomePage.class
                );
                startActivity(intent);
            }
        });

    }

}