package com.example.mobilecw01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.Random;

public class slider extends SearchDogBreeds {

    ViewFlipper view_flipper;
    Random randomNumberForSlider;
    int max, min, output;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);


        String saveEditTextValue = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            saveEditTextValue = extras.getString("Message");


        }
        ///////

        if (saveEditTextValue.equals("saint bernard")) {
//            text.findViewById(R.id.txtDogName);
//            text.setText("Saint");

            int saint_Bernard[] = {R.drawable.dog_0, R.drawable.dog_1, R.drawable.dog_2, R.drawable.dog_3, R.drawable.dog_4, R.drawable.dog_5,
                    R.drawable.dog_6, R.drawable.dog_7, R.drawable.dog_8, R.drawable.dog_9, R.drawable.dog_10, R.drawable.dog_11, R.drawable.dog_12,
                    R.drawable.dog_13, R.drawable.dog_14, R.drawable.dog_15};

            view_flipper = findViewById(R.id.v_flipper);

            for (int image : saint_Bernard) {

                randomNumberForSlider = new Random();
                max = 15;
                min = 0;
                output = randomNumberForSlider.nextInt((max - min) ) + min;

                flipperImages(saint_Bernard[output]);
            }


        } else if (saveEditTextValue.equals("husky")) {
            int siberian_husky[] = {R.drawable.dog_16, R.drawable.dog_17, R.drawable.dog_18, R.drawable.dog_19, R.drawable.dog_20, R.drawable.dog_21,
                    R.drawable.dog_22, R.drawable.dog_23, R.drawable.dog_24, R.drawable.dog_25, R.drawable.dog_26, R.drawable.dog_27, R.drawable.dog_28,
                    R.drawable.dog_29, R.drawable.dog_30};
            view_flipper = findViewById(R.id.v_flipper);
            for (int image : siberian_husky) {

                randomNumberForSlider = new Random();

                min = 0;
                max = 14;
                output = randomNumberForSlider.nextInt((max - min) ) + min;

                flipperImages(siberian_husky[output]);
            }
        } else if (saveEditTextValue.equals("great dane")) {
            int great_Dane[] = {R.drawable.dog_31, R.drawable.dog_32, R.drawable.dog_33, R.drawable.dog_34, R.drawable.dog_35, R.drawable.dog_36,
                    R.drawable.dog_37, R.drawable.dog_38, R.drawable.dog_39, R.drawable.dog_40, R.drawable.dog_41, R.drawable.dog_42, R.drawable.dog_43,
                    R.drawable.dog_44, R.drawable.dog_45};
            view_flipper = findViewById(R.id.v_flipper);
            for (int image : great_Dane) {

                randomNumberForSlider = new Random();

                min = 0;
                max = 14;
                output = randomNumberForSlider.nextInt((max - min)) + min;
                flipperImages(great_Dane[output]);
            }
        } else if (saveEditTextValue.equals("rottweiler")) {
            int rottweiler[] = {R.drawable.dog_46, R.drawable.dog_47, R.drawable.dog_48, R.drawable.dog_49, R.drawable.dog_50, R.drawable.dog_51,
                    R.drawable.dog_52, R.drawable.dog_53, R.drawable.dog_54, R.drawable.dog_55, R.drawable.dog_56, R.drawable.dog_57, R.drawable.dog_58,
                    R.drawable.dog_59, R.drawable.dog_60};
            view_flipper = findViewById(R.id.v_flipper);
            for (int image : rottweiler) {
                randomNumberForSlider = new Random();

                min = 0;
                max = 14;
                output = randomNumberForSlider.nextInt((max - min) ) + min;

                flipperImages(rottweiler[output]);
            }
        } else if (saveEditTextValue.equals("bull mastiff")) {
            int bull_mastiff[] = {R.drawable.dog_61, R.drawable.dog_62, R.drawable.dog_63, R.drawable.dog_64, R.drawable.dog_65, R.drawable.dog_66,
                    R.drawable.dog_67, R.drawable.dog_68, R.drawable.dog_69, R.drawable.dog_70, R.drawable.dog_71, R.drawable.dog_72, R.drawable.dog_73,
                    R.drawable.dog_74, R.drawable.dog_75};
            view_flipper = findViewById(R.id.v_flipper);
            for (int image : bull_mastiff) {
                randomNumberForSlider = new Random();

                min = 0;
                max = 14;
                output = randomNumberForSlider.nextInt((max - min)) + min;

                flipperImages(bull_mastiff[output]);
            }
        } else if (saveEditTextValue.equals("tibetan mastiff")) {
            int Tibetan_mastiff[] = {R.drawable.dog_76, R.drawable.dog_77, R.drawable.dog_78, R.drawable.dog_79, R.drawable.dog_80, R.drawable.dog_81,
                    R.drawable.dog_82, R.drawable.dog_83, R.drawable.dog_84, R.drawable.dog_85, R.drawable.dog_86, R.drawable.dog_87, R.drawable.dog_88,
                    R.drawable.dog_89, R.drawable.dog_90};
            view_flipper = findViewById(R.id.v_flipper);
            for (int image : Tibetan_mastiff) {
                randomNumberForSlider = new Random();

                min = 0;
                max = 14;
                output = randomNumberForSlider.nextInt((max - min) ) + min;

                flipperImages(Tibetan_mastiff[output]);
            }
        } else if (saveEditTextValue.equals("pomeranian")) {
            int pomeranian[] = {R.drawable.dog_91, R.drawable.dog_92, R.drawable.dog_93, R.drawable.dog_94, R.drawable.dog_95, R.drawable.dog_96,
                    R.drawable.dog_97, R.drawable.dog_98, R.drawable.dog_99, R.drawable.dog_100, R.drawable.dog_101, R.drawable.dog_102, R.drawable.dog_103,
                    R.drawable.dog_104, R.drawable.dog_105};
            view_flipper = findViewById(R.id.v_flipper);
            for (int image : pomeranian) {
                randomNumberForSlider = new Random();

                min = 0;
                max = 14;
                output = randomNumberForSlider.nextInt((max - min) ) + min;

                flipperImages(pomeranian[output]);
            }
        } else if (saveEditTextValue.equals("golden retriever")) {
            int golden_retriever[] = {R.drawable.dog_106, R.drawable.dog_107, R.drawable.dog_108, R.drawable.dog_109, R.drawable.dog_110, R.drawable.dog_111,
                    R.drawable.dog_112, R.drawable.dog_113, R.drawable.dog_114, R.drawable.dog_115, R.drawable.dog_116, R.drawable.dog_117, R.drawable.dog_118,
                    R.drawable.dog_119, R.drawable.dog_120};

            view_flipper = findViewById(R.id.v_flipper);
            for (int image : golden_retriever) {
                randomNumberForSlider = new Random();

                min = 0;
                max = 14;
                output = randomNumberForSlider.nextInt((max - min) ) + min;

                flipperImages(golden_retriever[output]);
            }
        } else if (saveEditTextValue.equals("Kerry blue terrier")) {
            int Kerry_blue_terrier[] = {R.drawable.dog_121, R.drawable.dog_122, R.drawable.dog_123, R.drawable.dog_124, R.drawable.dog_125, R.drawable.dog_126,
                    R.drawable.dog_127, R.drawable.dog_128, R.drawable.dog_129, R.drawable.dog_130, R.drawable.dog_131, R.drawable.dog_132, R.drawable.dog_133,
                    R.drawable.dog_134, R.drawable.dog_135};
            view_flipper = findViewById(R.id.v_flipper);
            for (int image : Kerry_blue_terrier) {
                randomNumberForSlider = new Random();

                min = 0;
                max = 14;
                output = randomNumberForSlider.nextInt((max - min) ) + min;

                flipperImages(Kerry_blue_terrier[output]);
            }
        } else if (saveEditTextValue.equals("chow")) {
            int chow[] = {R.drawable.dog_136, R.drawable.dog_137, R.drawable.dog_138, R.drawable.dog_139, R.drawable.dog_140, R.drawable.dog_141,
                    R.drawable.dog_142, R.drawable.dog_143, R.drawable.dog_144, R.drawable.dog_145, R.drawable.dog_146, R.drawable.dog_147, R.drawable.dog_148,
                    R.drawable.dog_149, R.drawable.dog_150};
            view_flipper = findViewById(R.id.v_flipper);
            for (int image : chow) {

                randomNumberForSlider = new Random();

                min = 0;
                max = 14;
                output = randomNumberForSlider.nextInt((max - min) ) + min;

                flipperImages(chow[output]);
            }
        } else {
            Toast.makeText(getApplicationContext(), "This breed not Found",
                    Toast.LENGTH_SHORT).show();
        }


    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        view_flipper.addView(imageView);
        view_flipper.setFlipInterval(5000);//5 sec
        view_flipper.setAutoStart(true);

        //animation
        view_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        view_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
