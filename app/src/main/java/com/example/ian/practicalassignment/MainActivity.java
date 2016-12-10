package com.example.ian.practicalassignment;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    ListView li;
    TextView te;
    EditText edit;
    TextView currText;

    ArrayAdapter<CharSequence> arr;

    double aud;
    double bgn;
    double brl;
    double cad;
    double chf;
    double cny;
    double czk;
    double dkk;
    double gbp;
    double hkd;
    double hrk;
    double huf;
    double idr;
    double ils;
    double inr;
    double jpy;
    double krw;
    double mxn;
    double myr;
    double nok;
    double nzd;
    double php;
    double pln;
    double ron;
    double rub;
    double sek;
    double thb;
    double turk;
    double usd;
    double zar;
    double eur;


    Menu myMenu;
    String itemselected = "";
    double currentcySelected;
    double newCurr;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.myMenu = menu;
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.convert){
            DecimalFormat forma = new DecimalFormat("#0.00");


           newCurr = parseDouble(edit.getText().toString())/(currentcySelected);
            String temp = forma.format(newCurr)+"";
            te.setText(temp);
        }else if(item.getItemId()==R.id.addCustom){
            Intent tn = new Intent(this,CustomXchangeRate.class);
            startActivity(tn);


        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentcySelected=aud;

        aud = 0.944;
        bgn = 1.2824;
        brl = 2.2842;
        cad = 0.96158;
        chf = 0.70946;
        cny = 4.8624;
        czk = 17.719;
        dkk = 4.8779;
        gbp = 0.59045;
        hkd = 5.566;
        hrk = 4.9238;
        huf = 202.24;
        idr = 9359.3;
        ils = 2.763;
        inr = 47.927;
        jpy = 75.385;
        krw = 822.82;
        mxn = 13.583;
        myr = 3.0142;
        nok = 5.9239;
        nzd = 1.0041;
        php = 34.793;
        pln = 28.377;
        ron = 2.9546;
        rub = 45.407;
        sek = 6.4684;
        thb = 25.131;
        turk = 2.2271;
        usd = 0.71772;
        zar = 9.7359;
        eur = 0.65569;





        li = (ListView) findViewById(R.id.list);
        te = (TextView) findViewById(R.id.curr);
        edit = (EditText) findViewById(R.id.imputte);
        currText = (TextView) findViewById(R.id.currText);


        arr = ArrayAdapter.createFromResource(this, R.array.listCurr, android.R.layout.simple_spinner_dropdown_item);
        li.setAdapter(arr);


        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(), li.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();

                if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Australian Dollar")) {
                    System.out.println("AUSSS");
                    itemselected = "AUD";
                    currentcySelected=aud;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Bulgarian lev")) {
                    itemselected = "BGN";
                    currentcySelected=bgn;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Brazilian real")) {
                    itemselected = "BRL";
                    currentcySelected=brl;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Canadian Dollar")) {
                    itemselected = "CAD";
                    currentcySelected=cad;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Swiss franc")) {
                    itemselected = "CHF";
                    currentcySelected=chf;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Chinese Yuan")) {
                    itemselected = "CNY";
                    currentcySelected=cny;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Czech Republic Koruna")) {
                    itemselected = "CZK";
                    currentcySelected=czk;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Danish Krone")) {
                    itemselected = "DKK";
                    currentcySelected=dkk;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("British Pound")) {
                    itemselected = "GBP";
                    currentcySelected=gbp;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Hong Kong Dollar")) {
                    itemselected = "HKD";
                    currentcySelected=hkd;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Croatian Kuna")) {
                    itemselected = "HRK";
                    currentcySelected=hrk;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Hungarian Forint")) {
                    itemselected = "HUF";
                    currentcySelected=huf;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Indonesian Rupiah")) {
                    itemselected = "IDR";
                    currentcySelected=idr;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Israeli New Sheqel")) {
                    itemselected = "ILS";
                    currentcySelected=ils;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Indian Rupee")) {
                    itemselected = "INR";
                    currentcySelected=inr;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Japanese Yen")) {
                    itemselected = "JPY";
                    currentcySelected=jpy;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("South Korean Won")) {
                    itemselected = "KRW";
                    currentcySelected=krw;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Mexican Peso")) {
                    itemselected = "MXN";
                    currentcySelected=mxn;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Malaysian Ringgit")) {
                    itemselected = "MYR";
                    currentcySelected=myr;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Norwegian Krone")) {
                    itemselected = "NOK";
                    currentcySelected=nok;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("New Zealand Dollar")) {
                    itemselected = "NZD";
                    currentcySelected=nzd;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Philippine Peso")) {
                    itemselected = "PHP";
                    currentcySelected=php;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Polish Zloty")) {
                    itemselected = "PLN";
                    currentcySelected=pln;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Romanian Leu")) {
                    itemselected = "RON";
                    currentcySelected=ron;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Russian Ruble")) {
                    itemselected = "RUB";
                    currentcySelected=rub;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Swedish Krona")) {
                    itemselected = "SEK";
                    currentcySelected=sek;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Thai Baht")) {
                    itemselected = "THB";
                    currentcySelected=thb;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Turkish Lira")) {
                    itemselected = "TRY";
                    currentcySelected=turk;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("US Dollar")) {
                    itemselected = "USD";
                    currentcySelected=usd;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("South African Rand")) {
                    itemselected = "ZAR";
                    currentcySelected=zar;
                } else if (li.getItemAtPosition(i).toString().equalsIgnoreCase("Euro")) {
                    itemselected = "EUR";
                    currentcySelected=eur;
                }
//                System.out.println("sdrsrsd");
//                System.out.println(itemselected);

                currText.setText(itemselected);

            }
        });



    }


}
