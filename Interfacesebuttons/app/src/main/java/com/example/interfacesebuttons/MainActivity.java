package com.example.interfacesebuttons;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView titleTextView;
    EditText counterEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle", "onCreate");
        titleTextView = findViewById(R.id.titletextView);
        titleTextView.setText("Olá PUCPR");
        counterEditText = findViewById(R.id.counterEditText);
        counterEditText.setText("0");
    }

    public void addOneButtonOnClick(View v) {
        String aux = counterEditText.getText().toString();
        int num = Integer.parseInt(aux);
        num++;
        counterEditText.setText(String.valueOf(num));
    }

    public void toastButtonOnClick(View v) {
        Toast.makeText(
                MainActivity.this,
                "Button Pressed",
                Toast.LENGTH_LONG
        ).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("LifeCycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("LifeCycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.wtf("LifeCycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("LifeCycle", "onDestroy");
    }
}