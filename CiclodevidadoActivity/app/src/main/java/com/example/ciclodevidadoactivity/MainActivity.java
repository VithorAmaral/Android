package com.example.ciclodevidadoactivity;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle", "onCreate");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v("LifeCycle", "onStart");
    }
    @Override
    protected void onResume(){
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