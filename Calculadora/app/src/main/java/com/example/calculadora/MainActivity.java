package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText num1EditText;
    EditText num2EditText;
    EditText resultEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1EditText = findViewById(R.id.num1EditText);
        num2EditText = findViewById(R.id.num2EditText);
        resultEditText = findViewById(R.id.resultEditText);
    }

    protected float getNumFromEditText(int id) {
        String aux;
        if (id == 1) {
            aux = num1EditText.getText().toString();
        } else {
            aux = num2EditText.getText().toString();
        }
        return Float.parseFloat(aux);
    }

    public void plusButtonOnClick(View v) {
        float num1 = getNumFromEditText(1);
        float num2 = getNumFromEditText(2);

        float result = num1 + num2;

        resultEditText.setText(String.valueOf(result));
    }

    public void minusButtonOnClick(View v) {
        float num1 = getNumFromEditText(1);
        float num2 = getNumFromEditText(2);

        float result = num1 - num2;

        resultEditText.setText(String.valueOf(result));
    }

    public void multiButtonOnClick(View v) {
        float num1 = getNumFromEditText(1);
        float num2 = getNumFromEditText(2);

        float result = num1 * num2;

        resultEditText.setText(String.valueOf(result));
    }

    public void divButtonOnClick(View v) {
        float num1 = getNumFromEditText(1);
        float num2 = getNumFromEditText(2);

        float result = num1 / num2;

        resultEditText.setText(String.valueOf(result));
    }
}