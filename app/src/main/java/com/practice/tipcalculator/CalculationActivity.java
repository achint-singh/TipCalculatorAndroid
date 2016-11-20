package com.practice.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class CalculationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        EditText initialBill = (EditText)findViewById(R.id.originalBill);
        EditText tipPercent = (EditText)findViewById(R.id.tipPercentage);
        TextView tipValue = (TextView)findViewById(R.id.totalTip);
        TextView finalBill = (TextView)findViewById(R.id.totalBill);

        RecomputeTextWatcher textWatcher = new RecomputeTextWatcher(initialBill, tipPercent, tipValue, finalBill);


        initialBill.addTextChangedListener(textWatcher);
        tipPercent.addTextChangedListener(textWatcher);

    }
}
