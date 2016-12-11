package com.example.ian.practicalassignment;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.icu.text.DecimalFormat;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

/**
 * Created by Ian on 10/12/2016.
 */

public class Currency extends Application {

    private List<String> currList;
    private List<Integer> currIdList;

    private String country;
    private String countryCode;
    private String rate;


    private static Currency ourInstance = new Currency();


    public Currency() {
        currList = new ArrayList<String>();
        currIdList = new ArrayList<Integer>();


    }
    public String caculateCurrency(double input){
        DecimalFormat forma = new DecimalFormat("#0.00");
        String temp = forma.format(input/parseDouble(rate));

        return temp;

    }


    public Currency(String country, String countryCode, String rate) {
        this.country = country;
        this.countryCode = countryCode;
        this.rate = rate;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static Currency getInstance() {
        return ourInstance;
    };



    public long addToDatabase(String codes, String countryCodes, String rates, Context c) {
        MyDbAdapter db = new MyDbAdapter(c);
        db.open();

        long rowIDoInsertedEntry = db.insertEntry(codes, countryCodes, rates);
        db.close();
        return rowIDoInsertedEntry;
    }

    public void deleteAll(Context c) {
        MyDbAdapter db = new MyDbAdapter(c);
        db.open();

        Cursor myCursor;
        myCursor = db.retrieveAllEntriesCursor();


       for(int i=0;i<currIdList.size();i++) {

           System.out.println("DELETE running");
           boolean updateStatus = db.removeEntry(currIdList.get(i));


       }


        db.close();

    }

    public boolean deleteFrmDatabase(int rowID, Context c) {
        MyDbAdapter db = new MyDbAdapter(c);
        db.open();

        int id = currIdList.get(rowID);

        boolean updateStatus = db.removeEntry(id);
        db.close();

        return updateStatus;
    }

    public List<String> retrieveAll(Context c) {
        System.out.println("TEST!");

        Cursor myCursor;
        String myString;
        MyDbAdapter db = new MyDbAdapter(c);
        db.open();
        currIdList.clear();
        currList.clear();
        myCursor = db.retrieveAllEntriesCursor();

        System.out.println(myCursor.getCount());


        if (myCursor != null && myCursor.getCount() > 0) {
            myCursor.moveToFirst();
            do {
                currIdList.add(myCursor.getInt(db.COLUMN_KEY_ID));
                //    myString = myCursor.getString(db.COLUMN_CODES) + "-" + myCursor.getString(db.COLUMN_COUNTRY_CODES) + "-" + myCursor.getString(db.COLUMN_RATES) + "\n";
                System.out.println("DB CHECK");
                System.out.println(myCursor.getString(db.COLUMN_COUNTRY_CODES));
                currList.add(myCursor.getString(db.COLUMN_CODES));
                currList.add(myCursor.getString(db.COLUMN_COUNTRY_CODES));
                currList.add(myCursor.getString(db.COLUMN_RATES));

            } while (myCursor.moveToNext());
        }
        db.close();
        return currList;
    }



}
