package com.example.soumit.materialsliders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.appyvet.materialrangebar.RangeBar;

public class MainActivity extends AppCompatActivity {

    AppCompatSeekBar appCompatSeekBar;
    TextView seekbarValue;
    RangeBar rangeBar;
    TextView rangebarValue;
    RangeBar twoSidedRangebar;
    TextView rangebarLeftValue, rangebarRightValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appCompatSeekBar = (AppCompatSeekBar) findViewById(R.id.seekbar_id);
        seekbarValue = (TextView) findViewById(R.id.seekbar_value);
        rangeBar = (RangeBar) findViewById(R.id.rangebar_id);
        rangebarValue = (TextView) findViewById(R.id.rangebar_value);

        twoSidedRangebar = (RangeBar) findViewById(R.id.twosided_rangebar_id);
        rangebarLeftValue = (TextView) findViewById(R.id.rangebarleft_value);
        rangebarRightValue = (TextView) findViewById(R.id.rangebarright_value);

        appCompatSeekBar.setProgress(0);
        appCompatSeekBar.setKeyProgressIncrement(1);

        appCompatSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String value = String.valueOf(i);
                seekbarValue.setText(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        /**
         *  For single sided rangebar
         */
        rangeBar.setSeekPinByIndex(0);
//        rangeBar.setPinTextColor(getResources().getColor(R.color.colorAccent));
        rangeBar.setSelectorColor(getResources().getColor(R.color.colorAccent));
        rangeBar.setTickColor(getResources().getColor(R.color.colorAccent));
        rangeBar.setConnectingLineColor(getResources().getColor(R.color.colorAccent));
//        rangeBar.setBarColor(getResources().getColor(R.color.colorAccent));
        rangeBar.setPinColor(getResources().getColor(R.color.colorPrimaryDark));

        rangeBar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                                              int rightPinIndex, String leftPinValue, String rightPinValue) {

                rangebarValue.setText(rightPinValue);
            }
        });

        /**
         *  for both-sided rangebar
         */

        twoSidedRangebar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                                              int rightPinIndex, String leftPinValue, String rightPinValue) {

                rangebarLeftValue.setText(leftPinValue);
                rangebarRightValue.setText(rightPinValue);
            }
        });


         }
}
