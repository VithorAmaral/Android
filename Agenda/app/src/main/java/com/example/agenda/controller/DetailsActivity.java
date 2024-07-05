package com.example.agenda.controller;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.agenda.R;
import com.example.agenda.model.Contact;
import com.example.agenda.model.DataModel;

public class DetailsActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText phoneEditText;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        nameEditText = findViewById(R.id.nameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);

        Bundle extra = getIntent().getExtras();
        index = extra.getInt("index");
        if (index != -1) {
            Contact c = DataModel.getInstance().getContact(index);
            nameEditText.setText(c.getName());
            phoneEditText.setText((c.getPhone()));
        }
    }

    @Override
    public void onBackPressed() {
        String name = nameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();

        if (name.length() > 1 && phone.length() > 1) {
            if (index == -1) {
                DataModel.getInstance().addContact(
                        new Contact(name, phone)
                );
            } else {
                Contact c = DataModel.getInstance().getContact(index);
                c.setName(name);
                c.setPhone(phone);
                DataModel.getInstance().updateContact(c, index);
            }
            finish();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(DetailsActivity.this);
            builder.setTitle(R.string.attention);
            builder.setMessage(R.string.empty_contact_alert_msg);
            builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setNegativeButton(android.R.string.no, null);
            builder.create().show();
        }
    }
}