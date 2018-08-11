package com.example.npc.luyentap_listview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> dsDate;
    ListView lvDate;
    ArrayAdapter<String> adapter;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date = new Date();
                dsDate.add(date.toString());
                adapter.notifyDataSetChanged();
            }
        });

        lvDate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,dsDate.get(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addControls() {
        lvDate = findViewById(R.id.lvlDate);
        dsDate = new ArrayList<>();
        adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,dsDate);
        lvDate.setAdapter(adapter);
        btnAdd = findViewById(R.id.btnAdd);
    }

}
