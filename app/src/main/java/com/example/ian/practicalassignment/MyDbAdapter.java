package com.example.ian.practicalassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDbAdapter {
    private static final String DATABASE_NAME = "test.db";
    private static final String DATABASE_TABLE = "myTestDb";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase _db;
    private final Context context;

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ", ";
    public static final String KEY_ID = "_id";
    public static final int COLUMN_KEY_ID = 0;
    public static final String CODES = "codes";
    public static final int COLUMN_CODES = 1;
    public static final String COUNTRY_CODES = "country_codes";
    public static final int COLUMN_COUNTRY_CODES= 2;
    public static final String RATES = "rates";
    public static final int COLUMN_RATES = 3;

    protected static final String DATABASE_CREATE = "create table " + DATABASE_TABLE + " " + "(" + KEY_ID + " integer primary key autoincrement, " + CODES +TEXT_TYPE+COMMA_SEP+
            COUNTRY_CODES+TEXT_TYPE+COMMA_SEP+RATES+TEXT_TYPE+" )";

    private String MYDBADAPTER_LOG_CAT = "MY_LOG";

    private MyDBOpenHelper dbHelper;

    public MyDbAdapter(Context _context) {
        this.context = _context;
        dbHelper = new MyDBOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION);


        //step 16 - create MyDBOpenHelper object


    }

    public void close() {

        _db.close();
        Log.w(MYDBADAPTER_LOG_CAT, "DB closed");
        //step 17 - close db

    }

    public void open() throws SQLiteException {

        try {
            _db = dbHelper.getWritableDatabase();
            Log.w(MYDBADAPTER_LOG_CAT, "DB closed");
        } catch (SQLiteException e) {

            _db = dbHelper.getWritableDatabase();
            Log.w(MYDBADAPTER_LOG_CAT, "DB opened as readable database");

        }
        //step 18 - open db


    }

    public long insertEntry(String codes, String countryCodes,String rates) {
        ContentValues newEntryValues = new ContentValues();

        newEntryValues.put(CODES, codes);
        newEntryValues.put(COUNTRY_CODES, countryCodes);
        newEntryValues.put(RATES, rates);

        Log.w(MYDBADAPTER_LOG_CAT, "Inserted Codes = " + codes + "CountryCodes = " +
                countryCodes + "Rates = " + rates + "into table" + DATABASE_TABLE);

        return _db.insert(DATABASE_TABLE, null, newEntryValues);
        //step 19 - insert record into table

    }

    public boolean removeEntry(long _rowIndex) {

        if (_db.delete(DATABASE_TABLE, KEY_ID + "=" + _rowIndex, null) <= 0) {
            Log.w(MYDBADAPTER_LOG_CAT, "Removing entry where id = " + _rowIndex + "Failed");
            return false;
        }
        Log.w(MYDBADAPTER_LOG_CAT, "Removing entry where id = " + _rowIndex + "Success");
        //step 20 - remove record from table


        return true;

    }

    public boolean updateEntry(long _rowIndex, String codes, String countryCodes,String rates) {
        ContentValues cv = new ContentValues();
        cv.put(CODES,codes); //These Fields should be your String values of actual column names
        cv.put(COUNTRY_CODES,countryCodes);
        cv.put(RATES,rates);

        _db.update(DATABASE_TABLE,cv,"_id="+_rowIndex,null);

        return false;
    }

    public Cursor retrieveAllEntriesCursor() {

        Cursor c = null;

        try {
            c = _db.query(DATABASE_TABLE, new String[]{KEY_ID, CODES, COUNTRY_CODES,RATES},
                    null, null, null, null, null);
        } catch (SQLiteException e) {
            Log.w(MYDBADAPTER_LOG_CAT, "Retrieve fail!");

        }

        return c;
        //step 21 - retrieve all records from table
    }

    public class MyDBOpenHelper extends SQLiteOpenHelper {
        public MyDBOpenHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub

            db.execSQL(DATABASE_CREATE);
            Log.w(MYDBADAPTER_LOG_CAT, "Helper : DB " + DATABASE_TABLE + "Created!!");
            //step 14 - execute create sql statement


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub

        }

    } // End of myDBOpenHelper

}// End of myDBAdapter

