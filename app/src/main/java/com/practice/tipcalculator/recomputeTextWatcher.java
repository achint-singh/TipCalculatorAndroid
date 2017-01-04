package com.practice.tipcalculator;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by achintsingh on 11/20/16.
 */
public class RecomputeTextWatcher implements TextWatcher {

    private EditText initial_Bill;
    private TextView tip_Percent;
    private TextView people_Num;
    private TextView final_Tip;
    private TextView final_Bill;
    private TextView final_perPerson;

    public RecomputeTextWatcher(EditText initialBill, TextView tipPercent, TextView peopleNum, TextView finalTip, TextView finalBill,
                                TextView finalperPerson) {
        initial_Bill = initialBill;
        tip_Percent = tipPercent;
        people_Num = peopleNum;
        final_Tip = finalTip;
        final_Bill = finalBill;
        final_perPerson = finalperPerson;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        update();
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    public void update() {

        String tip = tip_Percent.getText().toString();
        int tipPercent = Integer.parseInt(tip.substring(0, tip.length() - 1));
        double initBill = Double.parseDouble(initial_Bill.getText().toString());
        int peopleNum = Integer.parseInt(people_Num.getText().toString());

        double tips = initBill * ((double)tipPercent/100);
        double total = initBill + tips;
        double perPerson = total/peopleNum;

        String bill = String.format("$%.2f", total);
        final_Bill.setText(bill);
        String tipString = String.format("$%.2f", tips);
        final_Tip.setText(tipString);
        String finalPersonCost = String.format("$%.2f", perPerson);
        final_perPerson.setText(finalPersonCost);


    }


}
