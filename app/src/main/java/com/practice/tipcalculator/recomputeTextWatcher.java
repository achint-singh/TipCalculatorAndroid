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
    private EditText tip_Percent;
    private TextView final_Tip;
    private TextView final_Bill;

    public RecomputeTextWatcher(EditText initialBill, EditText tipPercent, TextView finalTip, TextView finalBill) {
        initial_Bill = initialBill;
        tip_Percent = tipPercent;
        final_Tip = finalTip;
        final_Bill = finalBill;
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
        double tipPercent = 0.0;
        double initBill = 0.0;
        try {
            tipPercent = Double.parseDouble(tip_Percent.getText().toString());
            initBill = Double.parseDouble(initial_Bill.getText().toString());
        } catch (NumberFormatException ex) {
            final_Bill.setText("Total Bill: $0.00");
            final_Tip.setText("Tip: $0.00");
        }
        double tip = initBill * tipPercent/100;
        double total = initBill + tip;
        final_Bill.setText("Total Bill: $" + total);
        final_Tip.setText("Tip: $" + tip);
    }


}
