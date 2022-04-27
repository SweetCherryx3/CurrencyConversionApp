package com.example.lab_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double USD_Amount;
    double oneMexicanPeso = 20.07;
    double oneEuro = 0.90;
    double oneCAD = 1.25;
    double totalConversion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText USD_Amt = (EditText) findViewById(R.id.USD_Amount);
        final RadioButton Euros = (RadioButton) findViewById(R.id.conversion1);
        final RadioButton MxnPesos = (RadioButton) findViewById(R.id.conversion2);
        final RadioButton CAD_dollars = (RadioButton) findViewById(R.id.conversion3);
        final TextView result = (TextView) findViewById(R.id.totalConversionAmount);
        Button calculate = (Button) findViewById(R.id.btnCost);

        calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                USD_Amount = Double.parseDouble(USD_Amt.getText().toString());
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                if (Euros.isChecked()){
                    if (USD_Amount > 99_999){
                        Toast.makeText(MainActivity.this, "Amount too large to calculate.", Toast.LENGTH_LONG).show();
                    } else {
                        totalConversion = USD_Amount * oneEuro;
                        result.setText(String.format("%s for %s Euros.", currency.format(USD_Amount), totalConversion));
                    }

                }
                if (MxnPesos.isChecked()) {
                    if (USD_Amount > 99_999) {
                        Toast.makeText(MainActivity.this, "Amount too large to calculate.", Toast.LENGTH_LONG).show();
                    } else {
                        totalConversion = USD_Amount * oneMexicanPeso;
                        result.setText(String.format("%s for %s Mexican Pesos.", currency.format(USD_Amount), totalConversion));
                    }
                }

                if (CAD_dollars.isChecked()) {
                    if (USD_Amount > 99_999) {
                        Toast.makeText(MainActivity.this, "Amount too large to calculate.", Toast.LENGTH_LONG).show();
                    } else {
                        totalConversion = USD_Amount * oneCAD;
                        result.setText(String.format("%s for %s Canadian Dollars.", currency.format(USD_Amount), totalConversion));
                    }
                }
            }

        });


    }

    public void checkButton(View view) {
    }
}
