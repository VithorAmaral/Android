package com.example.usodeimages;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Switch imageSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitch = findViewById(R.id.imageSwitch);
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.mario);

        imageSwitch.setChecked(true);
        imageSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    imageView.setImageDrawable(getImageDrawable("mario"));
                } else {
                    imageView.setImageDrawable(getImageDrawable("mario2"));
                }
            }
        });

    }
    protected Drawable getImageDrawable(String name){
        return getResources().getDrawable(
                getResources().getIdentifier(name, "drawable", getPackageName()),
                getTheme()
        );
    }
}