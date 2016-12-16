package com.example.ian.practicalassignment;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {

    final int RESULT_CODE = 1;
    ListView li;
    TextView te;
    EditText edit;
    TextView currText;
    ArrayAdapter<CharSequence> arr;
    ArrayList<String> allCurr = new ArrayList<String>();
    List<String> listcountrycode = new ArrayList<>();
    List<String> listrate = new ArrayList<>();
    List<String> listcountry;
    Menu myMenu;
    String itemselected = "";
    double currentcySelected;
    double newCurr;

    ArrayList<Currency> tempALl;
    JSONObject a;
    int cleared = 0;
    int acleared = 0;
    Currency myCurrency;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void getFromAPI(JSONObject a) {

        refreshAllArray();
        getAllFromDb();

        myCurrency.deleteAll(getApplicationContext());
        for (int i = 0; i < listcountrycode.size(); i++) {


            myCurrency.addToDatabase(listcountry.get(i), listcountrycode.get(i), listrate.get(i), getApplicationContext());

        }
        ArrayList<String> temp = (ArrayList<String>) myCurrency.retrieveAll(getApplicationContext());




        System.out.println("CHECKING DB for load: " + temp.size());

        ArrayList<String> country = new ArrayList<String>();
        ArrayList<String> countrycode = new ArrayList<String>();
        ArrayList<String> rates = new ArrayList<String>();

//        System.out.println("TTTEE"+tempALl.size());
//        for(int i=0;i<tempALl.size();i++){
//            System.out.println(tempALl.get(i).getCountry());
//            System.out.println(i);
//
//        }

        for (int i = 0; i < 31; i++) {
            country.add(tempALl.get(i).getCountry());
            countrycode.add(tempALl.get(i).getCountryCode());
            rates.add(tempALl.get(i).getRate());

            System.out.println("TTTT");
            System.out.println(tempALl.get(i).getCountry());
            System.out.println("GLORY"+i);
            System.out.println(tempALl.get(i).getRate());

        }
        ArrayList<Currency>rr=new ArrayList<>();
        if(tempALl.size()>31){
            for(int i=31;i<tempALl.size();i++) {
                rr.add(tempALl.get(i));
            }

        }








        myCurrency.deleteAll(getApplicationContext());

        System.out.println("NATA");
        System.out.println(country.size());
        System.out.println(countrycode.size());
        System.out.println(rates.size());

        for(int i=0;i<country.size();i++){
            try {
                myCurrency.addToDatabase(country.get(i),countrycode.get(i),a.getString(countrycode.get(i)),getApplicationContext());
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        for(int i=0;i<rr.size();i++){

            myCurrency.addToDatabase(rr.get(i).getCountry(),rr.get(i).getCountryCode(),rr.get(i).getRate(),getApplicationContext());

        }

        System.out.println("DUDEwaa"+tempALl.get(0).getRate());

//        ListAdapter myAdap = new ListCustomAdapter(this, tempALl);
//        li.setAdapter(myAdap);
        getAllFromDb();

    }

    public void getAllFromDb() {

        DecimalFormat forma = new DecimalFormat("#0.00");
        //USE DB TO GET ARRAY
        Currency temp = new Currency();
        temp = Currency.getInstance();

        ArrayList<String> temparr = (ArrayList<String>) temp.retrieveAll(getApplicationContext());


        tempALl = new ArrayList<Currency>();

        for (int i = 0; i < temparr.size(); i += 3) {
//            System.out.println("DATA "+temparr.get(i + 2));
            String a = forma.format(parseDouble(temparr.get(i + 2)));

            Currency c = new Currency(temparr.get(i), temparr.get(i + 1), a);
            tempALl.add(c);

        }
        if(tempALl.isEmpty()){
            myCurrency.addToDatabase("AUD","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("BGN","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("BRL","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("CAD","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("CHF","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("CNY","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("CZK","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("DKK","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("GBP","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("HKD","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("HRK","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("HUF","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("IDR","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("ILS","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("INR","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("JPY","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("KRW","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("MXN","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("MYR","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("NOK","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("NZD","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("PHP","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("PLN","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("RON","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("RUB","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("SEK","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("THB","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("TRY","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("USD","aus","0.5",getApplicationContext());
            myCurrency.addToDatabase("ZAR","aus","0.5",getApplicationContext());

            myCurrency.addToDatabase("EUR","aus","0.5",getApplicationContext());
            ArrayList<String> test = (ArrayList<String>) temp.retrieveAll(getApplicationContext());
            for (int i = 0; i < temparr.size(); i += 3) {
//            System.out.println("DATA "+temparr.get(i + 2));
                String a = forma.format(parseDouble(temparr.get(i + 2)));

                Currency c = new Currency(temparr.get(i), temparr.get(i + 1), a);
                tempALl.add(c);

            }
        }



        System.out.println("NO IN ARR");
        System.out.println("GTTTE"+tempALl.get(0).getRate());
        System.out.println(temparr.get(2));


        ListAdapter myAdap = new ListCustomAdapter(this, tempALl);


        if (acleared == 0) {
            li.setAdapter(myAdap);
            acleared = 1;
        } else if (acleared == 1) {

            li.setAdapter(myAdap);

        }
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
            System.out.println("werrerwer");
            System.out.println("selected " + itemselected);

//            newCurr = parseDouble(edit.getText().toString()) / (currentcySelected);
//            String temp = forma.format(newCurr) + "";


//            for (int i = 0; i < tempALl.size(); i++) {
//                System.out.println(tempALl.get(i).getCountryCode());
//                if (tempALl.get(i).getCountryCode().equalsIgnoreCase(itemselected)) {
//                    te.setText(tempALl.get(i).caculateCurrency(parseDouble(edit.getText().toString())));
//                }
//            }
            te.setText(forma.format(parseDouble(edit.getText().toString()) / currentcySelected) + "");

        } else if (item.getItemId() == R.id.addCustom) {
            Intent tn = new Intent(this, CustomXchangeRate.class);

//            tn.putExtra("arr", allCurr);
            startActivity(tn);
            getAllFromDb();

        } else if (item.getItemId() == R.id.loadDefault) {
            System.out.println("arraytest");
            refreshAllArray();


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

            getAllFromDb();
        }

        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myCurrency = Currency.getInstance();
//        if(tempALl.isEmpty()){
//            myCurrency.addToDatabase("AUD","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("BGN","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("BRL","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("CAD","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("CHF","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("CNY","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("CZK","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("DKK","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("GBP","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("HKD","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("HRK","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("HUF","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("IDR","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("ILS","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("INR","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("JPY","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("KRW","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("MXN","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("MYR","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("NOK","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("NZD","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("PHP","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("PLN","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("RON","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("RUB","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("SEK","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("THB","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("TRY","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("USD","aus","0.5",getApplicationContext());
//            myCurrency.addToDatabase("ZAR","aus","0.5",getApplicationContext());
//
//            myCurrency.addToDatabase("EUR","aus","0.5",getApplicationContext());
//        }


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


        registerForContextMenu(li);

        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(), li.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
                System.out.println("THIS IS SELECTED");
//                System.out.println(li.getItemAtPosition(i).toString());

                TextView tv1 = (TextView) view.findViewById(R.id.customrate);
                TextView tv2 = (TextView) view.findViewById(R.id.customcountrycode);

                System.out.println(tv1.getText().toString());

                itemselected = tv2.getText().toString();
                currentcySelected = parseDouble(tv1.getText().toString());


//                if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Australian Dollar")) {
//                    //  System.out.println("AUSSS");
//                    itemselected = "AUD";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Bulgarian lev")) {
//                    System.out.println("JA");
//                    itemselected = "BGN";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Brazilian real")) {
//                    itemselected = "BRL";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Canadian Dollar")) {
//                    itemselected = "CAD";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Swiss franc")) {
//                    itemselected = "CHF";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Chinese Yuan")) {
//                    itemselected = "CNY";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Czech Republic Koruna")) {
//                    itemselected = "CZK";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Danish Krone")) {
//                    itemselected = "DKK";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("British Pound")) {
//                    itemselected = "GBP";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Hong Kong Dollar")) {
//                    itemselected = "HKD";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Croatian Kuna")) {
//                    itemselected = "HRK";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Hungarian Forint")) {
//                    itemselected = "HUF";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Indonesian Rupiah")) {
//                    itemselected = "IDR";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Israeli New Sheqel")) {
//                    itemselected = "ILS";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Indian Rupee")) {
//                    itemselected = "INR";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Japanese Yen")) {
//                    itemselected = "JPY";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("South Korean Won")) {
//                    itemselected = "KRW";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Mexican Peso")) {
//                    itemselected = "MXN";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Malaysian Ringgit")) {
//                    itemselected = "MYR";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Norwegian Krone")) {
//                    itemselected = "NOK";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("New Zealand Dollar")) {
//                    itemselected = "NZD";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Philippine Peso")) {
//                    itemselected = "PHP";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Polish Zloty")) {
//                    itemselected = "PLN";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Romanian Leu")) {
//                    itemselected = "RON";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Russian Ruble")) {
//                    itemselected = "RUB";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Swedish Krona")) {
//                    itemselected = "SEK";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Thai Baht")) {
//                    itemselected = "THB";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Turkish Lira")) {
//                    itemselected = "TRY";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("US Dollar")) {
//                    itemselected = "USD";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("South African Rand")) {
//                    itemselected = "ZAR";
//
//                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Euro")) {
//                    itemselected = "EUR";
//
//                }
//                System.out.println("sdrsrsd");
//                System.out.println(itemselected);
                System.out.println(itemselected);


//                for (int p = 0; p < allCurr.size(); p++) {
//
//                    if (itemselected.equalsIgnoreCase(allCurr.get(p).toString())) {
//                        currentcySelected = parseDouble(allCurr.get(p + 1));
//                    }
//
//                }


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
        itemselected = "AUD";

        String url = String.format("http://api.fixer.io/latest?base=SGD");

        try {
            a = new GetOnlineCurrency().execute(url).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("MAINN" + a);

        getFromAPI(a);

        System.out.println("arraytest");
        refreshAllArray();


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

        getAllFromDb();

//        refreshAllArray();

//        getAllFromDb();
    }

//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo info) {
////        menu.setHeaderTitle("Context Menu");
//        menu.add(0, v.getId(), 0, "Delete");
//
//    }
//
//    public boolean onContextItemSelected(MenuItem item) {
//        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
//        int index = info.position;
//        View view = info.targetView;
//
//        System.out.println("INDEX POSI" + index);
//
//        Currency cu = new Currency();
//        cu = Currency.getInstance();
//        cu.deleteFrmDatabase(index, getApplicationContext());
//
//        getAllFromDb();
//        return true;

//    }

    public void onResume() {
        super.onResume();
        getAllFromDb();



    }


}
