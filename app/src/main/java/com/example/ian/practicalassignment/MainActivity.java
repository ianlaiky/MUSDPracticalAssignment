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
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    ListView li;
    TextView te;
    EditText edit;
    TextView currText;

    ArrayAdapter<CharSequence> arr;
    ArrayList<String> allCurr = new ArrayList<String>();
    List<String> listcountrycode = new ArrayList<>();
    List<String> listrate = new ArrayList<>();
    List<String> listcountry;



    final int RESULT_CODE = 1;

    Menu myMenu;
    String itemselected = "";
    double currentcySelected;
    double newCurr;

    int cleared = 0;
    Currency myCurrency;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    public void getAllFromDb(){


        //USE DB TO GET ARRAY
        Currency temp = new Currency();
        temp = Currency.getInstance();

        ArrayList<String>temparr = (ArrayList<String>) temp.retrieveAll(getApplicationContext());

        ArrayList<String>tempCountry = new ArrayList<String>();
        ArrayList<String>tempCountryCode = new ArrayList<String>();
        ArrayList<String>tempRate = new ArrayList<>();


        ArrayList<ArrayList>tempALl = new ArrayList<ArrayList>();

        for(int i=0;i<temparr.size();i+=3){
            tempCountry.add(temparr.get(i));
            tempCountryCode.add(temparr.get(i+1));
            tempRate.add(temparr.get(i+2));

        }

        tempALl.add(tempCountry);
        tempALl.add(tempCountryCode);
        tempALl.add(tempRate);

        System.out.println("NO IN ARR");

        for(int i=0;i<tempCountry.size();i+=3){
//            System.out.println(tempALl.get(1).size());


        }

        ListAdapter myAdap = new ListCustomAdapter(this, tempALl);
        li.setAdapter(myAdap);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.myMenu = menu;
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void refreshAllArray() {
        String[] myResArray = getResources().getStringArray(R.array.listCurr);

//        if(listcountry!=null){
//            listcountry.clear();
//        }
//        if(listcountrycode!=null){
//            listcountrycode.clear();
//        }
//        if(listrate!=null){
//            listrate.clear();
//        }
//

        if (cleared == 0) {
            //country names
            listcountry = Arrays.asList(myResArray);
            for (int i = 0; i < allCurr.size(); i += 2) {

                listcountrycode.add(allCurr.get(i));
                listrate.add(allCurr.get(i + 1));

            }
            cleared = 1;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.convert) {
            DecimalFormat forma = new DecimalFormat("#0.00");


            newCurr = parseDouble(edit.getText().toString()) / (currentcySelected);
            String temp = forma.format(newCurr) + "";
            te.setText(temp);
        } else if (item.getItemId() == R.id.addCustom) {
            Intent tn = new Intent(this, CustomXchangeRate.class);
            tn.putExtra("arr", allCurr);
            startActivity(tn);


        } else if (item.getItemId() == R.id.loadDefault) {
            System.out.println("arraytest");
            refreshAllArray();

            myCurrency = Currency.getInstance();
            myCurrency.deleteAll(getApplicationContext());
            for (int i = 0; i < listcountrycode.size(); i++) {


                myCurrency.addToDatabase(listcountry.get(i), listcountrycode.get(i), listrate.get(i), getApplicationContext());

            }
            ArrayList<String> temp = (ArrayList<String>) myCurrency.retrieveAll(getApplicationContext());

            System.out.println("CHECKING DB for load: " + temp.size());
//            System.out.println("test array");
//            for(int i=0;i<listcountrycode.size();i++){
//                System.out.println(listcountry.get(i));
//                System.out.println(listcountrycode.get(i));
//                System.out.println(listrate.get(i));
//            }


        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        allCurr.add("AUD");
        allCurr.add("0.944");
        allCurr.add("BGN");
        allCurr.add("1.2824");
        allCurr.add("BRL");
        allCurr.add("2.2842");
        allCurr.add("CAD");
        allCurr.add("0.96158");
        allCurr.add("CHF");
        allCurr.add("0.70946");
        allCurr.add("CNY");
        allCurr.add("4.8624");
        allCurr.add("CZK");
        allCurr.add("17.719");
        allCurr.add("DKK");
        allCurr.add("4.8779");
        allCurr.add("GBP");
        allCurr.add("0.59045");
        allCurr.add("HKD");
        allCurr.add("5.566");
        allCurr.add("HRK");
        allCurr.add("4.9238");
        allCurr.add("HUF");
        allCurr.add("202.24");
        allCurr.add("IDR");
        allCurr.add("9359.3");
        allCurr.add("ILS");
        allCurr.add("2.763");
        allCurr.add("INR");
        allCurr.add("47.927");
        allCurr.add("JPY");
        allCurr.add("75.385");
        allCurr.add("KRW");
        allCurr.add("822.82");
        allCurr.add("MXN");
        allCurr.add("13.583");
        allCurr.add("MYR");
        allCurr.add("3.0142");
        allCurr.add("NOK");
        allCurr.add("5.9239");
        allCurr.add("NZD");
        allCurr.add("1.0041");
        allCurr.add("PHP");
        allCurr.add("34.793");
        allCurr.add("PLN");
        allCurr.add("28.377");
        allCurr.add("RON");
        allCurr.add("2.9546");
        allCurr.add("RUB");
        allCurr.add("45.407");
        allCurr.add("SEK");
        allCurr.add("6.4684");
        allCurr.add("THB");
        allCurr.add("25.131");
        allCurr.add("TRY");
        allCurr.add("2.2271");
        allCurr.add("USD");
        allCurr.add("0.71772");
        allCurr.add("ZAR");
        allCurr.add("9.7359");
        allCurr.add("EUR");
        allCurr.add("0.65569");


        currentcySelected = parseDouble(allCurr.get(1));

        li = (ListView) findViewById(R.id.list);
        te = (TextView) findViewById(R.id.curr);
        edit = (EditText) findViewById(R.id.imputte);
        currText = (TextView) findViewById(R.id.currText);


        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(), li.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();

                if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Australian Dollar")) {
                    //  System.out.println("AUSSS");
                    itemselected = "AUD";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Bulgarian lev")) {
                    itemselected = "BGN";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Brazilian real")) {
                    itemselected = "BRL";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Canadian Dollar")) {
                    itemselected = "CAD";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Swiss franc")) {
                    itemselected = "CHF";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Chinese Yuan")) {
                    itemselected = "CNY";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Czech Republic Koruna")) {
                    itemselected = "CZK";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Danish Krone")) {
                    itemselected = "DKK";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("British Pound")) {
                    itemselected = "GBP";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Hong Kong Dollar")) {
                    itemselected = "HKD";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Croatian Kuna")) {
                    itemselected = "HRK";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Hungarian Forint")) {
                    itemselected = "HUF";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Indonesian Rupiah")) {
                    itemselected = "IDR";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Israeli New Sheqel")) {
                    itemselected = "ILS";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Indian Rupee")) {
                    itemselected = "INR";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Japanese Yen")) {
                    itemselected = "JPY";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("South Korean Won")) {
                    itemselected = "KRW";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Mexican Peso")) {
                    itemselected = "MXN";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Malaysian Ringgit")) {
                    itemselected = "MYR";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Norwegian Krone")) {
                    itemselected = "NOK";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("New Zealand Dollar")) {
                    itemselected = "NZD";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Philippine Peso")) {
                    itemselected = "PHP";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Polish Zloty")) {
                    itemselected = "PLN";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Romanian Leu")) {
                    itemselected = "RON";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Russian Ruble")) {
                    itemselected = "RUB";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Swedish Krona")) {
                    itemselected = "SEK";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Thai Baht")) {
                    itemselected = "THB";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Turkish Lira")) {
                    itemselected = "TRY";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("US Dollar")) {
                    itemselected = "USD";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("South African Rand")) {
                    itemselected = "ZAR";

                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Euro")) {
                    itemselected = "EUR";

                }
//                System.out.println("sdrsrsd");
//                System.out.println(itemselected);
                System.out.println(itemselected);


                for (int p = 0; p < allCurr.size(); p++) {

                    if (itemselected.equalsIgnoreCase(allCurr.get(p).toString())) {
                        currentcySelected = parseDouble(allCurr.get(p + 1));
                    }

                }


                currText.setText(itemselected);

            }
        });
//        System.out.println("TTTTTTT");
//        myCurrency = Currency.getInstance();

//         myCurrency.addToDatabase("ass","asdf","124",getApplicationContext());
//        myCurrency.deleteAll(getApplicationContext());
//        ArrayList<String> temp = (ArrayList<String>) myCurrency.retrieveAll(getApplicationContext());
//        System.out.println(temp.get(0));
//        System.out.println("CHECKING DB" + temp.size());
//        System.out.println("CCCCCC");

        refreshAllArray();

        getAllFromDb();
    }

}
