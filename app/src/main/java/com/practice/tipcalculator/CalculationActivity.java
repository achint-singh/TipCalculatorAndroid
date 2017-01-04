package com.practice.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CalculationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        EditText initialBill = (EditText)findViewById(R.id.originalBill);
        final TextView tipPercent = (TextView)findViewById(R.id.tipPercentage);
        final TextView numPeople = (TextView) findViewById(R.id.numPeople);
        TextView tipValue = (TextView)findViewById(R.id.totalTip);
        TextView finalBill = (TextView)findViewById(R.id.totalBill);
        TextView perPerson = (TextView)findViewById(R.id.perPersonValue);
        Button increaseTip = (Button)findViewById(R.id.increaseTip);
        Button decreaseTip = (Button)findViewById(R.id.decreaseTip);
        Button increasePeople = (Button)findViewById(R.id.increasePeople);
        Button decreasePeople = (Button)findViewById(R.id.decreasePeople);
        RecomputeTextWatcher textWatcher = new RecomputeTextWatcher(initialBill, tipPercent, numPeople, tipValue, finalBill, perPerson);

        initialBill.addTextChangedListener(textWatcher);
        tipPercent.addTextChangedListener(textWatcher);
        numPeople.addTextChangedListener(textWatcher);
        increaseTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tip = tipPercent.getText().toString();
                int percent = Integer.parseInt(tip.substring(0, tip.length() - 1));
                tip = (percent + 1) + "%";
                tipPercent.setText(tip);
            }
        });
        decreaseTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tip = tipPercent.getText().toString();
                int percent = Integer.parseInt(tip.substring(0, tip.length() - 1));
                tip = (percent - 1) + "%";
                if(percent - 1 >= 0) {
                    tipPercent.setText(tip);
                }
            }
        });
        increasePeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String people = numPeople.getText().toString();
                int peoples = Integer.parseInt(people);
                people = (peoples + 1) + "";
                numPeople.setText(people);
            }
        });
        decreasePeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String people = numPeople.getText().toString();
                int peoples = Integer.parseInt(people);
                people = (peoples - 1) + "";
                if(peoples - 1 >= 1) {
                    numPeople.setText(people);
                }
            }
        });




    }
}
