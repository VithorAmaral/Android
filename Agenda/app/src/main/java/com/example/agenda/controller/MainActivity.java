package com.example.agenda.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agenda.R;
import com.example.agenda.model.Contact;
import com.example.agenda.model.DataModel;
import com.google.android.material.snackbar.Snackbar;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ContactAdapter adapter = new ContactAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        DataModel.getInstance().createDatabase(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(MainActivity.this)
        );
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(
                MainActivity.this, DividerItemDecoration.VERTICAL
        );
        recyclerView.addItemDecoration(itemDecoration);

        adapter.setOnItemClickListener(new ContactAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                goToDetailActivity(position);
            }
        });
        adapter.setOnItemLongClickListener(new ContactAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(View view, int position) {

                Contact c = DataModel.getInstance().getContact(position);
                DataModel.getInstance().removeContact(position);
                adapter.notifyItemRemoved(position);
                View contextView = findViewById(android.R.id.content);
                Snackbar.make(contextView, R.string.remove_contact, Snackbar.LENGTH_LONG)
                        .setAction(R.string.undo, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                DataModel.getInstance().insertContact(c, position);
                                adapter.notifyItemInserted(position);
                            }
                        })
                        .show();
                return true;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    void goToDetailActivity(int index) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("index", index);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_add_contact) {
            goToDetailActivity(-1);
        }
        return super.onOptionsItemSelected(item);
    }
}