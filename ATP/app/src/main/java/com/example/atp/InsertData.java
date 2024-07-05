package com.example.atp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InsertData extends AppCompatActivity {
    EditText name, email, age;
    Button insert, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        age = findViewById(R.id.age);
        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);

        DB = new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InsertData.this, Userlist.class));
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String emailTXT = email.getText().toString();
                String ageTXT = age.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, emailTXT, ageTXT);
                if (checkinsertdata == true) {
                    Toast.makeText(InsertData.this, "Nova entrada inserida", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(InsertData.this, "Nova entrada não inserida", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}