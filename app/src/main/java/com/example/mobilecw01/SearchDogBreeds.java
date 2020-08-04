package com.example.mobilecw01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SearchDogBreeds extends AppCompatActivity {

    Button button;
    EditText editTextResult;
    protected String editTextValue;
    private EditText mmmMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_dog_breeds);
        mmmMessage =findViewById(R.id.editTextSearch);


        //search button links
        button = findViewById(R.id.btnSearch);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextValue=mmmMessage.getText().toString();
                Intent a = new Intent(SearchDogBreeds.this, slider.class);

                //like a hashMap
                a.putExtra("Message",editTextValue);
                startActivity(a);

            }
        });




    }


}
