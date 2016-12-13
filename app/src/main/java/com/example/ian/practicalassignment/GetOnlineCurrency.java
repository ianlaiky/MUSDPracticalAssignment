package com.example.ian.practicalassignment;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Ian on 12/12/2016.
 */

public class GetOnlineCurrency extends AsyncTask<String, Void, JSONObject> {

    JSONObject obj;

    public GetOnlineCurrency() {


    }


    @Override
    protected JSONObject doInBackground(String... strings) {
        String check = "UNDEFINED";
        ArrayList<String> currency = new ArrayList<String>();
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();

            String inputString;
            while ((inputString = bufferedReader.readLine()) != null) {
                builder.append(inputString);


            }

            JSONObject topLevel = new JSONObject(builder.toString());
            System.out.println("FULL: " + topLevel);

            System.out.println("Length " + topLevel.length());

            JSONObject obj = topLevel.getJSONObject("rates");
//            JSONArray tt = topLevel.getJSONArray("rates");

            System.out.println(obj);
            System.out.println(obj.getString("AUD"));

            this.obj = obj;


//            currency.add(String.valueOf(topLevel.getString("rates")));


//            for(int i = 0, count = tt.length(); i< count; i++)
//            {
//                try {
//                    JSONObject jsonObject = tt.getJSONObject(i);
//                    currency.add(jsonObject.toString());
////                    System.out.println(jsonObject.toString());
//                }
//                catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }


            urlConnection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return obj;


    }
}
