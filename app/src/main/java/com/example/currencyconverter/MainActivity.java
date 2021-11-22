package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText etKwacha;
    private EditText etDollars;
    private Button btnGetKwacha;
    private Button btnGetDollars;
    private TextView tvResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etKwacha = findViewById(R.id.editTextKwacha);
        etDollars = findViewById(R.id.editTextDollars);
        btnGetKwacha = findViewById(R.id.buttonGetKwacha);
        btnGetDollars = findViewById(R.id.buttonGetDollars);
        tvResults = findViewById(R.id.textViewResult);

        btnGetKwacha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConvertToKwacha();
            }
        });
        btnGetDollars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConvertToDollars();
            }
        });
    }
    private boolean validate(EditText editText){
        if(editText.getText().toString().isEmpty()){
            editText.setError("This field can't be empty");
            return false;
        }else{
            return true;
        }
    }
    private void ConvertToDollars() {
        if(validate(etKwacha)) {
            Double kwacha = Double.parseDouble(etKwacha.getText().toString());
            Double dollars = 0.0012 * kwacha;
            NumberFormat us = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
            tvResults.setText(us.format(dollars));
        }
    }

    private void ConvertToKwacha() {
        if(validate(etDollars)) {
            Double dollars = Double.parseDouble(etDollars.getText().toString());
            Double kwacha = 816.73 * dollars;
            NumberFormat mw = NumberFormat.getCurrencyInstance(new Locale("en", "MW"));
            tvResults.setText(mw.format(kwacha));
        }
    }
}