package com.example.ian.practicalassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class CustomXchangeRate extends AppCompatActivity {

    Spinner spin;
    EditText name;

    ArrayAdapter<CharSequence>arr;


    Menu myMenu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.myMenu = menu;
        getMenuInflater().inflate(R.menu.currencymenu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_xchange_rate);


        spin = (Spinner) findViewById(R.id.spin);
        name = (EditText) findViewById(R.id.name);

        arr = ArrayAdapter.createFromResource(this, R.array.listCurr, android.R.layout.simple_spinner_dropdown_item);
       spin.setAdapter(arr);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String a = spin.getSelectedItem().toString();

                name.setText(a);



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
}
