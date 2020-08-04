package com.example.mobilecw01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set connections form the buttons
        button = findViewById(R.id.btnIdentifyBreed);

        //create event listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create intent IdentifytheBreed
                Intent i = new Intent(getApplicationContext(), IdentifytheBreed.class);
                //launch the
                startActivity(i);
            }
        });

        //set connections form the buttons
        button = findViewById(R.id.btnIdentifyDog);

        //create event listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create intent
                Intent j = new Intent(getApplicationContext(), IdentifytheDog.class);
                //launch the IdentifytheDog
                startActivity(j);
            }
        });

        //set connections form the buttons
        button = findViewById(R.id.btnSearchDogBreed);

        //create event listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create intent
                Intent i = new Intent(getApplicationContext(), SearchDogBreeds.class);
                //launch the SearchDogBreeds
                startActivity(i);
            }
        });

    }
}
