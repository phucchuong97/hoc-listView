package com.example.npc.luyentap_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import custom.adapter.DanhBaAdapter;
import model.DanhBa;


public class MainActivity extends AppCompatActivity {

    ArrayList<DanhBa> dsDanhBa;
    DanhBaAdapter adapter;
    ListView lvDanhBa;
    Button btnRemove,btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int row = lvDanhBa.getSelectedItemPosition();
                try{
                    dsDanhBa.remove(row);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,(row)+" Vui lòng chọn danh bạ muốn xóa",Toast.LENGTH_SHORT).show();
                }

                adapter.notifyDataSetChanged();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = dsDanhBa.size();
                for(int i=0;i<n;i++){
                    DanhBa temp = new DanhBa(dsDanhBa.get(i).getTen(),dsDanhBa.get(i).getSdt());
                    dsDanhBa.add(temp);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void addControls() {
        lvDanhBa = findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();
        dsDanhBa.add(new DanhBa("Chương","0969430995"));
        dsDanhBa.add(new DanhBa("mẹ","01647502276"));
        dsDanhBa.add(new DanhBa("ba","01988776347"));

        adapter = new DanhBaAdapter(MainActivity.this,R.layout.danhba_layout,dsDanhBa);
        lvDanhBa.setAdapter(adapter);
        btnRemove = findViewById(R.id.btnRemove);
        btnAdd = findViewById(R.id.btnAdd);
    }

}
