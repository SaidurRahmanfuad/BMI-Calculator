package com.example.bmicalculator;

import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bmicalculator.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    float height, weight;
    float Total_heightinInch, Total_heightinMeter,Total_heightinCm,minVal,maxVal;
    int gender;
    boolean is_UnderWeight=false;
    boolean is_Overweight=false;


    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());


        binding.cardNormal.setCardElevation(8f);
        binding.cardNormal.setOutlineAmbientShadowColor(getResources().getColor(R.color.red));
        binding.cardNormal.setOutlineSpotShadowColor(getResources().getColor(R.color.red));
        binding.calculate.setOnClickListener(v -> {
            weight = Float.parseFloat(binding.etWeight.getText().toString());
            float heightFeetin_cm = Float.parseFloat(binding.etHeight.getText().toString()) * 30.48f;
            float et_inch;
            if (binding.etInch.getText().toString().isEmpty()) {
                et_inch = 0;
            } else {
                et_inch = Float.parseFloat(binding.etInch.getText().toString());
            }
            float heightInchin_cm = et_inch * 2.54f;
             Total_heightinCm = heightFeetin_cm + heightInchin_cm;

            Total_heightinMeter = Total_heightinCm / 100;
            Total_heightinInch = Total_heightinCm * 2.54f;
            float BMI = weight / (Total_heightinMeter * Total_heightinMeter);
            binding.bmiresult.setText(String.valueOf(String.format("%.2f", BMI)));
            float diff = 72.3f - Float.parseFloat(binding.etWeight.getText().toString());

            checkingRange(BMI, diff);


            switch (gender)
            {
                case 1:
                    //Male
                    switch (Math.round(Total_heightinCm))
                    {
                        case 137:
                            binding.normalGender.setText("28.5 - 34.9 kg");
                            setMinMax(28.5f,34.9f);
                            break;
                        case 140:
                            binding.normalGender.setText("30.8 - 38.1 kg");
                            setMinMax(30.8f,38.1f);
                            break;
                        case 142:
                            binding.normalGender.setText("33.5 - 40.8 kg");
                            setMinMax(33.5f,40.8f);
                            break;
                        case 145:
                            binding.normalGender.setText("35.8 - 43.9 kg");
                            setMinMax(35.8f,43.9f);
                            break;
                        case 147:
                            binding.normalGender.setText("38.5 - 46.7 kg");
                            setMinMax(38.5f,46.7f);
                            break;
                        case 150:
                            binding.normalGender.setText("40.8 - 49.9 kg");
                            setMinMax(40.8f,49.9f);
                            break;
                        case 152:
                            binding.normalGender.setText("43.1 - 53 kg");
                            setMinMax(43.1f,53f);
                            break;
                        case 155:
                            binding.normalGender.setText("45.8 - 55.8 kg");
                            setMinMax(45.8f,55.8f);
                            break;
                        case 157:
                            binding.normalGender.setText("48.1 - 58.9 kg");
                            setMinMax(48.1f,58.9f);
                            break;
                        case 160:
                            binding.normalGender.setText("50.8 - 61.6 kg");
                            setMinMax(50.8f,61.6f);
                            break;
                        case 165:
                            binding.normalGender.setText("55.3 - 68 kg");
                            setMinMax(55.3f,68f);
                            break;

                        case 168:
                            binding.normalGender.setText("58 - 70.7 kg");
                            setMinMax(58f,70.7f);
                            break;
                        case 170:
                            binding.normalGender.setText("60.3 - 73.9 kg");
                            setMinMax(60.3f,73.9f);
                            break;
                        case 173:
                            binding.normalGender.setText("63 - 76.6 kg");
                            setMinMax(63f,76.6f);
                            break;

                        case 175:
                            binding.normalGender.setText("65.3 - 79.8 kg");
                            setMinMax(65.3f,79.8f);
                            break;
                        case 178:
                            binding.normalGender.setText("67.6 - 83 kg");
                            setMinMax(67.6f,83f);
                            break;
                        case 180:
                            binding.normalGender.setText("70.3 - 85.7 kg");
                            setMinMax(70.3f,85.7f);
                            break;
                        case 183:
                            binding.normalGender.setText("72.6 - 88.9 kg");
                            setMinMax(72.6f,88.9f);
                            break;
                        case 185:
                            binding.normalGender.setText("75.3 - 91.6 kg");
                            setMinMax(75.3f,91.6f);
                            break;
                        case 188:
                            binding.normalGender.setText("77.5 - 94.8 kg");
                            setMinMax(77.5f,94.8f);
                            break;
                        case 191:
                            binding.normalGender.setText("89.8 - 98 kg");
                            setMinMax(89.8f,98f);
                            break;
                        case 193:
                            binding.normalGender.setText("82.5 - 100.6 kg");
                            setMinMax(82.5f,100.6f);
                            break;
                        case 195:
                            binding.normalGender.setText("84.8 - 103.8 kg");
                            setMinMax(84.8f,103.8f);
                            break;
                    }
                    break;
                case 0:
                    switch (Math.round(Total_heightinCm))
                    {
                        case 137:
                            binding.normalGender.setText("28.5 - 34.9 kg");
                            setMinMax(28.5f,34.9f);
                            break;
                        case 140:
                            binding.normalGender.setText("30.8 - 37.6 kg");
                            setMinMax(30.8f,37.6f);
                            break;
                        case 142:
                            binding.normalGender.setText("32.5 - 40.8 kg");
                            setMinMax(32.5f,40.8f);
                            break;
                        case 145:
                            binding.normalGender.setText("35.8 - 42.9 kg");
                            setMinMax(35.8f,42.9f);
                            break;
                        case 147:
                            binding.normalGender.setText("37.5 - 46.7 kg");
                            setMinMax(37.5f,37.5f);
                            break;
                        case 150:
                            binding.normalGender.setText("40.8 - 48.9 kg");
                            setMinMax(40.8f,48.9f);
                            break;
                        case 152:
                            binding.normalGender.setText("42.1 - 53 kg");
                            setMinMax(42.1f,53f);
                            break;
                        case 155:
                            binding.normalGender.setText("45.8 - 56.8 kg");
                            setMinMax(45.8f,56.8f);
                            break;
                        case 157:
                            binding.normalGender.setText("47.1 - 58.9 kg");
                            setMinMax(47.1f,58.9f);
                            break;
                        case 160:
                            binding.normalGender.setText("50.8 - 62.6 kg");
                            setMinMax(50.8f,62.6f);
                            break;
                        case 165:
                            binding.normalGender.setText("53.3 - 68 kg");
                            setMinMax(53.3f,68f);
                            break;

                        case 168:
                            binding.normalGender.setText("58 - 71.7 kg");
                            setMinMax(58f,71.7f);
                            break;
                        case 170:
                            binding.normalGender.setText("60.5 - 73.9 kg");
                            setMinMax(60.5f,73.9f);
                            break;
                        case 173:
                            binding.normalGender.setText("63 - 77.6 kg");
                            setMinMax(63f,77.6f);
                            break;

                        case 175:
                            binding.normalGender.setText("65.8 - 79.8 kg");
                            setMinMax(65.8f,79.8f);
                            break;
                        case 178:
                            binding.normalGender.setText("67.9 - 82 kg");
                            setMinMax(67.9f,82f);
                            break;
                        case 180:
                            binding.normalGender.setText("69.3 - 85.7 kg");
                            setMinMax(69.3f,85.7f);
                            break;
                        case 183:
                            binding.normalGender.setText("72.6 - 86.9 kg");
                            setMinMax(72.6f,86.9f);
                            break;
                        case 185:
                            binding.normalGender.setText("75.3 - 91.6 kg");
                            setMinMax(75.3f,91.6f);
                            break;
                        case 188:
                            binding.normalGender.setText("77.5 - 94.8 kg");
                            setMinMax(77.5f,94.8f);
                            break;
                        case 191:
                            binding.normalGender.setText("89.8 - 98 kg");
                            setMinMax(89.8f,98f);
                            break;
                        case 193:
                            binding.normalGender.setText("82.5 - 100.6 kg");
                            setMinMax(82.5f,100.6f);
                            break;
                        case 195:
                            binding.normalGender.setText("84.8 - 103.8 kg");
                            setMinMax(84.8f,103.8f);
                            break;
                    }
                    break;

            }


        });
        binding.male.setOnClickListener(v -> {
            binding.male.setBackgroundColor(getResources().getColor(R.color.ash));
            binding.female.setBackgroundColor(0);

            gender=1;
        });

        binding.female.setOnClickListener(v -> {
            binding.male.setBackgroundColor(0);
            binding.female.setBackgroundColor(getResources().getColor(R.color.ash));

            gender=0;
        });



        binding.reset.setOnClickListener(v -> {
            binding.etHeight.setText("");
            binding.etWeight.setText("");
            binding.etInch.setText("");
            binding.difference.setText("- - -");
            binding.bmiresult.setText("- - -");
            binding.category.setText("- - -");
            binding.check.setVisibility(View.GONE);
            binding.difference.setVisibility(View.VISIBLE);
            binding.difference.setText("- - -");
            binding.normalGender.setText("- - -");

            binding.iv1.setVisibility(View.INVISIBLE);
            binding.iv2.setVisibility(View.INVISIBLE);
            binding.iv3.setVisibility(View.INVISIBLE);
            binding.iv4.setVisibility(View.INVISIBLE);
            binding.iv5.setVisibility(View.INVISIBLE);
            binding.iv6.setVisibility(View.INVISIBLE);
            binding.iv7.setVisibility(View.INVISIBLE);
            binding.iv8.setVisibility(View.INVISIBLE);

            binding.viewUw.setVisibility(View.INVISIBLE);
            binding.viewN.setVisibility(View.INVISIBLE);
            binding.viewOw.setVisibility(View.INVISIBLE);

            binding.tvVsu.setTextColor(getResources().getColor(R.color.black));
            binding.tvSu.setTextColor(getResources().getColor(R.color.black));
            binding.tvU.setTextColor(getResources().getColor(R.color.black));
            binding.tvN.setTextColor(getResources().getColor(R.color.black));
            binding.tvO.setTextColor(getResources().getColor(R.color.black));
            binding.tvO1.setTextColor(getResources().getColor(R.color.black));
            binding.tvO2.setTextColor(getResources().getColor(R.color.black));
            binding.tvO3.setTextColor(getResources().getColor(R.color.black));
        });
    }

    private void checkingRange(float x, float diff) {

        if (x >= 0.0F && x <= 15.9F) {
            binding.iv1.setVisibility(View.VISIBLE);
            binding.iv2.setVisibility(View.INVISIBLE);
            binding.iv3.setVisibility(View.INVISIBLE);
            binding.iv4.setVisibility(View.INVISIBLE);
            binding.iv5.setVisibility(View.INVISIBLE);
            binding.iv6.setVisibility(View.INVISIBLE);
            binding.iv7.setVisibility(View.INVISIBLE);
            binding.iv8.setVisibility(View.INVISIBLE);
            //binding.iv1.setBackgroundColor(Color.parseColor("#D50000"));

            binding.category.setText("Underweight");
            binding.category.setTextColor(getResources().getColor(R.color.blue));
            binding.tvVsu.setTextColor(getResources().getColor(R.color.blue));
            is_UnderWeight=true;

            binding.difference.setText(String.valueOf(diff));
            binding.check.setVisibility(View.GONE);
            binding.difference.setVisibility(View.VISIBLE);

            binding.viewUw.setVisibility(View.VISIBLE);
            binding.viewN.setVisibility(View.INVISIBLE);
            binding.viewOw.setVisibility(View.INVISIBLE);

            binding.tvSu.setTextColor(getResources().getColor(R.color.black));
            binding.tvU.setTextColor(getResources().getColor(R.color.black));
            binding.tvN.setTextColor(getResources().getColor(R.color.black));
            binding.tvO.setTextColor(getResources().getColor(R.color.black));
            binding.tvO1.setTextColor(getResources().getColor(R.color.black));
            binding.tvO2.setTextColor(getResources().getColor(R.color.black));
            binding.tvO3.setTextColor(getResources().getColor(R.color.black));
        } else if (x >= 16.0F && x <= 16.9F) {
            // between 0.5 (inclusive) and 1.0 (exclusive)
            binding.iv2.setVisibility(View.VISIBLE);
            binding.iv1.setVisibility(View.INVISIBLE);
            binding.iv3.setVisibility(View.INVISIBLE);
            binding.iv4.setVisibility(View.INVISIBLE);
            binding.iv5.setVisibility(View.INVISIBLE);
            binding.iv6.setVisibility(View.INVISIBLE);
            binding.iv7.setVisibility(View.INVISIBLE);
            binding.iv8.setVisibility(View.INVISIBLE);
            // binding.iv2.setBackgroundColor(Color.parseColor("#D50000"));

            binding.category.setText("Underweight");
            is_UnderWeight=true;
            binding.category.setTextColor(getResources().getColor(R.color.blue));
            binding.tvSu.setTextColor(getResources().getColor(R.color.blue));

            binding.viewUw.setVisibility(View.VISIBLE);
            binding.viewN.setVisibility(View.INVISIBLE);
            binding.viewOw.setVisibility(View.INVISIBLE);

            binding.difference.setText(String.valueOf(diff));
            binding.check.setVisibility(View.GONE);
            binding.difference.setVisibility(View.VISIBLE);

            binding.tvU.setTextColor(getResources().getColor(R.color.black));
            binding.tvVsu.setTextColor(getResources().getColor(R.color.black));
            binding.tvN.setTextColor(getResources().getColor(R.color.black));
            binding.tvO.setTextColor(getResources().getColor(R.color.black));
            binding.tvO1.setTextColor(getResources().getColor(R.color.black));
            binding.tvO2.setTextColor(getResources().getColor(R.color.black));
            binding.tvO3.setTextColor(getResources().getColor(R.color.black));

        } else if (x >= 17.0F && x <= 18.4F) {
            binding.iv3.setVisibility(View.VISIBLE);
            binding.iv2.setVisibility(View.INVISIBLE);
            binding.iv1.setVisibility(View.INVISIBLE);
            binding.iv4.setVisibility(View.INVISIBLE);
            binding.iv5.setVisibility(View.INVISIBLE);
            binding.iv6.setVisibility(View.INVISIBLE);
            binding.iv7.setVisibility(View.INVISIBLE);
            binding.iv8.setVisibility(View.INVISIBLE);
            // binding.iv3.setBackgroundColor(Color.parseColor("#D50000"));
            binding.category.setText("Underweight");
            is_UnderWeight=true;
            binding.category.setTextColor(getResources().getColor(R.color.blue));
            binding.tvU.setTextColor(getResources().getColor(R.color.blue));

            binding.viewUw.setVisibility(View.VISIBLE);
            binding.viewN.setVisibility(View.INVISIBLE);
            binding.viewOw.setVisibility(View.INVISIBLE);

            binding.difference.setText(String.valueOf(diff));
            binding.check.setVisibility(View.GONE);
            binding.difference.setVisibility(View.VISIBLE);

            binding.tvVsu.setTextColor(getResources().getColor(R.color.black));
            binding.tvSu.setTextColor(getResources().getColor(R.color.black));
            binding.tvN.setTextColor(getResources().getColor(R.color.black));
            binding.tvO.setTextColor(getResources().getColor(R.color.black));
            binding.tvO1.setTextColor(getResources().getColor(R.color.black));
            binding.tvO2.setTextColor(getResources().getColor(R.color.black));
            binding.tvO3.setTextColor(getResources().getColor(R.color.black));
        } else if (x >= 18.5F && x <= 24.9F) {
            binding.iv4.setVisibility(View.VISIBLE);
            binding.iv2.setVisibility(View.INVISIBLE);
            binding.iv3.setVisibility(View.INVISIBLE);
            binding.iv1.setVisibility(View.INVISIBLE);
            binding.iv5.setVisibility(View.INVISIBLE);
            binding.iv6.setVisibility(View.INVISIBLE);
            binding.iv7.setVisibility(View.INVISIBLE);
            binding.iv8.setVisibility(View.INVISIBLE);
            //binding.iv4.setBackgroundColor(Color.parseColor("#D50000"));

            binding.tvN.setTextColor(getResources().getColor(R.color.green));
            binding.category.setText("Normal");
            binding.category.setTextColor(getResources().getColor(R.color.green));

            binding.viewUw.setVisibility(View.INVISIBLE);
            binding.viewN.setVisibility(View.VISIBLE);
            binding.viewOw.setVisibility(View.INVISIBLE);

            //binding.difference.
            binding.check.setVisibility(View.VISIBLE);
            binding.difference.setVisibility(View.GONE);

            binding.tvU.setTextColor(getResources().getColor(R.color.black));
            binding.tvVsu.setTextColor(getResources().getColor(R.color.black));
            binding.tvSu.setTextColor(getResources().getColor(R.color.black));
            binding.tvO.setTextColor(getResources().getColor(R.color.black));
            binding.tvO1.setTextColor(getResources().getColor(R.color.black));
            binding.tvO2.setTextColor(getResources().getColor(R.color.black));
            binding.tvO3.setTextColor(getResources().getColor(R.color.black));
        } else if (x >= 25.0F && x <= 29.9F) {
            binding.iv5.setVisibility(View.VISIBLE);
            binding.iv2.setVisibility(View.INVISIBLE);
            binding.iv3.setVisibility(View.INVISIBLE);
            binding.iv4.setVisibility(View.INVISIBLE);
            binding.iv1.setVisibility(View.INVISIBLE);
            binding.iv6.setVisibility(View.INVISIBLE);
            binding.iv7.setVisibility(View.INVISIBLE);
            binding.iv8.setVisibility(View.INVISIBLE);
            //binding.iv5.setBackgroundColor(Color.parseColor("#D50000"));

            binding.tvO.setTextColor(getResources().getColor(R.color.red));
            binding.category.setText("Overweight");
            is_Overweight=true;
            binding.category.setTextColor(getResources().getColor(R.color.red));

            binding.difference.setText(String.valueOf(diff));
            binding.check.setVisibility(View.GONE);
            binding.difference.setVisibility(View.VISIBLE);

            binding.viewUw.setVisibility(View.INVISIBLE);
            binding.viewN.setVisibility(View.INVISIBLE);
            binding.viewOw.setVisibility(View.VISIBLE);

            binding.tvN.setTextColor(getResources().getColor(R.color.black));
            binding.tvU.setTextColor(getResources().getColor(R.color.black));
            binding.tvVsu.setTextColor(getResources().getColor(R.color.black));
            binding.tvSu.setTextColor(getResources().getColor(R.color.black));
            binding.tvO1.setTextColor(getResources().getColor(R.color.black));
            binding.tvO2.setTextColor(getResources().getColor(R.color.black));
            binding.tvO3.setTextColor(getResources().getColor(R.color.black));
        } else if (x >= 30.0F && x <= 34.9F) {
            binding.iv6.setVisibility(View.VISIBLE);
            binding.iv2.setVisibility(View.INVISIBLE);
            binding.iv3.setVisibility(View.INVISIBLE);
            binding.iv4.setVisibility(View.INVISIBLE);
            binding.iv5.setVisibility(View.INVISIBLE);
            binding.iv1.setVisibility(View.INVISIBLE);
            binding.iv7.setVisibility(View.INVISIBLE);
            binding.iv8.setVisibility(View.INVISIBLE);
            //binding.iv6.setBackgroundColor(Color.parseColor("#D50000"));
            binding.tvO1.setTextColor(getResources().getColor(R.color.red));
            binding.category.setText("Overweight");
            is_Overweight=true;
            binding.category.setTextColor(getResources().getColor(R.color.red));

            binding.viewUw.setVisibility(View.INVISIBLE);
            binding.viewN.setVisibility(View.INVISIBLE);
            binding.viewOw.setVisibility(View.VISIBLE);

            binding.difference.setText(String.valueOf(diff));
            binding.check.setVisibility(View.GONE);
            binding.difference.setVisibility(View.VISIBLE);

            binding.tvO.setTextColor(getResources().getColor(R.color.black));
            binding.tvN.setTextColor(getResources().getColor(R.color.black));
            binding.tvU.setTextColor(getResources().getColor(R.color.black));
            binding.tvVsu.setTextColor(getResources().getColor(R.color.black));
            binding.tvSu.setTextColor(getResources().getColor(R.color.black));
            binding.tvO2.setTextColor(getResources().getColor(R.color.black));
            binding.tvO3.setTextColor(getResources().getColor(R.color.black));
        } else if (x >= 35.0F && x <= 39.9F) {
            binding.iv7.setVisibility(View.VISIBLE);
            binding.iv2.setVisibility(View.INVISIBLE);
            binding.iv3.setVisibility(View.INVISIBLE);
            binding.iv4.setVisibility(View.INVISIBLE);
            binding.iv5.setVisibility(View.INVISIBLE);
            binding.iv6.setVisibility(View.INVISIBLE);
            binding.iv1.setVisibility(View.INVISIBLE);
            binding.iv8.setVisibility(View.INVISIBLE);
            //binding.iv7.setBackgroundColor(Color.parseColor("#D50000"));
            binding.tvO2.setTextColor(getResources().getColor(R.color.red));
            binding.category.setText("Overweight");
            is_Overweight=true;
            binding.category.setTextColor(getResources().getColor(R.color.red));

            binding.viewUw.setVisibility(View.INVISIBLE);
            binding.viewN.setVisibility(View.INVISIBLE);
            binding.viewOw.setVisibility(View.VISIBLE);

            binding.difference.setText(String.valueOf(diff));
            binding.check.setVisibility(View.GONE);
            binding.difference.setVisibility(View.VISIBLE);

            binding.tvO1.setTextColor(getResources().getColor(R.color.black));
            binding.tvO.setTextColor(getResources().getColor(R.color.black));
            binding.tvN.setTextColor(getResources().getColor(R.color.black));
            binding.tvU.setTextColor(getResources().getColor(R.color.black));
            binding.tvVsu.setTextColor(getResources().getColor(R.color.black));
            binding.tvSu.setTextColor(getResources().getColor(R.color.black));
            binding.tvO3.setTextColor(getResources().getColor(R.color.black));
        } else if (x >= 40.0F) {
            binding.iv8.setVisibility(View.VISIBLE);
            binding.iv2.setVisibility(View.INVISIBLE);
            binding.iv3.setVisibility(View.INVISIBLE);
            binding.iv4.setVisibility(View.INVISIBLE);
            binding.iv5.setVisibility(View.INVISIBLE);
            binding.iv6.setVisibility(View.INVISIBLE);
            binding.iv7.setVisibility(View.INVISIBLE);
            binding.iv1.setVisibility(View.INVISIBLE);
            // binding.iv8.setBackgroundColor(Color.parseColor("#D50000"));

            binding.tvO3.setTextColor(getResources().getColor(R.color.red));
            binding.category.setText("Overweight");
            is_Overweight=true;
            binding.category.setTextColor(getResources().getColor(R.color.red));

            binding.difference.setText(String.valueOf(diff));
            binding.check.setVisibility(View.GONE);
            binding.difference.setVisibility(View.VISIBLE);

            binding.viewUw.setVisibility(View.INVISIBLE);
            binding.viewN.setVisibility(View.INVISIBLE);
            binding.viewOw.setVisibility(View.VISIBLE);

            binding.tvO2.setTextColor(getResources().getColor(R.color.black));
            binding.tvO1.setTextColor(getResources().getColor(R.color.black));
            binding.tvO.setTextColor(getResources().getColor(R.color.black));
            binding.tvN.setTextColor(getResources().getColor(R.color.black));
            binding.tvU.setTextColor(getResources().getColor(R.color.black));
            binding.tvVsu.setTextColor(getResources().getColor(R.color.black));
            binding.tvSu.setTextColor(getResources().getColor(R.color.black));
        } else {
            Toast.makeText(this, "Out Of Range", Toast.LENGTH_SHORT).show();
            binding.category.setText("- - -");
        }
    }

    private void CalculateBMI() {
        weight = Float.parseFloat(binding.etWeight.getText().toString());
        float BMI = weight / (height * height);

        float BMIf = Math.round((BMI * 100) / 100);
        binding.bmiresult.setText(String.valueOf(BMIf));
        CheckSeekbarStatus();

    }

    private void CheckSeekbarStatus() {
    /*    binding.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String ht = progress + getResources().getString(R.string.cm);
                binding.etHeight.setText(ht);
                height = (float)(progress)/100;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });*/
    }


    private void lb() {
        weight = Float.parseFloat(binding.etWeight.getText().toString());

        //float BMIlb = 703*(weight / (height * height));
        float BMIlb = 703 * (weight / (Total_heightinInch * Total_heightinInch));
        binding.bmiresult.setText(String.valueOf(BMIlb));
        float difflb = 72.3f - Float.parseFloat(binding.etWeight.getText().toString());

        checkingRange(BMIlb, difflb);
    }

    private void setMinMax(float min,float max) {
        minVal=min;
        maxVal=max;

        if(is_UnderWeight==true)
        {
            float diff=weight-min;
            binding.difference.setText(String.valueOf(String.format("%.2f",diff)));
        }
        if(is_Overweight==true)
        {
            float diff=weight-max;
            binding.difference.setText(String.valueOf(String.format("%.2f",diff)));
        }


    }
}