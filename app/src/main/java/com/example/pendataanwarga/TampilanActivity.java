package com.example.pendataanwarga;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class TampilanActivity extends AppCompatActivity {

    ListView list_data;
    MaterialButton backbtn;
    ArrayList<String> datalist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan);
        backbtn = findViewById(R.id.back);
        list_data = findViewById(R.id.listdata);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            Intent intent = getIntent();
            String name = intent.getStringExtra("Name");
            String address = intent.getStringExtra("Address");
            String city = intent.getStringExtra("City");
            int age = intent.getIntExtra("Age", 0);
            String job = intent.getStringExtra("Job");
            String salary = intent.getStringExtra("Salary");
            String status = intent.getStringExtra("Status");


            datalist.add("Name : " + name);
            datalist.add("Address : " + address);
            datalist.add("City : " + city);
            datalist.add("Age : " + age);
            datalist.add("Job : " + job);
            datalist.add("Salary : " + salary);
            datalist.add("Status : " + status);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.item_text_view, datalist);
        list_data.setAdapter(adapter);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TampilanActivity.this, IdentitasActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

    }
}