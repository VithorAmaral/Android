package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double altura, peso, imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_calcula = (Button) findViewById(R.id.btn_calcula);
        TextView tv_resultado = (TextView) findViewById(R.id.tv_resultado);
        EditText et_altura = (EditText) findViewById(R.id.et_altura);
        EditText et_peso = (EditText) findViewById(R.id.et_peso);

        btn_calcula.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String alturaStr = et_altura.getText().toString();
                String pesoStr = et_peso.getText().toString();

                if (alturaStr.isEmpty() || pesoStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Valores inválidos", Toast.LENGTH_SHORT).show();
                } else {
                    altura = Double.parseDouble(alturaStr);
                    peso = Double.parseDouble(pesoStr);
                    imc = peso / (altura * altura);
                    tv_resultado.setText(String.valueOf(String.format("%.2f", imc)));

                }
            }
        });
    }
}
