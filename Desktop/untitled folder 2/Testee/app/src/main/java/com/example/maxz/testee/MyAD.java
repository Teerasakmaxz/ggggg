package com.example.maxz.testee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by maxz on 8/5/16 AD.
 */
public class MyAD extends BaseAdapter {
    //ประกาศตัวแปร
    private Context odjContext;
    private String[] titerStrings, dataStrings;
    private int[] iconInts;

    public MyAD(Context odjContext, String[] titerStrings, String[] dataStrings, int[] iconInts) {
        this.odjContext = odjContext;
        this.titerStrings = titerStrings;
        this.dataStrings = dataStrings;
        this.iconInts = iconInts;

    }//นี่คือ con


    @Override
    public int getCount() {
        return titerStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater odjLayoutInflater = (LayoutInflater) odjContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View odjView = odjLayoutInflater.inflate(R.layout.my_listview, parent, false);

        TextView titeTextView = (TextView) odjView.findViewById(R.id.textView2);
        titeTextView.setText(titerStrings[position]);

        TextView dataTextView = (TextView) odjView.findViewById(R.id.textView3);
        dataTextView.setText(dataStrings[position]);

        ImageView IconImageView = (ImageView) odjView.findViewById(R.id.imageView);
        IconImageView.setImageResource(iconInts[position]);




        return odjView;
    }
}
