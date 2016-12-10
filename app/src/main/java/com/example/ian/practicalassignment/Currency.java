package com.example.ian.practicalassignment;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ian on 10/12/2016.
 */

public class Currency extends Application {

    private List<String> currList;
    private List<Integer> currIdList;
 

    private static Currency ourInstance = new Currency();







public Currency(){
    currList = new ArrayList<String>();
    currIdList = new ArrayList<Integer>();



}
  public static Currency getInstance(){return ourInstance;};

    public long addToDatabase(String codes, String countryCodes,String rates ,Context c) {
        MyDbAdapter db = new MyDbAdapter(c);
        db.open();

        long rowIDoInsertedEntry = db.insertEntry(codes, countryCodes,rates);
        db.close();
        return rowIDoInsertedEntry;
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
                currList.add( myCursor.getString(db.COLUMN_COUNTRY_CODES));
                currList.add(myCursor.getString(db.COLUMN_RATES));

            } while (myCursor.moveToNext());
        }
        db.close();
        return currList;
    }


}
