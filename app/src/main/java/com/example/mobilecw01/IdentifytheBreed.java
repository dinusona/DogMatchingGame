package com.example.mobilecw01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class IdentifytheBreed extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    final Random rnd = new Random();
    String spinnerResultValue = new String();
    String str = new String();
    String resultValue;
    int round = 0; //mekn thama eka submission ekak witharak karnna dena eka validate karala thiynne
    Button button;
    TextView text;

    private Button btnGenerate;
    private TextView countdownText;
    private Button countdownButton;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliSeconds = 11000; //11 seconds
    private boolean timerRunning;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set layout
        setContentView(R.layout.activity_identifythe_breed);

        countdownText = findViewById(R.id.countdown_text);
        countdownButton = findViewById(R.id.countdown_button);

        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });


        //Create Spinner
        Spinner mySpinner = (Spinner) findViewById(R.id.spinnerofBreedView);

        //Create array adapter
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(IdentifytheBreed.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.breedNames));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        //random image viwer eka
        final ImageView img = (ImageView) findViewById(R.id.breedViewSpace);

        str = "dog_" + rnd.nextInt(150);
        img.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(str, "drawable",
                                getApplicationContext()))
                );


        // Create the spinner.
        Spinner spinner = findViewById(R.id.spinnerofBreedView);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.breedNames, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        //button set eka

        //make link next btn id
        button = findViewById(R.id.btnNext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                round = 0;
                next();
            }
        });

        //make link submit btn id
        button = findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                submit(spinnerResultValue);
//                saveImgName(str);
                if (round == 0) {
                    checkDogName();
                    round++;
                } else {
                    Toast.makeText(getApplicationContext(), "No more submissions!",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
    // ... End of onCreate code ...


//    public Random getRnd() {
//        return rnd;
//    }

    //create method for take result of spinner
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerResult = adapterView.getItemAtPosition(i).toString();
//        displayToast(spinnerResult);
        checkSpinnerResult(spinnerResult);


    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Do nothing.
    }


    protected final int getResourceID(final String resName, final String resType, final Context ctx) {
        final int ResourceID =
                ctx.getResources().getIdentifier(resName, resType,
                        ctx.getApplicationInfo().packageName);
        if (ResourceID == 0) {
            throw new IllegalArgumentException
                    (
                            "No resource string found with name " + resName
                    );
        } else {
            return ResourceID;
        }
    }


    //next button method body
    public void next() {
        //random image viwer eka
        final ImageView img = (ImageView) findViewById(R.id.breedViewSpace);

        // I have 3 images named img_0 to img_2, so...
        str = "dog_" + rnd.nextInt(150);
        img.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(str, "drawable",
                                getApplicationContext()))
                );
        text = findViewById(R.id.textView);
        text.setText("");

        text = findViewById(R.id.txtCorrectAns);
        text.setText("");

    }


//    public void displayToast(String message) {
//        Toast.makeText(getApplicationContext(), message,
//                Toast.LENGTH_SHORT).show();
//    }


    //spinner eke result eka save kara ganna eka
    public void checkSpinnerResult(String spinnerResultValue) {
        resultValue = spinnerResultValue;


//        Toast.makeText(getApplicationContext(), resultValue,
//                Toast.LENGTH_SHORT).show();

    }


    public void saveImgName(String str) {
        String imgName = str;
        Toast.makeText(getApplicationContext(), imgName, Toast.LENGTH_SHORT).show();
    }

    public void checkDogName() {


        String parts[] = str.split("_");

        String imgExtention = parts[1];

        int checkDogNameRange = Integer.parseInt(imgExtention);
//        Toast.makeText(getApplicationContext(), checkDogNameRange,
//                Toast.LENGTH_SHORT).show();


        if (checkDogNameRange >= 0 && checkDogNameRange <= 15) {
            String stBernard = "Saint Bernard";
            if (resultValue.equals(stBernard)) {

                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#1EC137"));
                text.setText("Correct");
                text = findViewById(R.id.txtCorrectAns);
                text.setText("");

//            Toast.makeText(getApplicationContext(), "Correct",
//                    Toast.LENGTH_SHORT).show();
            } else {
//                Toast.makeText(getApplicationContext(), "Wrong",
//                       Toast.LENGTH_SHORT).show();
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#FF0000"));
                text.setText("Wrong");

                text = findViewById(R.id.txtCorrectAns);
                text.setTextColor(Color.parseColor("#1343E7"));
                text.setText("Correct Answer Is Saint Bernard!!!");

            }

//            Toast.makeText(getApplicationContext(), "Correct",
//                    Toast.LENGTH_SHORT).show();
        } else if (checkDogNameRange >= 16 && checkDogNameRange <= 30) {
            String siberian_husky = "Siberian Husky";
            if (resultValue.equals(siberian_husky)) {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#1EC137"));
                text.setText("Correct");
                text = findViewById(R.id.txtCorrectAns);
                text.setText("");
//                Toast.makeText(getApplicationContext(), "Correct",
//                        Toast.LENGTH_SHORT).show();
            } else {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#FF0000"));
                text.setText("Wrong");

                text = findViewById(R.id.txtCorrectAns);
                text.setTextColor(Color.parseColor("#1343E7"));
                text.setText("Correct Answer Is Siberian Husky!!!");
//                Toast.makeText(getApplicationContext(), "Wrong",
//                        Toast.LENGTH_SHORT).show();
            }
//            Toast.makeText(getApplicationContext(), "Siberian_husky",
//                    Toast.LENGTH_SHORT).show();
        } else if (checkDogNameRange >= 31 && checkDogNameRange <= 45) {
            String great_Dane = "Great Dane";
            if (resultValue.equals(great_Dane)) {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#1EC137"));
                text.setText("Correct");
                text = findViewById(R.id.txtCorrectAns);
                text.setText("");
//                Toast.makeText(getApplicationContext(), "Correct",
//                        Toast.LENGTH_SHORT).show();
            } else {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#FF0000"));
                text.setText("Wrong");

                text = findViewById(R.id.txtCorrectAns);
                text.setTextColor(Color.parseColor("#1343E7"));
                text.setText("Correct Answer Is Great Dane!!!");
//                Toast.makeText(getApplicationContext(), "Wrong",
//                        Toast.LENGTH_SHORT).show();
            }
//            Toast.makeText(getApplicationContext(), "Great_Dane",
//                    Toast.LENGTH_SHORT).show();
        } else if (checkDogNameRange >= 46 && checkDogNameRange <= 60) {
            String rottweiler = "Rottweiler";
            if (resultValue.equals(rottweiler)) {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#1EC137"));
                text.setText("Correct");
                text = findViewById(R.id.txtCorrectAns);
                text.setText("");
//                Toast.makeText(getApplicationContext(), "Correct",
//                        Toast.LENGTH_SHORT).show();
            } else {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#FF0000"));
                text.setText("Wrong");

                text = findViewById(R.id.txtCorrectAns);
                text.setTextColor(Color.parseColor("#1343E7"));
                text.setText("Correct Answer Is Rottweiler!!!");
//                Toast.makeText(getApplicationContext(), "Wrong",
//                        Toast.LENGTH_SHORT).show();
            }
//            Toast.makeText(getApplicationContext(), "Rottweiler",
//                    Toast.LENGTH_SHORT).show();
        } else if (checkDogNameRange >= 61 && checkDogNameRange <= 75) {
            String bull_mastiff = "Bull Mastiff";
            if (resultValue.equals(bull_mastiff)) {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#1EC137"));
                text.setText("Correct");
                text = findViewById(R.id.txtCorrectAns);
                text.setText("");
//                Toast.makeText(getApplicationContext(), "Correct",
//                        Toast.LENGTH_SHORT).show();
            } else {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#FF0000"));
                text.setText("Wrong");

                text = findViewById(R.id.txtCorrectAns);
                text.setTextColor(Color.parseColor("#1343E7"));
                text.setText("Correct Answer Is Bull Mastiff!!!");
//                Toast.makeText(getApplicationContext(), "Wrong",
//                        Toast.LENGTH_SHORT).show();
            }
//            Toast.makeText(getApplicationContext(), "bull_mastiff",
//                    Toast.LENGTH_SHORT).show();
        } else if (checkDogNameRange >= 76 && checkDogNameRange <= 90) {
            String Tibetan_mastiff = "Tibetan Mastiff";
            if (resultValue.equals(Tibetan_mastiff)) {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#1EC137"));
                text.setText("Correct");
                text = findViewById(R.id.txtCorrectAns);
                text.setText("");
//                Toast.makeText(getApplicationContext(), "Correct",
//                        Toast.LENGTH_SHORT).show();
            } else {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#FF0000"));
                text.setText("Wrong");

                text = findViewById(R.id.txtCorrectAns);
                text.setTextColor(Color.parseColor("#1343E7"));
                text.setText("Correct Answer Is Tibetan Mastiff!!!");
//                Toast.makeText(getApplicationContext(), "Wrong",
//                        Toast.LENGTH_SHORT).show();
            }
//            Toast.makeText(getApplicationContext(), "Tibetan_mastiff",
//                    Toast.LENGTH_SHORT).show();
        } else if (checkDogNameRange >= 91 && checkDogNameRange <= 105) {
            String pomeranian = "Pomeranian";
            if (resultValue.equals(pomeranian)) {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#1EC137"));
                text.setText("Correct");
                text = findViewById(R.id.txtCorrectAns);
                text.setText("");
//                Toast.makeText(getApplicationContext(), "Correct",
//                        Toast.LENGTH_SHORT).show();
            } else {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#FF0000"));
                text.setText("Wrong");

                text = findViewById(R.id.txtCorrectAns);
                text.setTextColor(Color.parseColor("#1343E7"));
                text.setText("Correct Answer Is Pomeranian!!!");
//                Toast.makeText(getApplicationContext(), "Wrong",
//                        Toast.LENGTH_SHORT).show();
            }
//            Toast.makeText(getApplicationContext(), "Pomeranian",
//                    Toast.LENGTH_SHORT).show();
        } else if (checkDogNameRange >= 106 && checkDogNameRange <= 120) {
            String golden_retriever = "Golden Retriever";
            if (resultValue.equals(golden_retriever)) {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#1EC137"));
                text.setText("Correct");
                text = findViewById(R.id.txtCorrectAns);
                text.setText("");
//                Toast.makeText(getApplicationContext(), "Correct",
//                        Toast.LENGTH_SHORT).show();
            } else {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#FF0000"));
                text.setText("Wrong");

                text = findViewById(R.id.txtCorrectAns);
                text.setTextColor(Color.parseColor("#1343E7"));
                text.setText("Correct Answer Is Golden Retriever!!!");
//                Toast.makeText(getApplicationContext(), "Wrong",
//                        Toast.LENGTH_SHORT).show();
            }
//            Toast.makeText(getApplicationContext(), "golden_retriever",
//                    Toast.LENGTH_SHORT).show();
        } else if (checkDogNameRange >= 121 && checkDogNameRange <= 135) {
            String Kerry_blue_terrier = "Kerry Blue terrier";
            if (resultValue.equals(Kerry_blue_terrier)) {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#1EC137"));
                text.setText("Correct");
                text = findViewById(R.id.txtCorrectAns);
                text.setText("");
//                Toast.makeText(getApplicationContext(), "Correct",
//                        Toast.LENGTH_SHORT).show();
            } else {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#FF0000"));
                text.setText("Wrong");

                text = findViewById(R.id.txtCorrectAns);
                text.setTextColor(Color.parseColor("#1343E7"));
                text.setText("Correct Answer Is Kerry Blue terrier!!!");
//                Toast.makeText(getApplicationContext(), "Wrong",
//                        Toast.LENGTH_SHORT).show();
            }
//            Toast.makeText(getApplicationContext(), "Kerry_blue_terrier",
//                    Toast.LENGTH_SHORT).show();
        } else if (checkDogNameRange >= 136 && checkDogNameRange <= 150) {
            String chow = "Chow Chow";
            if (resultValue.equals(chow)) {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#1EC137"));
                text.setText("Correct");
                text = findViewById(R.id.txtCorrectAns);
                text.setText("");
//                Toast.makeText(getApplicationContext(), "Correct",
//                        Toast.LENGTH_SHORT).show();
            } else {
                text = findViewById(R.id.textView);
                text.setTextColor(Color.parseColor("#FF0000"));
                text.setText("Wrong");

                text = findViewById(R.id.txtCorrectAns);
                text.setTextColor(Color.parseColor("#1343E7"));
                text.setText("Correct Answer Is Chow Chow!!!");
//                Toast.makeText(getApplicationContext(), "Wrong",
//                        Toast.LENGTH_SHORT).show();
            }
//            Toast.makeText(getApplicationContext(), "chow",
//                    Toast.LENGTH_SHORT).show();
        }


    }

    public void checkRound() {
        if (round < 2) {
            checkDogName();
        } else {
            Toast.makeText(getApplicationContext(), "You can submit one attempt only",
                    Toast.LENGTH_SHORT).show();
//            next();
        }

    }

    public void startStop() {
        if (timerRunning) {
        } else {
            startTimer();
        }
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliSeconds, 1000) {  //interval 1 sec
            @Override
            public void onTick(long l) {
                timeLeftInMilliSeconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        timerRunning = true;
    }

    public void updateTimer() {
        int minuits = (int) timeLeftInMilliSeconds / 60000; //divided by 60 sec
        int seconds = (int) timeLeftInMilliSeconds % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + minuits;
        timeLeftText += ":";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;

        countdownText.setText(timeLeftText);
    }


}



