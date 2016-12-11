package com.example.ian.practicalassignment;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ian on 11/12/2016.
 */

public class ListCustomAdapter extends ArrayAdapter<String> {

    private Context context;
    ArrayList<Currency> currency = new ArrayList<>();;


    public ListCustomAdapter(Context c, ArrayList countr) {

        super(c, R.layout.custom_list, countr);
        this.currency = countr;
        this.context = c;

    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.custom_list, parent, false);


        TextView customCountry = (TextView) rowView.findViewById(R.id.customcountry);
        TextView customCountryCode = (TextView) rowView.findViewById(R.id.customcountrycode);
        TextView customRates = (TextView) rowView.findViewById(R.id.customrate);

        if(currency!=null){
//            System.out.println(currency.get(0).get(position).toString());
//            System.out.println(currency.get(1).get(position).toString());
//            System.out.println(currency.get(2).get(position).toString());

            customCountry.setText(currency.get(position).getCountry());
            customCountryCode.setText(currency.get(position).getCountryCode());
            customRates.setText(currency.get(position).getRate());





        }


        return rowView;
    }


}



