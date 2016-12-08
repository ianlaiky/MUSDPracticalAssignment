package com.example.ian.practicalassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class CustomXchangeRate extends AppCompatActivity {

    Spinner spin;

    ArrayAdapter<CharSequence>arr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_xchange_rate);


        spin = (Spinner) findViewById(R.id.spin);
        arr = ArrayAdapter.createFromResource(this, R.array.listCurr, android.R.layout.simple_spinner_dropdown_item);
       spin.setAdapter(arr);




    }
}
