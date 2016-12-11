package com.example.ian.practicalassignment;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;


public class CustomXchangeRate extends AppCompatActivity {
    final static String RETURN_MSG = "message";
    Spinner spin;
    EditText name;
    EditText rate;
    ArrayList<String> array = new ArrayList<String>();
    ArrayAdapter<CharSequence> arr;

    ArrayList<String>itemm;

    String itemselected;
    Menu myMenu;

    double currencySelected;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.myMenu = menu;
        getMenuInflater().inflate(R.menu.currencymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//


        return true;

    }
    public void getAllFromDb() {

        DecimalFormat forma = new DecimalFormat("#0.00");
        //USE DB TO GET ARRAY
        Currency temp = new Currency();
        temp = Currency.getInstance();

        ArrayList<String> temparr = (ArrayList<String>) temp.retrieveAll(getApplicationContext());


        ArrayList<Currency> tempALl = new ArrayList<Currency>();

        for (int i = 0; i < temparr.size(); i += 3) {
//            System.out.println("DATA "+temparr.get(i + 2));
            String a =  forma.format(parseDouble(temparr.get(i + 2)));

            Currency c = new Currency(temparr.get(i), temparr.get(i + 1),a);
            tempALl.add(c);

        }


        System.out.println("NO IN ARR");


        SpinnerAdapter myAdap = new ListCustomAdapter(this, tempALl);
        spin.setAdapter(myAdap);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_xchange_rate);


        spin = (Spinner) findViewById(R.id.spin);
        name = (EditText) findViewById(R.id.name);
        rate = (EditText) findViewById(R.id.rateno);

//        arr = ArrayAdapter.createFromResource(this, R.array.listCurr, android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(arr);
//        getAllFromDb();

        Bundle bundle = getIntent().getExtras();

//        array = bundle.getStringArrayList("arr");

        System.out.println(array.size());

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                String a = spin.getSelectedItem().toString();
//                name.setText(a);
//                if (spin.getSelectedItem().toString().equalsIgnoreCase("Australian Dollar")) {
//                    //  System.out.println("AUSSS");
//                    itemselected = "AUD";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Bulgarian lev")) {
//                    itemselected = "BGN";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Brazilian real")) {
//                    itemselected = "BRL";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Canadian Dollar")) {
//                    itemselected = "CAD";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Swiss franc")) {
//                    itemselected = "CHF";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Chinese Yuan")) {
//                    itemselected = "CNY";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Czech Republic Koruna")) {
//                    itemselected = "CZK";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Danish Krone")) {
//                    itemselected = "DKK";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("British Pound")) {
//                    itemselected = "GBP";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Hong Kong Dollar")) {
//                    itemselected = "HKD";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Croatian Kuna")) {
//                    itemselected = "HRK";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Hungarian Forint")) {
//                    itemselected = "HUF";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Indonesian Rupiah")) {
//                    itemselected = "IDR";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Israeli New Sheqel")) {
//                    itemselected = "ILS";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Indian Rupee")) {
//                    itemselected = "INR";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Japanese Yen")) {
//                    itemselected = "JPY";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("South Korean Won")) {
//                    itemselected = "KRW";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Mexican Peso")) {
//                    itemselected = "MXN";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Malaysian Ringgit")) {
//                    itemselected = "MYR";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Norwegian Krone")) {
//                    itemselected = "NOK";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("New Zealand Dollar")) {
//                    itemselected = "NZD";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Philippine Peso")) {
//                    itemselected = "PHP";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Polish Zloty")) {
//                    itemselected = "PLN";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Romanian Leu")) {
//                    itemselected = "RON";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Russian Ruble")) {
//                    itemselected = "RUB";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Swedish Krona")) {
//                    itemselected = "SEK";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Thai Baht")) {
//                    itemselected = "THB";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Turkish Lira")) {
//                    itemselected = "TRY";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("US Dollar")) {
//                    itemselected = "USD";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("South African Rand")) {
//                    itemselected = "ZAR";
//
//                } else if (spin.getSelectedItem().toString().equalsIgnoreCase("Euro")) {
//                    itemselected = "EUR";
//
//                }
//                for (int p = 0; p < array.size(); p++) {
//                    System.out.println(array.get(p));
//                    if (itemselected.equalsIgnoreCase(array.get(p).toString())) {
//                        currencySelected = parseDouble(array.get(p + 1));
//                        System.out.println(array.get(p + 1));
//                    }
//
//                }
//                System.out.println(currencySelected);
//                rate.setText(currencySelected + "");

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        getAllFromDb();
    }
}
