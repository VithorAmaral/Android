package com.example.sqlite;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CityDatabase database = new CityDatabase(MainActivity.this);
        /*database.createCityInDB(new City("Curitiba", 2000000));
        database.createCityInDB(new City("Rio de Janeiro", 10000000));
        database.createCityInDB(new City("São Paulo", 20000000));*/

        ArrayList<City> cities = database.getCitiesFromDB();
        for (City c : cities) {
            c.print();
        }
        /*cities.get(0).name = "NY";
        database.updateCityInDB(cities.get(0));
        database.removeCityInDB(cities.get(1));*/


    }
}