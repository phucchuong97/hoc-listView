package com.example.npc.luyentap_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lvlThang;
    String []arrThang;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        lvlThang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,arrThang[i].toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addControls() {
        arrThang = getResources().getStringArray(R.array.arrThang);
        adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,arrThang);
        lvlThang = findViewById(R.id.lvThang);
        lvlThang.setAdapter(adapter);

    }
}
